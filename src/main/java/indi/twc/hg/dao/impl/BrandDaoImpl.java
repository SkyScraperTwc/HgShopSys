package indi.twc.hg.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import indi.twc.hg.dao.IBrandDao;
import indi.twc.hg.entity.Brand;
import indi.twc.hg.utils.JdbcUtils;
 
public class BrandDaoImpl extends BaseDaoImpl implements IBrandDao {
	public static class Brand_Sql{
		public static final String brandQueryList = "select * from T_BRAND where 1=1";
		public static final String queryCount = "select count(*) from T_BRAND where 1=1";
		public static final String save = "insert into T_BRAND values(?,?,?,?,?,?)";
		public static final String delete = "delete from T_BRAND where 1=2";
		public static final String update = "update T_BRAND set B_CNNAME=?,B_ENNAME=?,"
	         + "B_BIGPHOTO=?,B_SMALLPHOTO=?,B_DESC=? where B_ID=?";
	}	
	/**
	 * 品牌添加！！
	 */  
	@Override 
	public void save(Brand brand) throws Exception{
			Connection conn = JdbcUtils.getConnection(); 
			Object[] params = new Object[]{
					null, 
					brand.getCnName(), 
					brand.getEnName(),
					brand.getBigPhoto(), 
					brand.getSmallPhoto(),
					brand.getDesc()  
			}; 
			JdbcUtils.executeUpdate(conn, Brand_Sql.save, params);
			JdbcUtils.close(conn);
			System.out.println("-----品牌添加成功！");
	}
	 
	/**
	 * 根据一组主键删除多条记录
	 * @param id
	 * @throws Exceptions
	 */
	@Override 
	public void delete(Integer[] ids) throws Exception {
		Connection conn = null;
		String deleteStr = Brand_Sql.delete;
		try{
			  conn = JdbcUtils.getConnection();
			  if(ids==null || ids.length==0){
				  return;
			  }
			  for (int i = 0; i < ids.length; i++) {
				  deleteStr = deleteStr +" or B_ID=?";
			  }
			  JdbcUtils.executeUpdate(conn, deleteStr, ids); 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
	}

	/**
	 * 更新brand
	 * @param brand
	 * @throws Exception
	 */
	@Override
	public void update(Brand brand) throws Exception {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			Object[] params = new Object[]{
					brand.getCnName(), 
					brand.getEnName(),
					brand.getBigPhoto(),
					brand.getSmallPhoto(),
					brand.getDesc(), 
					brand.getId()
			}; 
			JdbcUtils.executeUpdate(conn, Brand_Sql.update, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JdbcUtils.close(conn);
	}
	
}
