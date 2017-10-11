package indi.twc.hg.dao.impl;

import indi.twc.hg.dao.IUserDao;
import indi.twc.hg.entity.User;
import indi.twc.hg.utils.JdbcUtils;
import indi.twc.hg.utils.mapper.UserRowMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
		public static String findByUsername = "select * from T_USER where U_USERNAME =? ";
		public static String save = "insert into T_USER values(?,?,?,?,?)";
		public static String findByEmail = "select * from T_USER where U_EMAIL =? ";
		public static String findByMobile = "select * from T_USER where U_MOBILE =? ";
	 
	/**
	 * 保存用户
	 * @param user
	 * @throws Exception
	 */ 
	@Override 
	public void save(User user) throws Exception {
		Connection conn = null;
		try{
			conn = JdbcUtils.getConnection();
			Object[] params = new Object[]{
					null,
					user.getUsername(),
					user.getPwd(),
					user.getEmail(),
					user.getMobile(),
			};
			JdbcUtils.executeUpdate(conn, this.save, params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 根据参数查询用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@Override
	public User query(String parameter, String sqlStr) throws Exception {
		Connection conn = null;
		try{
			conn = JdbcUtils.getConnection();
			Object[] params = new Object[]{parameter};
			List<User> userList = JdbcUtils.executeQuery(conn, sqlStr, params,new UserRowMapper());
			if(userList.size()>0){
				return userList.get(0);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
