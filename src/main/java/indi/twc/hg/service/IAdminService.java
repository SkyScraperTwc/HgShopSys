package indi.twc.hg.service;

import java.util.LinkedHashMap;
import java.util.Map;

import indi.twc.hg.entity.Admin;
import indi.twc.hg.entity.PageData;

public interface IAdminService {
	/**
	 * 注册管理员！
	 * @param admin
	 * @return
	 * @throws Exception 
	 */
     public String add(Admin admin) throws Exception; 
     
	/** 
	 * 管理员登陆！
	 * @param admin
	 * @return
	 * @throws Exception
	 */
     public boolean login(String adminName,String password) throws Exception;
     
     /** 
	 * 管理员分页！
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	  public PageData listPage(Map<String, Object> conditions, 
			  int pageInt, int rowsInt,LinkedHashMap<String, String> orderBy);
     /** 
	 * 管理员删除
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	 public void delete(Integer[] array);
	 
	 /** 
	 * 管理员查找
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	 public Admin findByName(String adminName);
	 
	 /** 
	 * 管理员修改
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	 public boolean edit(Admin admin);
	 /** 
	 * 管理员修改密码
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	 public boolean editPwd(Integer id, String newPwd);


}
