package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import cn.e3.manager.utils.FastDFSClient;
import cn.e3.utils.JsonUtils;
import cn.e3.utils.KindEditorModel;

@Controller
public class UploadController {
	
	@Value("${IMAGE_URL}")
	private String IMAGE_URL;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPic(MultipartFile uploadFile){
		
		try {
			//获取上传文件名称
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			FastDFSClient fclient = new FastDFSClient("classpath:conf/client.conf");
			String url = fclient.uploadFile(uploadFile.getBytes(), extName);
			url=IMAGE_URL+url;
			KindEditorModel model = new KindEditorModel();
			model.setError(0);
			model.setUrl(url);
			String picJson = JsonUtils.objectToJson(model);
			return picJson;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			KindEditorModel model = new KindEditorModel();
			model.setError(0);
			model.setMessage("上传失败");
			String picJson = JsonUtils.objectToJson(model);
			return picJson;
		}
		
	}

}
