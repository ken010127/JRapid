package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysUserRole;

/**
* 用户角色关系请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysUserRoleRequest extends BaseRequest {

    private SysUserRole sysUserRole;

    public SysUserRole getSysUserRole() {
        return sysUserRole;
    }

    public void setSysUserRole(SysUserRole sysUserRole) {
        this.sysUserRole = sysUserRole;
    }
}
