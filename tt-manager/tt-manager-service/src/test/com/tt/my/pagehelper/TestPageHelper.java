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
		// ��ʼ��Spring����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		System.out.println("222");
		// �������л��mapper�������
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		// ִ�в�ѯ
		TbItemExample tbItemExample = new TbItemExample();
		// ��ѯ֮ǰ���з�ҳ����
		PageHelper.startPage(1,30); // ע�⣬��ҳ��������������һ�β�ѯ��Ч����һ�β�ѯ����Ч�ˡ���ôʵ�ֵ��أ�ʹ����LocalThread��
		List<TbItem> list = itemMapper.selectByExample(tbItemExample);
		// ȡ��ҳ��Ϣ
		System.out.println("������еļ�¼����" + list.size());
	    PageInfo<TbItem> pageInfo = new PageInfo<>(list);
	    System.out.println("�ܼ�¼����" + pageInfo.getTotal());
	    System.out.println("��ҳ����" + pageInfo.getPages());
	}

}
