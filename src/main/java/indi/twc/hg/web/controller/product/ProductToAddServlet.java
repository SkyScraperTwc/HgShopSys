package indi.twc.hg.web.controller.product;

import indi.twc.hg.entity.Brand;
import indi.twc.hg.service.impl.BrandServiceImpl;
import indi.twc.hg.service.IBrandService;
import indi.twc.hg.entity.Category;
import indi.twc.hg.service.impl.CategoryServiceImpl;
import indi.twc.hg.service.ICategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductToAddServlet extends HttpServlet{
	private IBrandService brandService = new BrandServiceImpl();
	private ICategoryService categoryService = new CategoryServiceImpl();
	private static final Integer categoryLevel = 1;
	   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			this.doPost(req, resp); 
	} 
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			try { 
				List<Brand> brandList = brandService.listAllBrand();
				List<Category> categoryList = categoryService.listAllCategory(categoryLevel);
				req.setAttribute("brandList", brandList); 
				req.setAttribute("categoryList", categoryList);
				
				//请求转发 
				req.getRequestDispatcher("/WEB-INF/pages/back/product/product_add.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
	}
	
}
