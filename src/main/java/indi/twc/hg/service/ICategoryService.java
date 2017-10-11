package indi.twc.hg.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import indi.twc.hg.entity.Category;
import indi.twc.hg.entity.PageData;

public interface ICategoryService {
	 
	public void add(Category category) throws Exception;
	
	public List<Category> listAllCategory(int level) throws Exception;
	
	public Category findById(Integer id) throws Exception;

	public void edit(Category category);

	public void delete(Integer[] array);

	public void recursionQuery(Category category, HashSet<Integer> delSet);

	public PageData listPage(Map<String, Object> conditions, int page, int rows,
									LinkedHashMap<String, String> orderBy)throws SQLException;
} 
