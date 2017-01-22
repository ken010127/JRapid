package com.rbac.jrapid.core.dto.request;

import com.rbac.jrapid.core.common.dao.Page;
import com.rbac.jrapid.core.dto.response.BaseResponse;

/**
 * 列表请求基础类
 * @author FWJ
 * @since 2016/11/14 下午5:55
 */
public class BasePageRequest<T> extends BaseResponse {

    Page<T> page;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }
}
