<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head> 
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="在线购物,网上购物,产品社区,积分兑换">
	<meta name="description" content="豆豆换购商品">
	  
	<!-- 以下方式定时转到其他页面 -->
<!-- 	<meta http-equiv="refresh" content="3;url=/HgShopSys">  -->
	
	<title>登陆成功 - 在线商城-产品论坛-免费购物-新豆网</title>
	<link rel="stylesheet" href="/HgShopSys/resource/css/dnt.css" type="text/css" media="all">
	<link rel="stylesheet" href="/HgShopSys/resource/css/new.css" type="text/css" media="all">
  </head>
  
  <body>

<a name="top"></a>
	<!---header area start--->
		 <jsp:include page="/WEB-INF/pages/front/head.jsp"/>
	<!---header area end--->
	
<div id="container">
	<!---position area start-->
	<div id="divposition">
		<h2><a href="http://localhost:8080/xindou/default.htm">在线商城-产品论坛-免费购物-宏购网</a> &gt; 会员登录</h2>
	</div>
	<!---position area end-->
	<br>
	<br>
	<div style="border:1px solid #B4C9E0;padding:1px;background-color:#F5FAFE;text-align:center;clear:both;">
		<div class="fgreen" style="margin:0 auto;padding:15px;width:60%;background:url(templates/default//HgShopSys/resource/frontImage/images/btn-true.gif) no-repeat left center;">
			<div style="line-height:22px;padding-left:45px;text-align:center;">${requestScope.global_message}<br>
				<span class="history-back" style="text-align:center;">  
						
							<a id = "targetUrl" href="">如果浏览器没有转向, 请点击这里.</a>
							
				</span>
			</div>
		</div>
		<div style="clear:both;"></div>
	</div>
</div>

  <!-- Footer Area Begin -->
  <jsp:include page="/WEB-INF/pages/front/foot.jsp"/>
  <!-- Footer Area end -->
  
<script type = "text/javascript">
 		var targetUrl = document.getElementById("targetUrl");
 		var nextUrl = '${requestScope.nextUrl}';
 		targetUrl.href = nextUrl;
		setTimeout("toPage('"+nextUrl+"')",3000);
		
		function toPage(url){
			if(url){
				window.location.href = url; 
			}
 		}
</script>

</body></html>