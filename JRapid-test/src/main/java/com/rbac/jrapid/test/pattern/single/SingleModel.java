package com.rbac.jrapid.test.pattern.single;

/**
 * 单例模式例子，保证线程安全
 * @author FWJ
 * @since 2017/3/15 下午4:55
 */
public class SingleModel {

    private static SingleModel instance = null;

    public SingleModel() {
        //Load configuration information from DB or file
        //Set values for properties
    }

    //线程安全
    protected static synchronized void syncInit() {
        if (instance == null) {
            instance = new SingleModel();
        }
    }

    public static SingleModel getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public void updateProperties() {
        //Load updated configuration information by new a GlobalConfig object
        SingleModel newReader = new SingleModel();
    }

}
