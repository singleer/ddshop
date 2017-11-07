package com.lxh.ddshop.web;

import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.pojo.po.TbItem;
import com.lxh.ddshop.pojo.vo.TbItemCustom;
import com.lxh.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /*@ResponseBody
    @RequestMapping("/items")
    public List<TbItem> listItems() {
        List<TbItem> list = null;
        try {
            list = itemService.listItems();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }*/

    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItem(Page page){

        Result<TbItemCustom> list = null;
        try {
            list = itemService.listItemsByPage(page);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }



}
