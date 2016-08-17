package org.JRapid.generation.bean;

import java.util.List;

/**
 * 实体类
 * Created by FWJ on 2015/5/7.
 */
public class Entity {

    /**
     * 基础包名
     */
    private String basePackage;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 实体描述
     */
    private String comments;

    /**
     * 数据库表名
     */
    private String tableName;

    /**
     * 类名
     */
    private String className;

    /**
     * 所包含的字段
     */
    private List<Field> fields;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
