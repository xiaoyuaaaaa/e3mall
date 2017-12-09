package cn.e3.fastdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3.manager.utils.FastDFSClient;

public class MyFastDFS {
	
	@Test
	public void uploadPicTest1() throws Exception{
		
		//指定上传图片
		String pic = "C:\\Users\\王雨\\Pictures\\Saved Pictures\\eee.jpg";
		//指定配置文件绝对路径
		String client = "E:\\workspace\\e3mall\\e3-manager-web\\src\\main\\resources\\conf\\client.conf";
		//使用fastDFS客户端api加载client.conf配置文件，连接tracker_server服务器
		ClientGlobal.init(client);
		
		//创建trackerServer服务对象
		TrackerClient tClient = new TrackerClient();
		//从客户端对象中获取服务对象
		TrackerServer trackerServer = tClient.getConnection();
		
		StorageServer storageServer = null;
		//创建storage存储服务器客户端对象
		StorageClient sClient = new StorageClient(trackerServer,storageServer);
		
		//上传
		String[] urls = sClient.upload_file(pic, "jpg", null);
		for (String url : urls) {
			System.out.println(url);
		}
		
	}
	
	@Test
	public void uploadPicTest2() throws Exception{
		
		//指定上传图片
		String pic = "C:\\Users\\王雨\\Pictures\\Saved Pictures\\qqq.jpg";
		//指定配置文件绝对路径
		String client = "E:\\workspace\\e3mall\\e3-manager-web\\src\\main\\resources\\conf\\client.conf";
		
		FastDFSClient fclient = new FastDFSClient(client);
		String url = fclient.uploadFile(pic);
		System.out.println(url);
		
	}

}
