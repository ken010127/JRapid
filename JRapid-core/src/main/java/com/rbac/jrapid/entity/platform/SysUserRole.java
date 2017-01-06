package com.rbac.jrapid.entity.platform;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 用户角色关系实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysUserRole implements Serializable {

    public final static String USER_ID = "user_id";
    public final static String ROLE_ID = "role_id";

    /**
    * 用户ID
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private Long userId;

    /**
    * 角色ID
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private Long roleId;


    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Long getRoleId(){
        return roleId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

}