package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysButton;

/**
* 按钮管理请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysButtonRequest extends BaseRequest {

    private SysButton sysButton;

    public SysButton getSysButton() {
        return sysButton;
    }

    public void setSysButton(SysButton sysButton) {
        this.sysButton = sysButton;
    }
}
