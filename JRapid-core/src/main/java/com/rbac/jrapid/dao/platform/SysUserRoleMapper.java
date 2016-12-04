package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysUserRole;
import org.springframework.stereotype.Component;

/**
* SysUserRole 用户角色关系 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysUserRoleMapper")
public interface SysUserRoleMapper extends BaseMapper<SysUserRole,Long> {

}