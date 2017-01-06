package com.rbac.jrapid.entity.platform;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 组织架构实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysOrg implements Serializable {

    public final static String ID = "id";
    public final static String PARENT_ID = "parent_id";
    public final static String ORG_CODE = "org_code";
    public final static String ORG_NAME = "org_name";
    public final static String ORG_TYPE = "org_type";
    public final static String CONTACT_NAME = "contact_name";
    public final static String CONTACT_PHONE = "contact_phone";
    public final static String CREATE_USER = "create_user";
    public final static String CREATE_TIME = "create_time";
    public final static String MODIFY_USER = "modify_user";
    public final static String MODIFY_TIME = "modify_time";

    /**
    * 主键ID
    **/
    @PK
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;

    /**
    * 上级ID
    **/
    private Long parentId;

    /**
    * 组织编码
    **/
    private String orgCode;

    /**
    * 组织名称
    **/
    private String orgName;

    /**
    * 组织类型，从字典表中取
    **/
    private String orgType;

    /**
    * 联系人
    **/
    private String contactName;

    /**
    * 联系电话
    **/
    private String contactPhone;

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

    public Long getParentId(){
        return parentId;
    }

    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    public String getOrgCode(){
        return orgCode;
    }

    public void setOrgCode(String orgCode){
        this.orgCode = orgCode;
    }

    public String getOrgName(){
        return orgName;
    }

    public void setOrgName(String orgName){
        this.orgName = orgName;
    }

    public String getOrgType(){
        return orgType;
    }

    public void setOrgType(String orgType){
        this.orgType = orgType;
    }

    public String getContactName(){
        return contactName;
    }

    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    public String getContactPhone(){
        return contactPhone;
    }

    public void setContactPhone(String contactPhone){
        this.contactPhone = contactPhone;
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