package com.rbac.jrapid.core.dto.response;

import com.rbac.jrapid.core.common.dao.Page;

import java.util.List;

/**
 * 列表基础数据返回类
 * @author FWJ
 * @since 2016/11/14 下午4:36
 */
public class BasePageResponse<T> extends BaseResponse {

    Page<T> page;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

}
