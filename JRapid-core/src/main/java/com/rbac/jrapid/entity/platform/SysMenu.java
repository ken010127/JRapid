package com.rbac.jrapid.entity.platform;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rbac.jrapid.core.common.annotation.CHILDREN;
import com.rbac.jrapid.core.common.annotation.ORDERID;
import com.rbac.jrapid.core.common.annotation.PARENTID;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;
import java.util.List;

/**
* 系统菜单管理实体类
* Created by JRapid on 2016-11-30 16:09:59.
*/
public class SysMenu implements Serializable {

    public final static String ID = "id";
    public final static String PARENT_ID = "parent_id";
    public final static String MENU_NAME = "menu_name";
    public final static String URL = "url";
    public final static String ICON = "icon";
    public final static String ORDER_NO = "order_no";
    public final static String OPEN_TYPE = "open_type";
    public final static String MODEL_TYPE = "model_type";
    public final static String TREE_ID = "tree_id";
    public final static String REFER_FIELD = "refer_field";
    public final static String MASTER_TABLE = "master_table";
    public final static String MASTER_PK = "master_pk";
    public final static String SLAVE_TABLE = "slave_table";
    public final static String SLAVE_FK = "slave_fk";

    /**
    * 主键ID
    **/
    @PK
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;

    /**
    * 父节点ID
    **/
    @PARENTID
    private Long parentId;

    /**
    * 菜单名称
    **/
    private String menuName;

    /**
    * 访问路径
    **/
    private String url;

    /**
    * 图标
    **/
    private String icon;

    /**
    * 序号
    **/
    @ORDERID
    private Integer orderNo;

    /**
    * 打开方式
    **/
    private String openType;

    /**
    * 模板类型，DataGrid,Tree+Datagrid，主从表
    **/
    private String modelType;

    /**
    * 左树资源ID
    **/
    private Long treeId;

    /**
    * 树关联字段
    **/
    private Long referField;

    /**
    * 主表表名
    **/
    private String masterTable;

    /**
    * 主表主键字段
    **/
    private String masterPk;

    /**
    * 从表表名
    **/
    private String slaveTable;

    /**
    * 从表外检字段
    **/
    private String slaveFk;

    /**
     *子节点
     */
    @CHILDREN
    private List<SysMenu> children;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getParentId(){
        return parentId;
    }

    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    public String getMenuName(){
        return menuName;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public Integer getOrderNo(){
        return orderNo;
    }

    public void setOrderNo(Integer orderNo){
        this.orderNo = orderNo;
    }

    public String getOpenType(){
        return openType;
    }

    public void setOpenType(String openType){
        this.openType = openType;
    }

    public String getModelType(){
        return modelType;
    }

    public void setModelType(String modelType){
        this.modelType = modelType;
    }

    public Long getTreeId(){
        return treeId;
    }

    public void setTreeId(Long treeId){
        this.treeId = treeId;
    }

    public Long getReferField(){
        return referField;
    }

    public void setReferField(Long referField){
        this.referField = referField;
    }

    public String getMasterTable(){
        return masterTable;
    }

    public void setMasterTable(String masterTable){
        this.masterTable = masterTable;
    }

    public String getMasterPk(){
        return masterPk;
    }

    public void setMasterPk(String masterPk){
        this.masterPk = masterPk;
    }

    public String getSlaveTable(){
        return slaveTable;
    }

    public void setSlaveTable(String slaveTable){
        this.slaveTable = slaveTable;
    }

    public String getSlaveFk(){
        return slaveFk;
    }

    public void setSlaveFk(String slaveFk){
        this.slaveFk = slaveFk;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }
}