package indi.twc.hg.web.controller.admin;

import indi.twc.hg.service.impl.AdminServiceImpl;
import indi.twc.hg.service.IAdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminDelServlet extends HttpServlet{
	IAdminService adminService 
	                      = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			//获得用户从页面传来的数据
			String[] ids = req.getParameterValues("id");
			List<Integer> idList = new ArrayList<Integer>();
			if(null!=ids){
				for (int i = 0; i < ids.length; i++) {
					Integer id = Integer.valueOf(ids[i]);
					idList.add(id);
				}
			}
			try {
				adminService.delete(idList.toArray(new Integer[]{}));
				req.setAttribute("nextUrl", "/back/admin/list.do");
				req.setAttribute("global_message", "管理员删除成功！");
				req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
