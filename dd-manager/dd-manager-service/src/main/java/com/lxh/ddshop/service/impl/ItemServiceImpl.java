package com.lxh.ddshop.service.impl;

import com.lxh.ddshop.common.dto.Order;
import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.common.util.IDUtils;
import com.lxh.ddshop.dao.TbItemCustomMapper;
import com.lxh.ddshop.dao.TbItemDescMapper;
import com.lxh.ddshop.dao.TbItemMapper;
import com.lxh.ddshop.pojo.po.TbItem;
import com.lxh.ddshop.pojo.po.TbItemDesc;
import com.lxh.ddshop.pojo.po.TbItemExample;
import com.lxh.ddshop.pojo.vo.TbItemCustom;
import com.lxh.ddshop.pojo.vo.TbItemQuery;
import com.lxh.ddshop.service.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ItemServiceImpl implements ItemService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Autowired
    private TbItemDescMapper itemDescDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query) {
        Result<TbItemCustom> result = null;
        try{
            //创建一个map来封装前台传递过来的参数
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);
            result = new Result<TbItemCustom>();
            result.setTotal(itemCustomDao.countItems(map));
            result.setRows(itemCustomDao.listItemsByPage(map));
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        int i=0;
        try{
            TbItem record = new TbItem();
            record.setStatus((byte) 3);

            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria  criteria = example.createCriteria();

            criteria.andIdIn(ids);
            //执行更新
            itemDao.updateByExampleSelective(record,example);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int upBatch(List<Long> ids) {
        int i=0;
        try{
            TbItem record = new TbItem();
            record.setStatus((byte) 1);

            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria  criteria = example.createCriteria();

            criteria.andIdIn(ids);
            //执行更新
            itemDao.updateByExampleSelective(record,example);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Transactional
    @Override
    public int downBatch(List<Long> ids) {
        int i=0;
        try{
            TbItem record = new TbItem();
            record.setStatus((byte) 2);

            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria  criteria = example.createCriteria();

            criteria.andIdIn(ids);
            //执行更新
            itemDao.updateByExampleSelective(record,example);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int saveItem(TbItem tbItem, String content) {
        int i = 0;
        try{
            long itemId = IDUtils.getItemId();
            tbItem.setId(itemId);
            tbItem.setStatus((byte)2);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            i = itemDao.insert(tbItem);

            //新建一个商品详细信息itemDesc
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(itemId);
            tbItemDesc.setItemDesc(content);
            tbItemDesc.setCreated(new Date());
            tbItemDesc.setUpdated(new Date());
            i += itemDescDao.insert(tbItemDesc);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
