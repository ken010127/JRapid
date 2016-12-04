package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysUserRoleExtMapper;
import com.rbac.jrapid.dao.platform.SysUserRoleMapper;
import com.rbac.jrapid.entity.platform.SysUserRole;
import com.rbac.jrapid.service.platform.SysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 用户角色关系逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService{
    protected static Logger logger = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

    @Autowired
    public SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    public SysUserRoleExtMapper sysUserRoleExtMapper;

    public SysUserRole findOne(Long id) throws Exception {
        return sysUserRoleMapper.findOne(id);
    }

    public Integer save(SysUserRole sysUserRole) throws Exception {
        return sysUserRoleMapper.save(sysUserRole);
    }

    public Integer update(SysUserRole sysUserRole) throws Exception {
        return sysUserRoleMapper.update(sysUserRole);
    }

    public Integer updateSelected(SysUserRole sysUserRole, List<String> list) throws Exception {
        return sysUserRoleMapper.updateSelected(sysUserRole,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysUserRoleMapper.delete(id);
    }

    public List<SysUserRole> listByCondition(CommonExample commonExample) throws Exception {
        return sysUserRoleMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysUserRoleMapper.countByCondition(commonExample);
    }

}
