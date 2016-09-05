package com.rbac.jrapid.core.common.utils;


import java.util.UUID;

/**
 * jababean帮助类
 * @author FengWeijian
 *
 */
public class JavaBeanUtil {
	/**
	 * 返回36位UUID
	 * @return
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();  
        // 去掉"-"符号  
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);  
        return temp;
	}

}
