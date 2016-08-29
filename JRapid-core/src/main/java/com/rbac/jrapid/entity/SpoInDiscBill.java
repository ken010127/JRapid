package com.rbac.jrapid.entity;

import java.io.Serializable;

/**
* 入库差异单头表(spo_in_disc_bill)实体类
* Created by JRapid on 2016-8-24 14:26:12.
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
    private java.lang.String rowId;

    /**
    * 业务主体编码
    **/
    private java.lang.String orgCode;

    /**
    * 入库单号，从入库单表中选择做入库差异的入库单号。
    **/
    private java.lang.String inBillNo;

    /**
    * 申请单号，根据系统单据规则生成。
    **/
    private java.lang.String applyBillNo;

    /**
    * 单据状态，单据状态有：草稿、已提交、已审核、已驳回，从CODELIST中的入库差异单据状态（SPO_DIFFERENCE_STATUS）中获取。
    **/
    private java.lang.String applyStatus;

    /**
    * 申请日期，单据新增保存时的系统时间。
    **/
    private java.util.Date applyDate;

    /**
    * 发货仓库组织ID，发货单位，从选择的入库单中带出。
    **/
    private java.lang.String sendUnitId;

    /**
    * 发货仓库组织代码，发货单位，从选择的入库单中带出。
    **/
    private java.lang.String sendUnitCode;

    /**
    * 发货仓库组织名称，发货单位，从选择的入库单中带出。
    **/
    private java.lang.String sendUnitName;

    /**
    * 发货仓库ID，发货仓库，从选择的入库单中带出。
    **/
    private java.lang.String sendWarehouseId;

    /**
    * 发货仓库编码，发货仓库，从选择的入库单中带出。
    **/
    private java.lang.String sendWarehouseCode;

    /**
    * 发货仓库名称，发货仓库，从选择的入库单中带出。
    **/
    private java.lang.String sendWarehouseName;

    /**
    * 收货仓库组织ID，收货单位，从选择的入库单中带出。
    **/
    private java.lang.String rcUnitId;

    /**
    * 收货仓库组织代码，收货单位，从选择的入库单中带出。
    **/
    private java.lang.String rcUnitCode;

    /**
    * 收货仓库组织名称，收货单位，从选择的入库单中带出。
    **/
    private java.lang.String rcUnitName;

    /**
    * 收货仓库ID，收货仓库，从选择的入库单中带出。
    **/
    private java.lang.String rcWarehouseId;

    /**
    * 本仓库编码，收货仓库，从选择的入库单中带出。
    **/
    private java.lang.String rcWarehouseCode;

    /**
    * 本仓库名称，收货仓库，从选择的入库单中带出。
    **/
    private java.lang.String rcWarehouseName;

    /**
    * 承运商ID，从入库单对应的业务单据的对应出库单对应的运输合同中关联出运输合同。

    **/
    private java.lang.String carrierId;

    /**
    * 承运商编码，从入库单对应的业务单据的对应出库单对应的运输合同中关联出运输合同。
    **/
    private java.lang.String carrierCode;

    /**
    * 承运商名称，从入库单对应的业务单据的对应出库单对应的运输合同中关联出运输合同。
    **/
    private java.lang.String carrierName;

    /**
    * 申请人编码，新增单据保存时的操作用户。
    **/
    private java.lang.String applyPerson;

    /**
    * 申请人姓名，新增单据保存时的操作用户。
    **/
    private java.lang.String applyName;

    /**
    * 来源单据号，入库单对应的业务单据号，从入库单中带出。
    **/
    private java.lang.String referBillCode;

    /**
    * 直发业务单号，小电模式下业务单据号，其他模式下此字段为空。
    **/
    private java.lang.String straightOriginalCode;

    /**
    * 出库单号，从选择的入库单关联的业务单据中获取对应的出库单号。
    **/
    private java.lang.String outBillNo;

    /**
    * 是否走MIP流程，如果收货单位为网点，则为是，否则为否，从CODELIST中的是否走MIP流程标识（SPO_MIP_FLAG）中获取。
    **/
    private java.lang.String mipFlag;

    /**
    * 审核结果，审核通过、审核不通过,从CODELIST中的审核结果（SPO_AUDIT_RESULTS）获取。
    **/
    private java.lang.String dotAuditResult;

    /**
    * 审核说明，审核时填写审核说明。
    **/
    private java.lang.String dotAuditDesc;

    /**
    * 备注
    **/
    private java.lang.String pubRemark;

    /**
    * 是否有效 1-有效、0-无效
    **/
    private java.lang.String pubValidly;

    /**
    * 品牌编码
    **/
    private java.lang.String brandCode;

    /**
    * 品牌名称
    **/
    private java.lang.String brandName;

    /**
    * 版本号
    **/
    private java.lang.Integer version;

    /**
    * 创建人编码
    **/
    private java.lang.String pubCreatePerson;

    /**
    * 创建日期
    **/
    private java.util.Date pubCreateDate;

    /**
    * 最近修改人编码
    **/
    private java.lang.String pubModiPerson;

    /**
    * 最近修改日期
    **/
    private java.util.Date pubModiDate;

    /**
    * 创建人名称
    **/
    private java.lang.String pubCreatePersonName;

    /**
    * 最近修改人名称
    **/
    private java.lang.String pubModiPersonName;

    /**
    * 来源单据类型id，入库单对应的业务单据类型id，从入库单中带出。
    **/
    private java.lang.String referTypeId;

    /**
    * 来源单据类型名称，入库单对应的业务单据类型名称，从入库单中带出。
    **/
    private java.lang.String referTypeName;


    public java.lang.String getRowId(){
        return rowId;
    }

    public void setRowId(java.lang.String rowId){
        this.rowId = rowId;
    }

    public java.lang.String getOrgCode(){
        return orgCode;
    }

    public void setOrgCode(java.lang.String orgCode){
        this.orgCode = orgCode;
    }

    public java.lang.String getInBillNo(){
        return inBillNo;
    }

    public void setInBillNo(java.lang.String inBillNo){
        this.inBillNo = inBillNo;
    }

    public java.lang.String getApplyBillNo(){
        return applyBillNo;
    }

    public void setApplyBillNo(java.lang.String applyBillNo){
        this.applyBillNo = applyBillNo;
    }

    public java.lang.String getApplyStatus(){
        return applyStatus;
    }

    public void setApplyStatus(java.lang.String applyStatus){
        this.applyStatus = applyStatus;
    }

    public java.util.Date getApplyDate(){
        return applyDate;
    }

    public void setApplyDate(java.util.Date applyDate){
        this.applyDate = applyDate;
    }

    public java.lang.String getSendUnitId(){
        return sendUnitId;
    }

    public void setSendUnitId(java.lang.String sendUnitId){
        this.sendUnitId = sendUnitId;
    }

    public java.lang.String getSendUnitCode(){
        return sendUnitCode;
    }

    public void setSendUnitCode(java.lang.String sendUnitCode){
        this.sendUnitCode = sendUnitCode;
    }

    public java.lang.String getSendUnitName(){
        return sendUnitName;
    }

    public void setSendUnitName(java.lang.String sendUnitName){
        this.sendUnitName = sendUnitName;
    }

    public java.lang.String getSendWarehouseId(){
        return sendWarehouseId;
    }

    public void setSendWarehouseId(java.lang.String sendWarehouseId){
        this.sendWarehouseId = sendWarehouseId;
    }

    public java.lang.String getSendWarehouseCode(){
        return sendWarehouseCode;
    }

    public void setSendWarehouseCode(java.lang.String sendWarehouseCode){
        this.sendWarehouseCode = sendWarehouseCode;
    }

    public java.lang.String getSendWarehouseName(){
        return sendWarehouseName;
    }

    public void setSendWarehouseName(java.lang.String sendWarehouseName){
        this.sendWarehouseName = sendWarehouseName;
    }

    public java.lang.String getRcUnitId(){
        return rcUnitId;
    }

    public void setRcUnitId(java.lang.String rcUnitId){
        this.rcUnitId = rcUnitId;
    }

    public java.lang.String getRcUnitCode(){
        return rcUnitCode;
    }

    public void setRcUnitCode(java.lang.String rcUnitCode){
        this.rcUnitCode = rcUnitCode;
    }

    public java.lang.String getRcUnitName(){
        return rcUnitName;
    }

    public void setRcUnitName(java.lang.String rcUnitName){
        this.rcUnitName = rcUnitName;
    }

    public java.lang.String getRcWarehouseId(){
        return rcWarehouseId;
    }

    public void setRcWarehouseId(java.lang.String rcWarehouseId){
        this.rcWarehouseId = rcWarehouseId;
    }

    public java.lang.String getRcWarehouseCode(){
        return rcWarehouseCode;
    }

    public void setRcWarehouseCode(java.lang.String rcWarehouseCode){
        this.rcWarehouseCode = rcWarehouseCode;
    }

    public java.lang.String getRcWarehouseName(){
        return rcWarehouseName;
    }

    public void setRcWarehouseName(java.lang.String rcWarehouseName){
        this.rcWarehouseName = rcWarehouseName;
    }

    public java.lang.String getCarrierId(){
        return carrierId;
    }

    public void setCarrierId(java.lang.String carrierId){
        this.carrierId = carrierId;
    }

    public java.lang.String getCarrierCode(){
        return carrierCode;
    }

    public void setCarrierCode(java.lang.String carrierCode){
        this.carrierCode = carrierCode;
    }

    public java.lang.String getCarrierName(){
        return carrierName;
    }

    public void setCarrierName(java.lang.String carrierName){
        this.carrierName = carrierName;
    }

    public java.lang.String getApplyPerson(){
        return applyPerson;
    }

    public void setApplyPerson(java.lang.String applyPerson){
        this.applyPerson = applyPerson;
    }

    public java.lang.String getApplyName(){
        return applyName;
    }

    public void setApplyName(java.lang.String applyName){
        this.applyName = applyName;
    }

    public java.lang.String getReferBillCode(){
        return referBillCode;
    }

    public void setReferBillCode(java.lang.String referBillCode){
        this.referBillCode = referBillCode;
    }

    public java.lang.String getStraightOriginalCode(){
        return straightOriginalCode;
    }

    public void setStraightOriginalCode(java.lang.String straightOriginalCode){
        this.straightOriginalCode = straightOriginalCode;
    }

    public java.lang.String getOutBillNo(){
        return outBillNo;
    }

    public void setOutBillNo(java.lang.String outBillNo){
        this.outBillNo = outBillNo;
    }

    public java.lang.String getMipFlag(){
        return mipFlag;
    }

    public void setMipFlag(java.lang.String mipFlag){
        this.mipFlag = mipFlag;
    }

    public java.lang.String getDotAuditResult(){
        return dotAuditResult;
    }

    public void setDotAuditResult(java.lang.String dotAuditResult){
        this.dotAuditResult = dotAuditResult;
    }

    public java.lang.String getDotAuditDesc(){
        return dotAuditDesc;
    }

    public void setDotAuditDesc(java.lang.String dotAuditDesc){
        this.dotAuditDesc = dotAuditDesc;
    }

    public java.lang.String getPubRemark(){
        return pubRemark;
    }

    public void setPubRemark(java.lang.String pubRemark){
        this.pubRemark = pubRemark;
    }

    public java.lang.String getPubValidly(){
        return pubValidly;
    }

    public void setPubValidly(java.lang.String pubValidly){
        this.pubValidly = pubValidly;
    }

    public java.lang.String getBrandCode(){
        return brandCode;
    }

    public void setBrandCode(java.lang.String brandCode){
        this.brandCode = brandCode;
    }

    public java.lang.String getBrandName(){
        return brandName;
    }

    public void setBrandName(java.lang.String brandName){
        this.brandName = brandName;
    }

    public java.lang.Integer getVersion(){
        return version;
    }

    public void setVersion(java.lang.Integer version){
        this.version = version;
    }

    public java.lang.String getPubCreatePerson(){
        return pubCreatePerson;
    }

    public void setPubCreatePerson(java.lang.String pubCreatePerson){
        this.pubCreatePerson = pubCreatePerson;
    }

    public java.util.Date getPubCreateDate(){
        return pubCreateDate;
    }

    public void setPubCreateDate(java.util.Date pubCreateDate){
        this.pubCreateDate = pubCreateDate;
    }

    public java.lang.String getPubModiPerson(){
        return pubModiPerson;
    }

    public void setPubModiPerson(java.lang.String pubModiPerson){
        this.pubModiPerson = pubModiPerson;
    }

    public java.util.Date getPubModiDate(){
        return pubModiDate;
    }

    public void setPubModiDate(java.util.Date pubModiDate){
        this.pubModiDate = pubModiDate;
    }

    public java.lang.String getPubCreatePersonName(){
        return pubCreatePersonName;
    }

    public void setPubCreatePersonName(java.lang.String pubCreatePersonName){
        this.pubCreatePersonName = pubCreatePersonName;
    }

    public java.lang.String getPubModiPersonName(){
        return pubModiPersonName;
    }

    public void setPubModiPersonName(java.lang.String pubModiPersonName){
        this.pubModiPersonName = pubModiPersonName;
    }

    public java.lang.String getReferTypeId(){
        return referTypeId;
    }

    public void setReferTypeId(java.lang.String referTypeId){
        this.referTypeId = referTypeId;
    }

    public java.lang.String getReferTypeName(){
        return referTypeName;
    }

    public void setReferTypeName(java.lang.String referTypeName){
        this.referTypeName = referTypeName;
    }

}