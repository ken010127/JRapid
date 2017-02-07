package org.JRapid.generation.bean;

import java.util.List;

/**
* 系统菜单管理实体类
* Created by JRapid on 2016-11-30 16:09:59.
*/
public class Model {

    private Long id;

    /**
     * 类名
     */
    private String className;

    /**
     * 标题
     */
    private String title;

    /**
     * 包名
     */
    private String modulePackage;

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
    private String referField;

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

    private List<TableConfig> tableConfigs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public void setModulePackage(String modulePackage) {
        this.modulePackage = modulePackage;
    }

    /**
    * 从表外检字段
    **/
    private String slaveFk;

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

    public String getReferField() {
        return referField;
    }

    public void setReferField(String referField) {
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

    public List<TableConfig> getTableConfigs() {
        return tableConfigs;
    }

    public void setTableConfigs(List<TableConfig> tableConfigs) {
        this.tableConfigs = tableConfigs;
    }
}