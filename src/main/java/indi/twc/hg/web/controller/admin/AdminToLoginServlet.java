package indi.twc.hg.web.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminToLoginServlet extends HttpServlet{ 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//转发器
		req.getRequestDispatcher("/WEB-INF/pages/back/admin/admin_login.jsp").forward(req, resp);
	} 
	 
} 
