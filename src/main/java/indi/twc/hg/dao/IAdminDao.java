package indi.twc.hg.dao;

import indi.twc.hg.entity.Admin;

public interface IAdminDao {
	/**
	 * 保存用户
	 * @param user
	 * @throws Exception
	 */
	public void save(Admin admin) throws Exception;
	/**
	 * 删除记录
	 * @param id
	 */
	public void delete(Integer[] id);
	/**
	 * 修改记录
	 * @param admin
	 */
	public boolean update(Admin admin);
	/**
	 * 密码修改
	 * @param admin
	 */
	public boolean updatePwd(Integer id, String newPwd);
}
