<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   		 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>产品列表</title>
		<style type="text/css">
			@import url("/HgShopSys/resource/css/List.css");
		</style>
		<style>
			a{text-decoration: none}
		</style>
	</head>

	<body noresize="yes">
		<div id="title">
			<div class="title">产品列表</div>
		</div>

		<div id="position"> 当前位置：产品管理 >> 产品列表 </div>

		<div id="content">
			<table id="list_tb" align="center" style="width:1500px">
				<caption id="cap">产品列表</caption>
				<thead>
					<tr>
						<th width="6%">序号</th>
						<th width="6%">选择</th> 
						<th width="12%">产品名称</th>
						<th width="12%">编号</th>
						<th width="8%">购买说明</th>
						<th width="10%">所属品牌</th>
						<th width="15%">所属分类</th>
						<th width="5%">市场价</th>
						<th width="5%">宏购价</th>
						<th width="5%">是否推荐</th>
						<th width="5%">是否促销</th>
						<th width="10%">产品主图片</th>
						<th width="20%">产品副图片</th>
						<th width="5%">产品颜色</th>
						<th width="5">操作</th>
					</tr>
				</thead> 

				<tbody class="tbody">
					
				<c:choose>	
					<c:when test = "${null==pageData.dataList or fn:length(pageData.dataList)==0}  ">
						<tr>
						   <td align="center" colspan="7">暂时没有数据！<td>
						</tr>
					</c:when> 
					
					<c:otherwise> 
					  <c:forEach items="${pageData.dataList }" var="product" varStatus="status">
								<tr align='center'> 
								<!--status.count是从0开始的,序号1234567890  -->
									<td>${status.count}</td>
									<td>
										<input name="id" type="checkbox" value="${product.id }">
									</td>   
					 				<td>${product.name }</td>
									<td>${product.number}</td>
									<td>${product.remark}</td>
									<td>${product.brand.cnName}(${product.brand.enName})</td>
									<td>${product.category.name}</td>
									<td>${product.marketPrice}</td>
									<td>${product.discountedPrice}</td>
									<td>${product.recommend}</td>
									<td>${product.promotion}</td>
									<!-- 产品主图片 -->
								 	<td>
							 			<a target="_blank" href="${pageContext.request.contextPath}${product.mainImage}">
							 				<img height="35px" src="${pageContext.request.contextPath}${product.mainImage}"/>
							 			</a>
								 	</td>
									<td>
									<!-- 产品副图片 -->
									<c:choose>
										<c:when test = "${null==product.productImagesList or fn:length(product.productImagesList)==0}  ">
												<tr>
												   <td align="center" colspan="2">暂时没有图片！<td>
												</tr>
										</c:when> 
										
										<c:otherwise> 
						  							<c:forEach items="${product.productImagesList }" var="pi">
															<a target="_blank" href="${pageContext.request.contextPath}${pi.url}">
																<img height="50px" src="${pageContext.request.contextPath}${pi.url}"/>
															</a>
										 		    </c:forEach>
										</c:otherwise> 
									</c:choose>
									
									</td>
									<td>${product.color}</td>
									
									<td>
										<a class="like_btn" href="/HgShopSys/back/product/toEdit.do?id=${product.id }">修改</a>
									</td>
							    </tr>
					    </c:forEach>
					</c:otherwise> 
				</c:choose>	


			<tr class="operation">
				<td align="left" colspan="15">&nbsp;
					<a href="javascript:void(0)" class="like_btn" onclick="checkAll('id')">全选</a>
					<a href="javascript:void(0)" class="like_btn" onclick="cancelCheck('id')">取消选择</a>
					<a href="javascript:void(0)" class="like_btn" onclick="reverseCheck('id')">反选</a>
					<a href="javascript:void(0)" class="like_btn" onclick="deleteChecked('id','/HgShopSys/back/product/delete.do')">删除</a>
					<a target="_blank" class="like_btn" href="/HgShopSys/back/product/productToAdd.do">添加产品</a>
				</td>
			</tr>
  
					<tr class="page"> 
						<td align="right" colspan="15"> 
								<a href="${requestScope.reqUri }?productName=${productName}&brandName=${brandName }&categoryName=${categoryName}&page=${pageData.first }&rows=${pageData.rows}" class="like_btn">首页</a>
								<a href="${requestScope.reqUri }?productName=${productName}&brandName=${brandName }&categoryName=${categoryName}&page=${pageData.pre }&rows=${pageData.rows}" class="like_btn">上一页</a>
								<a href="${requestScope.reqUri }?productName=${productName}&brandName=${brandName }&categoryName=${categoryName}&page=${pageData.next }&rows=${pageData.rows}" class="like_btn">下一页</a>
								<a href="${requestScope.reqUri }?productName=${productName}&brandName=${brandName }&categoryName=${categoryName}&page=${pageData.last }&rows=${pageData.rows}" class="like_btn">尾页</a>
								共${pageData.totalRecordes }条纪录，当前第${pageData.page }
								  
								/${pageData.totalpages }页，每页   
								
								<input type="text" id="rows" 
								   onblur="updateRows('${pageData.rows}',this.value)" size="2" value="${pageData.rows }"/>条记录 
								    
								  <script type="text/javascript">  
										function updateRows(oldRows,newRows){   
											if(oldRows == newRows){ 
												return;
											}  
													var url = "${requestScope.reqUri }"+"?productName="+
															"${productName}"+"&brandName="+"${brandName }"+"&categoryName="+"${categoryName}"
															+"&page="+"${pageData.first }"+"&rows="+newRows;
													window.location.href = url;
										}
							       </script>
						</td>
					</tr>
					 
				</tbody>
			</table>
		</div>
 
		<form id="SearchForm" method="post" action="/HgShopSys/back/product/productList.do" >
			<table id="search" align="center" > 
				<tr>
					<td>产品名称：</td>
					<td>
						<input type="text" name="productName" />&nbsp;&nbsp;&nbsp;
					</td>
					<td>品牌名称(中文)：</td>
					<td>
						<input type="text" name="brandName"/>&nbsp;&nbsp;&nbsp;
					</td>  
					<td>分类名称(中文)：</td>
				    <td>
						<input type="text" name="categoryName"/>
					</td>  
				
				</tr>

				<tr> 
					<td colspan="4" align="center">
					<input type="button" id="button" value="搜索" onclick="search()"/>
					    <script type="text/javascript">
								var sv = "${pageData.first}";
								var sr = "${pageData.rows}";
						</script>
						<script type="text/javascript" src = "/HgShopSys/resource/common/js/SearchForm.js">
						</script>
					</td>
				</tr>
			</table>
	</form>
	</body>
	
	<script type="text/javascript" src="/HgShopSys/resource/common/js/utils.js"> 
	</script>
   
	   

</html>