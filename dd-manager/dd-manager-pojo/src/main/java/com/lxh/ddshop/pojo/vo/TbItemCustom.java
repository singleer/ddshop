package com.lxh.ddshop.pojo.vo;

import com.lxh.ddshop.pojo.po.TbItem;

/**
 * Created by ${lxh} on 2017/11/7 0007
 */
public class TbItemCustom extends TbItem {
    private String catName;
    private String priceView;

    public String getPriceView() {
        return priceView;
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
