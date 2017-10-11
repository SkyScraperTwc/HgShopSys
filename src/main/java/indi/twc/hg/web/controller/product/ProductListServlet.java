package indi.twc.hg.web.controller.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.twc.hg.entity.PageData;
import indi.twc.hg.service.IProductService;
import indi.twc.hg.service.impl.ProductServiceImpl;

public class ProductListServlet extends HttpServlet{
	private IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			Map<String,Object> conditions = new HashMap<String,Object>();
			LinkedHashMap<String, String> orderBy = new LinkedHashMap<String,String>();		
			
			String productName = req.getParameter("productName");
			String brandName = req.getParameter("brandName");
			String categoryName = req.getParameter("categoryName");
			
			String page = req.getParameter("page");
			String rows = req.getParameter("rows");
			
			//默认第一页和10条记录数
			int pageInt = PageData.PAGE;//1
			int rowsInt = PageData.ROWS;//30
			if(null!=productName && productName.length()>0){
				conditions.put("productName", productName);
			}
			if(null!=brandName && brandName.length()>0){
				conditions.put("brandName", brandName);
			}
			if(null!=categoryName && categoryName.length()>0){
				conditions.put("categoryName", categoryName);
			}
			if(null!=page && page.length()>0){
				pageInt = Integer.valueOf(page);
			} 
			if(null!=rows && rows.length()>0){
				rowsInt = Integer.valueOf(rows); 
			}
			orderBy.put("P_ID", "asc");    
			
			PageData pageData =  					 //1      //10
					productService.listPage(conditions,pageInt,rowsInt,orderBy);
			  
			String reqUri = req.getRequestURI();
			req.setAttribute("reqUri", reqUri);
			req.setAttribute("pageData", pageData);
			req.setAttribute("productName", productName);
			req.setAttribute("brandName", brandName); 
			req.setAttribute("categoryName", categoryName);
			
			req.getRequestDispatcher("/WEB-INF/pages/back/product/product_list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
