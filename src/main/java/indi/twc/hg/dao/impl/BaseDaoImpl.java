package indi.twc.hg.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import indi.twc.hg.common.mapper.RowMapper;
import indi.twc.hg.dao.IBaseDao;
import indi.twc.hg.utils.JdbcUtils;
import indi.twc.hg.utils.ShowSql;

public class BaseDaoImpl implements IBaseDao {
	/**
	 * 带条件的分页查询
	 * @param whereSql
	 * @param page
	 * @param rows
	 * @param orderBy 
	 * @return 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> queryList(StringBuffer whereSql, Object[] params, int page, int rows,
			LinkedHashMap<String, String> orderBy, String SQLState, RowMapper<T> rm)  throws SQLException{
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
			
			String sql = SQLState; 
			//拼凑whereSql
			if(null!=whereSql && !"".equals(whereSql)){ 
				sql = sql + whereSql;
			}
			//拼凑orderBy子句
			if(null!=orderBy && orderBy.size()>0){
				sql = sql + " order by ";
				for (String key  : orderBy.keySet()) {
					String value = orderBy.get(key);
					sql = sql+key+" "+value+", ";
				}  
				sql = sql.substring(0,sql.lastIndexOf(","));
			}
			
			List plist = new ArrayList();
			if(null!=params && params.length>0){
				Collections.addAll(plist, params);//params添加到paramsList
			}
			 
			//拼凑limit子句  
			if(page!=-1 && rows!=-1){
				sql = sql + " limit ?,?";
				int start = (page-1)*rows; //关键 
				plist.add(start); 
				plist.add(rows);
			}
			//打印sql与plist
			ShowSql.print(sql, plist);
			
			List<T> dataList = JdbcUtils.executeQuery(conn, sql, plist.toArray(), rm);
			return dataList;
	}	
	/**
	 * 获得总记录数,与分页条件无关
	 * @param whereSql  
	 * @param paramsList
	 * @return 
	 * @throws SQLException 
	 */
	public int getTotalRecords(StringBuffer whereSql, List paramsList, String SQLState) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		String sql = SQLState;
		if(null!=whereSql && !"".equals(whereSql)){ 
			sql = sql + whereSql;
		}   
		//打印sql与plist
		ShowSql.print(sql, paramsList);
		
		List<Object[]> rowlist =  JdbcUtils.executeQuery(conn, sql, paramsList.toArray());
		if(null!=rowlist && rowlist.size()>0){
			int rows = Integer.parseInt(String.valueOf(rowlist.get(0)[0]));
			return rows;
		}  
		return 0;
	}
}
