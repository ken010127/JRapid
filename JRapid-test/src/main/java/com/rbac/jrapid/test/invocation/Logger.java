package com.rbac.jrapid.test.invocation;

import java.util.Date;

/**
 * @author FWJ
 * @since 2017/1/11 下午3:28
 */
public class Logger {
    /**
     * 根据等级记录日志
     * @param level
     * @param context
     */
    public static void logging(Level level, String context) {
        if (level.equals(Level.INFO)) {
            System.out.println(new Date() + " " + context);
        }
        if (level.equals(Level.DEBUGE)) {
            System.err.println(new Date() + " " + context);
        }
    }
}
