package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysRole;

/**
* 角色管理返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysRoleResponse extends BaseResponse {

    private SysRole sysRole;

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
}
