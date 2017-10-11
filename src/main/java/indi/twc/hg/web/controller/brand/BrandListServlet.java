package indi.twc.hg.web.controller.brand;

import indi.twc.hg.service.impl.BrandServiceImpl;
import indi.twc.hg.service.IBrandService;
import indi.twc.hg.entity.PageData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//品牌列表
public class BrandListServlet extends HttpServlet{
	private IBrandService brandService 
						= new BrandServiceImpl();
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    this.doPost(req, resp);
	} 
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			try {
				/**
				 * 　Servlet的线程安全问题只有在大量的并发访问时才会显现出来，并且很难发现，因此在编写Servlet程序时要特别注意。
				 * 线程安全问题主要是由实例变量造成的,因此在Servlet中应避免使用实例变量。如果应用程序设计无法避免使用实例变量，
				 * 那么使用同步来保护要使用的实例变量，但为保证系统的最佳性能，应该同步可用性最小的代码路径。
				 */
				Map<String,Object> conditions = new HashMap<String,Object>();
				LinkedHashMap<String, String> orderBy = new LinkedHashMap<String,String>();		
				
				String enName = req.getParameter("B_ENNAME"); 
				String cnName = req.getParameter("B_CNNAME");
				String page = req.getParameter("page");
				String rows = req.getParameter("rows");
				
				//默认第一页和10条记录数
				int pageInt = PageData.PAGE;//1
				int rowsInt = PageData.ROWS;//10
				if(null!=enName && enName.length()>0){
					conditions.put("B_ENNAME", enName);
				}
				if(null!=cnName && cnName.length()>0){
					conditions.put("B_CNNAME", cnName); 
				}
				if(null!=page && page.length()>0){
					pageInt = Integer.valueOf(page);
				} 
				if(null!=rows && rows.length()>0){
					rowsInt = Integer.valueOf(rows); 
				}   
				orderBy.put("B_ID", "asc");    
				
				PageData pageData =  					 //1      //10
						brandService.listPage(conditions,pageInt,rowsInt,orderBy);
				  
				String reqUri = req.getRequestURI();
				req.setAttribute("reqUri", reqUri);
				req.setAttribute("pageData", pageData);
				req.setAttribute("enName", enName);  
				req.setAttribute("cnName", cnName); 
				
				req.getRequestDispatcher("/WEB-INF/pages/back/brand/Brand_list.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
	} 
} 
