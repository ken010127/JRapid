package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysTreeResource;

/**
* 树资源信息，管理树机构的表信息请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysTreeResourceRequest extends BaseRequest {

    private SysTreeResource sysTreeResource;

    public SysTreeResource getSysTreeResource() {
        return sysTreeResource;
    }

    public void setSysTreeResource(SysTreeResource sysTreeResource) {
        this.sysTreeResource = sysTreeResource;
    }
}
