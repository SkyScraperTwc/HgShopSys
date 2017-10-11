package indi.twc.hg.web.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import indi.twc.hg.utils.StringUtils;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontLoginFilter implements Filter{
	private Set<String> excludePaths = new HashSet<String>();
	
	@Override
	public void destroy() {
		
	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		String excludePathStr = config.getInitParameter("exclude_path");
		if(excludePathStr!=null){
			excludePathStr = StringUtils.getStringNoBlank(excludePathStr);
			String[] paths = excludePathStr.split(",");
					for (String s : paths) {
						excludePaths.add(s);
					}
					System.out.println(excludePaths);
		}
	}
	  
	@Override  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
			// 设置页面不缓存
			resp.setHeader("Pragma", "No-cache");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setDateHeader("Expires", 0);
			
			//检查init-param
			String requestURI = req.getRequestURI();
			for (String path : excludePaths) {
				if(requestURI.equals(req.getContextPath()+path)){
					chain.doFilter(request, response);//放行
					return; 
				} 
			} 
			
			String loginUser = (String)req.getSession().getAttribute("login_user");
			if(null==loginUser){
				//重定向 sendRedirect()方法
				resp.sendRedirect(req.getContextPath()+"/front/user/toLogin.do");
			}else{
				chain.doFilter(request, response);//放行 
			}
	}

}
