package org.JRapid.generation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties工具类
 * @author: FWJ
 * @date 2016/8/17  17:41
 */
public class PropertiesUtil {
    private static Properties prop = new Properties();

    static  {
        InputStream in = Object. class .getResourceAsStream( "/config/generation-config.xml" );
        try  {
            prop.loadFromXML(in);
        }  catch  (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return prop.getProperty(key).trim();
    }

}
