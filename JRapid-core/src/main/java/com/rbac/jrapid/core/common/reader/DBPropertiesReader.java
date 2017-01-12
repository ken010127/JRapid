package com.rbac.jrapid.core.common.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties工具类
 * @author: FWJ
 * @date 2016/8/17  17:41
 */
public class DBPropertiesReader extends BasePropertiesReader{
    public DBPropertiesReader() {
        InputStream in = Object.class.getResourceAsStream( "/config/db.properties" );
        try  {
            properties.loadFromXML(in);
        }  catch  (IOException e) {
            e.printStackTrace();
        }
    }
}
