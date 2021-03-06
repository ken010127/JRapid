package com.rbac.jrapid.core.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * JDBC类型与JAVA类型是多对多关系
 * Created by FengWeijian on 2015/5/8.
 */
public class JdbcTypesUtils {

    private static Map<String, Integer> jdbcTypes; // Name to value
    private static Map<Integer, String> jdbcTypeValues; // value to Name
    private static Map<Integer, Class<?>> jdbcJavaTypes; // jdbc type to java type
    private static Map<Class<?>,Integer> javaJdbcTypes; //java type to jdbc type
    static {
        jdbcTypes = new TreeMap<String, Integer>();
        jdbcTypeValues = new TreeMap<Integer, String>();
        jdbcJavaTypes = new TreeMap<Integer, Class<?>>();
        Field[] fields = Types.class.getFields();
        for (int i=0, len=fields.length; i<len; ++i) {
            if (Modifier.isStatic(fields[i].getModifiers())) {
                try {
                    String name = fields[i].getName();
                    Integer value = (Integer) fields[i].get(Types.class);
                    jdbcTypes.put(name, value);
                    jdbcTypeValues.put(value, name);
                } catch (IllegalArgumentException e) {

                } catch (IllegalAccessException e) {

                }
            }
        }
        // 初始化jdbcJavaTypes：jdbcType映射到java类型
        jdbcJavaTypes.put(new Integer(Types.LONGNVARCHAR), String.class);  // -16 字符串
        jdbcJavaTypes.put(new Integer(Types.NCHAR), String.class);    // -15 字符串
        jdbcJavaTypes.put(new Integer(Types.NVARCHAR), String.class);   // -9 字符串
        jdbcJavaTypes.put(new Integer(Types.ROWID), String.class);    // -8 字符串
        jdbcJavaTypes.put(new Integer(Types.BIT), Boolean.class);    // -7 布尔
        jdbcJavaTypes.put(new Integer(Types.TINYINT), Byte.class);    // -6 数字
        jdbcJavaTypes.put(new Integer(Types.BIGINT), Long.class);    // -5 数字
        jdbcJavaTypes.put(new Integer(Types.LONGVARBINARY), Blob.class);  // -4 二进制
        jdbcJavaTypes.put(new Integer(Types.VARBINARY), Blob.class);   // -3 二进制
        jdbcJavaTypes.put(new Integer(Types.BINARY), Blob.class);    // -2 二进制
        jdbcJavaTypes.put(new Integer(Types.LONGVARCHAR), String.class);  // -1 字符串
        //  jdbcJavaTypes.put(new Integer(Types.NULL), String.class);    // 0 /
        jdbcJavaTypes.put(new Integer(Types.CHAR), String.class);    // 1 字符串
        jdbcJavaTypes.put(new Integer(Types.NUMERIC), Integer.class);  // 2 数字 原本为BigDecimal修改
        jdbcJavaTypes.put(new Integer(Types.DECIMAL), Integer.class);  // 3 数字 原本为BigDecimal修改
        jdbcJavaTypes.put(new Integer(Types.INTEGER), Integer.class);   // 4 数字
        jdbcJavaTypes.put(new Integer(Types.SMALLINT), Short.class);   // 5 数字
        jdbcJavaTypes.put(new Integer(Types.FLOAT), Float.class);   // 6 数字
        jdbcJavaTypes.put(new Integer(Types.REAL), BigDecimal.class);   // 7 数字
        jdbcJavaTypes.put(new Integer(Types.DOUBLE), Double.class);  // 8 数字
        jdbcJavaTypes.put(new Integer(Types.VARCHAR), String.class);   // 12 字符串
        jdbcJavaTypes.put(new Integer(Types.BOOLEAN), Boolean.class);   // 16 布尔
//  jdbcJavaTypes.put(new Integer(Types.DATALINK), String.class);   // 70 /
        jdbcJavaTypes.put(new Integer(Types.DATE), Date.class);    // 91 日期
        jdbcJavaTypes.put(new Integer(Types.TIME), Date.class);    // 92 日期
        jdbcJavaTypes.put(new Integer(Types.TIMESTAMP), Date.class);   // 93 日期
        jdbcJavaTypes.put(new Integer(Types.OTHER), Object.class);    // 1111 其他类型？
//  jdbcJavaTypes.put(new Integer(Types.JAVA_OBJECT), Object.class);  // 2000
//  jdbcJavaTypes.put(new Integer(Types.DISTINCT), String.class);   // 2001
//  jdbcJavaTypes.put(new Integer(Types.STRUCT), String.class);   // 2002
//  jdbcJavaTypes.put(new Integer(Types.ARRAY), String.class);    // 2003
        jdbcJavaTypes.put(new Integer(Types.BLOB), Blob.class);    // 2004 二进制
        jdbcJavaTypes.put(new Integer(Types.CLOB), Clob.class);    // 2005 大文本
//  jdbcJavaTypes.put(new Integer(Types.REF), String.class);    // 2006
//  jdbcJavaTypes.put(new Integer(Types.SQLXML), String.class);   // 2009
        jdbcJavaTypes.put(new Integer(Types.NCLOB), Clob.class);    // 2011 大文本

        //java类型映射jdbc类型
        javaJdbcTypes.put(String.class,new Integer(Types.VARCHAR));
        javaJdbcTypes.put(BigDecimal.class,new Integer(Types.NUMERIC));
        javaJdbcTypes.put(Boolean.class,new Integer(Types.BIT));
        javaJdbcTypes.put(Integer.class,new Integer(Types.INTEGER));
        javaJdbcTypes.put(Long.class,new Integer(Types.BIGINT));
        javaJdbcTypes.put(Float.class,new Integer(Types.REAL));
        javaJdbcTypes.put(Double.class,new Integer(Types.DOUBLE));
        javaJdbcTypes.put(Byte.class,new Integer(Types.TINYINT));
        javaJdbcTypes.put(Date.class,new Integer(Types.DATE));
        javaJdbcTypes.put(Time.class,new Integer(Types.TIME));
        javaJdbcTypes.put(Timestamp.class,new Integer(Types.TIMESTAMP));
    }

    /**
     * 转换成JDBC编码
     * @param jdbcName 类型
     * @return
     */
    public static int getJdbcCode(String jdbcName) {
        return jdbcTypes.get(jdbcName);
    }

    public static String getJdbcName(int jdbcCode) {
        return jdbcTypeValues.get(jdbcCode);
    }

    public static Class<?> jdbcTypeToJavaType(int jdbcType) {
        return jdbcJavaTypes.get(jdbcType);
    }

    public static boolean isJavaNumberType(int jdbcType) {
        Class<?> type = jdbcJavaTypes.get(jdbcType);
        return (type == null) ? false : (Number.class.isAssignableFrom(type))? true : false;
    }

    public static void main(String[] args) {
        System.out.println(getJdbcCode("bigint".toUpperCase()));
    }

}
