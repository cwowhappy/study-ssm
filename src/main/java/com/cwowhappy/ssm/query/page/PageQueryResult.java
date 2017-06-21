package com.cwowhappy.ssm.query.page;

import java.util.List;

/**
 * Created by cwowhappy on 2017/6/14.
 */
public class PageQueryResult<T> {
    private Integer total;
    private List<T> records;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
