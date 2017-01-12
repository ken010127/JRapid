package com.rbac.jrapid.core.common.reader;

import java.util.Properties;

/**
 * 基础的properties读取方法
 * @author FWJ
 * @since 2017/1/9 下午2:27
 */
public class BasePropertiesReader {

    private static BasePropertiesReader instance = null;

    protected Properties properties = null;

    public BasePropertiesReader() {
        //Load configuration information from DB or file
        //Set values for properties
    }

    //线程安全
    protected static synchronized void syncInit() {
        if (instance == null) {
            instance = new BasePropertiesReader();
        }
    }

    public static BasePropertiesReader getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public String getProperties(String key) {
        return properties.getProperty(key).trim();
    }

    public void updateProperties() {
        //Load updated configuration information by new a GlobalConfig object
        BasePropertiesReader newReader = new BasePropertiesReader();
    }

}
