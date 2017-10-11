package indi.twc.hg.web.filter;

import indi.twc.hg.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BackLoginFilter implements Filter{
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
			//类型强转
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
					//请求路径与excludePaths一样，则放行
					chain.doFilter(request, response);
					return; 
				}       
			}      
			//判断loginName
			String loginName = (String)req.getSession().getAttribute("loginName");
			if(null==loginName){ 
				//不满足条件，全部重定向  
				resp.sendRedirect(req.getContextPath()+"/back/admin/toLogin.do");
			}else{
				chain.doFilter(request, response);//放行 
			}
	}
 
}
