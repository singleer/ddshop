package com.lxh.ddshop.dao;

import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface TbItemCustomMapper {
    /**
     * 查询商品表中所有记录
     * @return
     */
    int countItems();

    /**
     *
     * @param page
     * @return
     */
    List<TbItemCustom> listItemsByPage(Page page);
}
