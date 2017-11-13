package com.lxh.ddshop.service.impl;

import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.dao.TbItemParamCustomMapper;
import com.lxh.ddshop.pojo.vo.TbItemParamCustom;
import com.lxh.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
