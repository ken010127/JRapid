package com.rbac.jrapid.test;

import java.io.File;

/**
 * 读取文件路径测试类
 * @author FWJ
 * @since 2017/1/18 下午2:05
 */
public class FilePathTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(FilePathTest.class.getClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(FilePathTest.class.getResource(""));
        System.out.println(FilePathTest.class.getResource("/"));//Class文件所在路径
        //System.out.println(new File("/").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
    }

}
