package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysButtonExtMapper;
import com.rbac.jrapid.dao.platform.SysButtonMapper;
import com.rbac.jrapid.entity.platform.SysButton;
import com.rbac.jrapid.service.platform.SysButtonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 按钮管理逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysButtonService")
public class SysButtonServiceImpl implements SysButtonService{
    protected static Logger logger = LoggerFactory.getLogger(SysButtonServiceImpl.class);

    @Autowired
    public SysButtonMapper sysButtonMapper;

    @Autowired
    public SysButtonExtMapper sysButtonExtMapper;

    public SysButton findOne(Long id) throws Exception {
        return sysButtonMapper.findOne(id);
    }

    public Integer save(SysButton sysButton) throws Exception {
        return sysButtonMapper.save(sysButton);
    }

    public Integer update(SysButton sysButton) throws Exception {
        return sysButtonMapper.update(sysButton);
    }

    @Override
    public Integer saveOrUpdate(SysButton sysButton) throws Exception {
        if (sysButton.getId() == null){
            return this.update(sysButton);
        }else {
            return this.save(sysButton);
        }
    }

    public Integer updateSelected(SysButton sysButton, List<String> list) throws Exception {
        return sysButtonMapper.updateSelected(sysButton,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysButtonMapper.delete(id);
    }

    public List<SysButton> listByCondition(CommonExample commonExample) throws Exception {
        return sysButtonMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysButtonMapper.countByCondition(commonExample);
    }

    public List<SysButton> queryButtonByMenuId(Long menuId) throws Exception {
        CommonExample example = new CommonExample();
        example.andEqNum(SysButton.MENU_ID,menuId);
        return this.listByCondition(example);
    }
}