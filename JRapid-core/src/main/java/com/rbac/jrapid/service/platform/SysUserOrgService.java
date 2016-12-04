package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysUserOrg;

/**
* 用户组织机构关系逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysUserOrgService {

    SysUserOrg findOne(Long id) throws Exception;

    Integer save(SysUserOrg sysUserOrg) throws Exception;

    Integer update(SysUserOrg sysUserOrg) throws Exception;

    Integer updateSelected(SysUserOrg sysUserOrg, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysUserOrg> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
