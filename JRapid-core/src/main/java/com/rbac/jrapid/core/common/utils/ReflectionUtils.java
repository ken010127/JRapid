package com.rbac.jrapid.core.common.utils;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 反射工具类
 * @author FWJ
 * @since 2016/9/21 16:32
 */
public class ReflectionUtils {

    protected static Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    /**
     * 查找标了注解的属性 (包括父类的属性)
     * @param clazz 查找类 class
     * @param aClazz annotaion class
     * @return field
     */
    public static List<Field> findFieldByAnnotation(Class clazz, Class aClazz){
        List<Field> resultFields = new ArrayList<Field>();

        Class searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = searchType.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(aClazz)) {
                    resultFields.add(field);
                }
            }
            searchType = searchType.getSuperclass();
        }
        return resultFields;
    }

    /**
     * /根据类和属性名称查找属性字段
     * @param clazz 类
     * @param name 属性名称
     * @return
     */
    public static Field findField(Class clazz, String name) {
        return findField(clazz, name, null);
    }

    /**
     * 根据类、属性名称、属性类型查找属性字段
     * @param clazz 类
     * @param name 属性名称
     * @param type 属性类型
     * @return
     */
    public static Field findField(Class clazz, String name, Class type) {
        Assert.notNull(clazz, "Class must not be null");
        Assert.isTrue(name != null || type != null, "Either name or type of the field must be specified");
        Class searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = searchType.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                if ((name == null || name.equals(field.getName()))
                        && (type == null || type.equals(field.getType()))) {
                    return field;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * 根据属性字段和对象，设置对象的值
     * @param field 字段
     * @param target 对象
     * @param value 值
     */
    public static void setField(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        }
        catch (IllegalAccessException ex) {
            throw new IllegalStateException(
                    "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    /**
     * 根据属性字段和对象，获取的对象中字段的值
     * @param field 字段
     * @param target 对象
     * @return
     */
    public static Object getField(Field field, Object target) {
        try {
            return field.get(target);
        }
        catch (IllegalAccessException ex) {
            throw new IllegalStateException(
                    "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    /**
     * 根据类，方法名称和参数类型查找方法
     * @param clazz
     * @param name
     * @return
     */
    public static Method findMethod(Class clazz, String name) {
        return findMethod(clazz, name, new Class[0]);
    }

    /**
     * 根据类，方法名称和参数类型查找方法
     * @param clazz
     * @param name
     * @param paramTypes
     * @return
     */
    public static Method findMethod(Class clazz, String name, Class[] paramTypes) {
        Assert.notNull(clazz, "Class must not be null");
        Assert.notNull(name, "Method name must not be null");
        Class searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (name.equals(method.getName()) &&
                        (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
                    return method;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * 调用方法的应用
     * @param method
     * @param target
     * @return
     */
    public static Object invokeMethod(Method method, Object target) {
        return invokeMethod(method, target, null);
    }

    /**
     * 调用方法的应用
     * @param method
     * @param target
     * @param args
     * @return
     */
    public static Object invokeMethod(Method method, Object target, Object[] args) {
        try {
            return method.invoke(target, args);
        }
        catch (Exception ex) {
            throw new IllegalStateException("Should never get here");
        }

    }
}
