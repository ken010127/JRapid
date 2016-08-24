package com.rbac.jrapid.core.common.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Random;

/**
 * 在分布式系统中，需要生成全局UID的场合还是比较多的，twitter的snowflake解决了这种需求，
 * 实现也还是很简单的，除去配置信息，核心代码就是毫秒级时间41位+机器ID 10位+毫秒内序列12位。
 * 该项目地址为：https://github.com/twitter/snowflake是用Scala实现的。
 * python版详见开源项目https://github.com/erans/pysnowflake。
 *
 * 其原理结构如下，分别用一个0表示一位，用—分割开部分的作用：
 * 0---0000000000 0000000000 0000000000 0000000000 0 --- 00000 ---00000 ---0000000000 00
 * 在上面的字符串中，第一位为未使用（实际上也可作为long的符号位），接下来的41位为毫秒级时间，然后5位datacenter标识位，
 * 5位机器ID（并不算标识符，实际是为线程标识），然后12位该毫秒内的当前毫秒内的计数，加起来刚好64位，为一个Long型
 * 这样的好处是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞（由datacenter和机器ID作区分），
 * 并且效率较高，经测试，snowflake每秒能够产生26万ID左右，完全满足需要。
 *
 * @author: FWJ
 * @date 2016/8/23  14:25
 */
public class IdWorker {

    // 根据具体机器环境提供
    private final long workerId;

    // 滤波器,使时间变小,生成的总位数变小,一旦确定不能变动
    private final static long twepoch = 1361753741828L;

    private long sequence = 0L;

    private final static long workerIdBits = 10L;

    private final static long maxWorkerId = -1L ^ -1L << workerIdBits;

    private final static long sequenceBits = 12L;

    private final static long workerIdShift = sequenceBits;

    private final static long timestampLeftShift = sequenceBits + workerIdBits;

    private final static long sequenceMask = -1L ^ -1L << sequenceBits;

    private long lastTimestamp = -1L;

    // 根据主机id获取机器码
    private static IdWorker worker = new IdWorker();
    protected static Logger logger = LoggerFactory.getLogger(IdWorker.class);

    // 主机和进程的机器码
    private static final int _genmachine;
    static {
        try {
            // build a 2-byte machine piece based on NICs info
            int machinePiece;
            {
                try {
                    StringBuilder sb = new StringBuilder();
                    Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
                    while ( e.hasMoreElements() ) {
                        NetworkInterface ni = e.nextElement();
                        sb.append(ni.toString());
                    }
                    machinePiece = sb.toString().hashCode() << 16;
                } catch ( Throwable e ) {
                    // exception sometimes happens with IBM JVM, use random
                    logger.error(e.getMessage(), e);
                    machinePiece = new Random().nextInt() << 16;
                }
                logger.debug("machine piece post: " + Integer.toHexString(machinePiece));
            }

            // add a 2 byte process piece. It must represent not only the JVM
            // but the class loader.
            // Since static var belong to class loader there could be collisions
            // otherwise
            final int processPiece;
            {
                int processId = new java.util.Random().nextInt();
                try {
                    processId = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().hashCode();
                } catch ( Throwable t ) {}

                ClassLoader loader = IdWorker.class.getClassLoader();
                int loaderId = loader != null ? System.identityHashCode(loader) : 0;

                StringBuilder sb = new StringBuilder();
                sb.append(Integer.toHexString(processId));
                sb.append(Integer.toHexString(loaderId));
                processPiece = sb.toString().hashCode() & 0xFFFF;
                logger.debug("process piece: " + Integer.toHexString(processPiece));
            }

            _genmachine = machinePiece | processPiece;
            logger.debug("machine : " + Integer.toHexString(_genmachine));
        } catch ( Exception e ) {
            throw new RuntimeException(e);
        }

    }


    /**
     * 创建 IdWorker对象.
     *
     * @Deprecated 请调用静态方法getId()
     * @param workerId
     */
    @Deprecated
    public IdWorker( final long workerId ) {
        if ( workerId > IdWorker.maxWorkerId || workerId < 0 ) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",
                    IdWorker.maxWorkerId));
        }
        this.workerId = workerId;
    }


    public IdWorker() {
        // this.workerId = getAddress() % (IdWorker.maxWorkerId + 1);
        workerId = _genmachine % (IdWorker.maxWorkerId + 1);
    }


    public static long getId() {
        return worker.nextId();
    }


    public synchronized long nextId() {
        long timestamp = timeGen();
        if ( lastTimestamp == timestamp ) {
            sequence = sequence + 1 & IdWorker.sequenceMask;
            if ( sequence == 0 ) {
                // System.out.println("###########" + sequenceMask);//等待下一毫秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        if ( timestamp < lastTimestamp ) {
            try {
                throw new Exception(String.format(
                        "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
            } catch ( Exception e ) {
                logger.error(e.getMessage(), e);
            }
        }

        lastTimestamp = timestamp;
        long nextId = timestamp - twepoch << timestampLeftShift | workerId << IdWorker.workerIdShift | sequence;
        // System.out.println("timestamp:" + timestamp + ",timestampLeftShift:"
        // + timestampLeftShift + ",nextId:" + nextId + ",workerId:"
        // + workerId + ",sequence:" + sequence);
        return nextId;
    }


    private long tilNextMillis( final long lastTimestamp1 ) {
        long timestamp = timeGen();
        while ( timestamp <= lastTimestamp1 ) {
            timestamp = timeGen();
        }
        return timestamp;
    }


    // private static long getAddress() {
    // try {
    // String currentIpAddress = InetAddress.getLocalHost().getHostAddress();
    // String[] str = currentIpAddress.split("\\.");
    // StringBuilder hardware = new StringBuilder();
    // for ( int i = 0 ; i < str.length ; i++ ) {
    // hardware.append(str[i]);
    // }
    // return Long.parseLong(hardware.toString());
    // } catch ( Exception e ) {
    // logger.error(e.getMessage(),e);
    // }
    //
    // return 2L;
    // }

    private long timeGen() {
        return System.currentTimeMillis();
    }


    public static void main( final String[] args ) {
        // IdWorker worker2 = new IdWorker(0);
        // System.out.println(worker2.nextId());
        // long ll = getAddress() % 16;
        // System.out.println(ll);
        // long start = System.currentTimeMillis();
        // for ( int i = 0 ; i < 100000 ; i++ ) {
        // getId();
        // }
        // long end = System.currentTimeMillis();
        // System.out.println((100000 / (end - start)) + "个/ms");
        // IdWorker worker2 = new IdWorker(2);
        System.out.println(getId());
        // 830762065
        // 830796545
        // System.out.println(_genmachine);
    }

}

