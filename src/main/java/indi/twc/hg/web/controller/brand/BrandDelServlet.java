package indi.twc.hg.web.controller.brand;

import indi.twc.hg.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrandDelServlet extends HttpServlet{
	BrandServiceImpl brandService = new BrandServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		    int c = 1/0;
			//获得用户从页面传来的数据
			String[] ids = req.getParameterValues("id");
			List<Integer> idList = new ArrayList<Integer>();
			if(null != ids && ids.length>0){
				for (int i = 0; i < ids.length; i++) {
					Integer id = Integer.valueOf(ids[i]);
					idList.add(id);
				}
			}
			try {
				brandService.delete(idList.toArray(new Integer[]{}));
				req.setAttribute("nextUrl", "/back/brand/brandList.do");
				req.setAttribute("global_message", "品牌删除成功！");
				req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("nextUrl", "/back/brand/brandList.do");
				req.setAttribute("global_message", "品牌删除失败！！具体原因我们会尽快查找");
				req.getRequestDispatcher("/WEB-INF/pages/back/back_global_message.jsp").forward(req, resp);
			}
	}
	
	
}
