<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>品牌修改</title>
		
		<style>
				@import url("/HgShopSys/resource/css/Brand_add.css");
		</style>
	</head>  

	<body>
		<div id="title">
				<div class="title">品牌修改</div>
		</div> 
		
		<div class="position"> 当前位置：品牌管理 >>品牌修改 </div>
		<div id="content"> 
		<form  method="post" enctype="multipart/form-data"
						action="/HgShopSys/back/brand/brandEdit.do">
		<table align="center" id="add_table" >
			<tbody>
				<input type="hidden" name="id" value="${brand.id }"/>
					<caption id="cap">品牌修改</caption>
						<tr>
							<td width="15%"> 中文名称:</td>
							<td>
								<input name="cnName" type="text" value="${brand.cnName }">
									<span>*</span>
							</td>

						</tr> 
						<tr>
							<td width="15%"> 英文名称:</td>
							<td>
								<input name="enName" type="text" value="${brand.enName }">
									<span>*</span>
							</td>

						</tr>
						
						<tr>
							<td width="15%"> 小图片:</td>
							<td>
								<input onchange="javascript:showSmallPhoto(this);" name="smallPhoto" type="file">
								<a id="sPATagID" target="_blank" href="${pageContext.request.contextPath}${brand.smallPhoto}">
						 				<img id="smallPhotoImg" height="35px" src="${pageContext.request.contextPath}${brand.smallPhoto}"/>
					 			</a>
					 			<input name="unChangedSmallPhoto" type="hidden" value="${brand.smallPhoto}">
							</td>
						</tr>
						<!-- 展示小图片 -->
						<script type="text/javascript">
							function showSmallPhoto(obj) {
								var smallPhotoDOM = document.getElementById("smallPhotoImg");
								var sPATag = document.getElementById("sPATagID");
								var Res = "/HgShopSys/imgServlet.do?pictureName="+obj.value+"&xx="+Math.random();
								smallPhotoDOM.src = Res;
								sPATag.href = Res;
							}	
						</script>
						
						<tr>
							<td width="15%"> 大图片:</td>
							<td>
								<input onchange="javascript:showBigPhoto(this);" name="bigPhoto" type="file">
								<a id="bPATagID" target="_blank" href="${pageContext.request.contextPath}${brand.bigPhoto}">
						 				<img id="bigPhotoImg" height="35px" src="${pageContext.request.contextPath}${brand.bigPhoto}"/>
					 			</a>
					 			<input name="unChangedbigPhoto" type="hidden" value="${brand.bigPhoto}">
							</td>
						</tr>
						<!-- 展示大图片 -->
						<script type="text/javascript">
							function showBigPhoto(obj) {
								var bigPhotoDOM = document.getElementById("bigPhotoImg");
								var bPATag = document.getElementById("bPATagID");
								var Res = "/HgShopSys/imgServlet.do?pictureName="+obj.value+"&xx="+Math.random();
								bigPhotoDOM.src = Res;
								bPATag.href = Res;
							}	
						</script>
							
						<tr>
							<td width="15%"> 描述:</td>
							<td>
								<textarea class="ckeditor" name="desc" cols="50" rows="10">${brand.desc }</textarea>
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
	<script type="text/javascript"  src="/HgShopSys/resource/ckeditor/ckeditor.js" ></script>
</html>