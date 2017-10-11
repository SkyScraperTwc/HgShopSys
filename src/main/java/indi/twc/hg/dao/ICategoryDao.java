package indi.twc.hg.dao;

import java.sql.SQLException;
import java.util.List;

import indi.twc.hg.entity.Category;

public interface ICategoryDao {
	/**
	 * 保存分类
	 * @param p
	 * @throws Exception
	 */  
	public void add(Category category) throws Exception;
	/** 
	 * 查询所有分类
	 * @param p 
	 * @throws Exception 
	 */
	public List<Category> query(String whereSql, List paramsList) throws Exception;
	/** 
	 * 更新分类
	 * @param p 
	 * @throws Exception
	 */
	public void update(Category category) throws SQLException;
	/**
	 * 删除分类
	 * @param ids 
	 * @param p
	 * @throws Exception
	 */  
	public void delete(Integer[] ids) throws SQLException;
	
}
