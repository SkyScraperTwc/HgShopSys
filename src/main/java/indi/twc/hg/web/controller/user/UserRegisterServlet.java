package indi.twc.hg.web.controller.user;

import indi.twc.hg.entity.User;
import indi.twc.hg.exception.EmailExistException;
import indi.twc.hg.exception.UsernameExistException;
import indi.twc.hg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserRegisterServlet extends HttpServlet{
	UserServiceImpl userServiceImpl = new UserServiceImpl();
	private final static String toRegister = "http://localhost:8080/HgShopSys/front/user/toRegister.do";
	private final static String index = "http://localhost:8080/HgShopSys";
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			//设置请求对象字符编码！
			req.setCharacterEncoding("utf-8"); 
			Map<String,String> errors = this.validate(req); 
			if(errors.size()>0){ 
				req.setAttribute("errors", errors);
				//转发器,有错误就转发!!!!!! 
				req.getRequestDispatcher("/WEB-INF/pages/front/user/User_register.jsp").forward(req, resp);
			}else{
				User user = this.getUserFromRequest(req); 
				System.out.println(user.toString()); 
				 
				try {   
					String state = userServiceImpl.register(user); 
					if(state.equals("UsernameAlreadyExist")){
						msg(req, resp, this.toRegister,"注册失败，用户名已经被注册！");  
						
					}else if(state.equals("EmailAlreadyExist")){
						 msg(req, resp, this.toRegister, "注册失败，邮箱已经被注册！");
						 
					}else if(state.equals("MobileAlreadyExist")){
						 msg(req, resp, this.toRegister, "注册失败，手机已经被注册！");
						 
					}else if(state.equals("success")){
						msg(req, resp,this.index , "恭喜您，注册成功！");
					}
					
				} catch (UsernameExistException e) {
					e.printStackTrace();
					errors.put("username", e.getMessage());
				}
				catch (EmailExistException e) {
					e.printStackTrace();
					errors.put("email", e.getMessage());
				}
				catch (Exception e) {
					e.printStackTrace();
				
				}
			} 
			
	}
	
	private void msg(HttpServletRequest req, HttpServletResponse resp, 
          String nextUrl, String global_message) throws ServletException, IOException {
				//设置nextUrl与global_message
				req.setAttribute("nextUrl", nextUrl);
				req.setAttribute("global_message", global_message);
				//转发器
				req.getRequestDispatcher("/WEB-INF/pages/front/front_global_message.jsp").forward(req, resp);
	}
	private User getUserFromRequest(HttpServletRequest req) {
		User user = new User();
		
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String authcode = req.getParameter("authcode");
		
		user.setUsername(username);
		user.setPwd(pwd);
		user.setEmail(email);
		user.setMobile(mobile);
		
		return user;
	}

	private Map<String,String> validate(HttpServletRequest req){
		Map<String, String> errors = new HashMap<String, String>();
		
		String username = req.getParameter("username");  
		String pwd = req.getParameter("pwd");
		String pwd2 = req.getParameter("pwd2");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String authcode = req.getParameter("authcode");
		
		//验证用户名
		if(null==username || username.isEmpty()){
			errors.put("username", "用户名不能为空！！");
		}else if(username.length()<6 || username.length()>20){
			errors.put("username", "用户名长度为6~20位！！");
		}else{
			//正则表达式校验！
			if(!username.matches("^[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+$")){
				errors.put("username", "用户名只能由中文、英文、数字及“_”、“-”组成");
			}
		}
		
		//验证密码
		if(null==pwd || pwd.isEmpty()){
			errors.put("pwd", "密码不能为空！！");
		}else if(pwd.length()<6 || pwd.length()>20){
			errors.put("pwd", "密码长度为6~20位！！");
		}else{
			if(!pwd.matches("^.*[A-Za-z0-9\\w_-]+.*$")){
				errors.put("pwd", "密码只能由英文、数字及标点符号组成");
			}
		}
		
		//验证重复密码
		if(null==pwd2 || pwd2.isEmpty()){
			errors.put("pwd2", "重复密码不能为空！！");
		}else if(pwd2.length()<6 || pwd2.length()>20){
			errors.put("pwd2", "重复密码长度为6~20位！！");
		}else{
			if(!pwd2.matches("^.*[A-Za-z0-9\\w_-]+.*$")){
				errors.put("pwd2", "重复密码只能由英文、数字及标点符号组成");
			}
		}
		
		//验证邮箱
		if(null==email || email.isEmpty()){
			errors.put("email", "邮箱不能为空！！");
		}else if(email.length()<6 || email.length()>20){
			errors.put("email", "邮件地址只能在50个字符以内！！");
		}else{
			if(!email.matches("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$")){
				errors.put("email", "邮箱格式不正确");
			}
		}
		 
		//验证手机
		if(null==mobile || mobile.isEmpty()){
			errors.put("mobile", "手机不能为空！！");
		}else{
			if(!mobile.matches("^0?(13|15|18|14)[0-9]{9}$")){
				errors.put("mobile", "手机号码不符合规则,请重新填写");
			}
		}
		//验证码
		if(null==authcode || authcode.isEmpty()){ 
			errors.put("authcode", "验证码不能为空！！");
		}else{
			String oldAuthCode = (String) req.getSession().getAttribute("AUTHCODE");
			if(!authcode.equals(oldAuthCode)){
				errors.put("authcode", "验证码输入错误！");
			}
		}
		return errors;
	}	
}
