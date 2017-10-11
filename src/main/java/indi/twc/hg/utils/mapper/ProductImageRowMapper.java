package indi.twc.hg.utils.mapper;

import indi.twc.hg.entity.ProductImage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductImageRowMapper implements RowMapper<ProductImage> {

	@Override
	public ProductImage getEntity(ResultSet rs) throws SQLException {
		ProductImage pi = new ProductImage();
		
		pi.setId(rs.getInt("PI_ID"));
		pi.setName(rs.getString("PI_NAME"));
		pi.setUrl(rs.getString("PI_URL"));
		pi.setProductId(rs.getInt("PI_PRODUCT_ID"));
		pi.setIndex(rs.getInt("PI_INDEX"));
		
		return pi;
	}
}
