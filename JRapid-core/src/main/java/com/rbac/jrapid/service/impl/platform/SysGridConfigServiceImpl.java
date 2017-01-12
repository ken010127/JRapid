package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysGridConfigExtMapper;
import com.rbac.jrapid.dao.platform.SysGridConfigMapper;
import com.rbac.jrapid.dto.response.platform.SysGridConfigResponse;
import com.rbac.jrapid.entity.platform.SysGridConfig;
import com.rbac.jrapid.service.platform.SysGridConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 页面表格配置信息逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Transactional
@Service("SysGridConfigService")
public class SysGridConfigServiceImpl implements SysGridConfigService{
    protected static Logger logger = LoggerFactory.getLogger(SysGridConfigServiceImpl.class);

    @Autowired
    public SysGridConfigMapper sysGridConfigMapper;

    @Autowired
    public SysGridConfigExtMapper sysGridConfigExtMapper;

    public SysGridConfig findOne(Long id) throws Exception {
        return sysGridConfigMapper.findOne(id);
    }

    public Integer save(SysGridConfig sysGridConfig) throws Exception {
        return sysGridConfigMapper.save(sysGridConfig);
    }

    public Integer update(SysGridConfig sysGridConfig) throws Exception {
        return sysGridConfigMapper.update(sysGridConfig);
    }

    public Integer saveOrUpdate(SysGridConfig sysGridConfig) throws Exception {
        if (sysGridConfig.getId() == null ){
            return this.save(sysGridConfig);
        }else {
            return this.update(sysGridConfig);
        }
    }

    public Integer updateSelected(SysGridConfig sysGridConfig, List<String> list) throws Exception {
        return sysGridConfigMapper.updateSelected(sysGridConfig,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysGridConfigMapper.delete(id);
    }

    public List<SysGridConfig> listByCondition(CommonExample commonExample) throws Exception {
        return sysGridConfigMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysGridConfigMapper.countByCondition(commonExample);
    }

    @Override
    public SysGridConfigResponse queryColumnInfo(String tableName) {
        SysGridConfigResponse response = new SysGridConfigResponse();
        List<SysGridConfig> sysGridConfigs = sysGridConfigExtMapper.queryColumnInfo(tableName);
        response.setRows(sysGridConfigs);
        return response;
    }

    @Override
    public List<SysGridConfig> queryGridConfigByMenuId(Long menuId) throws Exception {
        CommonExample example = new CommonExample();
        example.andEqNum(SysGridConfig.MENU_ID,menuId);
        return this.listByCondition(example);
    }

    @Override
    public Integer deleteByMenuId(Long menuId) throws Exception {
        return sysGridConfigExtMapper.deleteByMenuId(menuId);
    }
}
