package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysOrg;

/**
* 组织架构请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysOrgRequest extends BaseRequest {

    private SysOrg sysOrg;

    public SysOrg getSysOrg() {
        return sysOrg;
    }

    public void setSysOrg(SysOrg sysOrg) {
        this.sysOrg = sysOrg;
    }
}
