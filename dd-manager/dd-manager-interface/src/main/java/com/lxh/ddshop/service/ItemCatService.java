package com.lxh.ddshop.service;

import com.lxh.ddshop.common.dto.TreeNode;

import java.util.List;

/**
 * Created by ${lxh} on 2017/11/11 0011
 */
public interface ItemCatService {


    List<TreeNode> listItemCatsByPid(Long parentId);
}
