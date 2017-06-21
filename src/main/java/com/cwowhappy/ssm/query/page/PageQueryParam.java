package com.cwowhappy.ssm.query.page;

import java.util.List;

/**
 * @author cwowhappy
 */
public class PageQueryParam<T> {
    private Integer pageCurrent;
    private Integer pageSize;
    private T filter;
    private List<PageOrder> orders;

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }

    public List<PageOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PageOrder> orders) {
        this.orders = orders;
    }
}
