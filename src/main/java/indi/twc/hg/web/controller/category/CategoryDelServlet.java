package indi.twc.hg.web.controller.category;

import indi.twc.hg.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDelServlet extends HttpServlet{
	private CategoryServiceImpl categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			//获得用户从页面传来的数据,ids设定只有一个元素
			String[] ids = req.getParameterValues("id");
			List<Integer> idList = new ArrayList<Integer>();
			if(null!=ids && ids.length>0){
				for (int i = 0; i < ids.length; i++) {
					Integer id = Integer.valueOf(ids[i]);
					idList.add(id);
				}
			}
			try {
				categoryService.delete(idList.toArray(new Integer[]{}));
				req.setAttribute("nextUrl", "/back/category/categoryList.do");
				req.setAttribute("global_message", "分类删除成功！");
				req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
