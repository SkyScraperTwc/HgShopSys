package indi.twc.hg.web.controller.admin;

import indi.twc.hg.entity.Admin;
import indi.twc.hg.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminEditServlet extends HttpServlet{ 
	private AdminServiceImpl adminService = new AdminServiceImpl();
	private static final String ADMINLIST = "/back/admin/list.do";
	private static final String BACKPAGE = "BACKPAGE";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp); 
	} 
   
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
		try {
			//修改数据库记录
			Admin admin = getAdminFromRequest(req);     
			boolean flag = adminService.edit(admin);
			if(flag){
				msg(req, resp, ADMINLIST, "管理员信息修改成功！");
			}else{ 
				msg(req, resp, BACKPAGE, "管理员信息修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	private void msg(HttpServletRequest req, HttpServletResponse resp, 
	          String nextUrl, String global_message) throws ServletException, IOException {
					//设置nextUrl与global_message 
					req.setAttribute("nextUrl", nextUrl);
					req.setAttribute("global_message", global_message);
					//转发器
					req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
	}
	
	private Admin getAdminFromRequest(HttpServletRequest req){
		 
		String idStr = req.getParameter("adminId");
		Integer id = Integer.valueOf(idStr);
		String adminName = req.getParameter("adminName");  
		String password = req.getParameter("password");  
		String realName = req.getParameter("realName");  
		String gender =  req.getParameterValues("gender")[0];
		String desc = req.getParameter("desc");   
		
		Admin admin = new Admin();
		
		admin.setId(id);
		admin.setAdminName(adminName); 
		admin.setPassword(password); 
		admin.setRealName(realName);
		admin.setSex(gender); 
		admin.setDesc(desc);
		
		return admin;  
	} 
}   
