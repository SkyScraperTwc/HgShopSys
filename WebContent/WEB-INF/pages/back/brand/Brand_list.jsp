<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   		 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>品牌列表</title>
		<style type="text/css">
			@import url("/HgShopSys/resource/css/List.css");
		</style>
		<style>
			a{text-decoration: none}
		</style>
	</head>

	<body noresize="yes"> 
		<div id="title">
			<div class="title">品牌列表</div>
		</div>

		<div id="position"> 当前位置：品牌管理 >> 品牌列表 </div>

		<div id="content">
			<table id="list_tb" align="center">
				<caption id="cap">品牌列表</caption>
				<thead>
					<tr>
						<th width="6%">序号</th>
						<th width="4%">选择</th> 
						<th width="12%">品牌中文名称</th>
						<th width="12%">品牌英文名称</th>
						<th width="8%">品牌小图片</th>
						<th width="8%">品牌大图片</th>
						<th width="10%">操作</th>
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
					  <c:forEach items="${pageData.dataList }" var="brand" varStatus="status">
								<tr align='center'> 
									<td>${status.count}</td><!--status.index是从0开始的,序号1234567890  -->
									<td>
										<input name="id" type="checkbox" value="${brand.id }">
									</td>   
					 				<td>${brand.cnName }</td>
									<td>${brand.enName}</td>
								 	<td>
							 			<a target="_blank" href="${pageContext.request.contextPath}${brand.smallPhoto}">
							 				<img height="35px" src="${pageContext.request.contextPath}${brand.smallPhoto}"/>
							 			</a>
								 	</td>
									<td>
										<a target="_blank" href="${pageContext.request.contextPath}${brand.bigPhoto}">
											<img height="50px" src="${pageContext.request.contextPath}${brand.bigPhoto}"/>
										</a>
									</td>
									<td>
										<a class="like_btn" 
													href="/HgShopSys/back/brand/brandToEdit.do?id=${brand.id }">修改</a>
									</td>
							    </tr>
					    </c:forEach>
					</c:otherwise> 
					  
				</c:choose>	

			<tr class="operation">
				<td align="left" colspan="9">&nbsp;
<!-- 				href=""与href="#"有区别 -->
					<a href="javascript:void(0)" class="like_btn" onclick="checkAll('id')">全选</a>
					<a href="javascript:void(0)" class="like_btn" onclick="cancelCheck('id')">取消选择</a>
					<a href="javascript:void(0)" class="like_btn" onclick="reverseCheck('id')">反选</a>
					<a href="javascript:void(0)" class="like_btn" 
								onclick="deleteChecked('id','/HgShopSys/back/brand/brandDel.do')">删除</a>
					<a target="_blank" class="like_btn" 
								href="/HgShopSys/back/brand/brandToAdd.do">添加品牌</a>
				</td>
			</tr>
  
					<tr class="page"> 
						<td align="right" colspan="9"> 
<%-- 							 <jsp:include page="/WEB-INF/pages/back/brand/page_data.jsp"/> --%>
								<a href="${requestScope.reqUri }?B_CNNAME=${cnName}&B_ENNAME=${enName }&page=${pageData.first }&rows=${pageData.rows}" class="like_btn">首页</a>
								<a href="${requestScope.reqUri }?B_CNNAME=${cnName}&B_ENNAME=${enName }&page=${pageData.pre }&rows=${pageData.rows}" class="like_btn">上一页</a>
								<a href="${requestScope.reqUri }?B_CNNAME=${cnName}&B_ENNAME=${enName }&page=${pageData.next }&rows=${pageData.rows}" class="like_btn">下一页</a>
								<a href="${requestScope.reqUri }?B_CNNAME=${cnName}&B_ENNAME=${enName }&page=${pageData.last }&rows=${pageData.rows}" class="like_btn">尾页</a>
								共${pageData.totalRecordes }条纪录，当前第${pageData.page }
								  
								/${pageData.totalpages }页，每页   
								
								<input type="text" id="rows" 
								   onblur="updateRows('${pageData.rows}',this.value)" size="2" value="${pageData.rows }"/>条记录 
								    
								  <script type="text/javascript">  
										function updateRows(oldRows,newRows){   
											if(oldRows == newRows){ 
												return;
											}  
													var url = "${requestScope.reqUri }"+"?B_CNNAME="+
															"${cnName}"+"&B_ENNAME="+"${enName }"+"&page="
															+"${pageData.first }"+"&rows="+newRows;
													window.location.href = url;
										}
							       </script>
						</td>
					</tr>
					 
				</tbody>
			</table>
		</div>
 
		<form id="SearchForm" method="post" action="/HgShopSys/back/brand/brandList.do" >
			<table id="search" align="center" > 
				<tr>
					<td>中文名称：</td>
					<td>
						<input type="text" name="B_CNNAME" />&nbsp;&nbsp;&nbsp;
					</td>
					<td>英文名称：</td>
					<td>
						<input type="text" name="B_ENNAME"/>
					</td>  
				
				</tr>

				<tr> 
					<td colspan="4" align="center">
					<!-- submit：提交按钮 -->
					<input type="button" id="button" value="搜索" onclick="search()"/>
					   <script type="text/javascript">
								var sv = "${pageData.first}";
								var sr = "${pageData.rows}";
						</script>
						<script type="text/javascript" 
								src = "/HgShopSys/resource/common/js/SearchForm.js">
						</script>
					</td>
				</tr>
			</table>
		</form>
	</body>
	
	<script type="text/javascript"
	       src="/HgShopSys/resource/common/js/utils.js"> 
	</script>
   
	   

</html>