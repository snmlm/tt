package com.tt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tt.common.pojo.EasyUIDataGridResult;
import com.tt.common.pojo.TTResult;
import com.tt.common.utils.IDUtils;
import com.tt.mapper.TbItemDescMapper;
import com.tt.mapper.TbItemMapper;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemDesc;
import com.tt.pojo.TbItemExample;
import com.tt.service.ItemService;

/**
 * @ClassName ItemServiceImpl
 * @Description itemService
 * @author xxxxx
 * 
 *
 */

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	
	@Override
	public TbItem getItemById(Long itemId) {
		return tbItemMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		PageHelper.startPage(page,rows);
		List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(new PageInfo<>(list).getTotal());
		return result;
	}

	@Override
	public TTResult addItem(TbItem item, String desc) {
		long itemId = IDUtils.getItemId();
		item.setId(itemId);
		// 商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        tbItemMapper.insert(item);
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 插入商品描述
        tbItemDescMapper.insert(itemDesc);
        return TTResult.ok();
	}
}
