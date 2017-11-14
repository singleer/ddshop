package com.lxh.ddshop.service.impl;

import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.dao.TbItemParamCustomMapper;
import com.lxh.ddshop.dao.TbItemParamMapper;
import com.lxh.ddshop.pojo.po.TbItemExample;
import com.lxh.ddshop.pojo.po.TbItemParam;
import com.lxh.ddshop.pojo.po.TbItemParamExample;
import com.lxh.ddshop.pojo.vo.TbItemParamCustom;
import com.lxh.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${lxh} on 2017/11/13 0013
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;
    @Autowired
    private TbItemParamMapper itemParamDao;


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Result<TbItemParamCustom> listItemParamsByPage(Page page) {

        Result<TbItemParamCustom> result = null;
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("page",page);
            int count = itemParamCustomDao.countItemParams();
            List<TbItemParamCustom> list = itemParamCustomDao.listItemParamsByPage(map);
            result = new Result<TbItemParamCustom>();
            result.setTotal(count);
            result.setRows(list);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int saveItemParams(Long cid, String paramData) {
        int i = 0;
        try{
            TbItemParam tbItemParam = new TbItemParam();
            tbItemParam.setItemCatId(cid);
            tbItemParam.setParamData(paramData);
            tbItemParam.setCreated(new Date());
            tbItemParam.setUpdated(new Date());
            i = itemParamDao.insert(tbItemParam);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public TbItemParam getItemParamByCid(Long cid) {

        TbItemParam tbItemParam = null;
        try {
            //创建模板
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            //执行查询
            List<TbItemParam> list = itemParamDao.selectByExampleWithBLOBs(example);
            if(list!=null && list.size()>0){
                tbItemParam = list.get(0);
            }

        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return tbItemParam;
    }
}
