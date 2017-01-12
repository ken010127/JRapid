package com.rbac.jrapid.test.invocation;

import java.lang.reflect.Method;

/**
 * @author FWJ
 * @since 2017/1/11 下午4:44
 */
public interface IOperation {
    /**
     * 方法执行之前的操作
     *
     * @param method
     */
    void start(Method method);

    /**
     * 方法执行之后的操作
     * @param method
     */
    void end(Method method);
}
