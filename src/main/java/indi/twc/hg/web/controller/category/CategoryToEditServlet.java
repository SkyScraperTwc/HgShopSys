package indi.twc.hg.web.controller.category;

import indi.twc.hg.entity.Category;
import indi.twc.hg.service.impl.CategoryServiceImpl;
import indi.twc.hg.service.ICategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryToEditServlet extends HttpServlet{
	private ICategoryService categoryService 
			 					= new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		 
		String idStr = req.getParameter("id");//1
		Integer id = Integer.valueOf(idStr);  //1
		try {
			//根据id查找记录
			Category category = categoryService.findById(id);
			req.setAttribute("category", category);
			//请求转发
			req.getRequestDispatcher("/WEB-INF/pages/back/category/Category_edit.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
