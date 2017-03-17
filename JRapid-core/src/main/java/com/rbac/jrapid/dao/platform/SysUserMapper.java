package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysUser;
import org.springframework.stereotype.Component;

/**
* SysUser 系统用户管理 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {

}