package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysUserOrgExtMapper;
import com.rbac.jrapid.dao.platform.SysUserOrgMapper;
import com.rbac.jrapid.entity.platform.SysUserOrg;
import com.rbac.jrapid.service.platform.SysUserOrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 用户组织机构关系逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysUserOrgService")
public class SysUserOrgServiceImpl implements SysUserOrgService{
    protected static Logger logger = LoggerFactory.getLogger(SysUserOrgServiceImpl.class);

    @Autowired
    public SysUserOrgMapper sysUserOrgMapper;

    @Autowired
    public SysUserOrgExtMapper sysUserOrgExtMapper;

    public SysUserOrg findOne(Long id) throws Exception {
        return sysUserOrgMapper.findOne(id);
    }

    public Integer save(SysUserOrg sysUserOrg) throws Exception {
        return sysUserOrgMapper.save(sysUserOrg);
    }

    public Integer update(SysUserOrg sysUserOrg) throws Exception {
        return sysUserOrgMapper.update(sysUserOrg);
    }

    public Integer updateSelected(SysUserOrg sysUserOrg, List<String> list) throws Exception {
        return sysUserOrgMapper.updateSelected(sysUserOrg,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysUserOrgMapper.delete(id);
    }

    public List<SysUserOrg> listByCondition(CommonExample commonExample) throws Exception {
        return sysUserOrgMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysUserOrgMapper.countByCondition(commonExample);
    }

}
