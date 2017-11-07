package com.lxh.ddshop.service.impl;

import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.dao.TbItemCustomMapper;
import com.lxh.ddshop.dao.TbItemMapper;
import com.lxh.ddshop.pojo.po.TbItem;
import com.lxh.ddshop.pojo.vo.TbItemCustom;
import com.lxh.ddshop.service.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page) {
        Result<TbItemCustom> result = null;
        try{
            result = new Result<TbItemCustom>();
            result.setTotal(itemCustomDao.countItems());
            result.setRows(itemCustomDao.listItemsByPage(page));
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }


}
