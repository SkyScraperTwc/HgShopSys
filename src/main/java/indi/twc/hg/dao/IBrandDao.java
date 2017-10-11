package indi.twc.hg.dao;

import indi.twc.hg.entity.Brand;

public interface IBrandDao {
	/**
	 * 保存品牌
	 * @param brand
	 * @throws Exception 
	 */
	public void save(Brand brand) throws Exception;
	/**
	 * 根据一组主键删除多条记录 
	 * @param id
	 * @throws Exception
	 */
	public void delete(Integer[] id) throws Exception;
	/**
	 * 更新brand
	 * @param brand
	 * @throws Exception 
	 */
	public void update(Brand brand) throws Exception;
	
}
