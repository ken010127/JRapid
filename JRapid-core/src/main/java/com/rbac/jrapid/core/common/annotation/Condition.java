package com.rbac.jrapid.core.common.annotation;

import com.rbac.jrapid.core.common.dao.QueryCondition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 查询条件注解，用来转换成sql语句
 * @author FWJ
 * @since 2017/3/11 下午4:55
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Condition {

    String queryType() default QueryCondition.EQUAL_TYPE;

    String queryProperty() default "";

}
