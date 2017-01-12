package com.rbac.jrapid.test.invocation;

/**
 * DynaProxyHello2 测试类
 * @author FWJ
 * @since 2017/1/11 下午4:54
 */
public class Test2 {
    public static void main(String[] args) {
        IHello hello = (IHello)new DynaProxyHello2().bind(new Hello(),new LoggerOperation());
        hello.sayGoogBye("Double J");
        //hello.sayHello("Double J");
    }
}
