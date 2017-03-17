package com.rbac.jrapid.core.common.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties工具类
 * @author: FWJ
 * @date 2016/8/17  17:41
 */
public class DBPropertiesReader{

    private static Properties prop = new Properties();

    static  {
        InputStream in = DBPropertiesReader.class.getResourceAsStream( "/config/db.properties" );
        try  {
            prop.load(in);
        }  catch  (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return prop.getProperty(key).trim();
    }

    public static void main(String[] args) {
        String db = DBPropertiesReader.getValue("db.dbType");
        System.out.println(db);
    }

}
