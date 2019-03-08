package com.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.common.pojo.EasyUIDataGridResult;
import com.tt.service.ItemParamService;

@Controller
public class ItemParamController {
	
	@Autowired
	private ItemParamService itemParamService;
	
	@ResponseBody
	@RequestMapping("/item/param/list")
	public EasyUIDataGridResult getItemParamList(Integer page,Integer rows) {
		return itemParamService.geTbItemParam(page,rows);
	}
}
