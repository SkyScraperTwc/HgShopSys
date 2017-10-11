<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   		 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="在线购物,网上购物,产品社区,积分兑换">
	<meta name="description" content="豆豆换购商品">
	<title> 在线商城-产品论坛-免费购物-新豆网</title>
	<link rel="stylesheet" href="/HgShopSys/resource/css/dnt.css" type="text/css" media="all"/>
	<link rel="stylesheet" href="/HgShopSys/resource/css/new.css" type="text/css" media="all"/>
	<link rel="stylesheet" href="/HgShopSys/resource/css/shop.css" type="text/css" media="all"/>
  </head>
  
  <body>
      
  
   
<a name="top"></a>
<!---header area start--->
		<jsp:include page="/WEB-INF/pages/front/head.jsp"/>
	<!---header area end--->

    




<div id="container">
	<div id="Content">
		<div id="Cart-list-nav">
			<div id="TitleBar"><h2>我的购物车</h2></div>
			<div id="CartDiv">
				<div class="CartHead-th">
					<div class="CartHead-th-l">商品名称</div>
					<div class="CartHead-th-r">
						<div class="CartHeadTitle">价格</div>
						<div class="CartHeadTitle">颜色</div>
						<div class="CartHeadTitle">数量</div>
						<div class="CartHeadTitle">小计</div>
						<div class="CartHeadTitle">删除</div>
					</div>
				</div>
				




<script type="text/javascript" src="shopcart_files/prototype.js"></script>
<script type="text/javascript">
<!--
	
		function reflashCart()
		{
		  	var url = '/xindou/shopcart.do';
		  	var param = "cookiestr="+getCookie('shopcart');		  
		  	var a=new Ajax.Request(
		  		url,
		  		{
		  			method:'get',
		  			parameters:param,
		  			onComplete:deal
		  		});		  
		}
	  function deal(ajax)
	  {
	  	alert(ajax.responseText);
	  	$("UpdatePanel1").innerHTML=ajax.responseText;
	  }		
	
	function doDelete(pid,pname,cid)
	{
		var confirmstr = "确定删除商品";
		if(pname!=null) {confirmstr=confirmstr+" 『"+pname+"』 ";}		
		confirmstr+="?";
		if(window.confirm(confirmstr))
		{
			deleteProduct(pid,cid);
			reflashCart();
			alert('删除成功！');
		}
	}
	
	function doModify(pid,amt,cid)
	{
		if(window.confirm("确定修改商品数量?"))
		{
			modifyProduct(pid,amt,cid);
			reflashCart();
			alert('修改成功！');
		}		
	}
	
	//alert(getCookie('shopcart'));
	
//-->
</script>	


<div id="UpdatePanel1">
                        <!-- loop start -->
                        <c:forEach items="${sessionScope['SHOPCART'].items  }" var="entry">
                          <c:set var="item" value="${entry.value }" />
                                <div class="ProductList" onmouseover="this.className='ProductListOn'" onmouseout="this.className='ProductList'" id="103">
                                    <div class="ProductList-th-r">
                                    	<input id="pri103" style="display: none;" value="${item.product.discountedPrice }">
                                    	
                                        <div class="ProductTitle">
                                        	${item.product.discountedPrice } 
                                        </div>  
                                        
                                        <div class="ProductTitle">    
                                          ${item.product.color }                                      
                                        </div>  
                                           
                                        <div class="ProductTitle"> 
                                            <input name="rpProduct$ctl00$tbQuantity" 
                                            value="${item.count }"     
                                             style="width: 50px;" type="text"
                                             onblur="updateCount('${item.product.id}','${item.count }',this.value)"
                                             />
                                             <script type="text/javascript">
												function updateCount(id,oldCount,newCount){ 
// 													alert(oldCount+"-----"+count);
													if(oldCount == newCount){
														return;
													} 
														var b = confirm("您确定修改数量吗？");
														if(b){ 
															window.location.href="/HgShopSys/front/shopcart/scUpdate.do?id="+id+"&count="+newCount; 
														}
													}	   
                                    	</script>
                                        </div> 
                                        
                                        <div class="ProductTitle">
                                        	${item.subTotal }                         
                                        </div>
                                        
                                        <div class="ProductTitle">&nbsp;
                                            <a id="rpProduct_ctl00_btnDelete"  
                                            href="/HgShopSys/front/shopcart/scDel.do?id=${item.product.id }">删除</a>
                                        </div>
                                        
                                    </div> 
                                    <div class="ProductList-th-l">
                                    <a href="/HgShopSys/front/product/productDetail.do?id=${item.product.id }" target="_blank">${item.product.name }</a>                                        
                                    </div>
                                </div> 
                           </c:forEach>
                        
                        
                        <div id="ProductBottomDiv">
                            <div id="ProductBottom-l">
                                <a href="/HgShopSys/index.jsp">
                              	  <img src="/HgShopSys/resource/frontImage/images/continue.gif" border="0">
                                </a> 
                                <a href="/HgShopSys/front/shopcart/scClear.do">清空购物车</a>
                            </div>
                            <div id="ProductBottom-c">
                                <b>商品金额总计:￥
                                	<font style="color:Red"> 
                                		<span id="lbTotalPrice">                                			
                                		<!-- 商品金额总计 -->
                                          	${sessionScope['SHOPCART'].total}                          
                                		</span>
                                	</font>元
                                </b>
                            </div>
                            <div id="ProductBottom-r">
                                <a href="Order_checkout.html"><img src="/HgShopSys/resource/frontImage/images/checkout.gif"></a> 
                            </div>
                        </div>
                        
</div>
			</div>
		</div>
	</div>
	<br>
	<div style="height:150px"></div>
</div>
 
    
<a name="bottom"></a>
<div id="container">
<!-- Footer Area Begin -->
 	  <jsp:include page="/WEB-INF/pages/front/foot.jsp"/>
<!-- Footer Area end -->
</div>

  


</body></html>