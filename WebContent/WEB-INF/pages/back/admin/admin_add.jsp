<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 

	<head>
		<meta charset="utf-8"> 
		<title>管理员添加</title>
		<style>
			@import url("/HgShopSys/resource/css/Brand_add.css");
		</style>
	</head>

	<body>
		<div id="title">
			<div class="title">管理员添加</div> 
		</div>  
		
		<div class="position"> 当前位置：管理员管理 >> 管理员添加 </div>
		
		<div id="content">
			<form id="AdminAddform" name="AdminAddform"
					 method="post" action="/HgShopSys/back/admin/add.do">
				<table align="center" id="add_table">
					<caption id="cap">
						管理员添加
					</caption>
					<thead>
					</thead>
					<tbody>
						<tr>
							<td width="15%"> 管理员名称：</td>
							<td>
								<input name="adminName" type="text"><span>*</span>
								</td>
						</tr>
						<tr>
							<td width="15%"> 密码：</td>
							<td>
								<input name="password" type="password"><span>*</span></td>
						</tr>
						<tr>
							<td width="15%"> 确认密码：</td> 
							<td>
								<input name="password2" type="password"><span>*</span></td>
						</tr>
						<tr>
							<td width="15%"> 真实名称：</td>
							<td>
								<input name="realName" type="text">
							</td>
						</tr> 
						<tr>  
							<td width="15%"> 性别：</td>
							<td>男
								<input name="gender" type="radio" value="man" checked="true"/>&nbsp;&nbsp;女
								<input name="gender" type="radio" value="woman"/>&nbsp;&nbsp;保密
								<input name="gender" type="radio" value="secret"/> 
							</td>
						</tr>
 
						<tr>
							<td align="left"> 描述：</td>
							<td>
								<textarea  class="ckeditor" name="desc" id="desc" cols="50" rows="10"></textarea>

							</td>
 
						</tr>
						<tr>
							<td colspan="2" align="center">
									<input type="submit" value="添加"/> 
									<input type="reset" value="重置"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div> 
	</body>
	<script type="text/javascript"  src="/HgShopSys/resource/ckeditor/ckeditor.js" ></script>
</html>