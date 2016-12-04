package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysUserExtMapper;
import com.rbac.jrapid.dao.platform.SysUserMapper;
import com.rbac.jrapid.entity.platform.SysUser;
import com.rbac.jrapid.service.platform.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 系统用户管理逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService{
    protected static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    public SysUserMapper sysUserMapper;

    @Autowired
    public SysUserExtMapper sysUserExtMapper;

    public SysUser findOne(Long id) throws Exception {
        return sysUserMapper.findOne(id);
    }

    public Integer save(SysUser sysUser) throws Exception {
        return sysUserMapper.save(sysUser);
    }

    public Integer update(SysUser sysUser) throws Exception {
        return sysUserMapper.update(sysUser);
    }

    public Integer updateSelected(SysUser sysUser, List<String> list) throws Exception {
        return sysUserMapper.updateSelected(sysUser,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysUserMapper.delete(id);
    }

    public List<SysUser> listByCondition(CommonExample commonExample) throws Exception {
        return sysUserMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysUserMapper.countByCondition(commonExample);
    }

}
