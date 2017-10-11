<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   		 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   		 
   	 <script type="text/javascript" src = "/HgShopSys/resource/common/js/cookie.js">
	</script>
 
<div>
	<div id="header">
		<div id="headerlogo">
<!-- 			<h1><a href="http://localhost:8080/xindou/default.htm" title="在线商城-产品论坛-免费购物-新豆网 - " id="logo"><img src="/HgShopSys/resource/frontImage/images/logo." title="在线商城-产品论坛-免费购物-新豆网 - " border="0"></a></h1> -->
		</div>
		<div id="HeadNavBar">
			<ul id="navlist">
		 
<li style="width: 150px; text-align: right;">欢迎:<span id="usernameSpan">游客</span></li>
		
 <script type="text/javascript">
		var usernameSpan = document.getElementById("usernameSpan");
		var username = "${sessionScope.login_user}";
		if(''!=username && username!=null){
			usernameSpan.innerHTML = username;
		}else{
			usernameSpan.innerHTML = "游客";
		}
</script>
 

		<c:choose>
				<c:when test="${null==sessionScope.login_user}">	
						<li><a href="/HgShopSys/front/user/toRegister.do">注册</a></li>
						<li><a href="/HgShopSys/front/user/toLogin.do">登录</a></li>
				</c:when>	
				
				<c:otherwise>
					<li><a href="/HgShopSys/front/user/logOut.do">[退出]&nbsp;</a></li>
						<li class="message"><img src="/HgShopSys/resource/frontImage/images/mymessage.gif"><a href="http://localhost:8080/xindou/user/usercpinbox.htm">消息</a></li>
						<li class="more"><img src="/HgShopSys/resource/frontImage/images/myxindou.gif"><a href="http://localhost:8080/xindou/user/usercp.htm">控制面板</a></li>
						<li id="my" class="more2" onmouseover="showMenu(this.id);" onmouseout="showMenu(this.id);"><a href="###">我的&nbsp;&nbsp;&nbsp;</a></li>
						
						<div id="my_menu" class="downlist" style="display: none;">
							<h4><span class="last"><a href="http://localhost:8080/xindou/user/usercporder.htm">我的订单</a></span></h4>
							<div class="Dspace2">&nbsp;</div>
							
							<form action="/xindou/search.htm" method="post" name="sch">							
							<input name="author" value="zengqf1985" type="hidden">
							<input name="digest" type="hidden">
							<h4><span class="last"><a href="#"><div onclick="document.sch.submit();">我的主题</div></a></span></h4>
							<div class="Dspace2">&nbsp;</div>
							<h4><span class="last"><a href="#"><div onclick="document.sch.submit();">我的帖子</div></a></span></h4>
							<div class="Dspace2">&nbsp;</div>
							<h4><span class="last"><a href="#"><div onclick="document.sch.digest.value='true';document.sch.submit();">我的精华</div></a></span></h4>						
							</form>
						
						</div>
						<script>
// 							function showMenu(menuId){
// 								 var myMenu = document.getElementById("my_menu");
// 								 if(myMenu.style.display = "block"){
									 
// 								 }
// 							} 
// 							function hideMenu() {
// 								 var myMenu = document.getElementById("my_menu");
								 
// 							}
						</script>
				</c:otherwise>
		</c:choose>		
		
		
		
				<li class="gwc"><img src="/HgShopSys/resource/frontImage/images/gwc.gif"><a href="/HgShopSys/front/shopcart/toPage.do">购物车</a></li>
				<!-- 
					<li><a href="#">在线</a></li> 
				 -->
				 
				<li class="gwc"><a href="#"><b style="color: red">论坛交流区</b></a></li>
				<li class="last"><img src="/HgShopSys/resource/frontImage/images/help.gif"><a href="#">帮助</a></li>
			</ul>
		</div>
		<div id="HeadNavMenuDiv">			 
			<div id="ServicePhoneDiv"><img src="/HgShopSys/resource/frontImage/images/servicephone.gif" alt="客服电话:4008206003"></div>			 
			<div>
				<ul id="HeadNavMenu">
					<li class="ActiveMenu" id="rcDefault" onmouseover="ActiveLi(this)" onmouseout="LeaveLi()"><a href="http://localhost:8080/HgShopSys">首页</a></li>
					
						<li id="rc1" onmouseover="ActiveLi(this)" onmouseout="LeaveLi()"><a href="http://localhost:8080/xindou/rootcategory.htm?id=1">包包</a></li>
					
						<li id="rc2" onmouseover="ActiveLi(this)" onmouseout="LeaveLi()"><a href="http://localhost:8080/xindou/rootcategory.htm?id=2">电脑产品</a></li>
					
						<li id="rc3" onmouseover="ActiveLi(this)" onmouseout="LeaveLi()"><a href="http://localhost:8080/xindou/rootcategory.htm?id=3">数码娱乐</a></li>
					
						<li id="rc4" onmouseover="ActiveLi(this)" onmouseout="LeaveLi()"><a href="http://localhost:8080/xindou/rootcategory.htm?id=4">办公家居</a></li>
					
						<li id="rc5" onmouseover="ActiveLi(this)" onmouseout="LeaveLi()"><a href="http://localhost:8080/xindou/rootcategory.htm?id=5">苹果专区</a></li>

					
				</ul>
			</div>
		</div>
	</div>
</div>
<div id="SearchDiv">
	<div id="SearchBar">
		<div id="SearchCenterBar">
			<div id="searchalldiv">
				<a href="http://localhost:8080/xindou/categorylist.htm" target="_blank"><b>[所有分类]</b></a>&nbsp;
				<a href="http://localhost:8080/xindou/brandlist.htm" target="_blank"><b>[所有品牌]</b></a>&nbsp;
			</div>
			<div id="searchdivs">
				<select name="Header1$ddlSearchType" id="Header1_ddlSearchType">
					<option selected="selected" value="0">搜索商品</option>
					<option value="1">搜索帖子</option>
				</select>
				<input name="tbKey" id="tbKey" class="SearchInput" onkeydown="if(event.keyCode == 13) search2();" type="text">
				<select name="ddlSearchCategory" id="ddlSearchCategory">
					<option selected="selected" value="0">所有分类</option>
					
						<option value="1">
							
								
							包包
						</option>
					
						<option value="7">
							
								
								 &nbsp;&nbsp;
								
							
							手提包
						</option>
					
						<option value="37">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							男式电脑包
						</option>
					
						<option value="38">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							女式电脑包
						</option>
					
						<option value="39">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							手提式内袋
						</option>
					
						<option value="135">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							男式电脑包
						</option>
					
						<option value="136">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							女式电脑包
						</option>
					
						<option value="137">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							手提式内袋
						</option>
					
						<option value="8">
							
								
								 &nbsp;&nbsp;
								
							
							背包
						</option>
					
						<option value="40">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							男式电脑背包
						</option>
					
						<option value="41">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							女式电脑背包
						</option>
					
						<option value="42">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							拉杆背包
						</option>
					
						<option value="43">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲运动背包
						</option>
					
						<option value="138">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							男式电脑背包
						</option>
					
						<option value="139">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							女式电脑背包
						</option>
					
						<option value="140">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							拉杆背包
						</option>
					
						<option value="141">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲运动背包
						</option>
					
						<option value="9">
							
								
								 &nbsp;&nbsp;
								
							
							旅行箱包
						</option>
					
						<option value="44">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							旅行包
						</option>
					
						<option value="45">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							拉杆箱包
						</option>
					
						<option value="46">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							证件袋/钱包
						</option>
					
						<option value="47">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							旅行盥洗包
						</option>
					
						<option value="142">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							旅行包
						</option>
					
						<option value="143">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							拉杆箱包
						</option>
					
						<option value="144">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							证件袋/钱包
						</option>
					
						<option value="145">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							旅行盥洗包
						</option>
					
						<option value="10">
							
								
								 &nbsp;&nbsp;
								
							
							笔记本内袋
						</option>
					
						<option value="48">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							手提式内袋
						</option>
					
						<option value="49">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							普通内袋
						</option>
					
						<option value="146">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							手提式内袋
						</option>
					
						<option value="147">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							普通内袋
						</option>
					
						<option value="11">
							
								
								 &nbsp;&nbsp;
								
							
							数码包
						</option>
					
						<option value="50">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							双肩摄影包
						</option>
					
						<option value="51">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							数码相机/摄像机包
						</option>
					
						<option value="52">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							数码便携包
						</option>
					
						<option value="53">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							CD包/盒
						</option>
					
						<option value="148">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							双肩摄影包
						</option>
					
						<option value="149">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							数码相机/摄像机包
						</option>
					
						<option value="150">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							数码便携包
						</option>
					
						<option value="151">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							CD包/盒
						</option>
					
						<option value="12">
							
								
								 &nbsp;&nbsp;
								
							
							休闲包
						</option>
					
						<option value="54">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲挎包
						</option>
					
						<option value="55">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲腰包
						</option>
					
						<option value="56">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲单肩包
						</option>
					
						<option value="57">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲双肩背包
						</option>
					
						<option value="152">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲挎包
						</option>
					
						<option value="153">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲腰包
						</option>
					
						<option value="154">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲单肩包
						</option>
					
						<option value="155">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							休闲双肩背包
						</option>
					
						<option value="13">
							
								
								 &nbsp;&nbsp;
								
							
							多功能包
						</option>
					
						<option value="58">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							车载用包
						</option>
					
						<option value="156">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							车载用包
						</option>
					
						<option value="105">
							
								
								 &nbsp;&nbsp;
								
							
							手提包
						</option>
					
						<option value="106">
							
								
								 &nbsp;&nbsp;
								
							
							背包
						</option>
					
						<option value="107">
							
								
								 &nbsp;&nbsp;
								
							
							旅行箱包
						</option>
					
						<option value="108">
							
								
								 &nbsp;&nbsp;
								
							
							笔记本内袋
						</option>
					
						<option value="109">
							
								
								 &nbsp;&nbsp;
								
							
							数码包
						</option>
					
						<option value="110">
							
								
								 &nbsp;&nbsp;
								
							
							休闲包
						</option>
					
						<option value="111">
							
								
								 &nbsp;&nbsp;
								
							
							多功能包
						</option>
					
						<option value="2">
							
								
								
								
							
							电脑产品
						</option>
					
						<option value="14">
							
								
								 &nbsp;&nbsp;
								
							
							存储设备
						</option>
					
						<option value="59">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							U盘
						</option>
					
						<option value="60">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							硬盘
						</option>
					
						<option value="61">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							光盘
						</option>
					
						<option value="62">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							闪存卡
						</option>
					
						<option value="63">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							外置盒
						</option>
					
						<option value="64">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							移动硬盘
						</option>
					
						<option value="65">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							网络硬盘
						</option>
					
						<option value="66">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							磁盘阵列
						</option>
					
						<option value="67">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							数据磁带
						</option>
					
						<option value="68">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							硬盘抽取盒/模组
						</option>
					
						<option value="157">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							U盘
						</option>
					
						<option value="158">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							硬盘
						</option>
					
						<option value="159">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							光盘
						</option>
					
						<option value="160">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							闪存卡
						</option>
					
						<option value="161">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							外置盒
						</option>
					
						<option value="162">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							移动硬盘
						</option>
					
						<option value="163">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							网络硬盘
						</option>
					
						<option value="164">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							磁盘阵列
						</option>
					
						<option value="165">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							数据磁带
						</option>
					
						<option value="166">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							硬盘抽取盒/模组
						</option>
					
						<option value="15">
							
								
								 &nbsp;&nbsp;
								
							
							笔记本及周边
						</option>
					
						<option value="69">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							迷你笔记本电脑
						</option>
					
						<option value="70">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							品牌原装配件
						</option>
					
						<option value="167">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							迷你笔记本电脑
						</option>
					
						<option value="168">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							品牌原装配件
						</option>
					
						<option value="16">
							
								
								 &nbsp;&nbsp;
								
							
							输入输出设备
						</option>
					
						<option value="71">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							键盘鼠标
						</option>
					
						<option value="72">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							鼠标垫/护腕垫
						</option>
					
						<option value="169">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							键盘鼠标
						</option>
					
						<option value="170">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							鼠标垫/护腕垫
						</option>
					
						<option value="17">
							
								
								 &nbsp;&nbsp;
								
							
							接口设备
						</option>
					
						<option value="73">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							接口卡
						</option>
					
						<option value="74">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							USB集线器
						</option>
					
						<option value="171">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							接口卡
						</option>
					
						<option value="172">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							USB集线器
						</option>
					
						<option value="18">
							
								
								 &nbsp;&nbsp;
								
							
							线材类
						</option>
					
						<option value="75">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							USB/1394线
						</option>
					
						<option value="76">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							网络/电话线
						</option>
					
						<option value="173">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							USB/1394线
						</option>
					
						<option value="174">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							网络/电话线
						</option>
					
						<option value="19">
							
								
								 &nbsp;&nbsp;
								
							
							音频/视频设备
						</option>
					
						<option value="77">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							耳机耳麦
						</option>
					
						<option value="78">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							音响
						</option>
					
						<option value="175">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							耳机耳麦
						</option>
					
						<option value="176">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							音响
						</option>
					
						<option value="20">
							
								
								 &nbsp;&nbsp;
								
							
							电源设备
						</option>
					
						<option value="79">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							电源插座
						</option>
					
						<option value="80">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							变压器
						</option>
					
						<option value="177">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							电源插座
						</option>
					
						<option value="178">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							变压器
						</option>
					
						<option value="21">
							
								
								 &nbsp;&nbsp;
								
							
							网络设备
						</option>
					
						<option value="81">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							宽带路由器
						</option>
					
						<option value="82">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							网卡
						</option>
					
						<option value="179">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							宽带路由器
						</option>
					
						<option value="180">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							网卡
						</option>
					
						<option value="112">
							
								
								 &nbsp;&nbsp;
								
							
							存储设备
						</option>
					
						<option value="113">
							
								
								 &nbsp;&nbsp;
								
							
							笔记本及周边
						</option>
					
						<option value="114">
							
								
								 &nbsp;&nbsp;
								
							
							输入输出设备
						</option>
					
						<option value="115">
							
								
								 &nbsp;&nbsp;
								
							
							接口设备
						</option>
					
						<option value="116">
							
								
								 &nbsp;&nbsp;
								
							
							线材类
						</option>
					
						<option value="117">
							
								
								 &nbsp;&nbsp;
								
							
							音频/视频设备
						</option>
					
						<option value="118">
							
								
								 &nbsp;&nbsp;
								
							
							电源设备
						</option>
					
						<option value="119">
							
								
								 &nbsp;&nbsp;
								
							
							网络设备
						</option>
					
						<option value="3">
							
								
								
								
							
							数码娱乐
						</option>
					
						<option value="22">
							
								
								 &nbsp;&nbsp;
								
							
							GPS设备
						</option>
					
						<option value="83">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							车载GPS导航
						</option>
					
						<option value="84">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							手持GPS导航
						</option>
					
						<option value="181">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							车载GPS导航
						</option>
					
						<option value="182">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							手持GPS导航
						</option>
					
						<option value="23">
							
								
								 &nbsp;&nbsp;
								
							
							车载电子
						</option>
					
						<option value="85">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							车载交流供电器
						</option>
					
						<option value="183">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							车载交流供电器
						</option>
					
						<option value="24">
							
								
								 &nbsp;&nbsp;
								
							
							影音设备
						</option>
					
						<option value="86">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							MP3/MP4播放器
						</option>
					
						<option value="184">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							MP3/MP4播放器
						</option>
					
						<option value="25">
							
								
								 &nbsp;&nbsp;
								
							
							游戏玩具
						</option>
					
						<option value="87">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							电子宠物
						</option>
					
						<option value="185">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							电子宠物
						</option>
					
						<option value="26">
							
								
								 &nbsp;&nbsp;
								
							
							手机通讯
						</option>
					
						<option value="88">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							手机配件大全
						</option>
					
						<option value="186">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							手机配件大全
						</option>
					
						<option value="27">
							
								
								 &nbsp;&nbsp;
								
							
							数码存储
						</option>
					
						<option value="89">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							闪存卡
						</option>
					
						<option value="187">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							闪存卡
						</option>
					
						<option value="28">
							
								
								 &nbsp;&nbsp;
								
							
							数码周边配件
						</option>
					
						<option value="90">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							三脚架
						</option>
					
						<option value="188">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							三脚架
						</option>
					
						<option value="120">
							
								
								 &nbsp;&nbsp;
								
							
							GPS设备
						</option>
					
						<option value="121">
							
								
								 &nbsp;&nbsp;
								
							
							车载电子
						</option>
					
						<option value="122">
							
								
								 &nbsp;&nbsp;
								
							
							影音设备
						</option>
					
						<option value="123">
							
								
								 &nbsp;&nbsp;
								
							
							游戏玩具
						</option>
					
						<option value="124">
							
								
								 &nbsp;&nbsp;
								
							
							手机通讯
						</option>
					
						<option value="125">
							
								
								 &nbsp;&nbsp;
								
							
							数码存储
						</option>
					
						<option value="126">
							
								
								 &nbsp;&nbsp;
								
							
							数码周边配件
						</option>
					
						<option value="4">
							
								
								
								
							
							办公家居
						</option>
					
						<option value="29">
							
								
								 &nbsp;&nbsp;
								
							
							办公设备
						</option>
					
						<option value="91">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							多功能一体机
						</option>
					
						<option value="189">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							多功能一体机
						</option>
					
						<option value="30">
							
								
								 &nbsp;&nbsp;
								
							
							办公周边及耗材
						</option>
					
						<option value="92">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							多媒体演讲器
						</option>
					
						<option value="190">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							多媒体演讲器
						</option>
					
						<option value="31">
							
								
								 &nbsp;&nbsp;
								
							
							小家电
						</option>
					
						<option value="93">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							空气净化器
						</option>
					
						<option value="191">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							空气净化器
						</option>
					
						<option value="127">
							
								
								 &nbsp;&nbsp;
								
							
							办公设备
						</option>
					
						<option value="128">
							
								
								 &nbsp;&nbsp;
								
							
							办公周边及耗材
						</option>
					
						<option value="129">
							
								
								 &nbsp;&nbsp;
								
							
							小家电
						</option>
					
						<option value="5">
							
								
								
								
							
							苹果专区
						</option>
					
						<option value="32">
							
								
								 &nbsp;&nbsp;
								
							
							苹果iPhone专区
						</option>
					
						<option value="94">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							iPhone3G手机
						</option>
					
						<option value="192">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							iPhone3G手机
						</option>
					
						<option value="33">
							
								
								 &nbsp;&nbsp;
								
							
							苹果iPod专区
						</option>
					
						<option value="95">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							苹果iPod播放器
						</option>
					
						<option value="193">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							苹果iPod播放器
						</option>
					
						<option value="34">
							
								
								 &nbsp;&nbsp;
								
							
							苹果电脑
						</option>
					
						<option value="96">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							苹果笔记本电脑
						</option>
					
						<option value="194">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							苹果笔记本电脑
						</option>
					
						<option value="130">
							
								
								 &nbsp;&nbsp;
								
							
							苹果iPhone专区
						</option>
					
						<option value="131">
							
								
								 &nbsp;&nbsp;
								
							
							苹果iPod专区
						</option>
					
						<option value="132">
							
								
								 &nbsp;&nbsp;
								
							
							苹果电脑
						</option>
					
						<option value="6">
							
								
								
								
							
							礼品团购区
						</option>
					
						<option value="35">
							
								
								 &nbsp;&nbsp;
								
							
							小家电
						</option>
					
						<option value="97">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							电子玩具
						</option>
					
						<option value="195">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							电子玩具
						</option>
					
						<option value="36">
							
								
								 &nbsp;&nbsp;
								
							
							家居用品
						</option>
					
						<option value="98">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							保温杯
						</option>
					
						<option value="196">
							
								
								
								 &nbsp;&nbsp; &nbsp;&nbsp;
							
							保温杯
						</option>
					
						<option value="133">
							
								
								 &nbsp;&nbsp;
								
							
							小家电
						</option>
					
						<option value="134">
							
								
								 &nbsp;&nbsp;
								
							
							家居用品
						</option>
					
						<option value="99">
							
								
								
								
							
							包包
						</option>
					
						<option value="100">
							
								
								
								
							
							电脑产品
						</option>
					
						<option value="101">
							
								
								
								
							
							数码娱乐
						</option>
					
						<option value="102">
							
								
								
								
							
							办公家居
						</option>
					
						<option value="103">
							
								
								
								
							
							苹果专区
						</option>
					
						<option value="104">
							
								
								
								
							
							礼品团购区
						</option>
					
				</select>
				<input name="ibSearch" value="" onclick="search();" id="ibSearch" class="SearchButton" style="background-color: red;" type="button">&nbsp;
				<input name="ibBlurSearch" value="" onclick="blursearch();" id="ibBlurSearch" class="BlurSearchButton" type="button">
			</div>
			<div id="SearchPromotionDiv"><a href="http://localhost:8080/xindou/promotion.htm" target="_blank"> <img src="/HgShopSys/resource/frontImage/images/xindoutime.gif"></a></div>
		</div>
	</div>
</div>

<script type="text/javascript"> 
 
	function LeaveLi()
	{
	    var lis = document.getElementById("HeadNavMenu").getElementsByTagName("li");
	    for(var i=0;i<lis.length;i++)
			{ 
				lis[i].className = "NormalMenu"; 
			}  
		var rcactive = document.getElementById('rc'); 
	    if(rcactive)
	        rcactive.className = "ActiveMenu";
	    else
	        document.getElementById('rcDefault').className="ActiveMenu";
			
	}
	var rcactive = document.getElementById('rc');
	if(rcactive)
		rcactive.className = "ActiveMenu";
	else
		document.getElementById('rcDefault').className="ActiveMenu";
</script>