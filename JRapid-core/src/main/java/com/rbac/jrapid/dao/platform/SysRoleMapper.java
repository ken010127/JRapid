package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysRole;
import org.springframework.stereotype.Component;

/**
* SysRole 角色管理 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysRoleMapper")
public interface SysRoleMapper extends BaseMapper<SysRole,Long> {

}