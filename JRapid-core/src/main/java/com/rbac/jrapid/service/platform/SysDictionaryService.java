package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.core.dto.vo.EasyUITreeNodeVO;
import com.rbac.jrapid.dto.response.platform.SysDictionaryResponse;
import com.rbac.jrapid.entity.platform.SysDictionary;

import java.util.List;

/**
* 数据字典逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysDictionaryService {

    SysDictionary findOne(Long id) throws Exception;

    SysDictionaryResponse save(SysDictionary sysDictionary) throws Exception;

    SysDictionaryResponse update(SysDictionary sysDictionary) throws Exception;

    SysDictionaryResponse updateSelected(SysDictionary sysDictionary, java.util.List<String> list) throws Exception;

    SysDictionaryResponse delete(Long id) throws Exception;

    java.util.List<SysDictionary> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

    /**
     * 根据父节点编码查询子节点
     * @param parentCode 父节点编码
     * @return 子节点
     */
    List<SysDictionary> queryChildrenByCode(String parentCode);

    /**
     * 获取EasyUI树子节点
     * @param nodeId 父节点ID
     * @return 子节点
     */
    List<EasyUITreeNodeVO> queryEasyuiTreeChildren(String nodeId);
}
