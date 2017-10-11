package indi.twc.hg.utils.mapper;

import indi.twc.hg.entity.Brand;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRowMapper implements RowMapper<Brand> {

	@Override
	public Brand getEntity(ResultSet rs) throws SQLException {
		Brand brand = new Brand();	
		
		brand.setId(rs.getInt("B_ID"));
		brand.setCnName(rs.getString("B_CNNAME"));
		brand.setEnName(rs.getString("B_ENNAME"));
		brand.setBigPhoto(rs.getString("B_BIGPHOTO"));
		brand.setSmallPhoto(rs.getString("B_SMALLPHOTO"));
		brand.setDesc(rs.getString("B_DESC"));
		
		return brand;
	}

}
