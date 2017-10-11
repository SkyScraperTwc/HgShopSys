package indi.twc.hg.service.impl;

import indi.twc.hg.dao.impl.UserDaoImpl;
import indi.twc.hg.entity.User;
import indi.twc.hg.exception.EmailExistException;
import indi.twc.hg.exception.UsernameExistException;
import indi.twc.hg.service.IUserService;

public class UserServiceImpl implements IUserService {
	private UserDaoImpl userDao = new UserDaoImpl();
	/**
	 * 注册用户！
	 * @param user
	 * @return
	 */
	@Override
	public String register(User user) throws UsernameExistException,EmailExistException,Exception{
		//用户
		User u = userDao.query(user.getUsername(),userDao.findByUsername);
		if(null!=u){
			//用户已经存在
			return "UsernameAlreadyExist";
		}  
		
		//邮箱
		u = userDao.query(user.getEmail(),userDao.findByEmail);
		if(null!=u){   
			//邮箱已经存在 
			return "EmailAlreadyExist";  
		}
		
		//手机
		u = userDao.query(user.getMobile(), userDao.findByMobile);
		if(null!=u){
			return "MobileAlreadyExist";
		}
		
		//最后保存
			userDao.save(user); 
			return "success";
	}
	
	@Override
	public boolean login(String param, String pwd) throws Exception {
        //根据用户名查询
		User u = userDao.query(param, userDao.findByUsername); 
			if(null==u){ 
	        //根据邮箱查询 
				u = userDao.query(param, userDao.findByEmail);
					if(null==u){
						 //根据手机查询
						u = userDao.query(param, userDao.findByMobile);
					}
			} 
		
		if(null!=u && u.getPwd().equals(pwd)){
			return true;
		}else{ 
			return false;
		}
		
	}
}
