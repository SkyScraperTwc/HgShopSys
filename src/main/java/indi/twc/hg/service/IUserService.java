package indi.twc.hg.service;

import indi.twc.hg.entity.User;
import indi.twc.hg.exception.EmailExistException;
import indi.twc.hg.exception.UsernameExistException;

public interface IUserService {
		/**
		 * 注册用户！
		 * @param user
		 * @return
		 * @throws Exception 
		 */
	     public String register(User user) throws 
	          UsernameExistException,EmailExistException,Exception; 
	     
		/**
		 * 用户登陆！
		 * @param user
		 * @return
		 * @throws Exception 
		 */
	     public boolean login(String username,String pwd) throws Exception; 
	  
}
