package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysUserOrg;

/**
* 用户组织机构关系请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysUserOrgRequest extends BaseRequest {

    private SysUserOrg sysUserOrg;

    public SysUserOrg getSysUserOrg() {
        return sysUserOrg;
    }

    public void setSysUserOrg(SysUserOrg sysUserOrg) {
        this.sysUserOrg = sysUserOrg;
    }
}
