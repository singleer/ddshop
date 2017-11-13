package com.lxh.ddshop.service;

import com.lxh.ddshop.common.dto.Page;
import com.lxh.ddshop.common.dto.Result;
import com.lxh.ddshop.pojo.vo.TbItemParamCustom;

/**
 * Created by ${lxh} on 2017/11/13 0013
 */
public interface ItemParamService {
    Result<TbItemParamCustom> listItemParamsByPage(Page page);
}
