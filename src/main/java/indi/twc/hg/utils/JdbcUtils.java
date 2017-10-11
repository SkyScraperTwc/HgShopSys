package indi.twc.hg.utils;
/**
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import indi.twc.hg.common.mapper.RowMapper;


public class JdbcUtils {
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/HgShopSys";//��ݿ�λ��
	private static String username = "root";
	private static String password = "123456";
	
	static{
		try{ 
			//Class.forName(xxx.xx.xx)的作用就是要求JVM查找并加载指定的类，如果在类中有静态初始化器的话，JVM必然会执行该类的静态代码段。
//			而在JDBC规范中明确要求这个Driver类必须向DriverManager注册自己，即任何一个JDBC Driver的 Driver类的代码都必须类似如下：
//			public class MyJDBCDriver implements Driver {
//			static {
//			DriverManager.registerDriver(new MyJDBCDriver());
//			}
//			}
//			既然在静态初始化器的中已经进行了注册，所以我们在使用JDBC时只需要Class.forName(XXX.XXX);就可以了。
			Class c = Class.forName(driverClass);
		}catch(ClassNotFoundException e){ 
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		//线程安全
		Connection conn =  DriverManager.getConnection(url, username, password);
		return conn;
	}
	/**
	 * List<Object[]>
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static List<Object[]> executeQuery(Connection conn, String sql,
					Object[] params) throws SQLException { 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			stmt = conn.prepareStatement(sql);
			
			if (null != params && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i+1, params[i]);
				} 
			}
			rs = stmt.executeQuery();//rs数据集指针
			
			int colCount = rs.getMetaData().getColumnCount();//获取数据表列数
			while(rs.next()){
				Object[] oArr = new Object[colCount];
				for (int i = 0; i < oArr.length; i++) {
					oArr[i] = rs.getObject(i+1);
				}
				list.add(oArr);
			}
			return list;
			
		} finally {
			close(rs);
			close(stmt);
		}
	}
	
	/**
	 * 查找对象
	 * @param <T>
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static <T> List<T> executeQuery(Connection conn, String sql, Object[] params, RowMapper<T> rm) {
		List<T> list = new ArrayList<T>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				pstmt = conn.prepareStatement(sql);
				if(params!=null && params.length>0){
					for (int i = 0; i < params.length; i++) {
						pstmt.setObject(i+1, params[i]);
					}
				}
				rs = pstmt.executeQuery();
				while(rs.next()){
					T t = rm.getEntity(rs);
					list.add(t);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		return list;
	}
	/**
	 * Update!
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int executeUpdate(Connection conn,String sql,Object[] params) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(params!=null && params.length>0){
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		int rows = pstmt.executeUpdate();
		close(pstmt);
		return rows;
	}
	
	/**
	 * �ر�ResultSet, PreparedStatement,Connection
	 */
     public static void close(ResultSet rs, PreparedStatement pstmt,Connection conn){
    	 if(rs!=null){//���ж��Ƿ�Ϊ��
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
    	 if(pstmt!=null){//���ж��Ƿ�Ϊ��
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){//���ж��Ƿ�Ϊ��
			try {
					conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
     }
 	/**
 	 * �ر�ResultSet
 	 */
     public static void close(ResultSet rs){
    	 if(rs!=null){//���ж��Ƿ�Ϊ��
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
     }
 	/**
 	 * �ر� PreparedStatement
 	 */
     public static void close(PreparedStatement pstmt){
    	 if(pstmt!=null){//���ж��Ƿ�Ϊ��
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
     }
 	/**
 	 * �ر�Connection
 	 */
     public static void close(Connection conn){
    	 if(conn!=null){//���ж��Ƿ�Ϊ��
 			try {
 					conn.close();
 					} catch (SQLException e) {
 						e.printStackTrace();
 					}
 				}
     }
}
