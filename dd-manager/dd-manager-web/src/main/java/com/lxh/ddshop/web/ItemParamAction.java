package com.lxh.ddshop.web;

import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.pojo.po.TbItemParam;
import com.lxh.ddshop.pojo.vo.TbItemParamCustom;
import com.lxh.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ${lxh} on 2017/11/13 0013
 */
@Controller
public class ItemParamAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //显示商品过个参数
    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParamsByPage(Page page) {

        Result<TbItemParamCustom> result = null;
        try {
            result = itemParamService.listItemParamsByPage(page);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return result;


    }


    @ResponseBody
    @RequestMapping("/itemParamsAdd")
    public int saveItemParams(@RequestParam("cid") Long cid,@RequestParam("paramData") String paramData){
       int i = 0;
       try{
           i = itemParamService.saveItemParams(cid,paramData);

       }catch (Exception e){
           logger.error(e.getMessage(),e);
           e.printStackTrace();
       }

        return i;

    }


    //通过选中商品类别叶节点显示规格参数
    @ResponseBody
    @RequestMapping(value = "itemParam/query/{cid}",method = RequestMethod.GET)
    public TbItemParam getItemParamByCid(@PathVariable("cid") Long cid){
        TbItemParam tbItemParam = null;
        try {
            tbItemParam = itemParamService.getItemParamByCid(cid);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return tbItemParam;
    }
}
