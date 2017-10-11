<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8"> 
		<title></title>
		<style>
			@import "/HgShopSys/resource/css/head.css"
		</style>  
	    <style>
			a{text-decoration: none}
		</style>
	</head>
  
	<body>  
		<div id="head"> 
  					<img src = "/HgShopSys/resource/backImage/images/logo.gif"/>
				 
			<div id = "head-nav">
				${sessionScope.loginName}您好，欢迎使用后台管理系统！！
				<a target="_blank" href = "${pageContext.request.contextPath}">[商城首页]</a>
				<a target="main" href = "${pageContext.request.contextPath}/back/admin/toPwdChange.do?adminName=${sessionScope.loginName}">[修改密码]</a>
				<a target="_parent" href="${pageContext.request.contextPath}/back/admin/logOut.do">[退出登录]</a> 
			</div> 
		</div>    
	</body>	 
	   
</html>