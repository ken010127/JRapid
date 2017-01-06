package com.rbac.jrapid.core.exception;

/**
 * 基础异常类
 * @author FWJ
 * @since 2017/1/6 下午4:59
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 914360918539343267L;

    private String errorCode;

    private String errorMsg;

    public BaseException(){
        super();
    }

    /**
     * @Title:BaseException
     * @Description:TODO
     * @param errorCode
     * @param errorMsg
     */
    public BaseException(String errorCode, String errorMsg) {
        super("errorCode[" + errorCode + "],errorMsg[" +errorMsg + "]");
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * @Title:BaseException
     * @Description:TODO
     * @param errorCode
     */
    public BaseException(String errorCode) {
        super("errorCode[" + errorCode + "]");
        this.errorCode = errorCode;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /* (non Javadoc)
     * @Title: toString
     * @Description: TODO
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BaseException [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
    }
}
