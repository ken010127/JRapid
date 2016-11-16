package com.rbac.jrapid.core.dto.request;

import com.rbac.jrapid.core.common.dao.QueryCondition;
import com.rbac.jrapid.core.constants.MainConstants;
import com.rbac.jrapid.core.dto.response.BaseResponse;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 列表请求基础类
 * @author FWJ
 * @since 2016/11/14 下午5:55
 */
public class BasePageRequest extends BaseResponse {

    @NotNull(message = "分页页码pageIndex不能为空")
    private Integer page = MainConstants.DEFAUTL_PAGE_INDEX;
    @NotNull(message = "分页大小pageSize不能为空")
    private Integer rows = MainConstants.DEFAUTL_PAGE_SIZE;

    private String sort;
    private String order;
    private List<QueryCondition> queryConditionList;
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getRows() {
        return rows;
    }
    public void setRows(Integer rows) {
        if (rows <= 0 || rows > MainConstants.MAX_PAGE_SIZE) {
            this.rows = MainConstants.MAX_PAGE_SIZE;
            return;
        }
        this.rows = rows;
    }
    public List<QueryCondition> getQueryConditionList() {
        return queryConditionList;
    }
    public void setQueryConditionList(List<QueryCondition> queryConditionList) {
        this.queryConditionList = queryConditionList;
    }
    public void buildQueryCondition(String property, Object value,String propertyType,String queryMethod) {
        if(queryConditionList==null){
            queryConditionList=new ArrayList<QueryCondition>();
        }
        QueryCondition condition=new QueryCondition();
        condition.setPropertyType(propertyType);
        condition.setQueryMethod(queryMethod);
        condition.setQueryProperty(property);
        condition.setValue(value);
        queryConditionList.add(condition);

    }

}
