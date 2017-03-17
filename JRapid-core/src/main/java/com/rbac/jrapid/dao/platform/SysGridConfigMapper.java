package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysGridConfig;
import org.springframework.stereotype.Component;

/**
* SysGridConfig 页面表格配置信息 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysGridConfigMapper")
public interface SysGridConfigMapper extends BaseMapper<SysGridConfig> {

}