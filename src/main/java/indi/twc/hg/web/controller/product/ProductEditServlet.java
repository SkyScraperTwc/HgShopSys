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

public class ProductEditServlet extends HttpServlet{
	private IBrandService brandService = new BrandServiceImpl();
	private ICategoryService categoryService = new CategoryServiceImpl();
	private IProductService productService = new ProductServiceImpl();
    private static final String savePath = "/resource/upload/product";
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			this.doPost(req, resp);
	}   
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
			try {
				Product newProduct = getProductFromRequest(req);
				productService.edit(newProduct);
				req.setAttribute("global_message", "产品修改成功！");
				req.setAttribute("nextUrl", "/back/product/productList.do");
				req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}  
	}  
	 
	private Product getProductFromRequest(HttpServletRequest req){
		FileUploadUtils uploadObj = new FileUploadUtils(req);//构造方法初始化数据
		 
		String idStr = uploadObj.getParameter("id");
		Integer productId = Integer.valueOf(idStr);
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
		String mainImage = uploadObj.processSingleUploadFile("mainImage", savePath);
		String otherImages1 = uploadObj.processSingleUploadFile("otherImages1", savePath);
		String otherImages2 = uploadObj.processSingleUploadFile("otherImages2", savePath);
		
		Product p = new Product();
		p.setId(productId);
		p.setName(name);
		p.setNumber(number); 
		p.setRemark(remark); 
		p.setMarketPrice(marketPriceDou);
		p.setDiscountedPrice(discountedPriceDou);
		p.setAddDate(new Date());
		p.setColor(color);
		p.setDesc(desc);
		
		//设置Brand
		Brand brand = new Brand(brandId);
		p.setBrand(brand);
		
		//设置Category
		try {
			Category category = categoryService.findById(categoryId);
			p.setCategory(category); 
			p.setCls("|"+category.getId()+"|,"+category.getCls());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//设置recommend
		if(null!=recommend && recommend.equals("select")){
			p.setRecommend(true);
		}else{
			p.setRecommend(false);
		}
		
		//设置promotion
		if(null!=promotion && promotion.equals("select")){  
			p.setPromotion(true); 
		}else{
			p.setPromotion(false);   
		} 
		
		//设置mainImage图片
		if(null!=mainImage && !mainImage.isEmpty()){
			//用新上传的图片路径
			p.setMainImage(mainImage);
		}else{
			//否则用旧的图片路径值
			String unChangedMainImage = uploadObj.getParameter("unChangedMainImage");
			p.setMainImage(unChangedMainImage);
		}
		
		//设置otherImages副图片 
		ProductImage pi1 = new ProductImage();
		pi1.setProductId(productId);
		pi1.setIndex(1);
		if(null!=otherImages1 && !otherImages1.isEmpty()){
			pi1.setUrl(otherImages1);
			pi1.setName(otherImages1.substring(otherImages1.lastIndexOf('/')+1, otherImages1.length()));
		}else{
			String unChangedOtherImages1 = uploadObj.getParameter("unChangedOtherImages1");
			pi1.setUrl(unChangedOtherImages1);
			pi1.setName(unChangedOtherImages1.substring(unChangedOtherImages1.lastIndexOf('/')+1, unChangedOtherImages1.length()));
		}
		
		ProductImage pi2 = new ProductImage();
		pi2.setProductId(productId);
		pi2.setIndex(2);
		if(null!=otherImages2 && !otherImages2.isEmpty()){
			pi2.setUrl(otherImages2);
			pi2.setName(otherImages2.substring(otherImages2.lastIndexOf('/')+1, otherImages2.length()));
		}else{
			String unChangedOtherImages2 = uploadObj.getParameter("unChangedOtherImages2");
			pi2.setUrl(unChangedOtherImages2);
			pi2.setName(unChangedOtherImages2.substring(unChangedOtherImages2.lastIndexOf('/')+1, unChangedOtherImages2.length()));
		}
		
		List<ProductImage> imagesList = new ArrayList<ProductImage>();
		//先添加pi1再添加pi2,有顺序的
		imagesList.add(pi1);
		imagesList.add(pi2);
		p.setProductImagesList(imagesList);
		
		return p;
	}
	
}
