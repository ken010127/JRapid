package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysTreeResource;

/**
* 树资源信息，管理树机构的表信息返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysTreeResourceResponse extends BaseResponse {

    private SysTreeResource sysTreeResource;

    public SysTreeResource getSysTreeResource() {
        return sysTreeResource;
    }

    public void setSysTreeResource(SysTreeResource sysTreeResource) {
        this.sysTreeResource = sysTreeResource;
    }
}
