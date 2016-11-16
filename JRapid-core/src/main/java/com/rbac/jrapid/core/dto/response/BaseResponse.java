package com.rbac.jrapid.core.dto.response;

import java.io.Serializable;

/**
 * dto类，基础返回数据类
 * @author FWJ
 * @since 2016/11/14 下午3:35
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -4249165317136641764L;

    private Boolean status = true;
    private String errorCode;
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
