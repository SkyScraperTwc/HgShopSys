package indi.twc.hg.web.back;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BackMenuServlet extends HttpServlet{
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			this.doGet(req, resp); 
	} 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
		 
		req.getRequestDispatcher("/WEB-INF/pages/back/menu.jsp").forward(req,resp);
	}  
}  
    