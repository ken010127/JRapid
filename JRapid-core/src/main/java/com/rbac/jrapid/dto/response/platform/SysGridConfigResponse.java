package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BasePageResponse;
import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysGridConfig;

import java.util.List;

/**
* 页面表格配置信息返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysGridConfigResponse extends BasePageResponse<SysGridConfig> {

    private SysGridConfig sysGridConfig;

    public SysGridConfig getSysGridConfig() {
        return sysGridConfig;
    }

    public void setSysGridConfig(SysGridConfig sysGridConfig) {
        this.sysGridConfig = sysGridConfig;
    }

}
