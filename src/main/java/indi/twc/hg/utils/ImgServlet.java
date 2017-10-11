package indi.twc.hg.utils;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImgServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

			// 设置页面不缓存
			resp.setHeader("Pragma", "No-cache");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setDateHeader("Expires", 0);

			String pictureName = req.getParameter("pictureName");
			File file = new File("C:\\Users\\Administrator\\Desktop\\emoji表情包\\"+pictureName);
			BufferedImage bi = ImageIO.read(file);
			
			// 输出图象到页面
			ImageIO.write(bi, "GIF", resp.getOutputStream());
			
			}
	
}
