package indi.twc.hg.web.controller.admin;

import indi.twc.hg.entity.Admin;
import indi.twc.hg.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminPwdChangeServlet extends HttpServlet{ 
	private AdminServiceImpl adminService = new AdminServiceImpl();
	private static final String BACKPAGE = "BACKPAGE";
	private static final String BACKHOMEOAGE = "/back/index.do";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp); 
	} 
   
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			Admin newAdmin = getAdminFromRequest(req);   
			String[] newPwd = req.getParameterValues("newPassword");
			
			Admin adminFromDatabase = adminService.findByName(newAdmin.getAdminName());
			if(!newAdmin.getPassword().equals(adminFromDatabase.getPassword())){
				msg(req, resp, BACKPAGE, "修改密码失败,旧密码不正确！");
			}else if(!newPwd[0].equals(newPwd[1])){
				msg(req, resp, BACKPAGE, "修改密码失败,两次新密码不一致！");
			}else{
				boolean flag = adminService.editPwd(newAdmin.getId(),newPwd[0]);
				if(flag){
					msg(req, resp, BACKHOMEOAGE, "修改密码成功！");
				}
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
		String oldPwd = req.getParameter("oldPassword");
		
		Admin admin = new Admin();
		admin.setId(id);
		admin.setAdminName(adminName); 
		admin.setPassword(oldPwd); 
		
		return admin;  
	} 
}   
