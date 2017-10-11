package indi.twc.hg.web.controller.category;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.twc.hg.entity.Category;
import indi.twc.hg.service.impl.CategoryServiceImpl;

public class CategoryAddServlet extends HttpServlet{
	private CategoryServiceImpl categoryService 
							= new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	} 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			Map<String,String> errors = this.validate(req);   
			if(errors.size()>0){
				//有错误就转发 
				req.getRequestDispatcher("/WEB-INF/pages/back/category/Category_add.jsp").forward(req, resp);
			}else{
				   
				Category category = getCategoryFromRequest(req); 
			 	 
				//Dao,把对象存进数据库，然后页面跳转  
				try {
					categoryService.add(category);//添加到数据库
					req.setAttribute("global_message", "分类添加成功！"); 
					req.setAttribute("nextUrl", "/back/category/categoryList.do");
					req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			} 
	}	
	 
	private Map<String, String> validate(HttpServletRequest req){
		Map<String,String> errors = new HashMap<String, String>();
		//检验代码 
		
		return errors;
	}
	
	private Category getCategoryFromRequest(HttpServletRequest req){
		
		String name = req.getParameter("name");
		String levelStr = req.getParameter("level"); 
		String P_IDStr = req.getParameter("P_ID");
		String desc = req.getParameter("desc");
		
		Integer P_ID = Integer.valueOf(P_IDStr);
		Integer level = Integer.valueOf(levelStr); 
		 
		Category category = new Category();
		//cls查询 
		Category parentCategory = null;
		try {
			parentCategory = categoryService.findById(P_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String parentCls = parentCategory.getCls();
		String finalCls = "|"+P_IDStr+"|,"+parentCls;   
		
		category.setId(null);
		category.setName(name);
		category.setLevel(level);    
		category.setCls(finalCls);
		category.setDesc(desc);
		category.setParentCategory(parentCategory);
		
		return category; 
	}
	
	
	
}
