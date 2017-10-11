<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>分类修改</title>
		
		<style>
				@import url("/HgShopSys/resource/css/Brand_add.css");
		</style>
	</head>  

	<body>
		<div id="title">
				<div class="title">分类修改</div>
		</div> 
		
		<div class="position"> 当前位置：分类管理 >> 分类修改 </div>
		<div id="content"> 
		<form  method="post" 
					action="/HgShopSys/back/category/categoryEdit.do">
		<table align="center" id="add_table" >
			<tbody>
				<input type="hidden" name="id" value="${category.id }"/>
					<caption id="cap">分类修改</caption>
						<tr>
							<td width="15%"> 名称:</td>
							<td>
								<input name="name" type="text" value="${category.name }">
									<span>*</span>
							</td>
						</tr>
						<tr>
							<td width="15%"> 级别:</td>
							<td>
								<input name="level" type="text" value="${category.level }" >
									<span>*</span>
							</td>

						</tr>
						<tr>
							<td width="15%"> 上一级别ID:</td>
							<td>
								<input name="P_ID" type="text" value="${category.parentCategory.id }">
									<span>*</span>
							</td>
						</tr>
						<tr>
							<td align="left"> 描述:</td>
							<td>
								<textarea class="ckeditor" name="desc" cols="50" rows="10">${category.desc }</textarea>
							</td>

						</tr>
						<tr>
							<td colspan="3" align="center">
								<input type="submit" id="submit" value="修改"/>
								<input type="reset" id="reset" value="重置">
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