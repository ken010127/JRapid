package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysUser;

/**
* 系统用户管理请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysUserRequest extends BaseRequest {

    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
