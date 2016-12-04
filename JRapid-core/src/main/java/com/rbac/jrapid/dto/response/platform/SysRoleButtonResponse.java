package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysRoleButton;

/**
* 返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysRoleButtonResponse extends BaseResponse {

    private SysRoleButton sysRoleButton;

    public SysRoleButton getSysRoleButton() {
        return sysRoleButton;
    }

    public void setSysRoleButton(SysRoleButton sysRoleButton) {
        this.sysRoleButton = sysRoleButton;
    }
}
