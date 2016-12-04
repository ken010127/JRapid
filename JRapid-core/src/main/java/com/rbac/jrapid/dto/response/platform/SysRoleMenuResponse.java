package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysRoleMenu;

/**
* 角色菜单关系返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysRoleMenuResponse extends BaseResponse {

    private SysRoleMenu sysRoleMenu;

    public SysRoleMenu getSysRoleMenu() {
        return sysRoleMenu;
    }

    public void setSysRoleMenu(SysRoleMenu sysRoleMenu) {
        this.sysRoleMenu = sysRoleMenu;
    }
}
