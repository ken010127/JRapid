package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysRoleButton;

/**
* 请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysRoleButtonRequest extends BaseRequest {

    private SysRoleButton sysRoleButton;

    public SysRoleButton getSysRoleButton() {
        return sysRoleButton;
    }

    public void setSysRoleButton(SysRoleButton sysRoleButton) {
        this.sysRoleButton = sysRoleButton;
    }
}
