package com.rbac.jrapid.test.invocation;

/**
 * @author FWJ
 * @since 2017/1/11 下午2:51
 */
public interface IHello {

    /**
     * 业务处理A方法
     *
     * @param name
     */
    void sayHello(String name);

    /**
     * 业务处理B方法
     *
     * @param name
     */
    void sayGoogBye(String name);
}
