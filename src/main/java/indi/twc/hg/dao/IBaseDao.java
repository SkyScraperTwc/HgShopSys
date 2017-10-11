package indi.twc.hg.dao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import indi.twc.hg.common.mapper.RowMapper;

public interface IBaseDao {
	
	public <T> List<T> queryList(StringBuffer whereSql, Object[] params, int page, int rows,
			LinkedHashMap<String, String> orderBy, String SQLState, RowMapper<T> rm)  throws SQLException;
	
	public int getTotalRecords(StringBuffer whereSql, List paramsList, String SQLState) throws SQLException;
	
}
