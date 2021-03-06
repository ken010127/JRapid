package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysButton;
import com.rbac.jrapid.entity.platform.SysGridConfig;
import com.rbac.jrapid.entity.platform.SysMenu;

import java.util.List;

/**
* 系统菜单管理返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysMenuResponse extends BaseResponse<SysMenu> {

    private List<SysButton> sysButtons;

    private List<SysGridConfig> sysGridConfigs;

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
