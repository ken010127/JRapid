package com.rbac.jrapid.entity.platform;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rbac.jrapid.core.common.annotation.CHILDREN;
import com.rbac.jrapid.core.common.annotation.ORDERID;
import com.rbac.jrapid.core.common.annotation.PARENTID;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 页面表格配置信息实体类
* Created by JRapid on 2017-3-14 17:06:06.
*/
public class SysGridConfig implements Serializable {

    public final static String ID = "id";
    public final static String GRID_TYPE = "grid_type";
    public final static String TITLE = "title";
    public final static String FIELD = "field";
    public final static String TYPE = "type";
    public final static String WIDTH = "width";
    public final static String DICTIONARY = "dictionary";
    public final static String ORDER_NO = "order_no";
    public final static String IS_DISPLAY = "is_display";
    public final static String IS_SEARCH = "is_search";
    public final static String SEARCH_TYPE = "search_type";
    public final static String CONDITION_TYPE = "condition_type";
    public final static String IS_MODIFY = "is_modify";
    public final static String MODIFY_TYPE = "modify_type";
    public final static String ALLOW_NULL = "allow_null";
    public final static String REFER_ID = "refer_id";
    public final static String MENU_ID = "menu_id";

    /**
    * 主键ID
    **/
    @PK
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;

    /**
    * 表格类型，DATAGRID、TREEGRID
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String gridType;

    /**
    * 列名称
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String title;

    /**
    * 字段名
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String field;

    /**
    * 字段类型
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String type;

    /**
    * 列宽
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private Integer width;

    /**
    * 是否使用字典编码
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String dictionary;

    /**
    * 序号
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private Integer orderNo;

    /**
    * 是否显示列,Y/N
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String isDisplay;

    /**
    * 是否查询条件,Y/N
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String isSearch;

    /**
    * 查询控件类型
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String searchType;

    /**
    * 查询条件类型
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String conditionType;

    /**
    * 是否编辑项,Y/N
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String isModify;

    /**
    * 编辑控件类型
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String modifyType;

    /**
    * 能否为空
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private String allowNull;

    /**
    * 关联ID，关联sys_menu或sys_tree_resource
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private Long referId;

    /**
    * 关联菜单ID
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private Long menuId;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getGridType(){
        return gridType;
    }

    public void setGridType(String gridType){
        this.gridType = gridType;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getField(){
        return field;
    }

    public void setField(String field){
        this.field = field;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public Integer getWidth(){
        return width;
    }

    public void setWidth(Integer width){
        this.width = width;
    }

    public String getDictionary(){
        return dictionary;
    }

    public void setDictionary(String dictionary){
        this.dictionary = dictionary;
    }

    public Integer getOrderNo(){
        return orderNo;
    }

    public void setOrderNo(Integer orderNo){
        this.orderNo = orderNo;
    }

    public String getIsDisplay(){
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay){
        this.isDisplay = isDisplay;
    }

    public String getIsSearch(){
        return isSearch;
    }

    public void setIsSearch(String isSearch){
        this.isSearch = isSearch;
    }

    public String getSearchType(){
        return searchType;
    }

    public void setSearchType(String searchType){
        this.searchType = searchType;
    }

    public String getConditionType(){
        return conditionType;
    }

    public void setConditionType(String conditionType){
        this.conditionType = conditionType;
    }

    public String getIsModify(){
        return isModify;
    }

    public void setIsModify(String isModify){
        this.isModify = isModify;
    }

    public String getModifyType(){
        return modifyType;
    }

    public void setModifyType(String modifyType){
        this.modifyType = modifyType;
    }

    public String getAllowNull(){
        return allowNull;
    }

    public void setAllowNull(String allowNull){
        this.allowNull = allowNull;
    }

    public Long getReferId(){
        return referId;
    }

    public void setReferId(Long referId){
        this.referId = referId;
    }

    public Long getMenuId(){
        return menuId;
    }

    public void setMenuId(Long menuId){
        this.menuId = menuId;
    }

}