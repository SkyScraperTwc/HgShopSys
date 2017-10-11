package indi.twc.hg.web.controller.admin;

import indi.twc.hg.entity.Admin;
import indi.twc.hg.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminAddServlet extends HttpServlet{ 
	private final static String toADD = "/back/admin/toAdd.do";
	private final static String adminList = "/back/admin/list.do";
	
	private AdminServiceImpl adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp); 
	} 
   
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
		
		Admin admin = this.getAdminFromRequest(req);     
		try {  
			String password2 = req.getParameter("password2"); 
			if(!admin.getPassword().equals(password2)){  
				msg(req, resp, toADD,"注册失败，两次输入的密码不一致！"); 
			} 
			
			String state = adminService.add(admin); 
			if(state.equals("AdminAlreadyExist")){
				msg(req, resp, toADD,"注册失败，管理员已经被注册！");
				
			}else if(state.equals("success")){  
				msg(req, resp, adminList , "恭喜您，注册成功！"); 
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
		 
		String adminName = req.getParameter("adminName");  
		String password = req.getParameter("password");  
		String realName = req.getParameter("realName");  
		String gender =  req.getParameterValues("gender")[0];
		String desc = req.getParameter("desc");   
		
		Admin admin = new Admin();
		
		admin.setAdminName(adminName); 
		admin.setPassword(password); 
		admin.setRealName(realName);
		admin.setSex(gender); 
		admin.setDesc(desc);
		
		return admin;  
	} 
}   
