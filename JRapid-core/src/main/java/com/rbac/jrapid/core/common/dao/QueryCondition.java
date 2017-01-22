package com.rbac.jrapid.core.common.dao;

import java.io.Serializable;

/**
 * 查询条件
 * @author FWJ
 * @since 2016/11/15 上午10:47
 */
public class QueryCondition implements Serializable{

    private static final long serialVersionUID = -639963874811754837L;

    public static final String LIKE_TYPE = "LIKE";
    public static final String Left_LIKE_TYPE = "LEFT_LIKE";
    public static final String RIGHT_LIKE_TYPE = "RIGHT_LIKE";
    public static final String EQUAL_TYPE = "EQUAL";
    public static final String IN_TYPE = "IN";
    public static final String EXIST_TYPE = "EXIST";
    public static final String GREATER_TYPE = "GREATER";
    public static final String LESS_TYPE = "LESS";
    public static final String TIME_GREATER_TYPE = "TIME_GREATER";
    public static final String TIME_LESS_TYPE = "TIME_LESS";

    /**
     * 以哪种函数在数据库中使用查询，如=，like，等
     */
    String queryType;
    //查询哪个字段
    String queryProperty;
    //字段值是多少
    Object queryValue;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getQueryProperty() {
        return queryProperty;
    }

    public void setQueryProperty(String queryProperty) {
        this.queryProperty = queryProperty;
    }

    public Object getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(Object queryValue) {
        this.queryValue = queryValue;
    }
}
