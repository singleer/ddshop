package com.lxh.ddshop.common.dto;

public class Page {

    private int page;//当前页码

    private int rows;//总量

    //偏移量
    //private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;
    }


}
