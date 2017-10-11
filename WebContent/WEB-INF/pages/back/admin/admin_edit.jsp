<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>管理员修改</title>
		
		<style>
				@import url("/HgShopSys/resource/css/Brand_add.css");
		</style>
	</head>  

	<body>
		<div id="title">
				<div class="title">管理员修改</div>
		</div> 
		
		<div class="position"> 当前位置：管理员管理 >> 管理员修改 </div>
		<div id="content"> 
		<form  method="post" action="/HgShopSys/back/admin/edit.do">
		<table align="center" id="add_table" >
			<tbody>
				<input type="hidden" name="adminId" value="${admin.id }"/>
					<caption id="cap">管理员修改</caption>
						<tr>
							<td width="15%"> 管理员名称:</td>
							<td>
								<input name="adminName" type="text" value="${admin.adminName }">
									<span>*</span>
							</td>

						</tr>
						<tr>
							<td width="15%"> 真实名称:</td>
							<td>
								<input name="realName" type="text" value="${admin.realName }">
							</td>
 
						</tr>
						<tr>
							<td width="15%"> 性别:</td>
							<td>男
								<input id="radioMan" name="gender" type="radio" value="man"/>&nbsp;&nbsp;女
								<input id="radioWoman" name="gender" type="radio" value="woman"/>&nbsp;&nbsp;保密
								<input id="radioSecret" name="gender" type="radio" value="secret"/> 
								<script type="text/javascript">
									    var cr = "${admin.sex }";
											if(cr=="man"){
												document.getElementById("radioMan").checked="true"
											}else if(cr=="woman"){
												document.getElementById("radioWoman").checked="true";
											}else if(cr=="secret")	{
												document.getElementById("radioSecret").checked="true";
											}   
								</script>
							</td>
						</tr>
						<tr>
							<td align="left"> 描述:</td>
							<td>
								<textarea class="ckeditor" name="desc" cols="50" rows="10">${admin.desc }</textarea>
							</td>

						</tr>

						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="修改"/>
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