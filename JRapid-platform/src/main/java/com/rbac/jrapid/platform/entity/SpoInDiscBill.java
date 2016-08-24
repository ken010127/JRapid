package com.rbac.jrapid.platform.entity;

import java.io.Serializable;

/**
* 入库差异单头表(spo_in_disc_bill)实体类
* Created by JRapid on 2016-8-24 10:39:50.
*/
public class SpoInDiscBill implements Serializable {

    public final static String ROW_ID = "ROW_ID";
    public final static String ORG_CODE = "ORG_CODE";
    public final static String IN_BILL_NO = "IN_BILL_NO";
    public final static String APPLY_BILL_NO = "APPLY_BILL_NO";
    public final static String APPLY_STATUS = "APPLY_STATUS";
    public final static String APPLY_DATE = "APPLY_DATE";
    public final static String SEND_UNIT_ID = "SEND_UNIT_ID";
    public final static String SEND_UNIT_CODE = "SEND_UNIT_CODE";
    public final static String SEND_UNIT_NAME = "SEND_UNIT_NAME";
    public final static String SEND_WAREHOUSE_ID = "SEND_WAREHOUSE_ID";
    public final static String SEND_WAREHOUSE_CODE = "SEND_WAREHOUSE_CODE";
    public final static String SEND_WAREHOUSE_NAME = "SEND_WAREHOUSE_NAME";
    public final static String RC_UNIT_ID = "RC_UNIT_ID";
    public final static String RC_UNIT_CODE = "RC_UNIT_CODE";
    public final static String RC_UNIT_NAME = "RC_UNIT_NAME";
    public final static String RC_WAREHOUSE_ID = "RC_WAREHOUSE_ID";
    public final static String RC_WAREHOUSE_CODE = "RC_WAREHOUSE_CODE";
    public final static String RC_WAREHOUSE_NAME = "RC_WAREHOUSE_NAME";
    public final static String CARRIER_ID = "CARRIER_ID";
    public final static String CARRIER_CODE = "CARRIER_CODE";
    public final static String CARRIER_NAME = "CARRIER_NAME";
    public final static String APPLY_PERSON = "APPLY_PERSON";
    public final static String APPLY_NAME = "APPLY_NAME";
    public final static String REFER_BILL_CODE = "REFER_BILL_CODE";
    public final static String STRAIGHT_ORIGINAL_CODE = "STRAIGHT_ORIGINAL_CODE";
    public final static String OUT_BILL_NO = "OUT_BILL_NO";
    public final static String MIP_FLAG = "MIP_FLAG";
    public final static String DOT_AUDIT_RESULT = "DOT_AUDIT_RESULT";
    public final static String DOT_AUDIT_DESC = "DOT_AUDIT_DESC";
    public final static String PUB_REMARK = "PUB_REMARK";
    public final static String PUB_VALIDLY = "PUB_VALIDLY";
    public final static String BRAND_CODE = "BRAND_CODE";
    public final static String BRAND_NAME = "BRAND_NAME";
    public final static String VERSION = "VERSION";
    public final static String PUB_CREATE_PERSON = "PUB_CREATE_PERSON";
    public final static String PUB_CREATE_DATE = "PUB_CREATE_DATE";
    public final static String PUB_MODI_PERSON = "PUB_MODI_PERSON";
    public final static String PUB_MODI_DATE = "PUB_MODI_DATE";
    public final static String PUB_CREATE_PERSON_NAME = "PUB_CREATE_PERSON_NAME";
    public final static String PUB_MODI_PERSON_NAME = "PUB_MODI_PERSON_NAME";
    public final static String REFER_TYPE_ID = "REFER_TYPE_ID";
    public final static String REFER_TYPE_NAME = "REFER_TYPE_NAME";

    /**
    * ROW_ID
    **/
    private String rowId;

    /**
    * 业务主体编码
    **/
    private String orgCode;

    /**
    * 入库单号，从入库单表中选择做入库差异的入库单号。
    **/
    private String inBillNo;

    /**
    * 申请单号，根据系统单据规则生成。
    **/
    private String applyBillNo;

    /**
    * 单据状态，单据状态有：草稿、已提交、已审核、已驳回，从CODELIST中的入库差异单据状态（SPO_DIFFERENCE_STATUS）中获取。
    **/
    private String applyStatus;

    /**
    * 申请日期，单据新增保存时的系统时间。
    **/
    private java.util.Date applyDate;

    /**
    * 发货仓库组织ID，发货单位，从选择的入库单中带出。
    **/
    private String sendUnitId;

    /**
    * 发货仓库组织代码，发货单位，从选择的入库单中带出。
    **/
    private String sendUnitCode;

    /**
    * 发货仓库组织名称，发货单位，从选择的入库单中带出。
    **/
    private String sendUnitName;

    /**
    * 发货仓库ID，发货仓库，从选择的入库单中带出。
    **/
    private String sendWarehouseId;

    /**
    * 发货仓库编码，发货仓库，从选择的入库单中带出。
    **/
    private String sendWarehouseCode;

    /**
    * 发货仓库名称，发货仓库，从选择的入库单中带出。
    **/
    private String sendWarehouseName;

    /**
    * 收货仓库组织ID，收货单位，从选择的入库单中带出。
    **/
    private String rcUnitId;

    /**
    * 收货仓库组织代码，收货单位，从选择的入库单中带出。
    **/
    private String rcUnitCode;

    /**
    * 收货仓库组织名称，收货单位，从选择的入库单中带出。
    **/
    private String rcUnitName;

    /**
    * 收货仓库ID，收货仓库，从选择的入库单中带出。
    **/
    private String rcWarehouseId;

    /**
    * 本仓库编码，收货仓库，从选择的入库单中带出。
    **/
    private String rcWarehouseCode;

    /**
    * 本仓库名称，收货仓库，从选择的入库单中带出。
    **/
    private String rcWarehouseName;

    /**
    * 承运商ID，从入库单对应的业务单据的对应出库单对应的运输合同中关联出运输合同。

    **/
    private String carrierId;

    /**
    * 承运商编码，从入库单对应的业务单据的对应出库单对应的运输合同中关联出运输合同。
    **/
    private String carrierCode;

    /**
    * 承运商名称，从入库单对应的业务单据的对应出库单对应的运输合同中关联出运输合同。
    **/
    private String carrierName;

    /**
    * 申请人编码，新增单据保存时的操作用户。
    **/
    private String applyPerson;

    /**
    * 申请人姓名，新增单据保存时的操作用户。
    **/
    private String applyName;

    /**
    * 来源单据号，入库单对应的业务单据号，从入库单中带出。
    **/
    private String referBillCode;

    /**
    * 直发业务单号，小电模式下业务单据号，其他模式下此字段为空。
    **/
    private String straightOriginalCode;

    /**
    * 出库单号，从选择的入库单关联的业务单据中获取对应的出库单号。
    **/
    private String outBillNo;

    /**
    * 是否走MIP流程，如果收货单位为网点，则为是，否则为否，从CODELIST中的是否走MIP流程标识（SPO_MIP_FLAG）中获取。
    **/
    private String mipFlag;

    /**
    * 审核结果，审核通过、审核不通过,从CODELIST中的审核结果（SPO_AUDIT_RESULTS）获取。
    **/
    private String dotAuditResult;

    /**
    * 审核说明，审核时填写审核说明。
    **/
    private String dotAuditDesc;

    /**
    * 备注
    **/
    private String pubRemark;

    /**
    * 是否有效 1-有效、0-无效
    **/
    private String pubValidly;

    /**
    * 品牌编码
    **/
    private String brandCode;

    /**
    * 品牌名称
    **/
    private String brandName;

    /**
    * 版本号
    **/
    private Integer version;

    /**
    * 创建人编码
    **/
    private String pubCreatePerson;

    /**
    * 创建日期
    **/
    private java.util.Date pubCreateDate;

    /**
    * 最近修改人编码
    **/
    private String pubModiPerson;

    /**
    * 最近修改日期
    **/
    private java.util.Date pubModiDate;

    /**
    * 创建人名称
    **/
    private String pubCreatePersonName;

    /**
    * 最近修改人名称
    **/
    private String pubModiPersonName;

    /**
    * 来源单据类型id，入库单对应的业务单据类型id，从入库单中带出。
    **/
    private String referTypeId;

    /**
    * 来源单据类型名称，入库单对应的业务单据类型名称，从入库单中带出。
    **/
    private String referTypeName;


    public String getRowId(){
        return rowId;
    }

    public void setRowId(String rowId){
        this.rowId = rowId;
    }

    public String getOrgCode(){
        return orgCode;
    }

    public void setOrgCode(String orgCode){
        this.orgCode = orgCode;
    }

    public String getInBillNo(){
        return inBillNo;
    }

    public void setInBillNo(String inBillNo){
        this.inBillNo = inBillNo;
    }

    public String getApplyBillNo(){
        return applyBillNo;
    }

    public void setApplyBillNo(String applyBillNo){
        this.applyBillNo = applyBillNo;
    }

    public String getApplyStatus(){
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus){
        this.applyStatus = applyStatus;
    }

    public java.util.Date getApplyDate(){
        return applyDate;
    }

    public void setApplyDate(java.util.Date applyDate){
        this.applyDate = applyDate;
    }

    public String getSendUnitId(){
        return sendUnitId;
    }

    public void setSendUnitId(String sendUnitId){
        this.sendUnitId = sendUnitId;
    }

    public String getSendUnitCode(){
        return sendUnitCode;
    }

    public void setSendUnitCode(String sendUnitCode){
        this.sendUnitCode = sendUnitCode;
    }

    public String getSendUnitName(){
        return sendUnitName;
    }

    public void setSendUnitName(String sendUnitName){
        this.sendUnitName = sendUnitName;
    }

    public String getSendWarehouseId(){
        return sendWarehouseId;
    }

    public void setSendWarehouseId(String sendWarehouseId){
        this.sendWarehouseId = sendWarehouseId;
    }

    public String getSendWarehouseCode(){
        return sendWarehouseCode;
    }

    public void setSendWarehouseCode(String sendWarehouseCode){
        this.sendWarehouseCode = sendWarehouseCode;
    }

    public String getSendWarehouseName(){
        return sendWarehouseName;
    }

    public void setSendWarehouseName(String sendWarehouseName){
        this.sendWarehouseName = sendWarehouseName;
    }

    public String getRcUnitId(){
        return rcUnitId;
    }

    public void setRcUnitId(String rcUnitId){
        this.rcUnitId = rcUnitId;
    }

    public String getRcUnitCode(){
        return rcUnitCode;
    }

    public void setRcUnitCode(String rcUnitCode){
        this.rcUnitCode = rcUnitCode;
    }

    public String getRcUnitName(){
        return rcUnitName;
    }

    public void setRcUnitName(String rcUnitName){
        this.rcUnitName = rcUnitName;
    }

    public String getRcWarehouseId(){
        return rcWarehouseId;
    }

    public void setRcWarehouseId(String rcWarehouseId){
        this.rcWarehouseId = rcWarehouseId;
    }

    public String getRcWarehouseCode(){
        return rcWarehouseCode;
    }

    public void setRcWarehouseCode(String rcWarehouseCode){
        this.rcWarehouseCode = rcWarehouseCode;
    }

    public String getRcWarehouseName(){
        return rcWarehouseName;
    }

    public void setRcWarehouseName(String rcWarehouseName){
        this.rcWarehouseName = rcWarehouseName;
    }

    public String getCarrierId(){
        return carrierId;
    }

    public void setCarrierId(String carrierId){
        this.carrierId = carrierId;
    }

    public String getCarrierCode(){
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode){
        this.carrierCode = carrierCode;
    }

    public String getCarrierName(){
        return carrierName;
    }

    public void setCarrierName(String carrierName){
        this.carrierName = carrierName;
    }

    public String getApplyPerson(){
        return applyPerson;
    }

    public void setApplyPerson(String applyPerson){
        this.applyPerson = applyPerson;
    }

    public String getApplyName(){
        return applyName;
    }

    public void setApplyName(String applyName){
        this.applyName = applyName;
    }

    public String getReferBillCode(){
        return referBillCode;
    }

    public void setReferBillCode(String referBillCode){
        this.referBillCode = referBillCode;
    }

    public String getStraightOriginalCode(){
        return straightOriginalCode;
    }

    public void setStraightOriginalCode(String straightOriginalCode){
        this.straightOriginalCode = straightOriginalCode;
    }

    public String getOutBillNo(){
        return outBillNo;
    }

    public void setOutBillNo(String outBillNo){
        this.outBillNo = outBillNo;
    }

    public String getMipFlag(){
        return mipFlag;
    }

    public void setMipFlag(String mipFlag){
        this.mipFlag = mipFlag;
    }

    public String getDotAuditResult(){
        return dotAuditResult;
    }

    public void setDotAuditResult(String dotAuditResult){
        this.dotAuditResult = dotAuditResult;
    }

    public String getDotAuditDesc(){
        return dotAuditDesc;
    }

    public void setDotAuditDesc(String dotAuditDesc){
        this.dotAuditDesc = dotAuditDesc;
    }

    public String getPubRemark(){
        return pubRemark;
    }

    public void setPubRemark(String pubRemark){
        this.pubRemark = pubRemark;
    }

    public String getPubValidly(){
        return pubValidly;
    }

    public void setPubValidly(String pubValidly){
        this.pubValidly = pubValidly;
    }

    public String getBrandCode(){
        return brandCode;
    }

    public void setBrandCode(String brandCode){
        this.brandCode = brandCode;
    }

    public String getBrandName(){
        return brandName;
    }

    public void setBrandName(String brandName){
        this.brandName = brandName;
    }

    public Integer getVersion(){
        return version;
    }

    public void setVersion(Integer version){
        this.version = version;
    }

    public String getPubCreatePerson(){
        return pubCreatePerson;
    }

    public void setPubCreatePerson(String pubCreatePerson){
        this.pubCreatePerson = pubCreatePerson;
    }

    public java.util.Date getPubCreateDate(){
        return pubCreateDate;
    }

    public void setPubCreateDate(java.util.Date pubCreateDate){
        this.pubCreateDate = pubCreateDate;
    }

    public String getPubModiPerson(){
        return pubModiPerson;
    }

    public void setPubModiPerson(String pubModiPerson){
        this.pubModiPerson = pubModiPerson;
    }

    public java.util.Date getPubModiDate(){
        return pubModiDate;
    }

    public void setPubModiDate(java.util.Date pubModiDate){
        this.pubModiDate = pubModiDate;
    }

    public String getPubCreatePersonName(){
        return pubCreatePersonName;
    }

    public void setPubCreatePersonName(String pubCreatePersonName){
        this.pubCreatePersonName = pubCreatePersonName;
    }

    public String getPubModiPersonName(){
        return pubModiPersonName;
    }

    public void setPubModiPersonName(String pubModiPersonName){
        this.pubModiPersonName = pubModiPersonName;
    }

    public String getReferTypeId(){
        return referTypeId;
    }

    public void setReferTypeId(String referTypeId){
        this.referTypeId = referTypeId;
    }

    public String getReferTypeName(){
        return referTypeName;
    }

    public void setReferTypeName(String referTypeName){
        this.referTypeName = referTypeName;
    }

}