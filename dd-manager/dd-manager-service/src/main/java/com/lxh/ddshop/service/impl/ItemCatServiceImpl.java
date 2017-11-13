package com.lxh.ddshop.service.impl;

import com.lxh.ddshop.common.dto.TreeNode;
import com.lxh.ddshop.dao.TbItemCatMapper;
import com.lxh.ddshop.pojo.po.TbItemCat;
import com.lxh.ddshop.pojo.po.TbItemCatExample;
import com.lxh.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${lxh} on 2017/11/11 0011
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<TreeNode> listItemCatsByPid(Long parentId) {
        List<TreeNode> treeNodeList = null;
        try{
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            //执行查询
            List<TbItemCat> itemCatList = itemCatDao.selectByExample(example);
            //要序列化成json列表对象
            treeNodeList = new ArrayList<TreeNode>();
            //遍历原有列表生成新的列表
            for(int i=0;i<itemCatList.size();i++){
                TbItemCat itemCat = itemCatList.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId(itemCat.getId());
                treeNode.setText(itemCat.getName());
                treeNode.setState(itemCat.getIsParent() ? "closed" : "open");
                //新列表
                treeNodeList.add(treeNode);
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return treeNodeList;
    }
}
