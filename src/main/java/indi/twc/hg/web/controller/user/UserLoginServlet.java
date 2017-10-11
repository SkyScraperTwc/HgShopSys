package indi.twc.hg.web.controller.user;

import indi.twc.hg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet{
	UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			//设置请求对象字符编码！
//			req.setCharacterEncoding("utf-8");
			String login_user = req.getParameter("username");
			String pwd = req.getParameter("password"); 
				try {
					boolean isOk = userServiceImpl.login(login_user, pwd);
					if(isOk){
						//创建cookie
						Cookie cookie = new Cookie(login_user, pwd);
						//一个月以内有效
						cookie.setMaxAge(60*60*24*30);
						cookie.setPath(req.getContextPath());
						resp.addCookie(cookie);
						
						HttpSession session = req.getSession();
						//设置单位为秒，设置为-1永不过期
						session.setMaxInactiveInterval(-1);
						//添加login_user到session
						session.setAttribute("login_user", login_user);
						
						this.msg(req, resp,  "http://localhost:8080/HgShopSys", "恭喜您，登陆成功！");
					}else{ 
						this.msg(req, resp,  "http://localhost:8080/HgShopSys/front/user/toLogin.do", "登陆失败：用户名或者密码错误！");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
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
	/**
	 * 	private Map<String,String> validate(HttpServletRequest req){
		Map<String, String> errors = new HashMap<String, String>();
		
		String username = req.getParameter("username"); 
		String pwd = req.getParameter("password");
		
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
			errors.put("pwd", "用户名长度为6~20位！！");
		}else{
			if(!pwd.matches("^.*[A-Za-z0-9\\w_-]+.*$")){
				errors.put("pwd", "密码只能由英文、数字及标点符号组成");
			}
		}
	
		return errors;
	}	
	 */
}
