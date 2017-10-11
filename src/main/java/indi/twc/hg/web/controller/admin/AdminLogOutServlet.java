package indi.twc.hg.web.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminLogOutServlet extends HttpServlet{ 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);  
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String loginName = (String) session.getAttribute("loginName");
		if(null!=loginName && loginName.length()>0){
			session.removeAttribute("loginName");
		}
		//转发器
		req.getRequestDispatcher("/WEB-INF/pages/back/admin/admin_login.jsp").forward(req, resp);
	} 
	  
}   
