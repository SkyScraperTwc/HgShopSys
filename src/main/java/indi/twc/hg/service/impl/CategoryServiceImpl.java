package indi.twc.hg.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import indi.twc.hg.dao.impl.CategoryDaoImpl;
import indi.twc.hg.dao.impl.CategoryDaoImpl.Cg_Sql;
import indi.twc.hg.entity.Category;
import indi.twc.hg.entity.PageData;
import indi.twc.hg.common.mapper.CategoryRowMapper;
import indi.twc.hg.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	private CategoryDaoImpl categoryDao = new CategoryDaoImpl();
	
	@Override
	public void add(Category category) throws Exception {
		try{
			categoryDao.add(category); 
		}catch(Exception e){ 
			e.printStackTrace();
		}  
	}   
 
	@Override
	public void delete(Integer[] ids){
		try {
			HashSet<Integer> delSet = new HashSet<Integer>();
			for (int i = 0; i < ids.length; i++) {
				Category category = findById(ids[i]);
				delSet.add(ids[i]);
				//递归删除,ids要重新构造成delList
				recursionQuery(category, delSet);
			}
			//删除delSet
			categoryDao.delete(delSet.toArray(new Integer[]{}));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 递归查询子分类的Id！
	 */
	@Override
	public void recursionQuery(Category category ,HashSet<Integer> delSet){
		HashSet<Category> chindsSet = (HashSet<Category>) category.getChilds();
		if(null==chindsSet || chindsSet.size()<=0){
			return ;
		}
		for (Category c : chindsSet) {
			delSet.add(c.getId());
			recursionQuery(c, delSet);
		}
	}
	
	@Override
	public List<Category> listAllCategory(int level) throws Exception {
		if(level<1 && level>3){
			level = 1;
		}  
		String whereSql = " and C_LEVEL=?"; 
		
		List paramsList = new ArrayList();
		paramsList.add(level);
		try{
			 List<Category> categoryList = categoryDao.query(whereSql, paramsList); 
			 return categoryList;
			 
		}catch(Exception e){   
			e.printStackTrace();
		}
		return null; 
	}
	/**
	 * 根据Id查找一个分类！
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Category findById(Integer id) throws Exception {
		try{
			List paramsList = new ArrayList();
			paramsList.add(id);
			List<Category> categoryList = categoryDao.query(" and C_ID=?", paramsList);
			  if(null!=categoryList && categoryList.size()>0){
				  return categoryList.get(0);
			  }
		}catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	/**
	 * category分页查询
	 * @param conditions
	 * @param pageInt
	 * @param rowsInt
	 * @param orderBy
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public PageData listPage(Map<String, Object> conditions, int page, int rows,
			LinkedHashMap<String, String> orderBy) throws SQLException {
		StringBuffer whereSql = new StringBuffer();
		List<Object> paramsList = new ArrayList<Object>();
		 
		if(null!=conditions && conditions.size()>0){
			Object categoryName = conditions.get("categoryName");
			//判断enName是否为空 ,不为空才添加到whereSql
			if(null!=categoryName && !"".equals(categoryName)){
				whereSql.append(" and C_NAME like ?");
				paramsList.add("%"+categoryName+"%"); //添加categoryName到paramsList
			}
			
			Object level = conditions.get("level"); 
			//判断level是否为空,不为空才添加到whereSql 
			if(null!=level && !"".equals(level)){   
				whereSql.append(" and C_LEVEL=?");
				paramsList.add(level); //添加level到paramsList
			} 
		}     
		//查出dataList    
		List<Category> dataList = categoryDao.queryList(whereSql,paramsList.toArray(),
					page,rows,orderBy,Cg_Sql.CategoryQueryList,new CategoryRowMapper());
		
		//查出totalRecordes总记录数  
		int totalRecordes = categoryDao.getTotalRecords(whereSql,paramsList,Cg_Sql.queryCount);
		
		//创建pageData对象(totalRecordes,1,10,dataList)
		PageData pageData = new PageData(totalRecordes, page, rows, dataList);
		  
		return pageData;
	}
    
	@Override
	public void edit(Category category) {
		try {
			categoryDao.update(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
