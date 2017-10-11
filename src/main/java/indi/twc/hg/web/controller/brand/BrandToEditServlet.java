package indi.twc.hg.web.controller.brand;

import indi.twc.hg.entity.Brand;
import indi.twc.hg.service.impl.BrandServiceImpl;
import indi.twc.hg.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BrandToEditServlet extends HttpServlet{
	private IBrandService brandService = new BrandServiceImpl();
	
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
			Brand brand = brandService.findById(id);
			req.setAttribute("brand", brand);
			//转发器  
			req.getRequestDispatcher("/WEB-INF/pages/back/brand/Brand_edit.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
