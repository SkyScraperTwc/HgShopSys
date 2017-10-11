<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   		 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!--
	作者：offline
	时间：2015-12-29 
	描述：产品修改页面  
-->
<html> 
	<head> 
		<meta charset="utf-8">
		<title > 产品修改</title>
		 
		<style type="text/css">  
			@import url("/HgShopSys/resource/easydialog/easydialog.css");
 			@import url("/HgShopSys/resource/css/Brand_add.css"); 
		</style>
		<style type="text/css">
			.like_btn{
				background-color:#FFDEAD    ;
				padding: 3px 8px;
				border-right: 1px solid #999999;
				border-bottom: 1px solid #999999;
				text-decoration: none;
				color: #333333;
				margin-right: 10px;
				cursor: pointer;
		     }
			.like_btn:hover{
				color: #FF4500;
			}
		</style>
	</head>
	 
	<body> 
		<div id="title">
			<div class="title"> 产品修改</div>
		</div>
		
		<div class="position">
			当前位置：产品管理>>产品修改
		</div>
		  
		<div id="content">
			<form  method="post"  enctype="multipart/form-data"  action="/HgShopSys/back/product/edit.do">
				<table align="center" id="add_table">
					<input type="hidden" name="id" value="${product.id }"/>
					<caption id="cap"> 产品修改</caption>
					<tr>
						<td width="15%">产品名称:</td>
						<td> 
							<input style="width:100px;" type = "text" name = "name" value="${product.name }"/>
							<span>*</span>
						</td>
					</tr>
					
					<tr>
						<td width="15%">编号:</td>
						<td> 
							<input style="width:100px;" type = "text" name = "number" value="${product.number}"/>
							<span>*</span> 
						</td>
					</tr>
					
					<tr>
						<td width="15%">购买说明:</td>
						<td> 
							<input style="width:200px;" type = "text" name = "remark" value="${product.remark}"/>
							<span>*</span> 
						</td>
					</tr>
					
					<tr>
						<td width="15%">所属品牌:</td> 
						<td> 
							<input type="text" id="brandName" readonly="readonly" value="${product.brand.cnName}(${product.brand.enName})"/>
							
							<input id="brand_ID" name="brandID" type="hidden" value="${product.brand.id}"/>
							
							<a id="a" href="javascript:void(0)" class="like_btn" onclick="openDialogBox('brand_box')">点击选择品牌</a> 
						</td> 
					</tr>
					
					<tr>
						<td width="15%">所属分类:</td>
						<td> 
							<input type="text" id="categoryName" readonly="readonly" value="${product.category.name}"/>
							
							<input id="category_ID" name="categoryID" type="hidden" value="${product.category.id}"/>
							
							 <a href="javascript:void(0)"  class="like_btn"  onclick="openDialogBox('category_box')">点击选择分类</a> 
						</td>  
					</tr>
					
					<tr>
						<td width="15%">市场价:</td>
						<td> 
							<input style="width:100px;" type = "text" name = "marketPrice" value="${product.marketPrice}"/>
							元<span>*</span> 
						</td>
					</tr>
					
					<tr>
						<td width="15%">宏购价:</td>
						<td> 
							<input style="width:100px;" type = "text" name = "discountedPrice" value="${product.discountedPrice}"/>
							元<span>*</span> 
						</td>
					</tr>
					
					<tr>
						<td width="15%">是否推荐:</td>
						<td>
							<input id="recommendID" name="recommend" type="checkbox" value="select">
						</td>
					</tr>
					
					<tr>
						<td width="15%">是否促销:</td>
						<td>
							<input id="promotionID" name="promotion" type="checkbox" value="select">
						</td>
					</tr> 
						<script type="text/javascript">
						    var pr = ${product.recommend};
						    var recCheckbox = document.getElementById("recommendID");
								if(pr==true){
									recCheckbox.checked=true;
								}else{
									recCheckbox.checked=false;
								} 
							 var pp = ${product.promotion};
							 var proCheckbox = document.getElementById("promotionID");
								if(pp==true){
									proCheckbox.checked=true;
								}else{
									proCheckbox.checked=false;
								} 
						</script>
					<tr> 
						<td width="15%">产品颜色:</td>
						<td> 
							<input type="text" name="color" value="${product.color}"/>
						</td>
					</tr>
					
					<tr>
						<td width="15%"> 产品主图片:</td>
						<td>
							<input onchange="javascript:showMainPhoto(this);" name="mainImage" type="file">
							<a id="aMainTag" target="_blank" href="${pageContext.request.contextPath}${product.mainImage}">
						 				<img id="mainImg" height="35px" src="${pageContext.request.contextPath}${product.mainImage}"/>
				 			</a>
				 			<input name="unChangedMainImage" type="hidden" value="${product.mainImage}">
						</td>
					</tr>
					<script type="text/javascript">
						function showMainPhoto(obj) {
							var mainImg = document.getElementById("mainImg");
							var aMainTag = document.getElementById("aMainTag");
							var Res = "/HgShopSys/imgServlet.do?pictureName="+obj.value+"&xx="+Math.random();
							mainImg.src = Res;
							aMainTag.href = Res;
						}	
					</script>
<!-- 				     <tr>  -->
<!-- 						<td width="15%"> 产品副图片:</td> -->
<!-- 						<td>
								<input name="otherImages" type="file" size="50"> -->
<!-- 					        <a href="javascript:void(0)" onclick="javascript:addFileInput(this);" class="like_btn">继续添加图片</a> -->
<!-- 					    </td>   -->
<!-- 					</tr>  -->
					
					<!-- 产品副图片 -->
					<c:choose>
						<c:when test = "${null==product.productImagesList or fn:length(product.productImagesList)==0}  ">
								<tr>
								   <td align="center" colspan="2">暂时没有图片！<td>
								</tr>
						</c:when> 
						
						<c:otherwise>
	  							<c:forEach items="${product.productImagesList }" var="pi" >
			  							<tr>
			  							   <td width="15%">产品副图片:</td>
			  							    <td>
			  								   <input flag="${pi.index }" onchange="javascript:showOtherPhotos(this);" name="otherImages${pi.index }" type="file" >
												<a id="aTag${pi.index }" target="_blank" href="${pageContext.request.contextPath}${pi.url}">
														<img id="imgTag${pi.index }" height="50px" src="${pageContext.request.contextPath}${pi.url}"/>
												</a>
												<input name="unChangedOtherImages${pi.index}" type="hidden" value="${pi.url}">
											</td>
										</tr>
					 		    </c:forEach>
						</c:otherwise>
					</c:choose>
					<!-- 展示副图片 -->
					<script type="text/javascript">
						function showOtherPhotos(obj) {
							var flag = obj.getAttribute("flag");
// 							alert("aTag"+flag);
							var imgTag = document.getElementById("imgTag"+flag);
							var aTag = document.getElementById("aTag"+flag);
							var Res = "/HgShopSys/imgServlet.do?pictureName="+obj.value+"&xx="+Math.random();
							imgTag.src = Res;
							aTag.href = Res;
						}	
					</script>
					
					<tr>
						<td>商品介绍:</td> 
						<td> 
							<textarea class="ckeditor" name = "desc">${product.desc}</textarea>
						</td>
					</tr> 
					
						<tr>
							<td colspan="2" align="center">
									<input type="submit" value="修改"/> 
									<input type="reset" value="重置"/>
							</td>
						</tr>
				</table>
			</form>
		</div>
		
<div class="hide_box" id="category_box">
		<h4>
			<a href="javascript:closeDialogBox()" title="关闭窗口">&times;</a>
			请选择分类
		</h4>
		<div  id="categorys">
				<c:forEach items = "${requestScope.categoryList}" var = "c">
               		 <div>
               		       第一级分类：${c.name }  
      		       		   <c:forEach items = "${c.childs}" var = "c2">
			               		 <div>
			               		       ---第2级分类：${c2.name }   
			               		       <div>
			               		          ---------第3级分类：
				               		      <c:forEach items="${c2.childs}" var="c3">
				               		      		    <a href="javascript:void(0)" class="category" a_categoryId="${c3.id }" >${c3.name }</a> 
	           		       				   </c:forEach> 
           		       				   </div>
			               		 </div>
           		          </c:forEach>  
               		 </div> 
           		 </c:forEach>  
	    </div> 
</div> 
	 
<div class="hide_box" id="brand_box">
		<h4> 
			<a href="javascript:closeDialogBox()" title="关闭窗口">&times;</a>
			请选择品牌
		</h4> 
		<div id="brands"> 
			<c:forEach items = "${requestScope.brandList }" var = "b">
				<a href="javascript:void(0)" class="brand" a_brandId="${b.id }">${b.cnName }(${b.enName })</a><br/>
			</c:forEach>
	    </div> 
</div>
	
</body>
	
		<script type="text/javascript" src="/HgShopSys/resource/ckeditor/ckeditor.js"  >
		</script>  
		<script type="text/javascript" src="/HgShopSys/resource/easydialog/easydialog.js"  >
		</script>
			
		 <script type="text/javascript">
				 function addFileInput(obj){
					 var input = document.createElement("input"); 
					 input.name = "otherImages"; 
					 input.type = "file";
					 input.size = "50"; 
					 obj.parentNode.insertBefore(input,obj);
					 
					 var br = document.createElement("br");
					 obj.parentNode.insertBefore(br,obj);
				 }
		  
		 		function openDialogBox(boxId){
		 			easyDialog.open({
		 				container:boxId,
		 			}); 
		 		}
		 		function closeDialogBox(){
		 			easyDialog.close();
		 		}
		 		
		 		var categorysDiv = document.getElementById("categorys");
		 		var categorys = categorysDiv.getElementsByTagName('a');
		 		for (var i = 0; i < categorys.length; i++) {
					var cate = categorys[i];//cate是<a>标签
					//定义<a>标签点击函数
					cate.onclick = function(){ 
						var categoryNameObj = document.getElementById("categoryName");
						var categoryIdObj = document.getElementById("category_ID");
						categoryNameObj.value = this.innerHTML;  //${c3.name }
						categoryIdObj.value = this.getAttribute("a_categoryId");
						closeDialogBox();
					} 
				} 
		 		
		 		var brandDiv = document.getElementById("brands");
		 		var brands = brandDiv.getElementsByTagName('a');
		 		for (var i = 0; i < brands.length; i++) {
					var cate = brands[i];//cate是<a>标签
					cate.onclick = function(){
						var brandNameObj = document.getElementById("brandName");
						var brandIdObj = document.getElementById("brand_ID");
						brandNameObj.value = this.innerHTML; //${b.cnName }(${b.enName })
						brandIdObj.value = this.getAttribute("a_brandId");
						closeDialogBox();  
					}
				}
		 </script> 
			
</html>
