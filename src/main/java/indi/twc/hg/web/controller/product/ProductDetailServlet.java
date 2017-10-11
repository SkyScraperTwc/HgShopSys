package indi.twc.hg.web.controller.product;

import indi.twc.hg.entity.Product;
import indi.twc.hg.service.IProductService;
import indi.twc.hg.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductDetailServlet extends HttpServlet{
	private IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			this.doPost(req, resp); 
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String p_idStr = req.getParameter("id");
		Integer p_idInt = Integer.valueOf(p_idStr);
		
		try {
			Product	product = productService.findById(p_idInt);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/WEB-INF/pages/front/product/product_detail.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
} 
 