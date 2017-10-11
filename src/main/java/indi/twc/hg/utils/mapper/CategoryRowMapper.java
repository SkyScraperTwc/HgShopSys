package indi.twc.hg.utils.mapper;

import indi.twc.hg.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category getEntity(ResultSet rs) throws SQLException {
		Category c = new Category();
		
		c.setId(rs.getInt("C_ID"));
		c.setName(rs.getString("C_NAME"));
		c.setLevel(rs.getInt("C_LEVEL"));
		c.setDesc(rs.getString("C_DESC"));
		c.setCls(rs.getString("C_CLS"));
		
		Category parent = new Category();
		parent.setId(rs.getInt("C_PID"));
		c.setParentCategory(parent);
		
		return c;
	}

}
