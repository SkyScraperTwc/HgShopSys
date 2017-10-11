<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<html>
	<!--
  menu界面 
-->
 
	<head>
		<!-- title--> 
		<title> 菜单导航页面</title>
		<meta http-equiv="content-type" content="text/html;charset = utf-8" />
    <style>
    	@import url("/HgShopSys/resource/css/menu.css");
    </style>  
	</head> 

	<body> 
		<ul>
			<li> 
				<h2 class = "sup_menu"> 品牌管理 </h2> 
			</li> 
			<ul class="sub_menu"> 
				<!-- target="main" 表示在“name=main”页面显示-->
				<li><a href="/HgShopSys/back/brand/brandToAdd.do" target="main">  品牌添加</a></li>
				<li><a href="/HgShopSys/back/brand/brandList.do" target="main">  品牌列表</a></li>
			</ul>
		</ul> 
		
		<ul>
			<li> 
				<h2 class = "sup_menu"> 分类管理 </h2> 
			</li> 
			<ul class="sub_menu"> 
				<!-- target="main" 表示在“name=main”页面显示-->
				<li><a href="/HgShopSys/back/category/categoryToAdd.do" target="main">  分类添加</a></li>
				<li><a href="/HgShopSys/back/category/categoryList.do" target="main">  分类列表</a></li>
			</ul>
		</ul> 
		
		<ul>
			<li> 
				<h2 class = "sup_menu"> 产品管理 </h2> 
			</li> 
			<ul class="sub_menu"> 
				<!-- target="main" 表示在“name=main”页面显示-->
				<li><a href="/HgShopSys/back/product/productToAdd.do" target="main">  产品添加</a></li>
				<li><a href="/HgShopSys/back/product/productList.do" target="main">  产品列表</a></li>
			</ul>
		</ul> 
		
		<ul>
			<li>
				<h2 class = "sup_menu"> 订单管理 </h2>
			</li>
			<ul class="sub_menu">
				<li><a href="#" target="main">  待审核订单</a></li>
				<li><a href="#" target="main">  已付款订单</a></li>
				<li><a href="#" target="main">  未付款订单</a></li>
				<li><a href="#" target="main">  已发货订单</a></li>
				<li><a href="#" target="main">  未发货订单</a></li>
			</ul>
		</ul>
		 
		<ul> 
			<li>
				<h2 class = "sup_menu"> 用户管理 </h2> 
			</li>
			<ul class="sub_menu">
				<li> <a href="/HgShopSys/back/user/toAdd.do" target="main"> 用户添加</a></li>
				<li><a href="user_list.html" target="main">  用户列表</a></li>
			</ul>
		</ul>
 
		<ul>
			<li> 
				<h2 class = "sup_menu"> 管理员管理 </h2>  
			</li>
			<ul class="sub_menu">
				<li> <a href="/HgShopSys/back/admin/toAdd.do" target="main"> 管理员添加</a></li>
				<li><a href="/HgShopSys/back/admin/list.do" target="main">  管理员列表</a></li>
			</ul>
		</ul>
	</body>
	
<script type="text/javascript">
	var supMenus = document.getElementsByClassName("sup_menu");
	var subMenus = document.getElementsByClassName("sub_menu");
	for(var i = 0; i<supMenus.length;i++){
		var supMenu = supMenus[i];
		
		supMenu.subMenu = subMenus[i];
		
		supMenu.onclick = function(){
			if(this.subMenu.style.display=='none'){
				this.subMenu.style.display = '';
			}else if(this.subMenu.style.display==''){
				this.subMenu.style.display = 'none';
			}
		}
	}
</script>

</html>