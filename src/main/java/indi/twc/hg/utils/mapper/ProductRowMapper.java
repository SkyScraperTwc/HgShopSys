package indi.twc.hg.utils.mapper;

import indi.twc.hg.entity.Brand;
import indi.twc.hg.entity.Category;
import indi.twc.hg.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product getEntity(ResultSet rs) throws SQLException {
		Product p = new Product();
		
		p.setId(rs.getInt("P_ID"));
		p.setName(rs.getString("P_NAME"));
		p.setMarketPrice(rs.getDouble("P_MARKET_PRICE"));
		p.setDiscountedPrice(rs.getDouble("P_DISCOUTED_PRICE"));
		p.setNumber(rs.getString("P_NUMBER"));
		p.setColor(rs.getString("P_COLOR"));
		p.setDesc(rs.getString("P_DESC"));
		p.setRemark(rs.getString("P_REMARK"));
		p.setAddDate(rs.getDate("P_ADD_DATE"));
		p.setRecommend(rs.getBoolean("P_RECOMMEND"));
		p.setPromotion(rs.getBoolean("P_PROMOTION"));
		p.setBuyCount(rs.getLong("P_BUY_COUNT"));
		p.setAttention(rs.getInt("P_ATTENTION"));
		p.setMainImage(rs.getString("P_MAINIMAGE")); 
		p.setCls(rs.getString("P_CLS"));
		
		//设置brand
		Integer brandId = rs.getInt("B_ID");
		String cnName = rs.getString("B_CNNAME");
		String enName = rs.getString("B_ENNAME");
		p.setBrand(new Brand(brandId,cnName,enName));
		
		//设置category
		Integer categoryId = rs.getInt("C_ID");
		String categoryName = rs.getString("C_NAME");
		p.setCategory(new Category(categoryId,categoryName));
		
		return p; 
	}

}
