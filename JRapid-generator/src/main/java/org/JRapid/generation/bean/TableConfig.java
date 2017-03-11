package org.JRapid.generation.bean;

import java.io.Serializable;

/**
* 页面表格配置信息实体类
* Created by JRapid on 2017-1-4 9:57:43.
*/
public class TableConfig implements Serializable {

    /**
    * 表格类型，DATAGRID、TREEGRID
    **/
    private String gridType;

    /**
    * 列名称
    **/
    private String title;

    /**
    * 数据库字段名
    **/
    private String field;

    /**
     * 属性名
     */
    private String property;

    /**
    * 列宽
    **/
    private Integer width;

    /**
    * 是否使用字典编码
    **/
    private String dictionary;

    /**
    * 序号
    **/
    private Integer orderNo;

    /**
    * 是否显示列,Y/N
    **/
    private String isDisplay;

    /**
    * 是否查询条件,Y/N
    **/
    private String isSearch;

    /**
    * 查询控件类型
    **/
    private String searchType;

    /**
    * 是否编辑项,Y/N
    **/
    private String isModify;

    /**
    * 编辑控件类型
    **/
    private String modifyType;

    /**
     * 能否为空
     */
    private String allowNull;

    /**
    * 关联ID，关联sys_menu或sys_tree_resource
    **/
    private Long referId;

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

    public String getAllowNull() {
        return allowNull;
    }

    public void setAllowNull(String allowNull) {
        this.allowNull = allowNull;
    }

    public Long getReferId(){
        return referId;
    }

    public void setReferId(Long referId){
        this.referId = referId;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}