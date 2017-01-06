package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dto.response.platform.SysGridConfigResponse;
import com.rbac.jrapid.entity.platform.SysGridConfig;

import java.util.List;

/**
* 页面表格配置信息逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysGridConfigService {

    SysGridConfig findOne(Long id) throws Exception;

    Integer save(SysGridConfig sysGridConfig) throws Exception;

    Integer update(SysGridConfig sysGridConfig) throws Exception;

    Integer saveOrUpdate(SysGridConfig sysGridConfig) throws Exception;

    Integer updateSelected(SysGridConfig sysGridConfig, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysGridConfig> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

    /**
     * 查询表字段信息
     * @param tableName 表名
     * @return 字段信息
     */
    SysGridConfigResponse queryColumnInfo(String tableName);

    /**
     * 查询菜单下列表的配置信息
     * @param menuId 菜单ID
     * @return 配置信息
     * @throws Exception
     */
    List<SysGridConfig> queryGridConfigByMenuId(Long menuId) throws Exception;
}
