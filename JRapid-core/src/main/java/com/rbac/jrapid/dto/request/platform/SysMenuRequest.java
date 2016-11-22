package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseTreeRequest;
import com.rbac.jrapid.entity.platform.SysMenu;

/**
 * 系统菜单请求类
 * @author FWJ
 * @since 2016/11/21 下午3:57
 */
public class SysMenuRequest extends BaseTreeRequest {

    private SysMenu sysMenu;

    public SysMenu getSysMenu() {
        return sysMenu;
    }

    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;
    }
}
