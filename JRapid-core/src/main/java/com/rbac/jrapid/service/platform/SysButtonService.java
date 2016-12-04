package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysButton;

/**
* 按钮管理逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysButtonService {

    SysButton findOne(Long id) throws Exception;

    Integer save(SysButton sysButton) throws Exception;

    Integer update(SysButton sysButton) throws Exception;

    Integer updateSelected(SysButton sysButton, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysButton> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
