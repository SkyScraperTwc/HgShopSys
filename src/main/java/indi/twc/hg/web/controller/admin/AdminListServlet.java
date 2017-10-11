package indi.twc.hg.web.controller.admin;

import indi.twc.hg.service.impl.AdminServiceImpl;
import indi.twc.hg.service.IAdminService;
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
public class AdminListServlet extends HttpServlet{
	private IAdminService adminService = new AdminServiceImpl();
	
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
				//默认第一页和10条记录数
				int pageInt = PageData.PAGE;//1
				int rowsInt = PageData.ROWS;//10
				
				String adminName = req.getParameter("adminName"); 
				String page = req.getParameter("page");
				String rows = req.getParameter("rows");
				
				if(null!=adminName && adminName.length()>0){
					conditions.put("adminName", adminName); 
				}
				if(null!=page && page.length()>0){
					//更新pageInt
					pageInt = Integer.valueOf(page);
				} 
				if(null!=rows && rows.length()>0){
					//更新rowsInt
					rowsInt = Integer.valueOf(rows); 
				}   
				orderBy.put("A_ID", "asc");
				
				PageData pageData =  					 //1      //10
						adminService.listPage(conditions,pageInt,rowsInt,orderBy);
				  
				String reqUri = req.getRequestURI();
				req.setAttribute("reqUri", reqUri);
				req.setAttribute("pageData", pageData);
				req.setAttribute("adminName", adminName);  
				
				req.getRequestDispatcher("/WEB-INF/pages/back/admin/admin_list.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
	} 
} 
