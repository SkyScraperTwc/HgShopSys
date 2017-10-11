<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   		 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
 
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			@import url("/HgShopSys/resource/css/List.css");
		</style>
	</head>

	<body>
		<div id="title"> 
			<div class = "title">分类列表</div>
		</div>
		
		<div id="position"> 当前位置：分类管理 >> 分类列表 </div>
		
		<div id="content">
		<table id = "list_tb" align="center">
			<caption id = "cap">分类列表</caption>
			<thead>
				<tr>
					<th width="6%">序号</th>
					<th width="4%">选择</th>
					<th width="20%">分类名称</th> 
					<th width="10%">级别</th>
					<th width="20%">cls</th>
					<th width="10%">操作</th> 
				</tr>
			</thead> 

			<tbody>
				
				<c:choose>	
					<c:when test = "${null==pageData.dataList or fn:length(pageData.dataList)==0}  ">
						<tr>
						   <td align="center" colspan="6">暂时没有数据！<td>
						</tr>
					</c:when>  
					<c:otherwise>  
					  <c:forEach items="${pageData.dataList }" var="category" varStatus="sta">
						<tr align='center'> 
							<td>${category.id }</td><!--序号1234567890  -->
							<td>
								<input name="id" type="checkbox" value="${category.id }">
							</td>
							<td align="center">${category.name}</td>
							<td>${category.level }</td>
							<td>${category.cls }</td>
							<td>
								<a class="like_btn" target="_blank"
											href="/HgShopSys/back/category/categoryToEdit.do?id=${category.id }">修改</a>
							</td>
						</tr>
			       </c:forEach>
				</c:otherwise> 
				
		</c:choose>		
				
				<tr class="operation">
					<td align="left" colspan="9">&nbsp;
						<a href="javascript:void(0)" class="like_btn" onclick="checkAll('id')">全选</a>
						<a href="javascript:void(0)" class="like_btn" onclick="cancelCheck('id')">取消选择</a>
						<a href="javascript:void(0)" class="like_btn" onclick="reverseCheck('id')"> 反选</a>
						<a href="javascript:void(0)" class="like_btn" 
										onclick="deleteChecked('id','/HgShopSys/back/category/delete.do')">删除</a>
						<a class="like_btn" target="_blank"
										href="/HgShopSys/back/category/categoryToAdd.do" >添加分类</a>
				</td>
				</tr>
					<tr class="page"> 
						<td align="right" colspan="9"> 
								<a href="${requestScope.reqUri }?categoryName=${categoryName}&level=${level }&page=${pageData.first }&rows=${pageData.rows}" class="like_btn">首页</a>
								<a href="${requestScope.reqUri }?categoryName=${categoryName}&level=${level }&page=${pageData.pre }&rows=${pageData.rows}" class="like_btn">上一页</a>
								<a href="${requestScope.reqUri }?categoryName=${categoryName}&level=${level }&page=${pageData.next }&rows=${pageData.rows}" class="like_btn">下一页</a>
								<a href="${requestScope.reqUri }?categoryName=${categoryName}&level=${level }&page=${pageData.last }&rows=${pageData.rows}" class="like_btn">尾页</a>
								共${pageData.totalRecordes }条纪录，当前第${pageData.page }
								  
								/${pageData.totalpages }页，每页   
								 
								<input type="text" id="rows" 
								   onblur="updateRows('${pageData.rows}',this.value)" size="2" value="${pageData.rows }"/>条记录 
								    
								  <script type="text/javascript">  
									    function updateRows(oldRows,newRows){   
											if(oldRows == newRows){  
												return; 
											}  
													var url = "${requestScope.reqUri }"+"?categoryName="+
															"${categoryName}"+"&level="+"${level }"+"&page="
															+"${pageData.first }"+"&rows="+newRows;
													alert(url);
													window.location.href = url;
											}	   
							       </script>
						</td>
					</tr>  
			</tbody> 
		</table>
		</div>
		
		<form id="SearchForm" method="post" action="/HgShopSys/back/category/categoryList.do" >
			<table id="search" align="center">
				<tr>
					<td>分类名称:</td>
					<td>
						<input name="categoryName" type="text" />
					</td>
					<td>级别：</td>  
					<td>
						<input name="level" type="text"/>
					</td>  
				</tr>
			 
				<tr>  
					<td colspan="4" align="center">
						<input id = "button" type="button" value="搜索" onclick="search()"/>
						<script type="text/javascript">
								var sv = "${pageData.first}";
								var sr = "${pageData.rows}";
						</script>
						<script type="text/javascript" 
								src = "/HgShopSys/resource/common/js/SearchForm.js">
						 
						</script>
					<td>
				</tr>
			</table>
		</form>
		
		</div>
	</body>
	<script type="text/javascript"
					 src="/HgShopSys/resource/common/js/utils.js" > 
	</script>
</html>