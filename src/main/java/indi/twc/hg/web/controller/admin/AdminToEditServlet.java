package indi.twc.hg.web.controller.admin;

import indi.twc.hg.entity.Admin;
import indi.twc.hg.service.impl.AdminServiceImpl;
import indi.twc.hg.service.IAdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminToEditServlet extends HttpServlet{
	private IAdminService adminService 
						= new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		 
		String adminName = req.getParameter("adminName");
		if(null!=adminName && adminName.length()>0){
			try {
				//根据adminName查找记录 
				Admin admin = adminService.findByName(adminName);
				req.setAttribute("admin", admin);
				//转发器  
				req.getRequestDispatcher("/WEB-INF/pages/back/admin/admin_edit.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
