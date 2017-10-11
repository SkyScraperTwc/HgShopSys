package indi.twc.hg.web.controller.brand;

import indi.twc.hg.dao.impl.BrandDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BrandToAddServlet extends HttpServlet{
	private BrandDaoImpl brandDao = new BrandDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
//		 String filePath = "E:/workspace/HgShopSys/WebContent/resource/upload/brand";
//		 File root = new File(filePath);
//		 File[] files = root.listFiles();
//		 List<String> filesList = new ArrayList<String>();
//		 for (int i = 0; i < files.length; i++) {
//			 filesList.add(files[i].getPath()); 
//		}
//		 
//		 try {
//			List<Brand> brandList = brandDao.queryList(null, null, 
//						-1, -1, null, Brand_Sql.brandQueryList, new BrandRowMapper());
//			 List<String> photoList = new ArrayList<String>();
//			 for (int i = 0; i < brandList.size(); i++) {
//				 String smallPhoto = "E:/workspace/HgShopSys/WebContent"+brandList.get(i).getSmallPhoto();
//				 String bigPhoto = "E:/workspace/HgShopSys/WebContent"+brandList.get(i).getBigPhoto();
//				 smallPhoto = smallPhoto.replaceAll("/", "\\\\");
//				 bigPhoto = bigPhoto.replaceAll("/", "\\\\"); 
//				 photoList.add(smallPhoto);
//				 photoList.add(bigPhoto);
//			}
//			 
//			filesList.removeAll(photoList);
//			System.out.println(filesList.size());
//			for (int i = 0; i < filesList.size(); i++) {
//				File file = new File(filesList.get(i));
//				if(file.exists()){
//					file.delete();
//				}
//			}
//		} catch (SQLException e){
//			e.printStackTrace();
//		}
		//转发器 
		req.getRequestDispatcher("/WEB-INF/pages/back/brand/Brand_add.jsp").forward(req, resp);
	}
	
}
 