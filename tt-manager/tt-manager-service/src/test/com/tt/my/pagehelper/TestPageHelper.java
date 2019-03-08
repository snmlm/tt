package com.tt.my.pagehelper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.tt.mapper.TbItemMapper;
import com.tt.pojo.TbItem;
import com.tt.pojo.TbItemExample;
import com.github.pagehelper.PageInfo;

public class TestPageHelper {

	@Test
	public void test() {
		System.out.println("1111");
		// 初始化Spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		System.out.println("222");
		// 从容器中获得mapper代理对象
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		// 执行查询
		TbItemExample tbItemExample = new TbItemExample();
		// 查询之前进行分页处理
		PageHelper.startPage(1,30); // 注意，分页插件仅对最近的这一次查询有效，下一次查询就无效了。怎么实现的呢？使用了LocalThread。
		List<TbItem> list = itemMapper.selectByExample(tbItemExample);
		// 取分页信息
		System.out.println("结果集中的记录数：" + list.size());
	    PageInfo<TbItem> pageInfo = new PageInfo<>(list);
	    System.out.println("总记录数：" + pageInfo.getTotal());
	    System.out.println("总页数：" + pageInfo.getPages());
	}

}
