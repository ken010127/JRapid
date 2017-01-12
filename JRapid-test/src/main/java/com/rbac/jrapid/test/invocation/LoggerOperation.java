package com.rbac.jrapid.test.invocation;

import java.lang.reflect.Method;

/**
 * @author FWJ
 * @since 2017/1/11 下午4:45
 */
public class LoggerOperation implements IOperation {
    @Override
    public void start(Method method) {
        Logger.logging(Level.DEBUGE, method.getName() + " Method end .");
    }

    @Override
    public void end(Method method) {
        Logger.logging(Level.INFO, method.getName() + " Method Start!");
    }
}
