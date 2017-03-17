package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysButton;
import org.springframework.stereotype.Component;

/**
* SysButton 按钮管理 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysButtonMapper")
public interface SysButtonMapper extends BaseMapper<SysButton> {

}