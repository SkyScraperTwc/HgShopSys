package indi.twc.hg.web.controller.brand;

import indi.twc.hg.entity.Brand;
import indi.twc.hg.service.impl.BrandServiceImpl;
import indi.twc.hg.utils.FileUploadUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BrandEditServlet extends HttpServlet{
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
					//获取新的brand
					Brand newBrand = getBrandFromRequest(req);
					brandService.edit(newBrand);//修改数据库记录,其中要删除原来的图片
					req.setAttribute("global_message", "品牌修改成功！");
					req.setAttribute("nextUrl", "/back/brand/brandList.do");
					req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}	
	
	private Map<String, String> validate(HttpServletRequest req){
		Map<String,String> errors = new HashMap<String, String>();
		//检验代码
		
		return errors;
	}
	
	private Brand getBrandFromRequest(HttpServletRequest req){
		FileUploadUtils uploadUtils = new FileUploadUtils(req);
		
		String idStr = uploadUtils.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		
		String cnName = uploadUtils.getParameter("cnName");
		String enName = uploadUtils.getParameter("enName");
		
		//图片上传为空怎么搞？
		String newSmallPhoto = uploadUtils.processSingleUploadFile("smallPhoto", savePath);
		String newBigPhoto = uploadUtils.processSingleUploadFile("bigPhoto", savePath);
		String desc = uploadUtils.getParameter("desc");
		
		Brand brand = new Brand();
		brand.setId(id);
		brand.setCnName(cnName);
		brand.setEnName(enName);
		brand.setDesc(desc);
		
		if(null!=newSmallPhoto && !newSmallPhoto.isEmpty()){
			//用新上传的图片路径
			brand.setSmallPhoto(newSmallPhoto);
		}else{
			//用旧的图片路径值
			String unChangedSP = uploadUtils.getParameter("unChangedSmallPhoto");
			brand.setSmallPhoto(unChangedSP);
		}
		if(null!=newBigPhoto && !newBigPhoto.isEmpty()){
			brand.setBigPhoto(newBigPhoto);
		}else{
			String unChangedBP = uploadUtils.getParameter("unChangedbigPhoto");
			brand.setBigPhoto(unChangedBP);
		}
		
		return brand;
	}
	
	
}
