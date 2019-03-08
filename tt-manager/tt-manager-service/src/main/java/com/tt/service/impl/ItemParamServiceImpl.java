package com.tt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tt.common.pojo.EasyUIDataGridResult;
import com.tt.mapper.TbItemParamMapper;
import com.tt.pojo.TbItemParam;
import com.tt.pojo.TbItemParamExample;
import com.tt.service.ItemParamService;

@Service("ItemParamService")
public class ItemParamServiceImpl implements ItemParamService{

	@Autowired
	private TbItemParamMapper TbItemParamMapper;
	
	@Override
	public EasyUIDataGridResult geTbItemParam(int page,int rows) {
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		List<TbItemParam> list = TbItemParamMapper.selectByExample(new TbItemParamExample());
		PageHelper.startPage(page, rows);
		result.setRows(list);
		result.setTotal(new PageInfo<>(list).getTotal());
		return result;
	}

}
