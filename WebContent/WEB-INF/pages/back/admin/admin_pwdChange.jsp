<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>修改密码</title>
		
		<style>
				@import url("/HgShopSys/resource/css/Brand_add.css");
		</style>
	</head>  

	<body>
		<div id="title">
				<div class="title">修改密码</div>
		</div> 
		
		<div class="position"> 当前位置：管理员管理 >> 修改密码</div>
		<div id="content">
		<form  method="post" action="/HgShopSys/back/admin/pwdChange.do">
		<table align="center" id="add_table" >
			<tbody>
				<input type="hidden" name="adminId" value="${admin.id }"/>
					<caption id="cap">修改密码</caption>
						<tr>
							<td width="15%"> 管理员名称:</td>
							<td>
								<input readonly="true" name="adminName" type="text" value="${admin.adminName }">
									<span>(不可修改)*</span>
							</td>
						</tr>
						
						<tr>
							<td width="15%"> 旧密码:</td>
							<td>
								<input name="oldPassword" type="password" value="" >
									<span>*</span>
							</td>

						</tr>
						
						<tr>
							<td width="15%"> 新密码:</td>
							<td>
								<input name="newPassword" type="password" >
									<span>*</span>
							</td>
						</tr>
						
						<tr>
							<td width="15%"> 确认新密码:</td>
							<td>
								<input name="newPassword" type="password" >
									<span>*</span>
							</td>

						</tr>
						
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="修改"/>
								<input type="reset" value="重置"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>

	</body>
	<script type="text/javascript"  
			src="/HgShopSys/resource/ckeditor/ckeditor.js" ></script>
</html>