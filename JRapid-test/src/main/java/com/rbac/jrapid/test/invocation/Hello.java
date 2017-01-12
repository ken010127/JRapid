package com.rbac.jrapid.test.invocation;

/**
 * @author FWJ
 * @since 2017/1/11 下午2:52
 */
public class Hello implements IHello {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    @Override
    public void sayGoogBye(String name) {
        System.out.println(name+" GoodBye!");
    }
}
