package com.rbac.jrapid.dao.platform;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
* SysButton 按钮管理 持久层扩展操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysButtonExtMapper")
public interface SysButtonExtMapper{

    int deleteByMenuId(@Param("menuId") Long menuId);

}