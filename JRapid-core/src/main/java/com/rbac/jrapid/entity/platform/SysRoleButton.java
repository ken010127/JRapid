package com.rbac.jrapid.entity.platform;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysRoleButton implements Serializable {

    public final static String ROLE_ID = "role_id";
    public final static String BOTTON_ID = "botton_id";

    /**
    * 角色ID
    **/
    private Long roleId;

    /**
    * 按钮ID
    **/
    private Long bottonId;


    public Long getRoleId(){
        return roleId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public Long getBottonId(){
        return bottonId;
    }

    public void setBottonId(Long bottonId){
        this.bottonId = bottonId;
    }

}