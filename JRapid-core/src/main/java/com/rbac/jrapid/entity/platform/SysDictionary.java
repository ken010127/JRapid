package com.rbac.jrapid.entity.platform;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 数据字典实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysDictionary implements Serializable {

    public final static String ID = "id";
    public final static String PARENT_ID = "parent_id";
    public final static String PARENT_CODE = "parent_code";
    public final static String PARENT_NAME = "parent_name";
    public final static String DICT_NAME = "dict_name";
    public final static String DICT_CODE = "dict_code";
    public final static String DIRECTION = "direction";

    public final static String DICT_CHILDREN = "dict_children";

    /**
    * 
    **/
    @PK
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;

    /**
    * 父节点ID
    **/
    private Long parentId;

    /**
    * 父节点编码
    **/
    private String parentCode;

    /**
    * 父节点名称
    **/
    private String parentName;

    /**
    * 字典名称
    **/
    private String dictName;

    /**
    * 字典编码
    **/
    private String dictCode;

    /**
    * 字典描述
    **/
    private String direction;


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

    public String getParentCode(){
        return parentCode;
    }

    public void setParentCode(String parentCode){
        this.parentCode = parentCode;
    }

    public String getParentName(){
        return parentName;
    }

    public void setParentName(String parentName){
        this.parentName = parentName;
    }

    public String getDictName(){
        return dictName;
    }

    public void setDictName(String dictName){
        this.dictName = dictName;
    }

    public String getDictCode(){
        return dictCode;
    }

    public void setDictCode(String dictCode){
        this.dictCode = dictCode;
    }

    public String getDirection(){
        return direction;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

}