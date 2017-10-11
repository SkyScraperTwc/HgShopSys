package indi.twc.hg.web.front;

import indi.twc.hg.entity.Product;
import indi.twc.hg.service.IProductService;
import indi.twc.hg.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IndexServlet extends HttpServlet{
	private IProductService productService = new ProductServiceImpl(); 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//调用业务层获得数据，展现的数据由自己决定
		
		//特价促销10款，与下列分开查询
		Map<String, Object> conPro = new HashMap<String, Object>();
		LinkedHashMap<String, String> orderByPro = new LinkedHashMap<String, String>();
		conPro.put("P_RECOMMEND", true);//是促销的
		orderByPro.put("P_ADD_DATE", "desc");//递减 
		List<Product> promotionList = productService.listFrontProduct(conPro, 1, 10, orderByPro);
		     
		//店长推荐10款
		Map<String, Object> conRec = new HashMap<String, Object>();
		LinkedHashMap<String, String> orderByRec = new LinkedHashMap<String, String>();
		conRec.put("P_PROMOTION", true); //是推荐的
		orderByRec.put("P_ADD_DATE", "desc");//递减
		List<Product> recommendList = productService.listFrontProduct(conRec, 1, 10, orderByRec);
		 
		  
		//最新上市10款
		Map<String, Object> conNew = new HashMap<String, Object>();
		LinkedHashMap<String, String> orderByNew = new LinkedHashMap<String, String>();
		orderByNew.put("P_ADD_DATE", "desc");//递减 
		List<Product> newList = productService.listFrontProduct(conNew, 1, 10, orderByNew);
		
		
		//本周畅销
		Map<String, Object> conBuy = new HashMap<String, Object>();
		LinkedHashMap<String, String> orderByBuy = new LinkedHashMap<String, String>();
		orderByBuy.put("P_BUY_COUNT", "desc");//递减
		List<Product> buyMostList = productService.listFrontProduct(conBuy, 1, 10, orderByBuy);
		 
		    
		//本周关注  
		Map<String, Object> conAtten = new HashMap<String, Object>();
		LinkedHashMap<String, String> orderByAtten = new LinkedHashMap<String, String>();
		orderByAtten.put("P_ATTENTION", "desc");//本周关注递减 
		List<Product> attentionList = productService.listFrontProduct(conAtten, 1, 10, orderByAtten);
		  
		 
		req.setAttribute("promotionList", promotionList);
		req.setAttribute("recommendList", recommendList);
		req.setAttribute("newList", newList);
		req.setAttribute("buyMostList", buyMostList);
		req.setAttribute("attentionList", attentionList);  
		
		req.getRequestDispatcher("/WEB-INF/pages/front/index.jsp").forward(req,resp);
	}
}
