package com.tt.service;

import com.tt.common.pojo.EasyUIDataGridResult;
import com.tt.common.pojo.TTResult;
import com.tt.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(Long itemId);
	
	EasyUIDataGridResult getItemList(int page,int rows);
	
	TTResult addItem(TbItem item,String desc);
}
