package com.rbac.jrapid.platform.dao;


import com.rbac.jrapid.core.common.dao.BaseDao;
import com.rbac.jrapid.platform.entity.SpoInDiscBill;
import org.springframework.stereotype.Component;

/**
* SpoInDiscBill 入库差异单头表(spo_in_disc_bill) 持久层操作类
* Created by JRapid on 2016-8-24 13:52:09.
*/
@Component("SpoInDiscBillMapper")
public interface SpoInDiscBillDao extends BaseDao<SpoInDiscBill,Long> {

}