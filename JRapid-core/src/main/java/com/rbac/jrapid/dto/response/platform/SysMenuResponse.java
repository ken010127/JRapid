package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysMenu;

/**
* 系统菜单管理返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysMenuResponse extends BaseResponse {

    private SysMenu sysMenu;

    public SysMenu getSysMenu() {
        return sysMenu;
    }

    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;
    }
}
