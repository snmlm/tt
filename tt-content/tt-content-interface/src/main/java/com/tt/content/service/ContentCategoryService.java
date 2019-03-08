package com.tt.content.service;

import java.util.List;

import com.tt.common.pojo.EasyUITreeNode;

public interface ContentCategoryService {
	
	List<EasyUITreeNode> getContentCatList(long parentId);
}
