package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysUserRole;

/**
* 用户角色关系返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysUserRoleResponse extends BaseResponse {

    private SysUserRole sysUserRole;

    public SysUserRole getSysUserRole() {
        return sysUserRole;
    }

    public void setSysUserRole(SysUserRole sysUserRole) {
        this.sysUserRole = sysUserRole;
    }
}
