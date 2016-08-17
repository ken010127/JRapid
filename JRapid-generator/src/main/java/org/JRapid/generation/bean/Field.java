package org.JRapid.generation.bean;

/**
 * 数据库字段
 * Created by FWJ on 2015/5/7.
 */
public class Field {

    /**
     * 是否主键
     */
    private boolean pk;

    /**
     * 字段描述
     */
    private String comments;

    /**
     * 数据字段名
     */
    private String columnName;

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 字段类型
     */
    private String type;

    public boolean isPk() {
        return pk;
    }

    public void setPk(boolean pk) {
        this.pk = pk;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
