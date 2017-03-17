package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.converter.ObjectConverter;
import com.rbac.jrapid.core.dto.vo.EasyUITreeNodeVO;
import com.rbac.jrapid.dao.platform.SysDictionaryExtMapper;
import com.rbac.jrapid.dao.platform.SysDictionaryMapper;
import com.rbac.jrapid.entity.platform.SysDictionary;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 数据字典逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Transactional
@Service("SysDictionaryService")
public class SysDictionaryServiceImpl extends BaseServiceImpl<SysDictionaryMapper,SysDictionary> implements SysDictionaryService{
    protected static Logger logger = LoggerFactory.getLogger(SysDictionaryServiceImpl.class);

    @Autowired
    private SysDictionaryExtMapper sysDictionaryExtMapper;

    @Override
    public List<SysDictionary> queryChildrenByCode(String parentCode) {
        return sysDictionaryExtMapper.queryChildrenByCode(parentCode);
    }

    @Override
    public List<EasyUITreeNodeVO> queryEasyuiTreeChildren(String nodeId) {
        List<Map<String,Object>> resultMaps = sysDictionaryExtMapper.getEasyUITreeChildren(nodeId);
        List<EasyUITreeNodeVO> easyUITreeNodeVOList = new ArrayList<>();
        for (Map<String,Object> resultMap : resultMaps){
            easyUITreeNodeVOList.add(easyUITreeNodeVOChanger(resultMap));
        }
        return easyUITreeNodeVOList;
    }

    /**
     * easyui tree node 转换器，将sysDictionary转换
     * @param map 字典信息
     * @return easyui tree node
     */
    private EasyUITreeNodeVO easyUITreeNodeVOChanger(Map<String,Object> map){
        EasyUITreeNodeVO easyUITreeNodeVO = new EasyUITreeNodeVO();
        easyUITreeNodeVO.setId(ObjectConverter.parseToString(map.get(SysDictionary.ID)));
        easyUITreeNodeVO.setText(ObjectConverter.parseToString(map.get(SysDictionary.DICT_NAME)));

        Map<String,String> attributes = new HashMap<>();
        attributes.put("dictCode", ObjectConverter.parseToString(map.get(SysDictionary.DICT_CODE)));
        attributes.put("direction", ObjectConverter.parseToString(map.get(SysDictionary.DIRECTION)));
        attributes.put("parentId", ObjectConverter.parseToString(map.get(SysDictionary.PARENT_ID)));
        attributes.put("parentCode", ObjectConverter.parseToString(map.get(SysDictionary.PARENT_CODE)));
        attributes.put("parentName", ObjectConverter.parseToString(map.get(SysDictionary.PARENT_NAME)));
        easyUITreeNodeVO.setAttribute(attributes);

        if(ObjectConverter.parseToInteger(map.get(SysDictionary.DICT_CHILDREN))>0){
            easyUITreeNodeVO.setState("closed");
        }else if(ObjectConverter.parseToInteger(map.get(SysDictionary.DICT_CHILDREN))==0){
            easyUITreeNodeVO.setState("open");
        }
        return easyUITreeNodeVO;
    }

}
