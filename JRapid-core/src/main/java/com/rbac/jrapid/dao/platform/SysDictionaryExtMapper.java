package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.entity.platform.SysDictionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
* SysDictionary 数据字典 持久层扩展操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysDictionaryExtMapper")
public interface SysDictionaryExtMapper{

    /**
     * 根据父节点编码查询子节点
     * @param parentCode 父节点编码
     * @return 子节点
     */
    List<SysDictionary> queryChildrenByCode(@Param("parentCode") String parentCode);

    /**
     * 获取EasyUI树子节点
     * @param nodeId 父节点ID
     * @return 子节点
     */
    List<Map<String,Object>> getEasyUITreeChildren(@Param("nodeId") String nodeId);

    /**
     * 更新子节点
     * @param sysDictionary 父节点字典
     * @return
     */
    int updateChildren(@Param("parent") SysDictionary sysDictionary);

    /**
     * 删除子节点
     * @param parentId 父节点ID
     * @return
     */
    int deleteChildren(@Param("parentId") Long parentId);
}