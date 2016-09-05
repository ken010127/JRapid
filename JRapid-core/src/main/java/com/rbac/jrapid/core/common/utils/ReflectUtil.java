package com.rbac.jrapid.core.common.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * java反射工具类
 * Created by FengWeijian on 2015/5/5.
 */
public class ReflectUtil {

    /**
     * 通过反射创建实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(String className) {
        T instance;
        try {
            Class<?> commandClass = ClassUtil.loadClass(className);
            instance = (T) commandClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 通过构造函数实例化对象
     * @param className       类的全路径名称
     * @param parameterTypes  参数类型
     * @param initargs        参数值
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Object constructorNewInstance(String className,Class [] parameterTypes,Object[] initargs) {
        try {
            Constructor<?> constructor = (Constructor<?>) Class
                    .forName(className).getDeclaredConstructor(parameterTypes);                     //暴力反射
            constructor.setAccessible(true);
            return constructor.newInstance(initargs);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

    }

    /**
     * 获取实体字段
     * @param entityClass 实体类
     * @return 所有字段
     */
    public static Field[] getFields(Class<?> entityClass){
        return entityClass.getDeclaredFields();
    }

    /**
     * 根据字段名获取字段属性
     * @param entityClass 实体类
     * @param fieldName 字段名
     * @return 字段属性
     */
    public static Field getFieldByFiledName(Class<?> entityClass,String fieldName){
        Field field = null;
        try {
            field = entityClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return field;
    }

    /**
     * 根据字段名获取值
     * @param entity
     * @return
     */
    public static Object getValue(Object entity,String fieldName){
        Class<?> entityClass = entity.getClass();
        try {
            PropertyDescriptor property = new PropertyDescriptor(fieldName, entityClass);
            Method getter = property.getReadMethod();
            return getter.invoke(entity);
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置字段值
     * @param entity
     * @param fieldName
     * @param value
     * @return
     */
    public static void setValue(Object entity,String fieldName,Object value){
        Class<?> entityClass = entity.getClass();
        try {
            PropertyDescriptor property = new PropertyDescriptor(fieldName, entityClass);
            Method setter = property.getWriteMethod();

            setter.invoke(entity, new Object[] { value });

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 得到某个对象的公共属性
     *
     * @param owner, fieldName
     * @return 该属性对象
     * @throws Exception
     *
     */
    public Object getProperty(Object owner, String fieldName) throws Exception {
        Class ownerClass = owner.getClass();

        Field field = ownerClass.getField(fieldName);

        Object property = field.get(owner);

        return property;
    }

    /**
     * 得到某类的静态公共属性
     *
     * @param className   类名
     * @param fieldName   属性名
     * @return 该属性对象
     * @throws Exception
     */
    public Object getStaticProperty(String className, String fieldName)
            throws Exception {
        Class ownerClass = Class.forName(className);

        Field field = ownerClass.getField(fieldName);

        Object property = field.get(ownerClass);

        return property;
    }


}
