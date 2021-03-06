package com.lxh.ddshop.common.dto;

import java.util.List;

/**
 *
 * @param <T>
 */
public class Result<T> {

    private int total;
    private List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
