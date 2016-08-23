package com.rbac.jrapid.core.db.mybatis.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * 注解解析
 * @author: FWJ
 * @date 2016/8/23  19:32
 */
public class AnnotationParser {
    protected static Logger logger = LoggerFactory.getLogger(AnnotationParser.class);

    /**
     * 获取实体主键字段
     * @param entityClass 实体类
     * @return 主键字段
     */
    public static Field getPKField(Class<?> entityClass){
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PK.class)) {
                return field;
            }
        }
        return null;
    }

    /**
     * 调用该字段的setter方法
     * @param target    要设置值得javabean
     * @param prop      字段属性
     * @param value     字段值
     * @throws java.sql.SQLException
     */
    private static void callSetter(Object target, PropertyDescriptor prop, Object value)
            throws Exception {

        Method setter = prop.getWriteMethod();

        if (setter == null) {
            return;
        }
        //获取set方法参数
        Class<?>[] params = setter.getParameterTypes();

        // convert types for some popular ones
        if (value != null) {
            if (value instanceof java.util.Date) {
                if (params[0].getName().equals("java.sql.Date")) {
                    value = new java.sql.Date(((java.util.Date) value)
                            .getTime());
                } else if (params[0].getName().equals("java.sql.Time")) {
                    value = new java.sql.Time(((java.util.Date) value)
                            .getTime());
                } else if (params[0].getName().equals("java.sql.Timestamp")) {
                    value = new Timestamp(((java.util.Date) value)
                            .getTime());
                }
            }
        }

        // Don't call setter if the value object isn't the right type
        if (isCompatibleType(value, params[0])) {
            setter.invoke(target, value);
        } else {
            throw new SQLException("Cannot set " + prop.getName()
                    + ": incompatible types.");
        }

    }


    /**
     * 判断是否可以转换
     * @param value 值
     * @param type 实体class
     * @return 是否
     */
    private static boolean isCompatibleType(Object value, Class<?> type) {
        // Do object check first, then primitives
        if (value == null || type.isInstance(value)) {
            return true;

        } else if (type.equals(Integer.TYPE) && Integer.class.isInstance(value)) {
            return true;

        } else if (type.equals(Long.TYPE) && Long.class.isInstance(value)) {
            return true;

        } else if (type.equals(Double.TYPE) && Double.class.isInstance(value)) {
            return true;

        } else if (type.equals(Float.TYPE) && Float.class.isInstance(value)) {
            return true;

        } else if (type.equals(Short.TYPE) && Short.class.isInstance(value)) {
            return true;

        } else if (type.equals(Byte.TYPE) && Byte.class.isInstance(value)) {
            return true;

        } else if (type.equals(Character.TYPE)
                && Character.class.isInstance(value)) {
            return true;

        } else if (type.equals(Boolean.TYPE) && Boolean.class.isInstance(value)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 设置主键ID
     * @param object 实体
     * @param pkValue 值
     */
    public static void setPKvalue(Object object,Object pkValue) throws Exception {
        Field pkField = getPKField(object.getClass());
        PropertyDescriptor prop;
        //获取某个字段的属性
        prop = new PropertyDescriptor(pkField.getName(), object.getClass());
        callSetter(object, prop, pkValue);
    }

}
