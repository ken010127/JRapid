package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysTreeResource;
import org.springframework.stereotype.Component;

/**
* SysTreeResource 树资源信息，管理树机构的表信息 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysTreeResourceMapper")
public interface SysTreeResourceMapper extends BaseMapper<SysTreeResource,Long> {

}