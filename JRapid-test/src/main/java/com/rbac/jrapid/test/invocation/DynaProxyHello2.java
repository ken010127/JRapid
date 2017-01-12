package com.rbac.jrapid.test.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * InvocationHandler接口就把我们的代理对象和被代理对象解藕,
 * 这个DynaPoxyHello对象只能跟我们去在方法前后加上日志记录的操作.
 * 我们要在被代理对象的方法前面或者后面去加上日志操作代码(或者是其它操作的代码),
 * 那么,我们可以抽象出一个接口 IOperation,这个接口里就只有两个方法,
 * 一个是在被代理对象要执行方法之前执行的方法,我们取名为start,
 * 第二个方法就是在被代理对象执行方法之后执行的方法,
 * 我们取名为end我们能不能把DynaPoxyHello对象和日志操作对象(Logger)解藕
 *
 * @author FWJ
 * @since 2017/1/11 下午4:46
 */
public class DynaProxyHello2 implements InvocationHandler {

    /**
     * 操作者
     */
    private Object proxy;
    /**
     * 要处理的对象(也就是我们要在方法的前后加上业务逻辑的对象,如例子中的Hello)
     */
    private Object delegate;

    /**
     * 动态生成方法被处理过后的对象 (写法固定)
     *
     * @param delegate
     * @param proxy
     * @return
     */
    public Object bind(Object delegate, Object proxy) {

        this.proxy = proxy;
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                this.delegate.getClass().getClassLoader(), this.delegate
                        .getClass().getInterfaces(), this);
    }

    /**
     * 要处理的对象中的每个方法会被此方法送去JVM调用,也就是说,要处理的对象的方法只能通过此方法调用
     * 此方法是动态的,不是手动调用的
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            //反射得到操作者的实例
            Class clazz = this.proxy.getClass();
            //反射得到操作者的Start方法
            Method start = clazz.getDeclaredMethod("start",
                    new Class[]{Method.class});
            //反射执行start方法
            start.invoke(this.proxy, new Object[]{method});
            //执行要处理对象的原本方法
            result = method.invoke(this.delegate, args);
            //反射得到操作者的end方法
            Method end = clazz.getDeclaredMethod("end",
                    new Class[]{Method.class});
            //反射执行end方法
            end.invoke(this.proxy, new Object[]{method});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
