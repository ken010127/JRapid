package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysOrg;
import org.springframework.stereotype.Component;

/**
* SysOrg 组织架构 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysOrgMapper")
public interface SysOrgMapper extends BaseMapper<SysOrg> {

}