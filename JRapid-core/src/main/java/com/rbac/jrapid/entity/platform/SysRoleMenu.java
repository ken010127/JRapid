package com.rbac.jrapid.entity.platform;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 角色菜单关系实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysRoleMenu implements Serializable {

    public final static String ROLE_ID = "role_id";
    public final static String MENU_ID = "menu_id";

    /**
    * 角色ID
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private Long roleId;

    /**
    * 菜单ID
    **/
    @JsonSerialize(using=ToStringSerializer.class)
    private Long menuId;


    public Long getRoleId(){
        return roleId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public Long getMenuId(){
        return menuId;
    }

    public void setMenuId(Long menuId){
        this.menuId = menuId;
    }

}