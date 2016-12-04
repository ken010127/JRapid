package com.rbac.jrapid.dto.response.platform;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.entity.platform.SysDictionary;

/**
* 数据字典返回类
* @author FWJ
* @since 2016-11-30 16:29:53
*/
public class SysDictionaryResponse extends BaseResponse {

    private SysDictionary sysDictionary;

    public SysDictionary getSysDictionary() {
        return sysDictionary;
    }

    public void setSysDictionary(SysDictionary sysDictionary) {
        this.sysDictionary = sysDictionary;
    }
}
