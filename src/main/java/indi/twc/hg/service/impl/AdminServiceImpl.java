package indi.twc.hg.service.impl;

import java.util.ArrayList; 
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import indi.twc.hg.dao.impl.AdminDaoImpl;
import indi.twc.hg.dao.impl.AdminDaoImpl.Admin_Sql;
import indi.twc.hg.entity.Admin;
import indi.twc.hg.entity.PageData;
import indi.twc.hg.common.mapper.AdminRowMapper;
import indi.twc.hg.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
	private AdminDaoImpl adminDao = new AdminDaoImpl();
	/**
	 * 注册用户！
	 * @param user
	 * @return
	 */
	@Override  
	public String add(Admin admin) throws Exception{
		//管理员
		Admin adm = findByName(admin.getAdminName());
		if(null!=adm){
			//管理员已经存在   
			return "AdminAlreadyExist"; 
		}else{
			//管理员不存在 
			adminDao.save(admin); 
			return "success"; 
		}
	}   
	  
	@Override
	public boolean login(String adminName, String password) throws Exception {
        //根据adminName查询 
		Admin adm = findByName(adminName);
		if(null!=adm && adm.getPassword().equals(password)){
			return true;
		}else{ 
			return false; 
		}
		
	}

	@Override
	public PageData listPage(Map<String, Object> conditions, int page, int rows,
			LinkedHashMap<String, String> orderBy) {
		
		StringBuffer whereSql = new StringBuffer();
		List<String> paramsList = new ArrayList<String>();
		  
		if(null!=conditions && conditions.size()>0){
			Object adminName = conditions.get("adminName");
			//判断adminName是否为空 ,不为空才添加到whereSql
			if(null!=adminName && !"".equals(adminName)){
				whereSql.append(" and A_ADMINNAME like ?");
				paramsList.add("%"+adminName+"%"); //添加enName到paramsList
			}
			
		}     
		try { 
			//查出dataList  
			List<Admin> dataList = adminDao.queryList(whereSql,paramsList.toArray(),
						page,rows,orderBy,Admin_Sql.AdminQueryList, new AdminRowMapper());
			
			//查出totalRecordes总记录数
			int totalRecordes = adminDao.getTotalRecords(whereSql,paramsList,Admin_Sql.queryCount);
			
			//创建pageData对象(totalRecordes,1,10,dataList)
			PageData pageData = new PageData(totalRecordes, page, rows, dataList);
			  
			return pageData; 
			
		} catch (Exception e) {  
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Integer[] id) {
		adminDao.delete(id);
	}

	@Override
	public Admin findByName(String adminName) {
		
		try {
			StringBuffer whereSql = new StringBuffer(" and A_ADMINNAME=? ");
			List<String> paramsList = new ArrayList<String>(); 
			paramsList.add(adminName);
			List<Admin> adminList = adminDao.queryList(whereSql, paramsList.toArray(),
					-1, -1, null, Admin_Sql.AdminQueryList, new AdminRowMapper());
			if(null!=adminList && adminList.size()>0){
				return adminList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean edit(Admin admin) {
		try {
			 return adminDao.update(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; 
	}
	
	@Override
	public boolean editPwd(Integer id,String newPwd) {
		try {
			return adminDao.updatePwd(id,newPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
