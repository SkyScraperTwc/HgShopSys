package indi.twc.hg.web.controller.product;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.twc.hg.entity.Brand;
import indi.twc.hg.service.impl.BrandServiceImpl;
import indi.twc.hg.service.IBrandService;
import indi.twc.hg.entity.Category;
import indi.twc.hg.service.impl.CategoryServiceImpl;
import indi.twc.hg.service.ICategoryService;
import indi.twc.hg.utils.FileUploadUtils;
import indi.twc.hg.entity.Product;
import indi.twc.hg.entity.ProductImage;
import indi.twc.hg.service.IProductService;
import indi.twc.hg.service.impl.ProductServiceImpl;

public class ProductAddServlet extends HttpServlet{
	private IBrandService brandService = new BrandServiceImpl();
	private ICategoryService categoryService = new CategoryServiceImpl();
	private IProductService productService = new ProductServiceImpl();
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
	}   
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
			Product product = getProductFromRequest(req);
			try {
				productService.add(product);
				req.setAttribute("global_message", "产品添加成功！");
				req.setAttribute("nextUrl", "/back/product/productList.do");
				req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("global_message", "产品添加失败！");
				req.setAttribute("nextUrl", "/back/product/productToAdd.do");  
				req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
			}  
	}  
	 
	private Product getProductFromRequest(HttpServletRequest req){
		FileUploadUtils uploadObj = new FileUploadUtils(req);//构造方法初始化数据
		 
		String name = uploadObj.getParameter("name");
		String number = uploadObj.getParameter("number");
		String remark = uploadObj.getParameter("remark");
		String brandStr = uploadObj.getParameter("brandID"); 
		String categoryStr = uploadObj.getParameter("categoryID");
		String marketPriceStr = uploadObj.getParameter("marketPrice");
		String discountedPriceStr = uploadObj.getParameter("discountedPrice");
		String color = uploadObj.getParameter("color");
		String recommend = uploadObj.getParameter("recommend");
		String promotion = uploadObj.getParameter("promotion"); 
		String desc = uploadObj.getParameter("desc");  
		Double marketPriceDou = Double.valueOf(marketPriceStr);
		Double discountedPriceDou = Double.valueOf(discountedPriceStr);
		  
		Integer brandId = Integer.valueOf(brandStr);
		Integer categoryId = Integer.valueOf(categoryStr);
		
		//processSingleUploadFile("name值","路径");
		String mainImage = uploadObj.processSingleUploadFile("mainImage", "/resource/upload/product");
		String[] otherImages = uploadObj.processUploadFiles("otherImages", "/resource/upload/product");
		
		Product p = new Product();
		p.setName(name);
		p.setNumber(number); 
		p.setRemark(remark); 
		p.setMarketPrice(marketPriceDou);
		p.setDiscountedPrice(discountedPriceDou);
		p.setAddDate(new Date());
		p.setColor(color);
		p.setDesc(desc);
		p.setMainImage(mainImage);
		
		//设置Brand
		p.setBrand(new Brand(brandId));
		//设置Category
		try {
			Category category = categoryService.findById(categoryId);
			p.setCategory(category); 
			p.setCls("|"+category.getId()+"|,"+category.getCls());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null!=recommend && recommend.equals("select")){
			p.setRecommend(true);
		}else{
			p.setRecommend(false);
		}
		if(null!=promotion && promotion.equals("select")){
			p.setPromotion(true); 
		}else{
			p.setPromotion(false);   
		} 
		
		//处理otherImages副图片
		List<ProductImage> imagesList = new ArrayList<ProductImage>();
		if(null!=otherImages && otherImages.length>0){
				for (int i = 0; i < otherImages.length; i++) {
					String str = otherImages[i];
					ProductImage pi = new ProductImage();
					pi.setName(str.substring(str.lastIndexOf('/')+1, str.length()));
					pi.setUrl(str);
					pi.setIndex(i+1);
					imagesList.add(pi);
				}
		}
		p.setProductImagesList(imagesList);
		return p;
	}
	
}
