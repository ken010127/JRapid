package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysRoleButton;

/**
* 逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysRoleButtonService {

    SysRoleButton findOne(Long id) throws Exception;

    Integer save(SysRoleButton sysRoleButton) throws Exception;

    Integer update(SysRoleButton sysRoleButton) throws Exception;

    Integer updateSelected(SysRoleButton sysRoleButton, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysRoleButton> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
