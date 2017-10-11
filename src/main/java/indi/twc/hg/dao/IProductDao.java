package indi.twc.hg.dao;

import java.sql.Connection;

import indi.twc.hg.entity.Product;
import indi.twc.hg.entity.ProductImage;

public interface IProductDao {
	/**
	 * 保存产品
	 * @param p
	 * @throws Exception 
	 */  
	public void save(Product product) throws Exception;
	/**
	 * 保存副图片 
	 * @param conn
	 * @param pi
	 */ 
	public void saveImages(Connection conn, ProductImage pi);
	/**
	 * 更新产品
	 * @param conn
	 * @param pi
	 */ 
	public void updateProduct(Product product);
	/**
	 * 更新副图片 
	 * @param conn
	 * @param pi
	 */ 
	public void updateImage(ProductImage pi);
	/**
	 * 删除副图片 
	 * @param conn
	 * @param pi
	 */ 
	public void delete(Integer[] ids);
	
} 
