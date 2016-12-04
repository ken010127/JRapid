package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysDictionaryExtMapper;
import com.rbac.jrapid.dao.platform.SysDictionaryMapper;
import com.rbac.jrapid.entity.platform.SysDictionary;
import com.rbac.jrapid.service.platform.SysDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 数据字典逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysDictionaryService")
public class SysDictionaryServiceImpl implements SysDictionaryService{
    protected static Logger logger = LoggerFactory.getLogger(SysDictionaryServiceImpl.class);

    @Autowired
    public SysDictionaryMapper sysDictionaryMapper;

    @Autowired
    public SysDictionaryExtMapper sysDictionaryExtMapper;

    public SysDictionary findOne(Long id) throws Exception {
        return sysDictionaryMapper.findOne(id);
    }

    public Integer save(SysDictionary sysDictionary) throws Exception {
        return sysDictionaryMapper.save(sysDictionary);
    }

    public Integer update(SysDictionary sysDictionary) throws Exception {
        return sysDictionaryMapper.update(sysDictionary);
    }

    public Integer updateSelected(SysDictionary sysDictionary, List<String> list) throws Exception {
        return sysDictionaryMapper.updateSelected(sysDictionary,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysDictionaryMapper.delete(id);
    }

    public List<SysDictionary> listByCondition(CommonExample commonExample) throws Exception {
        return sysDictionaryMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysDictionaryMapper.countByCondition(commonExample);
    }

}
