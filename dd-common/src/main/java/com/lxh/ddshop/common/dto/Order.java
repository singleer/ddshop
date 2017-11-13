package com.lxh.ddshop.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${lxh} on 2017/11/9 0009
 * easyui的datagrid排序通用类
 */
public class Order {

    private String order;
    private String sort;

    public List<String> getOrderParams() {
        String[] sorts = sort.split(",");//id,title
        String[] orders = order.split(",");//asc,desc
        List<String> list = new ArrayList<String>();
        for (int i=0;i<sorts.length;i++){
            String temp = sorts[i] +" "+orders[i];//id asc;title desc
            list.add(temp);//[id asc;title desc]
        }
        return list;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
