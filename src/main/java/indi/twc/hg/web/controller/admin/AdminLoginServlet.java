package indi.twc.hg.web.controller.admin;

import indi.twc.hg.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AdminLoginServlet extends HttpServlet{
	private static final String TOLOGIN = "/back/admin/toLogin.do";
	private static final String BACKINDEX = "/WEB-INF/pages/back/backIndex.jsp";
	private AdminServiceImpl adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String ln = (String) session.getAttribute("loginName");
			//假如session的loginName不为空
			if(null!=ln && ln.length()>0){
				req.getRequestDispatcher(BACKINDEX).forward(req, resp);
				return;
			}
		
			String loginName = req.getParameter("loginName");
			String password = req.getParameter("password"); 
			String authcode = req.getParameter("authcode");
			//acFromSession不会为null
			String acFromSession = (String) session.getAttribute("AUTHCODE");
			
			if(authcode==null || authcode.isEmpty()){
				msg(req, resp, TOLOGIN, "登陆失败：验证码输入不能为空！！"); 
				return;
			}else if(!authcode.equals(acFromSession)){
				msg(req, resp, TOLOGIN, "登陆失败：验证码输入错误！！"); 
				return; 
			}
			boolean loginFlag = adminService.login(loginName, password);
			if(loginFlag){
				//创建cookie 
				Cookie cookie = new Cookie(loginName, password);
				/**
				 * 如果不设置过期时间，则表示这个cookie生命周期为从创建到浏览器关闭止，只要关闭浏览器窗口，cookie就消失了。
				 * 这种生命期为浏览会话期的cookie被称为会话cookie。会话cookie一般不保存在硬盘上而是保存在内存里。
				 */
				/**
				 * 如果设置了过期时间(setMaxAge(606024))，浏览器就会把cookie保存到硬盘上，关闭后再次打开浏览器，
				 * 这些cookie依然有效直到超过设定的过期时间。
				 */
				//一个月以内有效
				cookie.setMaxAge(60*60*24*30); 
				cookie.setPath(req.getContextPath());
				//添加cookie到响应对象
				resp.addCookie(cookie);
				
				/**就算不添加自己创建的cookie，服务器也会返回一个jsessionId给浏览器*/
				//设置单位为秒，设置为-1永不过期
				session.setMaxInactiveInterval(-1);
				//添加adminName到session
				session.setAttribute("loginName", loginName);
				
				req.getRequestDispatcher(BACKINDEX).forward(req, resp);
			}else{
				msg(req, resp, TOLOGIN, "登陆失败：用户名或者密码错误！！");
			} 
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	private void msg(HttpServletRequest req, HttpServletResponse resp, 
	          String nextUrl, String global_message) throws ServletException, IOException {
					//设置nextUrl
					req.setAttribute("nextUrl", nextUrl);
					//设置global_message
					req.setAttribute("global_message", global_message);
					//转发器
					req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
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
