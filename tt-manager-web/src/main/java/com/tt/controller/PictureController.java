package com.tt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tt.common.utils.JsonUtils;
import com.tt.utils.FastDFSClient;

@Controller
public class PictureController {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	private Map result = new HashMap();
	
	@ResponseBody
	@RequestMapping(value="/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
	public String uploadPic(MultipartFile uploadFile) {
		try {
			byte[] fileByte = uploadFile.getBytes();
			String fileName = uploadFile.getOriginalFilename();
			String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:fast_dfs.conf");
			String url = fastDFSClient.uploadFile(fileByte,fileExt);
	        result.put("error", 0);
	        result.put("url", IMAGE_SERVER_URL + url);
	        return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			e.printStackTrace();
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return JsonUtils.objectToJson(result);
		}
	}
}
