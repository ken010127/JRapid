package com.rbac.jrapid.dto.request.platform;

import com.rbac.jrapid.core.dto.request.BaseRequest;
import com.rbac.jrapid.entity.platform.SysDictionary;

/**
* 数据字典请求类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysDictionaryRequest extends BaseRequest {

    private SysDictionary sysDictionary;

    public SysDictionary getSysDictionary() {
        return sysDictionary;
    }

    public void setSysDictionary(SysDictionary sysDictionary) {
        this.sysDictionary = sysDictionary;
    }
}
