package indi.twc.hg.dao.impl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import indi.twc.hg.dao.ICategoryDao;
import indi.twc.hg.entity.Category;
import indi.twc.hg.common.mapper.CategoryRowMapper;
import indi.twc.hg.utils.JdbcUtils;
import indi.twc.hg.utils.ShowSql;

public class CategoryDaoImpl extends BaseDaoImpl implements ICategoryDao {
	public static class Cg_Sql{ 
		public static final String queryCount = "select count(*) from T_CATEGORY where 1=1";
		public static final String save = "insert into T_CATEGORY"
		+ " (C_ID,C_NAME,C_LEVEL,C_DESC,C_PID,C_CLS) values(?,?,?,?,?,?)";
		public static final String delete = "delete from T_CATEGORY where 1=2";
		public static final String CategoryQueryList = "select * from T_CATEGORY where 1=1";
		public static final String update = "update T_CATEGORY set C_NAME=?,C_LEVEL=?,"
		         + "C_DESC=?,C_PID=?,C_CLS=? where C_ID=?";
	}
	/** 
	 * 保存分类 
	 * @param p 
	 * @throws Exception
	 */  
	@Override  
	public void add(Category category) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		Object[] params = new Object[]{
				null,
				category.getName(), 
				category.getLevel(), 
				category.getDesc(),  
				category.getParentCategory().getId(),
				category.getCls()
		};
		JdbcUtils.executeUpdate(conn, Cg_Sql.save, params);//保存产品
		JdbcUtils.close(conn);
	} 
	/** 
	 * 删除分类 
	 * @param p 
	 * @throws Exception
	 */ 
	@Override
	public void delete(Integer[] ids) { 
		Connection conn =null;
		String deleteStr = Cg_Sql.delete;
		try {
			conn = JdbcUtils.getConnection();
			if(ids==null || ids.length==0){
				return ;
			}
			for (int i = 0; i < ids.length; i++) {
				deleteStr = deleteStr + " or C_ID=?";
			}
			JdbcUtils.executeUpdate(conn, deleteStr, ids);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
	}
	/** 
	 * 修改分类 
	 * @param p 
	 * @throws Exception
	 */  
	@Override
	public void update(Category category) {
			Connection conn = null;
			try {
				conn = JdbcUtils.getConnection();
				Object[] params = new Object[]{
						category.getName(),
						category.getLevel(),
						category.getDesc(),
						category.getParentCategory().getId(),
						category.getCls(),
						category.getId()
				};
				JdbcUtils.executeUpdate(conn, Cg_Sql.update , params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
    /**
     * query()要使用递归 
     */
	@Override
	public List<Category> query(String whereSql, List paramsList) throws Exception {
		String sql = Cg_Sql.CategoryQueryList;
		if(null!=whereSql)
		{ 
			sql = sql + whereSql;  //select * from T_CATEGORY where 1=1 and C_ID=?;
		}  
		//打印sql与plist
		ShowSql.print(sql, paramsList);
		
		Connection conn = JdbcUtils.getConnection(); 
		//查找一个category对象
		List<Category> categoryList = JdbcUtils.executeQuery(conn, sql, paramsList.toArray(), new CategoryRowMapper());
		
		for (Category c : categoryList) {
			List<Category> subCategorys = findSubCategorys(conn,c);
			HashSet<Category> childsSet = new HashSet<Category>(subCategorys);
			c.setChilds(childsSet);
		}
		
		JdbcUtils.close(conn); 
		return categoryList;
	}
	/**
	 * 递归方法(重点!!!),寻找子分类！！！
	 * @param conn
	 * @param parent
	 * @return
	 */
	private List<Category> findSubCategorys(Connection conn, Category parent) {
		List<Category> categoryList = null;
		//parent为category
		if(null!=parent){
			String sql =  Cg_Sql.CategoryQueryList+" and C_PID=?";
			Object[] params = new Object[]{parent.getId()};
			categoryList = JdbcUtils.executeQuery(conn, sql, params, new CategoryRowMapper());
			
			//当categoryList长度为0的时候递归结束
			if(null!=categoryList && categoryList.size()>0){
				for(Category c:  categoryList){
					List<Category> subCategorys = findSubCategorys(conn,c);
					c.setChilds(new HashSet<Category>(subCategorys));//设置子分类
					c.setParentCategory(parent);//设置父分类
				}     
			}
		} 
		return categoryList;
	}
	
}
