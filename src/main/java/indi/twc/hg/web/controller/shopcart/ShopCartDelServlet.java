package indi.twc.hg.web.controller.shopcart;

import indi.twc.hg.entity.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShopCartDelServlet extends HttpServlet{
	
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
				Integer idInt = Integer.valueOf(idStr); 
				 
				ShopCart shopCart = (ShopCart)req.getSession().getAttribute("SHOPCART");
				
				//第一次访问，session没有购物车shopCart 
				if(null==shopCart){ 
		 			shopCart = new ShopCart();
					req.getSession().setAttribute("SHOPCART", shopCart);
				}
				
				//购物车删除商品 
				shopCart.remove(idInt); 
				
				//请求转发  
				req.getRequestDispatcher("/WEB-INF/pages/front/shopcart/shopcart.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();  
			}
	}
	
} 
