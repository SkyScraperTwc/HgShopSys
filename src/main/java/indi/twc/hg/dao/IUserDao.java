package indi.twc.hg.dao;

import indi.twc.hg.entity.User;

public interface IUserDao {
	/**
	 * 保存用户
	 * @param user
	 * @throws Exception
	 */
	public void save(User user) throws Exception;
	/**
	 * 根据参数查询用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public User query(String parameter, String sqlStr) throws Exception;
	
}
