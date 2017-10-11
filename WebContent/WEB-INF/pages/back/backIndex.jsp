<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<!--asd -->
<html>
<!--
	html框架
	css表现 
	javascript行为
-->
	<head>  
		<meta charset="utf-8">    
		<title>欢迎页面</title>   
	</head>  
	<frameset rows="57,700,*" frameborder="0">
 
		<frame name="head" src="/HgShopSys/back/head.do" scrolling="no" noresize="yes"></frame>

		<frameset cols="198,*" frameborder="0">
			<!--框架名字为menu-->
			<frame name="menu" src="/HgShopSys/back/menu.do" noresize="yes"></frame>
			<!-- name = "main"！！！！！！！！！ -->
			<!--！！！！--> 
			<frame name="main" src="/HgShopSys/back/welcome.do" noresize="yes"></frame>
		</frameset>
			<frame name="foot" src="/HgShopSys/back/foot.do" noresize="yes"></frame>
		
	</frameset>


 
	<noframes>
		<body>
			您的浏览器不支持frame框架！！
		</body> 
	</noframes>

</html> 