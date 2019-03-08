package com.tt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.common.pojo.EasyUITreeNode;
import com.tt.service.ItemCatService;

@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@ResponseBody
	@RequestMapping("/item/cat/list")
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0") long parendId) {
		return itemCatService.getItemCatList(parendId);
	}
}
