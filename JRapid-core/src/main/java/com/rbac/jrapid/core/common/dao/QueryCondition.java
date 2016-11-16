package com.rbac.jrapid.core.common.dao;

import java.io.Serializable;

/**
 * 查询条件
 * @author FWJ
 * @since 2016/11/15 上午10:47
 */
public class QueryCondition implements Serializable{

    private static final long serialVersionUID = -639963874811754837L;

    public static final String INTEGER_TYPE="java.lang.Integer";
    public static final String STRING_TYPE="java.lang.String";
    public static final String LONG_TYPE="java.lang.Long";
    public static final String DATE_TYPE="java.util.Date";

    public static final String LIKE_TYPE="LIKE";
    public static final String EUQAL_TYPE="EUQAL";
    public static final String IN_TYPE="IN";
    public static final String EXIST_TYPE="EXIST";

    //以哪种函数在数据库中使用查询，如=，like，等
    String queryMethod;
    //查询哪个字段
    String queryProperty;
    //字段值是多少
    Object value;
    //查询的字段的数据类型，如int，long,String等
    String propertyType;

    public String getQueryMethod() {
        return queryMethod;
    }

    public void setQueryMethod(String queryMethod) {
        this.queryMethod = queryMethod;
    }

    public String getQueryProperty() {
        return queryProperty;
    }

    public void setQueryProperty(String queryProperty) {
        this.queryProperty = queryProperty;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
