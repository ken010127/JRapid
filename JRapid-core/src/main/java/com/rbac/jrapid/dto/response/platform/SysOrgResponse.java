package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysOrg;

/**
* 组织架构返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysOrgResponse extends BaseResponse {

    private SysOrg sysOrg;

    public SysOrg getSysOrg() {
        return sysOrg;
    }

    public void setSysOrg(SysOrg sysOrg) {
        this.sysOrg = sysOrg;
    }
}
