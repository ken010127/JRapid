package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysRoleButton;
import org.springframework.stereotype.Component;

/**
* SysRoleButton  持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysRoleButtonMapper")
public interface SysRoleButtonMapper extends BaseMapper<SysRoleButton,Long> {

}