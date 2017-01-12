package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.entity.platform.SysGridConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* SysGridConfig 页面表格配置信息 持久层扩展操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysGridConfigExtMapper")
public interface SysGridConfigExtMapper{

    /**
     * 查询表信息
     * @param tableName 表名称
     * @return 字段信息列表
     */
    List<SysGridConfig> queryColumnInfo(@Param("tableName") String tableName);

    int deleteByMenuId(@Param("menuId") Long menuId);

}