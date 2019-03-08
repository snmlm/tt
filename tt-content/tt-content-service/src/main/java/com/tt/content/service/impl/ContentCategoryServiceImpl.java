package com.tt.content.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tt.common.pojo.EasyUITreeNode;
import com.tt.content.service.ContentCategoryService;
import com.tt.mapper.TbContentCategoryMapper;
import com.tt.pojo.TbContentCategory;
import com.tt.pojo.TbContentCategoryExample;
import com.tt.pojo.TbContentCategoryExample.Criteria;

@Service("ContentCategoryService")
public class ContentCategoryServiceImpl implements ContentCategoryService{

	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;
	
	@Override
	public List<EasyUITreeNode> getContentCatList(long parentId) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andParentIdEqualTo(parentId);
        // 执行查询
        List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
        // 返回结果为List
        List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
        for (TbContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            // 添加到列表
            resultList.add(node);
        }
        return resultList;
	}
	
}
