package indi.twc.hg.service.impl;

import indi.twc.hg.service.IBaseService;

import java.io.File;

public class BaseServiceImpl implements IBaseService {

	@Override
	public void deletePhoto(String path) throws Exception {
		File file1 = new File("D:/apache-tomcat-8.0.24/wtpwebapps/HgShopSys"+path);
		
		File file2 = new File("E:/workspace/HgShopSys/WebContent"+path);
		 
		if(file1.exists()){
			file1.delete();
		}
		if(file2.exists()){
			file2.delete();
		}
	}

}
