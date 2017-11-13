package com.lxh.ddshop.dao;

import com.lxh.ddshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map; /**
 * Created by ${lxh} on 2017/11/13 0013
 */
public interface TbItemParamCustomMapper {
    int countItemParams();

    List<TbItemParamCustom> listItemParamsByPage(Map<String, Object> map);
}
