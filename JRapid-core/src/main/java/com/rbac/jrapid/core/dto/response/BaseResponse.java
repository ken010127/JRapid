package com.rbac.jrapid.core.dto.response;

import java.io.Serializable;

/**
 * dto类，基础返回数据类
 * @author FWJ
 * @since 2016/11/14 下午3:35
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -4249165317136641764L;

    /**
     * 操作状态，成功true；失败false
     */
    private Boolean status = true;

    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 返回内容
     */
    private Object content;

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

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
