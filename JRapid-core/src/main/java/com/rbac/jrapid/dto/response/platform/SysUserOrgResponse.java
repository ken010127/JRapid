package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysUserOrg;

/**
* 用户组织机构关系返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysUserOrgResponse extends BaseResponse {

    private SysUserOrg sysUserOrg;

    public SysUserOrg getSysUserOrg() {
        return sysUserOrg;
    }

    public void setSysUserOrg(SysUserOrg sysUserOrg) {
        this.sysUserOrg = sysUserOrg;
    }
}
