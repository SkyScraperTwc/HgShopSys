package indi.twc.hg.web.controller.shopcart;

import indi.twc.hg.service.IProductService;
import indi.twc.hg.service.impl.ProductServiceImpl;
import indi.twc.hg.entity.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShopCartUpdateServlet extends HttpServlet{
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
				String idStr = req.getParameter("id");
				String countStr = req.getParameter("count");
				Integer idInt = Integer.valueOf(idStr); 
				Integer countInt = Integer.valueOf(countStr);
				
				ShopCart shopCart = (ShopCart)req.getSession().getAttribute("SHOPCART");
				 
				//第一次访问，session没有购物车shopCart 
				if(null==shopCart){ 
					shopCart = new ShopCart();
					req.getSession().setAttribute("SHOPCART", shopCart);
				}
				 
				//把产品添加到购物车 
				shopCart.update(idInt, countInt);
				
				//请求转发  
				req.getRequestDispatcher("/WEB-INF/pages/front/shopcart/shopcart.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();  
			}
	}
	
} 
