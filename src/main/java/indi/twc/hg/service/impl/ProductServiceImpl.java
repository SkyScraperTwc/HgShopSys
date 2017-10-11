package indi.twc.hg.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import indi.twc.hg.entity.PageData;
import indi.twc.hg.dao.impl.ProductDaoImpl;
import indi.twc.hg.dao.impl.ProductDaoImpl.PD_Sql;
import indi.twc.hg.entity.Product;
import indi.twc.hg.entity.ProductImage;
import indi.twc.hg.service.IProductService;
import indi.twc.hg.utils.mapper.ProductImageRowMapper;
import indi.twc.hg.utils.mapper.ProductRowMapper;

public class ProductServiceImpl extends BaseServiceImpl implements IProductService {
	private ProductDaoImpl productDao = new ProductDaoImpl();
	 
	@Override 
	public void add(Product p) throws Exception {
		try{
			productDao.save(p);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	/**  
	 * 首页查询！！！
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listFrontProduct(Map<String,Object> conditions,
			    int page, int rows, LinkedHashMap<String, String> orderBy) {
		StringBuffer whereSql = new StringBuffer();
		@SuppressWarnings("rawtypes")
		List paramsList = new ArrayList();
		
		if(null!=conditions && conditions.size()>0){
			Object recommend = conditions.get("P_RECOMMEND");//true
			//判断recommend是否为空 
			if(null!=recommend && !"".equals(recommend)){
				whereSql.append(" and P_RECOMMEND=?");
				paramsList.add(recommend); //添加recommend
			}
			Object promotion = conditions.get("P_PROMOTION");//true
			//判断promotion是否为空
			if(null!=promotion && !"".equals(promotion)){ 
				whereSql.append(" and P_PROMOTION=?");
				paramsList.add(promotion); //添加promotion
			}
		}   
		try {
			List<Product> productList = productDao.queryList(whereSql,paramsList.toArray(),
					page,rows,orderBy, PD_Sql.productQueryList, new ProductRowMapper());
			
			return productList;
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return null;
	} 
	
	@Override  
	public Product findById(Integer id) throws Exception {
		try {
			StringBuffer whereSql = new StringBuffer(" and P_ID=?");
			List<Integer> paramsList = new ArrayList<Integer>(); 
			paramsList.add(id);
			List<Product> productList = productDao.queryList(whereSql, paramsList.toArray(), 
					-1, -1, null, PD_Sql.productQueryList, new ProductRowMapper());
			if(productList!=null && productList.size()>0){
				Product product = productList.get(0);
				List<ProductImage> pImagesList = findPImages(product.getId());
				product.setProductImagesList(pImagesList);
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询副图片 
	 */
	@Override
	public List<ProductImage> findPImages(Integer id) throws Exception {
		try {
			StringBuffer whereSql = new StringBuffer(" and PI_PRODUCT_ID=?");
			List<Integer> paramsList = new ArrayList<Integer>(); 
			paramsList.add(id);
			List<ProductImage> PImageList = productDao.queryList(whereSql, paramsList.toArray(), 
					-1, -1, null, PD_Sql.PIMAGEQUERY, new ProductImageRowMapper());
			if(null!=PImageList && PImageList.size()>0){
				return PImageList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	/**  
	 * 后台分页查询！！！
	 */ 
	@Override
	public PageData listPage(Map<String, Object> conditions, int page, int rows,
			LinkedHashMap<String, String> orderBy) {
		
		StringBuffer whereSql = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		
		if(null!=conditions && conditions.size()>0){
			Object productName = conditions.get("productName");
			//判断productName是否为空 ,不为空才添加到whereSql
			if(null!=productName && !"".equals(productName)){
				whereSql.append(" and P_NAME like ?");
				paramsList.add("%"+productName+"%"); //添加productName到paramsList
			}
			
			Object brandName = conditions.get("brandName"); 
			//判断brandId是否为空,不为空才添加到whereSql
			if(null!=brandName && !"".equals(brandName)){  
				whereSql.append(" and b.B_CNNAME=?");
				paramsList.add(brandName); //添加brandId到paramsList
			}
			
			Object categoryName = conditions.get("categoryName"); 
			//判断categoryId是否为空,不为空才添加到whereSql
			if(null!=categoryName && !"".equals(categoryName)){  
				whereSql.append(" and c.C_NAME=?");
				paramsList.add(categoryName); //添加categoryId到paramsList 
			}
		} 
		try { 
			//查出dataList  
			List<Product> dataList = productDao.queryList(whereSql,paramsList.toArray(),
						page,rows,orderBy, PD_Sql.productQueryList, new ProductRowMapper());
			
			//处理productImagesList
			for (int i = 0; i < dataList.size(); i++) {
				Product product = dataList.get(i);
				List<ProductImage> PImageList = findPImages(product.getId());
				product.setProductImagesList(PImageList);
			}
			
			//查出totalRecordes总记录数
			int totalRecordes = productDao.getTotalRecords(whereSql,paramsList,PD_Sql.queryCount);
			
			//创建pageData对象(totalRecordes,1,30,dataList)
			PageData pageData = new PageData(totalRecordes, page, rows, dataList);
			  
			return pageData;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void edit(Product newProduct) throws Exception {
		Product oldProduct = findById(newProduct.getId());
		List<ProductImage> newPImageList = newProduct.getProductImagesList();
		List<ProductImage> oldPImageList = oldProduct.getProductImagesList();
		for (int i = 0; i <= 1; i++) {
			ProductImage newPI = newPImageList.get(i);
			ProductImage oldPI = oldPImageList.get(i);
			newPI.setId(oldPI.getId());
			//图片路径不相同，要删除旧的路径
			if(!newPI.getUrl().equals(oldPI.getUrl())){
				deletePhoto(oldPI.getUrl());
				productDao.updateImage(newPI);
			}
		}
		
		//修改数据库信息！
		productDao.updateProduct(newProduct);
	}
	
	@Override
	public void delete(Integer[] ids) {
		try {
			for (int i = 0; i < ids.length; i++) {
				Product product = findById(ids[i]);
				List<ProductImage> pImageList = product.getProductImagesList();
				for (int j = 0; j < pImageList.size(); j++) {
					//先删除副图片！
					deletePhoto(pImageList.get(j).getUrl());
				}
				//再删除主图片！
				deletePhoto(product.getMainImage());
			}
			
			//再删除数据库产品信息！
			productDao.delete(ids);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

