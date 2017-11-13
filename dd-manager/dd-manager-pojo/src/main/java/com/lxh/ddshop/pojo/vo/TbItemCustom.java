package com.lxh.ddshop.pojo.vo;

import com.lxh.ddshop.pojo.po.TbItem;

/**
 * Created by ${lxh} on 2017/11/7 0007
 */
public class TbItemCustom extends TbItem {
    private String catName;
    private Long priceView;

    public Long getPriceView() {
        return priceView;
    }

    public void setPriceView(Long priceView) {
        this.priceView = priceView;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
