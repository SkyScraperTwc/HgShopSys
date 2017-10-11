package indi.twc.hg.utils.mapper;

import indi.twc.hg.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper implements RowMapper<Admin> {

	@Override
	public Admin getEntity(ResultSet rs) throws SQLException {
		Admin admin = new Admin();
		
		admin.setId(rs.getInt("A_ID"));
		admin.setAdminName(rs.getString("A_ADMINNAME"));
		admin.setPassword(rs.getString("A_PASSWORD"));
		admin.setRealName(rs.getString("A_REALNAME")); 
		admin.setSex(rs.getString("A_GENDER"));
		admin.setDesc(rs.getString("A_DESC"));
		
		return admin;
	}

}
