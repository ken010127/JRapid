package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysGridConfig;

/**
* 页面表格配置信息请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysGridConfigRequest extends BaseRequest {

    private SysGridConfig sysGridConfig;

    public SysGridConfig getSysGridConfig() {
        return sysGridConfig;
    }

    public void setSysGridConfig(SysGridConfig sysGridConfig) {
        this.sysGridConfig = sysGridConfig;
    }
}
