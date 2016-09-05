package com.rbac.jrapid.core.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Object转换类
 * @author fwj
 *
 */
public class ObjectParseUtil {

	public static String parseToString(Object obj){
		if(null==obj){
			return null;
		}else{
			return obj.toString();
		}
	}
	
	/**
	 * 转换成字符串，null转为""
	 * @param obj 
	 * @return
	 */
	public static String parseToStringNull(Object obj){
		if(null==obj){
			return "";
		}else{
			return obj.toString();
		}
	}
	
	public static Integer parseToInteger(Object obj){
		if(null==obj){
			return null;
		}else{
			return Integer.parseInt(obj.toString());
		}
	}
	
	public static Date parseToDate(Object obj){
		if(null!=obj){
			Date date = null;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				date = df.parse(obj.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
		return null;
		
	}
	
	public static Boolean parseToBoolean(Object obj){
		return Boolean.parseBoolean(obj.toString());
	}
}
