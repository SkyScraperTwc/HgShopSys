package indi.twc.hg.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import indi.twc.hg.utils.JdbcUtils;
import indi.twc.hg.dao.IProductDao;
import indi.twc.hg.entity.Product;
import indi.twc.hg.entity.ProductImage;

public class ProductDaoImpl extends BaseDaoImpl implements IProductDao {
	public static class PD_Sql{
		public static final String saveProduct = "insert into T_PRODUCT" +
				" (P_ID,P_NAME,P_MARKET_PRICE,P_DISCOUTED_PRICE," +
				" P_BRAND_ID,P_CATEGORY_ID,P_DESC,P_REMARK," +
				" P_ADD_DATE,P_COLOR,P_NUMBER,P_RECOMMEND,P_PROMOTION,P_MAINIMAGE"
				+ ",P_ATTENTION,P_BUY_COUNT,P_CLS)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		public static final String PRODUCTUPDATE = "update T_PRODUCT set" +
				" P_NAME=?,P_MARKET_PRICE=?,P_DISCOUTED_PRICE=?," +
				" P_BRAND_ID=?,P_CATEGORY_ID=?,P_DESC=?,P_REMARK=?," +
				" P_ADD_DATE=?,P_COLOR=?,P_NUMBER=?,P_RECOMMEND=?,P_PROMOTION=?,P_MAINIMAGE=?,"+ 
				" P_ATTENTION=?,P_BUY_COUNT=?,P_CLS=? where P_ID=?";
		public static final String PRODUCTDELETE = 
				"delete from T_PRODUCT where 1=2";
		public static final String LastInsertId = "SELECT LAST_INSERT_ID()";
		public static final String queryCount = 
				"select count(*)"+
				" from T_PRODUCT p left outer join T_CATEGORY c on p.P_CATEGORY_ID=c.C_ID" +
				" left outer join T_BRAND b on p.P_BRAND_ID=b.B_ID"+ 
				" where 1=1";
		public static final String saveImages = 
				 "insert into T_PRODUCT_IMAGE" +    
				" (PI_ID,PI_NAME,PI_URL,PI_PRODUCT_ID,PI_INDEX)" +
				" values(?,?,?,?,?)";
		public static final String productQueryList = 
				"select p.*,c.C_ID,c.C_NAME,b.B_ID,b.B_CNNAME,b.B_ENNAME"+
				" from T_PRODUCT p left outer join T_CATEGORY c on p.P_CATEGORY_ID=c.C_ID" +
				" left outer join T_BRAND b on p.P_BRAND_ID=b.B_ID"+ 
				" where 1=1";
		public static final String PIMAGEQUERY = 
			   "select * from T_PRODUCT_IMAGE where 1=1";
		public static final String IMAGEUPDATE = 
				"update T_PRODUCT_IMAGE set PI_NAME=?,PI_URL=? where PI_ID=?";
		public static final String IMAGEDELETE = 
				"delete from T_PRODUCT_IMAGE where 1=2";
	}
	  
	/**
	 * 保存产品
	 * @param p
	 * @throws Exception
	 */  
	@Override
	public void save(Product product) throws Exception {
		Connection conn = JdbcUtils.getConnection(); 
		Object[] params = new Object[]{//总共17个元素
				product.getId(),//product的id，为null???
				product.getName(),
				product.getMarketPrice(),
				product.getDiscountedPrice(),
				product.getBrand().getId(),
				product.getCategory().getId(),
				product.getDesc(),
				product.getRemark(),
				product.getAddDate(),
				product.getColor(),
				product.getNumber(),
				product.isRecommend(),
				product.isPromotion(),
				product.getMainImage(),//主图片
				product.getAttention(),
				product.getBuyCount(),
				product.getCls()
		};
		//向数据库插入产品
		int rows = JdbcUtils.executeUpdate(conn, PD_Sql.saveProduct, params);
		if(rows>0){
			//添加产品成功后,获取最新插入记录的ID,查询和插入所使用的Connection对象必须是同一个才可以，否则返回值是不可预料的。
			List<Object[]> list = JdbcUtils.executeQuery(conn, PD_Sql.LastInsertId, null);
			int productId = Integer.parseInt(String.valueOf(list.get(0)[0]));
			List<ProductImage> pImagesList = product.getProductImagesList();
			for (int i = 0; i < pImagesList.size(); i++){
				ProductImage pi = pImagesList.get(i);
				pi.setProductId(productId);
				saveImages(conn, pi);
			}
		}
		//最后关闭conn！
		JdbcUtils.close(conn);
	}

	/**
	 * 保存副图片 
	 * @param conn
	 * @param pi
	 */ 
	@Override
	public void saveImages(Connection conn, ProductImage pi){
		Object[] params = new Object[]{
				null,//pi的id
				pi.getName(),//pi的名字
				pi.getUrl(),//pi的路径
				pi.getProductId(), //通过与产品的id绑定在一起
				pi.getIndex()//下标
		};  
		try {  
			JdbcUtils.executeUpdate(conn, PD_Sql.saveImages, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateImage(ProductImage pi) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			Object[] params = new Object[]{
					pi.getName(),
					pi.getUrl(),
					pi.getId()
			};
			JdbcUtils.executeUpdate(conn, PD_Sql.IMAGEUPDATE, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			Object[] params = new Object[]{//总共17个元素
					product.getName(),
					product.getMarketPrice(),
					product.getDiscountedPrice(),
					product.getBrand().getId(),
					product.getCategory().getId(),
					product.getDesc(),
					product.getRemark(),
					product.getAddDate(),
					product.getColor(),
					product.getNumber(),
					product.isRecommend(),
					product.isPromotion(),
					product.getMainImage(),//主图片
					product.getAttention(),
					product.getBuyCount(),
					product.getCls(),
					product.getId()
			};
			JdbcUtils.executeUpdate(conn, PD_Sql.PRODUCTUPDATE, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void delete(Integer[] ids) {
		Connection conn = null;
		try{
			  conn = JdbcUtils.getConnection();
			  if(ids==null || ids.length==0){
				  return;
			  }
			  
			  //先删除productImage
			  String deleteStr = PD_Sql.IMAGEDELETE;
			  for (int i = 0; i < ids.length; i++) {
				  deleteStr = deleteStr + " or PI_PRODUCT_ID=?";
			  }
			  JdbcUtils.executeUpdate(conn, deleteStr, ids);
			  
			  //再删除product
			  deleteStr = PD_Sql.PRODUCTDELETE;
			  for (int i = 0; i < ids.length; i++) {
				  deleteStr = deleteStr +" or P_ID=?";
			  }
			  JdbcUtils.executeUpdate(conn, deleteStr, ids); 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
	}
}
