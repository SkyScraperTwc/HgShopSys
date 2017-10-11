package indi.twc.hg.web.controller.category;

import indi.twc.hg.service.impl.CategoryServiceImpl;
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
public class CategoryListServlet extends HttpServlet{
	CategoryServiceImpl categoryService = new CategoryServiceImpl();
	
	@Override  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    this.doPost(req, resp);
	} 
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			try { 
				Map<String,Object> conditions = new HashMap<String,Object>();
				LinkedHashMap<String, String> orderBy = new LinkedHashMap<String,String>();		
				
				String categoryName = req.getParameter("categoryName"); 
				String level = req.getParameter("level"); 
				String page = req.getParameter("page");
				String rows = req.getParameter("rows");

				//默认第一页和10条记录数
				int pageInt = PageData.PAGE;//1
				int rowsInt = PageData.ROWS;//10 
				if(null!=categoryName && categoryName.length()>0){ 
					conditions.put("categoryName", categoryName);
				}
				if(null!=level && level.length()>0){
					conditions.put("level", level);
				}
				if(null!=page && page.length()>0){
					pageInt = Integer.valueOf(page);
				} 
				if(null!=rows && rows.length()>0){
					rowsInt = Integer.valueOf(rows);
				} 
				orderBy.put("C_ID", "asc");    
				
				PageData pageData =  					 //1      //10
						categoryService.listPage(conditions,pageInt,rowsInt,orderBy);
				 
				String reqUri = req.getRequestURI();
				req.setAttribute("reqUri", reqUri);
				req.setAttribute("pageData", pageData);
				req.setAttribute("categoryName", categoryName);  
				req.setAttribute("level", level); 
				
				req.getRequestDispatcher("/WEB-INF/pages/back/category/Category_list.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}  
	} 
} 
