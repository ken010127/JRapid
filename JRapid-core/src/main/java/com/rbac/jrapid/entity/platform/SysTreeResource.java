package com.rbac.jrapid.entity.platform;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 树资源信息，管理树机构的表信息实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysTreeResource implements Serializable {

    public final static String ID = "id";
    public final static String TABLE_NAME = "table_name";
    public final static String NODE_ID_FIELD = "node_id_field";
    public final static String NODE_PARENT_FIELD = "node_parent_field";
    public final static String NODE_NAME_FIELD = "node_name_field";
    public final static String RESOURCE_NAME = "resource_name";

    /**
    * 主键ID
    **/
    @PK
    private Long id;

    /**
    * 树表名
    **/
    private String tableName;

    /**
    * 节点ID字段
    **/
    private String nodeIdField;

    /**
    * 父节点ID字段
    **/
    private String nodeParentField;

    /**
    * 节点名称字段
    **/
    private String nodeNameField;

    /**
    * 资源名称
    **/
    private String resourceName;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTableName(){
        return tableName;
    }

    public void setTableName(String tableName){
        this.tableName = tableName;
    }

    public String getNodeIdField(){
        return nodeIdField;
    }

    public void setNodeIdField(String nodeIdField){
        this.nodeIdField = nodeIdField;
    }

    public String getNodeParentField(){
        return nodeParentField;
    }

    public void setNodeParentField(String nodeParentField){
        this.nodeParentField = nodeParentField;
    }

    public String getNodeNameField(){
        return nodeNameField;
    }

    public void setNodeNameField(String nodeNameField){
        this.nodeNameField = nodeNameField;
    }

    public String getResourceName(){
        return resourceName;
    }

    public void setResourceName(String resourceName){
        this.resourceName = resourceName;
    }

}