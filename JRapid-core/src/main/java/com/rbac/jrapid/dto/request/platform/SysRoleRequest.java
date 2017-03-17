package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BasePageRequest;
import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.dto.codition.platform.SysRoleCondition;
import com.rbac.jrapid.entity.platform.SysRole;

/**
* 角色管理请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysRoleRequest extends BasePageRequest<SysRole> {

    private SysRoleCondition condition;

    public SysRoleCondition getCondition() {
        return condition;
    }

    public void setCondition(SysRoleCondition condition) {
        this.condition = condition;
    }
}
