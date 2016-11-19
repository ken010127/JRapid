package com.rbac.jrapid.core.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
        List<Field> resultFields = new ArrayList<>();

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
     * 根据属性字段和对象，设置对象的值(只能是public)
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
     * 根据属性字段和对象，获取的对象中字段的值(只能是public)
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
     * 根据类，方法名称和参数类型查找方法(方法没有参数)
     * @param clazz 对象class
     * @param name 方法名
     * @return
     */
    public static Method findMethod(Class clazz, String name) {
        return findMethod(clazz, name, new Class[0]);
    }

    /**
     * 根据类，方法名称和参数类型查找方法
     * @param clazz 对象class
     * @param name 方法名
     * @param paramTypes 参数类型
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
     * 调用方法的应用(无参数)
     * @param method 方法
     * @param target 调用对象
     * @return
     */
    public static Object invokeMethod(Method method, Object target) {
        return invokeMethod(method, target, null);
    }

    /**
     * 调用方法的应用(有参数)
     * @param method 方法
     * @param target 调用对象
     * @param args 参数
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
    public static Field[] getAllFields(Class<?> entityClass){
        return entityClass.getDeclaredFields();
    }

    /**
     * 根据字段名获取值
     * @param entity
     * @return
     */
    public static Object invokeGetterMethod(Object entity,String fieldName){
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
    public static void invokeSetterMethod(Object entity,String fieldName,Object value){
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
    public static Object getProperty(Object owner, String fieldName) throws Exception {
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
    public static Object getStaticProperty(String className, String fieldName)
            throws Exception {
        Class ownerClass = Class.forName(className);

        Field field = ownerClass.getField(fieldName);

        Object property = field.get(ownerClass);

        return property;
    }
}
