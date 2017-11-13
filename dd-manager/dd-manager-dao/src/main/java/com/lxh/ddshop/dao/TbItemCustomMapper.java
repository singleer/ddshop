package com.lxh.ddshop.dao;

import com.lxh.ddshop.common.dto.Order;
import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.pojo.vo.TbItemCustom;
import com.lxh.ddshop.pojo.vo.TbItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {
    /**
     * 查询商品表中所有记录
     * @return
     */
    int countItems(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    //List<TbItemCustom> listItemsByPage(@Param("page")Page page, @Param("order")Order order);
    List<TbItemCustom> listItemsByPage(Map<String,Object> map);
}
