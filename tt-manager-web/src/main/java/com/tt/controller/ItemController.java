package com.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.common.pojo.EasyUIDataGridResult;
import com.tt.common.pojo.TTResult;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	public ItemService itemSercive;
	
	@ResponseBody
	@RequestMapping("/item/{itemId}")
	public TbItem getItemById(@PathVariable Long itemId) {
		return itemSercive.getItemById(itemId);
	}
	
	@ResponseBody
	@RequestMapping("/item/list")
	public EasyUIDataGridResult getItemList(Integer page,Integer rows) {
		return itemSercive.getItemList(page, rows);
	}
	
	@ResponseBody
	@RequestMapping("/item/save")
	public TTResult saveItem(TbItem item,String desc){
		return itemSercive.addItem(item, desc);
	}
}
