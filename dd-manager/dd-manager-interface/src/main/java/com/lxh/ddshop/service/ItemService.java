package com.lxh.ddshop.service;

import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.pojo.po.TbItem;
import com.lxh.ddshop.pojo.vo.TbItemCustom;


import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);

   //List<TbItem> listItems();

    /**
     * 分页
     * @param page
     * @return
     */
    Result<TbItemCustom> listItemsByPage(Page page);
}
