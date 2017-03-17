package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysUserOrg;
import org.springframework.stereotype.Component;

/**
* SysUserOrg 用户组织机构关系 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysUserOrgMapper")
public interface SysUserOrgMapper extends BaseMapper<SysUserOrg> {

}