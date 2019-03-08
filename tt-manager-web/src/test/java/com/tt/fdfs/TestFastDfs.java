package com.tt.fdfs;


import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.junit.Test;

import com.tt.utils.FastDFSClient;

public class TestFastDfs {

	@Test
	public void testUpload() throws Exception {
		//加载配置文件
		ClientGlobal.init("F:/workspace/tt/tt-manager-web/src/main/resources/fast_dfs.conf");
		String[] strings = new StorageClient(new TrackerClient().getConnection(),null).
				upload_file("D:/其他/3_ef608719ff6f8199603563b3d78ee386_0.jpg", "jpg", null);
		for(String string:strings){
			System.out.println(string);
		}
	}
	
	@Test
	public void testUpload1() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("F:/workspace/tt/tt-manager-web/src/main/resources/fast_dfs.conf");
		System.out.println(fastDFSClient.uploadFile("D:/其他/3_ef608719ff6f8199603563b3d78ee386_0.jpg"));
		
	}

}
