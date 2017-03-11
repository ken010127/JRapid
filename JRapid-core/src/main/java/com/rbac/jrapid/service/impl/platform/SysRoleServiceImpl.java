package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.core.common.dao.Page;
import com.rbac.jrapid.dao.platform.SysRoleExtMapper;
import com.rbac.jrapid.dao.platform.SysRoleMapper;
import com.rbac.jrapid.dto.request.platform.SysRoleRequest;
import com.rbac.jrapid.dto.response.platform.SysRoleResponse;
import com.rbac.jrapid.entity.platform.SysRole;
import com.rbac.jrapid.service.platform.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 角色管理逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysRoleService")
public class SysRoleServiceImpl implements SysRoleService{
    protected static Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    public SysRoleMapper sysRoleMapper;

    @Autowired
    public SysRoleExtMapper sysRoleExtMapper;

    public SysRoleResponse pageQuery(SysRoleRequest request){
        SysRoleResponse response = new SysRoleResponse();
        Page<SysRole> page = sysRoleMapper.pageQuery(request.getPage(),request.getSysRole());
        response.setPage(page);
        return response;
    }

    public SysRole findOne(Long id) throws Exception {
        return sysRoleMapper.findOne(id);
    }

    public Integer save(SysRole sysRole) throws Exception {
        return sysRoleMapper.save(sysRole);
    }

    public Integer update(SysRole sysRole) throws Exception {
        return sysRoleMapper.update(sysRole);
    }

    public Integer updateSelected(SysRole sysRole, List<String> list) throws Exception {
        return sysRoleMapper.updateSelected(sysRole,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysRoleMapper.delete(id);
    }

    public List<SysRole> listByCondition(CommonExample commonExample) throws Exception {
        return sysRoleMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysRoleMapper.countByCondition(commonExample);
    }

}
