package indi.twc.hg.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactServlet extends HttpServlet{
	   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			this.doPost(req, resp); 
	} 
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			try { 
				//请求转发 
				req.getRequestDispatcher("/WEB-INF/pages/status/contact.html").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
	}
	
}
