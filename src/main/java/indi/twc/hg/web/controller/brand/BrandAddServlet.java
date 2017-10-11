package indi.twc.hg.web.controller.brand;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.twc.hg.entity.Brand;
import indi.twc.hg.service.impl.BrandServiceImpl;
import indi.twc.hg.utils.FileUploadUtils;

public class BrandAddServlet extends HttpServlet{
	private BrandServiceImpl brandService = new BrandServiceImpl();
	private static final String savePath = "/resource/upload/brand";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}  

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			Map<String,String> errors = this.validate(req);   
			if(errors.size()>0){
				//有错误就转发
				req.getRequestDispatcher("/WEB-INF/pages/back/brand/Brand_add.jsp").forward(req, resp);
			}else{  
				try {    
					//Dao, 把对象存进数据库，然后页面跳转 
					Brand brand = getBrandFromRequest(req); 
					brandService.add(brand);//添加到数据库 
					req.setAttribute("global_message", "品牌添加成功！");
					req.setAttribute("nextUrl", "/back/brand/brandList.do");
					req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
				} catch (Exception e) { 
					e.printStackTrace();  
					req.setAttribute("global_message", "品牌添加失败！");
					req.setAttribute("nextUrl", "/back/brand/brandToAdd.do");  
					req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
				}  
			}  
	}	
	
	private Map<String, String> validate(HttpServletRequest req){
		Map<String,String> errors = new HashMap<String, String>();
		//检验代码
		
		return errors; 
	}   
	
	private Brand getBrandFromRequest(HttpServletRequest req){
		FileUploadUtils uploadObj = new FileUploadUtils(req); 
		
		String cnName = uploadObj.getParameter("cnName");
		String enName = uploadObj.getParameter("enName");
		
		//图片上传为空怎么搞？
		String smallPhoto = uploadObj.processSingleUploadFile("smallPhoto", savePath);
		String bigPhoto = uploadObj.processSingleUploadFile("bigPhoto", savePath); 
		String desc = uploadObj.getParameter("desc");
		 
		Brand brand = new Brand();
		brand.setCnName(cnName);
		brand.setEnName(enName); 
		brand.setDesc(desc); 
		
		if(smallPhoto!=null){
			brand.setSmallPhoto(smallPhoto);
		}else{
			brand.setSmallPhoto(" ");
		}
		
		if(bigPhoto!=null){
			brand.setBigPhoto(bigPhoto); 
		}else{
			brand.setBigPhoto(" ");
		}
		
		return brand; 
	}
	
}
