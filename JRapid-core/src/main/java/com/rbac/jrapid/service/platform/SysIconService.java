package com.rbac.jrapid.service.platform;

import java.util.List;

/**
 * 图标管理接口
 * @author FWJ
 * @since 2017/1/18 上午11:36
 */
public interface SysIconService {

    /**
     * 获取图标
     * @param type 图标类型：default默认，custom自定义
     * @return 图标名称
     */
    List<String> getIcons(String type);

}
