package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysButton;

/**
* 按钮管理返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysButtonResponse extends BaseResponse {

    private SysButton sysButton;

    public SysButton getSysButton() {
        return sysButton;
    }

    public void setSysButton(SysButton sysButton) {
        this.sysButton = sysButton;
    }
}
