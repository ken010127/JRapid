package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysButton;
import com.rbac.jrapid.entity.platform.SysGridConfig;
import com.rbac.jrapid.entity.platform.SysMenu;

import java.util.List;

/**
* 系统菜单管理请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysMenuRequest extends BaseRequest {

    private Long menuId;

    private SysMenu sysMenu;

    private List<SysButton> sysButtons;

    private List<SysGridConfig> sysGridConfigs;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public SysMenu getSysMenu() {
        return sysMenu;
    }

    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;

    }

    public List<SysButton> getSysButtons() {
        return sysButtons;
    }

    public void setSysButtons(List<SysButton> sysButtons) {
        this.sysButtons = sysButtons;
    }

    public List<SysGridConfig> getSysGridConfigs() {
        return sysGridConfigs;
    }

    public void setSysGridConfigs(List<SysGridConfig> sysGridConfigs) {
        this.sysGridConfigs = sysGridConfigs;
    }
}
