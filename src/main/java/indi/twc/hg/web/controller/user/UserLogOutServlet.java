package indi.twc.hg.web.controller.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLogOutServlet extends HttpServlet{ 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);  
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
			resp.setHeader("Cache-Control","no-cache"); 
			resp.setHeader("Cache-Control","no-store");   
			resp.setDateHeader("Expires",0); 
			resp.setHeader("Pragma","no-cache"); 
			req.getSession().removeAttribute("login_user"); 
		//转发器
		req.getRequestDispatcher("/").forward(req, resp);
	} 
	  
}   
