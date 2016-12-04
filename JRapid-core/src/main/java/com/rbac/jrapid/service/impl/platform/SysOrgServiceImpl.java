package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysOrgExtMapper;
import com.rbac.jrapid.dao.platform.SysOrgMapper;
import com.rbac.jrapid.entity.platform.SysOrg;
import com.rbac.jrapid.service.platform.SysOrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 组织架构逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysOrgService")
public class SysOrgServiceImpl implements SysOrgService{
    protected static Logger logger = LoggerFactory.getLogger(SysOrgServiceImpl.class);

    @Autowired
    public SysOrgMapper sysOrgMapper;

    @Autowired
    public SysOrgExtMapper sysOrgExtMapper;

    public SysOrg findOne(Long id) throws Exception {
        return sysOrgMapper.findOne(id);
    }

    public Integer save(SysOrg sysOrg) throws Exception {
        return sysOrgMapper.save(sysOrg);
    }

    public Integer update(SysOrg sysOrg) throws Exception {
        return sysOrgMapper.update(sysOrg);
    }

    public Integer updateSelected(SysOrg sysOrg, List<String> list) throws Exception {
        return sysOrgMapper.updateSelected(sysOrg,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysOrgMapper.delete(id);
    }

    public List<SysOrg> listByCondition(CommonExample commonExample) throws Exception {
        return sysOrgMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysOrgMapper.countByCondition(commonExample);
    }

}
