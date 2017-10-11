package indi.twc.hg.utils;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthCodeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
//		
//		int width = 65;
//		int height = 40;
//		
//		BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		Graphics g = bimg.getGraphics();
//		g.setColor(Color.LIGHT_GRAY);
//		g.fillRect(0, 0, width, height);
//		
//		for(int i=0;i<150;i++){ 
//			Color c = this.getRandomColor();
//			g.setColor(c);
//			
//			int x1 = random.nextInt(width);
//			int y1 = random.nextInt(height);
//			int x2 = random.nextInt(5);
//			int y2 = random.nextInt(5);
//			g.drawLine(x1, y1, x2, y2);
//		}
//		
//		String str = "123456789abcdefghijklmnopqrstuvwxyz";
//		String code = "";
//		code = code+str.charAt(random.nextInt(str.length()));
//		code = code+str.charAt(random.nextInt(str.length()));
//		code = code+str.charAt(random.nextInt(str.length()));
//		code = code+str.charAt(random.nextInt(str.length()));
//		
//		System.out.println(code);
//		System.out.println("+++++++++++++");
//		
//		req.getSession().setAttribute("AUTH_CODE", code);
//		
//		g.setFont(new Font("Courier New",Font.BOLD,24));
//		g.drawString(code, 0, height-10);
//		
//		resp.setContentType("image/jpeg");
//		OutputStream out = resp.getOutputStream();
//		
//		ImageIO.write(bimg, "JPEG", out);
//		
//		out.flush();
		// 设置页面不缓存
				resp.setHeader("Pragma", "No-cache");
				resp.setHeader("Cache-Control", "no-cache");
				resp.setDateHeader("Expires", 0);

				// 设置图片的长宽
				int width = 62, height = 22;

				// 创建内存图像
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);

				// 获取图形上下文
				Graphics g = image.createGraphics();

				// 设定图像背景色(因为是做背景，所以偏淡)
				g.setColor(getRandColor(180, 250));
				g.fillRect(0, 0, width, height); 

				// 设置字体
				g.setFont(new Font("Times New Roman", Font.PLAIN, 22));

				// 设置默认生成4个验证码
				int length = 4;
				java.util.Random rand = new Random(); // 设置随机种子

				// 设置备选验证码:包括"a-z"和数字"0-9"
				String base = "abcdefghijklmnopqrstuvwxyz0123456789";
				int size = base.length();
				StringBuffer str = new StringBuffer();
				for (int i = 0; i < length; i++) {
					int start = rand.nextInt(size);
					String tmpStr = base.substring(start, start + 1);

					str.append(tmpStr);

					// 生成随机颜色(因为是做前景，所以偏深)
					g.setColor(getRandColor(10, 150));

					// 将此字画到图片上
					// g.drawString(str.toString(), 4, 17);
					g.drawString(tmpStr, 13 * i + 6 + rand.nextInt(5),
							14 + rand.nextInt(6));

				}
				// 将验证码存入session
				req.getSession().setAttribute("AUTHCODE", str.toString());
				
				// 图象生效
				g.dispose();
				
				// 输出图象到页面
				ImageIO.write(image, "JPEG", resp.getOutputStream());
		
			}
  
			Color getRandColor(int fc, int bc) {
				Random random = new Random();
				if (fc > 255)
					fc = 255;
				if (bc > 255)
					bc = 255;
				int r = fc + random.nextInt(bc - fc);
				int g = fc + random.nextInt(bc - fc);
				int b = fc + random.nextInt(bc - fc);
				return new Color(r, g, b);
			}
	
}
