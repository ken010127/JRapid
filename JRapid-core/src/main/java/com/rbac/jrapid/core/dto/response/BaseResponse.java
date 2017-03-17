package com.rbac.jrapid.core.dto.response;

import java.io.Serializable;
import java.util.List;

/**
 * dto类，基础返回数据类
 * @author FWJ
 * @since 2016/11/14 下午3:35
 */
public class BaseResponse<T> implements Serializable {

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
     * 返回实体
     */
    private T entity;

    private List<T> list;

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

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
