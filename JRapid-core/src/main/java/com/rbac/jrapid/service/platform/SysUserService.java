package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysUser;

/**
* 系统用户管理逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysUserService {

    SysUser findOne(Long id) throws Exception;

    Integer save(SysUser sysUser) throws Exception;

    Integer update(SysUser sysUser) throws Exception;

    Integer updateSelected(SysUser sysUser, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysUser> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
