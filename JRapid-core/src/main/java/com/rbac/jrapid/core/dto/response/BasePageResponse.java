package com.rbac.jrapid.core.dto.response;

import java.util.List;

/**
 * 列表基础数据返回类
 * @author FWJ
 * @since 2016/11/14 下午4:36
 */
public class BasePageResponse<T> extends BaseResponse {

    private static final long serialVersionUID = 1741527189581389251L;
    private Integer pageIndex;// 分页索引,#从1开始
    private Integer pageSize;// 分页大小,
    private Integer pageCount;// 分页总数,
    private Integer total;//总数
    private List<T> rows;// 数据列表

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
