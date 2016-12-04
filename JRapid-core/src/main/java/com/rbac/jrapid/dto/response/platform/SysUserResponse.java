package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysUser;

/**
* 系统用户管理返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysUserResponse extends BaseResponse {

    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
