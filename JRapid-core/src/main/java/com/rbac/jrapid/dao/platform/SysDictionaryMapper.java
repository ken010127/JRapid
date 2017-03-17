package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysDictionary;
import org.springframework.stereotype.Component;

/**
* SysDictionary 数据字典 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysDictionaryMapper")
public interface SysDictionaryMapper extends BaseMapper<SysDictionary> {

}