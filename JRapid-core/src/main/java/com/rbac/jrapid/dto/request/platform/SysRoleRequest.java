package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysRole;

/**
* 角色管理请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysRoleRequest extends BaseRequest {

    private SysRole sysRole;

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
}
