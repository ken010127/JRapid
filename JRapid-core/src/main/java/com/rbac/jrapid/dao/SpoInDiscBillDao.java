package com.rbac.jrapid.dao;


import com.rbac.jrapid.core.common.dao.BaseDao;
import com.rbac.jrapid.entity.SpoInDiscBill;
import org.springframework.stereotype.Component;

/**
* SpoInDiscBill 入库差异单头表(spo_in_disc_bill) 持久层操作类
* Created by JRapid on 2016-8-24 14:47:30.
*/
@Component("SpoInDiscBillMapper")
public interface SpoInDiscBillDao extends BaseDao<SpoInDiscBill,Long> {

}