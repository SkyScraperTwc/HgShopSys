package indi.twc.hg.dao;

import indi.twc.hg.utils.mapper.RowMapper;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public interface IBaseDao {
	
	public <T> List<T> queryList(StringBuffer whereSql, Object[] params, int page, int rows,
			LinkedHashMap<String, String> orderBy, String SQLState, RowMapper<T> rm)  throws SQLException;
	
	public int getTotalRecords(StringBuffer whereSql, List paramsList, String SQLState) throws SQLException;
	
}
