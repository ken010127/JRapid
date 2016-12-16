package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysDictionary;

/**
* 数据字典请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysDictionaryRequest extends BaseRequest {

    private Long id;

    private SysDictionary sysDictionary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SysDictionary getSysDictionary() {
        return sysDictionary;
    }

    public void setSysDictionary(SysDictionary sysDictionary) {
        this.sysDictionary = sysDictionary;
    }
}
