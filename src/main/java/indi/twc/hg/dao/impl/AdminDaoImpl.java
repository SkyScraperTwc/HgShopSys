package indi.twc.hg.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import indi.twc.hg.dao.IAdminDao;
import indi.twc.hg.entity.Admin;
import indi.twc.hg.utils.JdbcUtils;
 
public class AdminDaoImpl extends BaseDaoImpl implements IAdminDao {
   public static class Admin_Sql{
	    public static final String AdminQueryList = "select * from T_ADMIN where 1=1";
		public static final String queryCount = "select count(*) from T_ADMIN where 1=1";
		public static final String delete = "delete from T_ADMIN where 1=2";
		public static final String save = "insert into T_ADMIN (?,?,?,values?,?,?)";
		public static final String update =  "update T_ADMIN set A_ADMINNAME=?,"
		        + "A_REALNAME=?,A_GENDER=?,A_DESC=? where A_ID=?";
		public static final String updatePWD =  "update T_ADMIN set A_PASSWORD=? where A_ID=?";
	}
	 
	/** 
	 * 保存用户 
	 * @param user
	 * @throws Exception 
	 */  
	@Override 
	public void save(Admin admin) throws Exception { 
		Connection conn = null; 
		try{ 
			conn = JdbcUtils.getConnection();
			Object[] params = new Object[]{
					null,  
					admin.getAdminName(),
					admin.getPassword(),
					admin.getRealName(),
					admin.getSex(),
					admin.getDesc()
			}; 
			JdbcUtils.executeUpdate(conn, Admin_Sql.save, params);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		 
	}
	 
	/**
	 * 删除管理员！
	 * @param id
	 */
	@Override
	public void delete(Integer[] id) {
		Connection conn = null;
		String deleteStr = Admin_Sql.delete;
		try {
			conn = JdbcUtils.getConnection();
			  if(id==null || id.length==0){
				  return;
			  }
			  
			  for (int i = 0; i < id.length; i++) {
				  deleteStr = deleteStr + " or A_ID=?";
			}
			  JdbcUtils.executeUpdate(conn, deleteStr, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
	}
	@Override
	public boolean update(Admin admin) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			Object[] params = new Object[]{
					admin.getAdminName(),
					admin.getRealName(),
					admin.getSex(), 
					admin.getDesc(),
					admin.getId()
			}; 
			int rows = JdbcUtils.executeUpdate(conn, Admin_Sql.update, params);
			if(rows>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return false;
	}
	@Override
	public boolean updatePwd(Integer id, String password) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			Object[] params = new Object[]{
					password,
					id
			}; 
			int rows = JdbcUtils.executeUpdate(conn, Admin_Sql.updatePWD, params);
			if(rows>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return false;
	}
}
