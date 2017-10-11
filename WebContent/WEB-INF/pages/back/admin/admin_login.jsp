<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="content-type" content="text/html;charset = utf-8" />
		<title>管理员登陆</title>
		<style>
			@import url("/HgShopSys/resource/css/admin_login.css");
		</style>
	</head>

	<body> 
		<div id = "head"></div>
	  <!--中间-->
		<div id="center"> 
		<!--顶部--> 
		<div id="center_left">
			<ul>
				<li>
					1.地区商家信息网门户站建立的首选方案... 
				</li>
				<li>
					2.一站通式的整合方式，方便用户使用....
				</li>
				<li>
					3.地区商家信息网门户站建立的首选方案....
				</li>
			</ul> 
		</div>
		
			<!--中左-->
			<div  id="center_right">
				<!-- form-->
				<form action="/HgShopSys/back/admin/login.do" method="post">
					<table id = "table">
						<caption> 登陆宏购网后台</caption>
						<tr>
							<td>管理员：</td>
							<td>
								<input type="text" name="loginName" /> </td>

						</tr>
						<tr> 
							<td>密码：</td>
							<td>
								<input type="password" name="password" /> </td>
							<td> <img src="/HgShopSys/resource/backImage/images/lock.gif" /> </td>
						</tr>  
						<tr>
							<td>验证码：</td> 
							<td colspan="2">
								<input style="width: 80px" type="text" name="authcode" />
								<span ><img id="authcodeImg" src="/HgShopSys/authcode.img" 
											onclick="getAuthcode()" style = "vertical-align: middle"></span>
							</td> 
			 			</tr> 
						<tr>
							<td class = "id">
								<input type="submit" value="登陆" />
							</td> 
							<td class = "id">
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table> 
				</form> 
			</div>

		</div>

		<div id = "foot">  
			Copyright &copy; 2016-2020 twc 
		</div>
    
	</body> 
		<script type="text/javascript">  
		 		function getAuthcode(){
		 			var authcodeDom = document.getElementById("authcodeImg");
		 			authcodeDom.src = "/HgShopSys/authcode.img?xx="+Math.random();
		 		}
		</script>
</html>