<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="在线购物,网上购物,产品社区,积分兑换">
	<meta name="description" content="豆豆换购商品">
	<title>会员登录 - 在线商城-产品论坛-免费购物-新豆网</title>
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
	<div id="divposition2" style="margin-top:8px;">
		<h2><a href="http://localhost:8080/xindou/default.htm">在线商城-产品论坛-免费购物-宏购网</a><img src="/HgShopSys/resource/frontImage/images/dot-postiont2.gif">用户登录</h2>
	</div>
	<!---position area end-->
<form id="form1" name="form1" method="post" action="/HgShopSys/front/user/login.do">
<div id="bbs-list-nav">
	<div id="bbs-title">
		<h3>用户登录</h3>
	</div>
	<div class="from-nav">
		<div class="Mtitle"><span>用户名:</span></div>
		<div class="Mright"><input name="username" id="username" size="20" class="colorfocus" onfocus="this.className='colorfocus';" onblur="this.className='colorblue';" type="text">  &nbsp; <a href="http://localhost:8080/xindou/register.htm" tabindex="-1" accesskey="r" title="立即注册 (ALT + R)">立即注册</a></div>
	</div>
	<div class="from-nav"> 
		<div class="Mtitle"><span>密码:</span></div>
		<div class="Mright"><input name="password" id="password" size="20" class="colorblue" onfocus="this.className='colorfocus';" onblur="this.className='colorblue';" type="password"> &nbsp; <a href="#" tabindex="-1" accesskey="g" title="忘记密码 (ALT + G)">忘记密码</a></div>
	</div>
	<div class="from-nav">
		<div class="Mtitle"><span>有效时间:</span></div>
		<div class="Mright"><input name="expires" value="5256000" type="radio">永远
							<input name="expires" value="43200" type="radio">一个月  
							<input name="expires" value="1440" type="radio">一天  
							<input name="expires" value="60" type="radio">一小时 
							<input name="expires" value="-1" checked="checked" type="radio">浏览器进程
		</div>
	</div>
	<div class="btn-area">
		<input name="login" id="login" value="登录" class="sbutton" type="submit">&nbsp;&nbsp;
		<input name="cancel" id="cancel" value="取消" class="sbutton" type="reset">
	</div>
</div>
</form>
<script type="text/javascript">
	document.getElementById("username").focus();
</script>
<br> 
</div>

<a name="bottom"></a>
<div id="container">
<!-- Footer Area Begin -->
  <jsp:include page="/WEB-INF/pages/front/foot.jsp"/>
<!-- Footer Area end -->
</div>

</body></html>