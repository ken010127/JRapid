package com.rbac.jrapid.entity.platform;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 角色管理实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysRole implements Serializable {

    public final static String ID = "id";
    public final static String ROLE_NAME = "role_name";
    public final static String DESCRIPTION = "description";
    public final static String CREATE_USER = "create_user";
    public final static String CREATE_TIME = "create_time";
    public final static String MODIFY_USER = "modify_user";
    public final static String MODIFY_TIME = "modify_time";

    /**
    * 主键ID
    **/
    @PK
    private Long id;

    /**
    * 角色名称
    **/
    private String roleName;

    /**
    * 描述
    **/
    private String description;

    /**
    * 创建人
    **/
    private String createUser;

    /**
    * 创建时间
    **/
    private java.util.Date createTime;

    /**
    * 修改人
    **/
    private String modifyUser;

    /**
    * 修改时间
    **/
    private java.util.Date modifyTime;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getRoleName(){
        return roleName;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getCreateUser(){
        return createUser;
    }

    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }

    public java.util.Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }

    public String getModifyUser(){
        return modifyUser;
    }

    public void setModifyUser(String modifyUser){
        this.modifyUser = modifyUser;
    }

    public java.util.Date getModifyTime(){
        return modifyTime;
    }

    public void setModifyTime(java.util.Date modifyTime){
        this.modifyTime = modifyTime;
    }

}