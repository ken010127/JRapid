package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysRoleMenu;

/**
* 角色菜单关系请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysRoleMenuRequest extends BaseRequest {

    private SysRoleMenu sysRoleMenu;

    public SysRoleMenu getSysRoleMenu() {
        return sysRoleMenu;
    }

    public void setSysRoleMenu(SysRoleMenu sysRoleMenu) {
        this.sysRoleMenu = sysRoleMenu;
    }
}
