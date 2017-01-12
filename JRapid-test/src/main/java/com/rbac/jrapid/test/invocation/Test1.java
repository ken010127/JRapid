package com.rbac.jrapid.test.invocation;

/**
 * DynaProxyHello1 测试类
 * @author FWJ
 * @since 2017/1/11 下午4:37
 */
public class Test1 {
    public static void main(String[] args) {
        //(DynaPoxyHello)自动去代理执行被代理对象(Hello)中的每一个方法,
        // 一个java.lang.reflect.InvocationHandler接口就把我们的代理对象和被代理对象解藕了
        IHello hello = (IHello) new DynaProxyHello1().bind(new Hello());
        hello.sayGoogBye("Double J");
        hello.sayHello("Double J");
    }
}
