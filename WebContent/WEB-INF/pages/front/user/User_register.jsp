<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta name="keywords" content="在线购物,网上购物,产品社区,积分兑换">
		<meta name="description" content="宏购换购商品">
		<title>用户注册 - 在线商城-产品论坛-免费购物-新豆网</title>
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
				<h2><a href="http://localhost:8080/xindou/default.htm">在线商城-产品论坛-免费购物-宏购网</a> &gt; 用户注册</h2>
			</div>
			<!---position area end-->
			<!---reg area start--->
			<form id="register_form" name="form"  method="post" action="/HgShopSys/front/user/register.do">
				<!-- onsubmit="return checkForm()" -->
				<div id="bbs-list-nav">
					<div id="bbs-title">
						<h3>填写注册信息</h3></div>
					<div class="detail-message2" style="text-align:left;">必填</div>

					<div class="from-nav">
						<div class="Mtitle"><span>用户名:</span></div>
						<div class="Mright">
							<input name="username" id="username" value = "${param['username']}" maxlength="20" class="text" type="text">
							<label class="blank" id="username_succeed"></label>
							<div id="username_error">${errors.username}</div>
						</div> 
					</div>
					<div class="from-nav">
						<div class="Mtitle"><span>密码:</span></div>
						<div class="Mright">
							<input name="pwd" id="pwd" class="text" onkeyup="return loadinputcontext(this);" type="password">
							<label class="blank" id="pwd_succeed"></label>
							<div id="pwd_error">${errors['pwd']}</div>
						</div>
					</div>
					<div class="from-nav">
						<div class="Mtitle">
							<span>重复输入密码:</span>
						</div>
						<div class="Mright">
							<input name="pwd2" id="pwd2" class="text" onfocus="this.className='text highlight1';" onblur="this.className='text';checkrepassword();" type="password">
							<label class="blank" id="pwd2_succeed"></label>
							<div id="pwd2_error">${errors['pwd2']}</div>
						</div>
					</div>
					<div class="from-nav">
						<div class="Mtitle">
							<span>手机号码:</span>
						</div>
						<div class="Mright">
							<input name="mobile" value = "${param['mobile']}" id="mobile" size="30" class="text" onfocus="this.className='text highlight1';" onblur="this.className='text';checkmobile();" type="text">
							<label class="blank" id="mobile_succeed"></label>
							<div id="mobile_error">${errors['mobile']}</div>
						</div>
					</div>
					<div class="from-nav">
						<div class="Mtitle">
							<span>Email:</span>
						</div>
						<div class="Mright">
							<input name="email"value = "${param['email']}" id="email" size="30" class="text" onfocus="this.className='text highlight1';" onblur="this.className='text';checkemail();" type="text">
							<label class="blank" id="email_succeed"></label>
							<div id="email_error">${errors['email']}</div>
						</div>
					</div>
					
					
					<!--验证码-->
					<div class="from-nav">
						<div class="Mtitle"><span>验证码:</span></div>
						<div class="Mright">
							<input name="authcode" id="authcode" maxlength="4" class="text text-1" onfocus="this.className='text text-1 highlight1 ';" onblur="this.className='text text-1';checkseccode();" type="text" style="width:50px">
							<span ><img id="authcodeImg" src="/HgShopSys/authcode.img" onclick="getAuthcode()" style = "vertical-align: middle"></span>
							
							<label>&nbsp;看不清？<a style="text-decoration:underline" onclick="getAuthcode()" href="javascript:void(0)">换一张</a></label>
							<div id="authcode_error">${errors['authcode']}</div>
						</div>
					</div>
					
					
					
					
					
					
					<div class="btn-area">
						<input name="submit" class="sbutton" value="创建用户" type="submit">
						<input class="sbutton" onclick="images:location.replace('/')" value="取消" type="button">
					</div>
				</div>
				<div id="bbs-list-nav" style="margin-top:2px;">
					<div id="bbs-title">
						<h3>
				填写可选项
			</h3>
						<div id="open">
							<a href="###" onclick="toggle_collapse('regoptions');"><img id="regoptions_img" src="/HgShopSys/resource/frontImage/images/open_yes.gif" alt="展开">
							</a>
						</div>
					</div>

					<!---reg area end--->

				</div>
			</form>

			<a name="bottom"></a>
			<div id="container">
				<!-- Footer Area Begin -->
					  <jsp:include page="/WEB-INF/pages/front/foot.jsp"/>
				<!-- Footer Area end -->
		     	</div>

		</div> 
	</body> 
	
	<!-- 引入验证的js文件 -->
		
	<script type="text/javascript" src="/HgShopSys/resource/js/registerFormCheck.js"></script>
	<script type="text/javascript" src="/HgShopSys/resource/common/js/util.js"></script>
	<script type="text/javascript" src="/HgShopSys/resource/common/js/validate.js"></script>
		<script type="text/javascript">
		 		function getAuthcode(){
		 			var authcodeImg = document.getElementById("authcodeImg");
		 			authcodeImg.src = "/HgShopSys/authcode.img?xx="+Math.random();
// 		 			alert(authcodeImg.src);
		 		}
		</script>
</html>