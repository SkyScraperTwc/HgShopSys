//tab切换
var selectTab = 0;
var changeDivs = document.getElementById("ProductImageList")
	.getElementsByTagName('div');
var changeHeads = document.getElementById("ProductImageHead")
    .getElementsByTagName("div");
var ProductImageListDivs = document.getElementById("ProductImageList").
	getElementsByTagName("div");

function changeTab(){

	selectTab++;
	if(selectTab>=changeDivs.length){
		selectTab = 0;
	}
	select(selectTab);
}
function select(index){
	
	for(var i = 0;i<changeDivs.length;i++){
		changeHeads[i].className = "PITab";
		if(index==i){
			changeHeads[i].className = "PITabActive";
		}else{
			
		}
	}
	
	for(var i = 0;i<changeDivs.length;i++){
		if(index==i){
			changeDivs[i].style.display = "block";
		}else{
			changeDivs[i].style.display = "none";
		}
	}
}
//div捆绑
function bindActions () {
	for(var i = 0;i<changeDivs.length;i++){
		
		changeHeads[i].TabIndex = i;
		//注册监听
		changeHeads[i].onmouseover = function() {
			select(this.TabIndex);
			clearInterval(time);
		}
		//注册监听
		changeHeads[i].onmouseout = function () {
			time = setInterval('changeTab()',1000);
		}
		
		ProductImageListDivs[i].TabIndex = i;
		//注册监听
		ProductImageListDivs[i].onmouseover = function() {
			select(this.TabIndex);
			clearInterval(time);
		}
	    //注册监听
		ProductImageListDivs[i].onmouseout = function () {
			time = setInterval('changeTab()',1000);
		}
	}
}
bindActions();
var time = setInterval('changeTab()',1000);

