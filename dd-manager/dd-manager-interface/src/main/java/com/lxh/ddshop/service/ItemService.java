package com.lxh.ddshop.service;

import com.lxh.ddshop.common.dto.Order;
import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.pojo.po.TbItem;
import com.lxh.ddshop.pojo.vo.TbItemCustom;
import com.lxh.ddshop.pojo.vo.TbItemQuery;


import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);

   //List<TbItem> listItems();

    /**
     * 分页
     * @param page
     * @return
     */
    Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteBatch(List<Long> ids);

    int upBatch(List<Long> ids);

    int downBatch(List<Long> ids);

    int saveItem(TbItem tbItem, String content);
}
