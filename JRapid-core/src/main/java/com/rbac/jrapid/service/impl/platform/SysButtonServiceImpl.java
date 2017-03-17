package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysButtonExtMapper;
import com.rbac.jrapid.dao.platform.SysButtonMapper;
import com.rbac.jrapid.entity.platform.SysButton;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysButtonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 按钮管理逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Transactional
@Service("SysButtonService")
public class SysButtonServiceImpl extends BaseServiceImpl<SysButtonMapper,SysButton> implements SysButtonService{
    protected static Logger logger = LoggerFactory.getLogger(SysButtonServiceImpl.class);

    @Autowired
    public SysButtonExtMapper sysButtonExtMapper;

    public List<SysButton> queryButtonByMenuId(Long menuId) throws Exception {
        CommonExample example = new CommonExample();
        example.andEqNum(SysButton.MENU_ID,menuId);
        return this.listByCondition(example);
    }

    @Override
    public Integer deleteByMenuId(Long menuId) throws Exception {
        return sysButtonExtMapper.deleteByMenuId(menuId);
    }
}