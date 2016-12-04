package com.rbac.jrapid.entity.platform;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 用户组织机构关系实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysUserOrg implements Serializable {

    public final static String ORG_ID = "org_id";
    public final static String USER_ID = "user_id";

    /**
    * 组织ID
    **/
    private Long orgId;

    /**
    * 用户ID
    **/
    private Long userId;


    public Long getOrgId(){
        return orgId;
    }

    public void setOrgId(Long orgId){
        this.orgId = orgId;
    }

    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

}