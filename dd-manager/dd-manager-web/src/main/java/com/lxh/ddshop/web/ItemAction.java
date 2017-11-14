package com.lxh.ddshop.web;

import com.lxh.ddshop.common.dto.Order;
import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.pojo.po.TbItem;
import com.lxh.ddshop.pojo.vo.TbItemCustom;
import com.lxh.ddshop.pojo.vo.TbItemQuery;
import com.lxh.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@Scope("prototype")
public class ItemAction {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "item/{itemId}",method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId){

        return itemService.getById(itemId);

    }

    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItem(Page page, Order order, TbItemQuery query){

        Result<TbItemCustom> list = null;
        try {
            list = itemService.listItemsByPage(page,order,query);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 删除商品记录(修改status为3)
     */
    @ResponseBody
    @RequestMapping("/items/remove")
    public int deleteItemBatch(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try{
            i = itemService.deleteBatch(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/items/up")
    public int upItemBatch(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try{
            i = itemService.upBatch(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/items/down")
    public int downItemBatch(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try{
            i = itemService.downBatch(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    //添加商品
    @ResponseBody
    @RequestMapping("/item")
    public int saveItem(TbItem tbItem, String content, String paramData){
        int i = 0;
        try{
            i = itemService.saveItem(tbItem,content,paramData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }



}
