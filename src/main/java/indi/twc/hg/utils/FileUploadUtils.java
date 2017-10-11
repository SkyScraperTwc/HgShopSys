package indi.twc.hg.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;


public class FileUploadUtils {
	private static final String TEMP_DIR_PATH = "E:\\";
	
	private Map<String, List<FileItem>> map = new HashMap<String, List<FileItem>>();
	
	private HttpServletRequest request;
	 
	public FileUploadUtils(HttpServletRequest req){
		 this.request = req;
		 DiskFileItemFactory dff = new DiskFileItemFactory();//创建该对象  
         dff.setRepository(new File(TEMP_DIR_PATH));//指定上传文件的临时目录
         dff.setSizeThreshold(10240000);//指定在内存中缓存数据大小,单位为byte  
         
         ServletFileUpload sfu = new ServletFileUpload(dff);//创建该对象  
         sfu.setFileSizeMax(10000000);// 指定单个上传文件的最大尺寸
         sfu.setSizeMax(100000000);//指定一次上传多个文件的总大小
         try { 
			@SuppressWarnings("unchecked")
			List<FileItem> list = sfu.parseRequest(req);
			if(null!=list){
				for (FileItem item : list) {
					String fieldName = item.getFieldName();
					List<FileItem> fis = map.get(fieldName);
					if(null==fis){
						fis = new ArrayList<FileItem>();
						map.put(fieldName, fis);
					}
					fis.add(item);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
	
	public String getParameter(String filedName){
		String[] value = getParameterValues(filedName);
		if(null!=value  && value.length>0){
			return value[0];
		}else{
			return null;
		}
	}
	
	public String[] getParameterValues(String filedName){

		List<FileItem> items = map.get(filedName);
		List<String> values = new ArrayList<String>();
		if(null!=items){
			for (FileItem item : items) {
				try {
					values.add(item.getString("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return values.toArray(new String[]{});
		}else{
			return null;
		}
	}
	/**
	 * getRealPath
	 * @param request
	 * @param path
	 * @return
	 */
	
	 private static String getRealPath(HttpServletRequest request, String path){
		 return request.getSession().getServletContext().getRealPath(path);
	 }
	    
	 /**
	  * processUploadFile  
	  * @param filedName html:name="filedName" 
	  * @param saveDirPath
	  * @return
	  */
	public String[] processUploadFiles(String filedName, String saveDirPath){
		List<FileItem> itemsList = map.get(filedName);
		List<String> pathsList = new ArrayList<String>();
		
		//往tomcat部署路径写
		String realSaveDirPath1 = this.getRealPath(request,"/")+saveDirPath;
//		System.out.println("realSaveDirPath1-----"+realSaveDirPath1);
		//往真实存储路径写
		String realSaveDirPath2 = "E://workspace//HgShopSys//WebContent"+saveDirPath;
		
		File saveDir1 = new File(realSaveDirPath1);  
//		System.out.println("saveDir1----"+saveDir1);
		File saveDir2 = new File(realSaveDirPath2);  
		if(!saveDir1.exists()){ 
			saveDir1.mkdirs();
		}
		if(!saveDir2.exists()){ 
			saveDir2.mkdirs();
		}
		
		if(null!=itemsList){
			for (FileItem item : itemsList) {
				//如果size<=0, 返回null
				if(item.getSize()<=0){
					return null;
				}
				String name = item.getName();
				String ext = name.substring(name.lastIndexOf("."));
				String saveName = UUID.randomUUID().toString()+ext;  
				
				File saveFile1 = new File(saveDir1, saveName);
				File saveFile2 = new File(saveDir2, saveName);
//				System.out.println("saveFile1----"+saveFile1);
				try {   
					//往saveFile1文件夹写文件  
					item.write(saveFile1);
					//往saveFile2文件夹写文件    
					item.write(saveFile2);
					//pathsList存放图片路径
					pathsList.add(saveDirPath+"/"+saveName);
				} catch (Exception e) { 
					e.printStackTrace();
				}   
			}  
			return pathsList.toArray(new String[]{});
		}else{
			return null;
		}
	}  
	/**
	 * 处理单个文件
	 * @param filedName
	 * @param saveDirPath
	 * @return  
	 */
	public String processSingleUploadFile(String filedName, String saveDirPath){
		String[] paths = processUploadFiles(filedName, saveDirPath);
		if(null!=paths && paths.length>0){
			return paths[0]; 
		}else{
			return null;
		}
	}
	
}
