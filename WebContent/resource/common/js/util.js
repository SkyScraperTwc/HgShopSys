/*去掉2端空白*/
String.prototype.trim=function(){
        return this.replace(/(^\s*)|(\s*$)/g, "");
}
/*去掉左边空白 */
String.prototype.ltrim=function(){
        return this.replace(/(^\s*)/g,"");
}
/*去掉右边空白 */
String.prototype.rtrim=function(){
        return this.replace(/(\s*$)/g,"");
}
/*设置class*/
function setClass(el, classname){
	el.className = classname;
}
/*判断是否包含指定class*/
function hasClass(ele, cls){
	return ele.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
}

/*添加一个class*/
function addClass(ele, cls){
	if(!hasClass(ele, cls)){
		ele.className += " " + cls;
	}
}
/*删除一个class*/
function removeClass(ele, cls){
	if(hasClass(ele, cls)) {
		var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
		ele.className = ele.className.replace(reg, ' ');
	}
}


/*全选*/
function checkAll(checkboxName){
	var objs = document.getElementsByName(checkboxName);
	for(i=0;i<objs.length;i++){
		 if(objs[i].type.toLowerCase() == "checkbox" ){
		 	objs[i].checked = true;
		 }
	}
}

/*取消选择*/
function cancelCheck(checkboxName){
	var objs = document.getElementsByName(checkboxName);
	for(i=0;i<objs.length;i++){
		 if(objs[i].type.toLowerCase() == "checkbox" ){
		 	objs[i].checked = false;
		 }
	}
}

/*反选*/
function reverseCheck(checkboxName){
	var objs = document.getElementsByName(checkboxName);
	for(i=0;i<objs.length;i++){
		 if(objs[i].type.toLowerCase() == "checkbox" ){
		 	if(objs[i].checked){
				objs[i].checked= false;
			}else{
				objs[i].checked = true;	
			}
		 }
	}
}

/*删除所选项*/
function deleteChecked(checkboxName,url){
	var objs = document.getElementsByName(checkboxName);
	
	var param = 'id=';
	var isChecked=false;
	for(i=0;i<objs.length;i++){
		 if(objs[i].type.toLowerCase() == "checkbox" ){
		 	if(objs[i].checked){
				param += objs[i].value+"_";
				isChecked = true;
			}
		 }
	}
	
	if(isChecked){
		var bool = window.confirm('您确定删除所选的项吗？');
		if(bool){
			var handler = function(data){
				if(eval(data)==true){
					window.location.reload(null);
				}else{
					alert("删除失败");
				}
			}
			//这里提交到删除的地方
			AjaxUtil.post(url, param, handler);
		}
	}else{
		window.alert("请选择您要删除的项！");
	}
}

/*兼容IE的getElementsByClassName(),node和tag两2上参数可选*/
var getElementsByClassName = function(searchClass,node,tag) {
        var classElements = new Array();
        if ( node == null )
                node = document;
        if ( tag == null )
                tag = '*';
        var els = node.getElementsByTagName(tag);
        var elsLen = els.length;
        var pattern = new RegExp("(^|\\s)"+searchClass+"(\\s|$)");
        for (var i = 0, j = 0; i < elsLen; i++) {
                if ( pattern.test(els[i].className) ) {
                        classElements[j] = els[i];
                        j++;
                }
        }
        return classElements;
}

/*
 * 用来得到某个对象在数组中的下标
 * */
function indexOf(o,arr){
	if(arr instanceof Array){
		for(var i=0;i<arr.length;i++){
			if(o==arr[i]){
				return i;
			}
		}
	}
	
	return -1;
}

/*隐藏，可以传入单个或者数组*/
function hide(o){
		if(o){
			if(o instanceof Array){
				for(var i=0;i<o.length;i++){
					o[i].style.display ="none";
				}
			}else{
					o.style.display = "none";
					
			}
		}
	}
/*显示，可以传入单个或者数组*/
function show(o){
	if(o){
			if(o instanceof Array){
				for(var i=0;i<o.length;i++){
					o[i].style.display ="block";
			}
		}else{
			o.style.display = "block";
		}
	}
}

/*- 跨浏览器的事件处理工具--*/
var EventUtil = {
    addHandler: function(element, type, handler) {
        if (element.addEventListener) {
            element.addEventListener(type, handler, false);
        } else if (element.attachEvent) {
            element.attachEvent("on" + type, handler);
        } else {
            element["on" + type] = handler;
        }
    },
    removeHandler: function(element, type, handler) {
        if (element.removeEventListener) {
            element.removeEventListener(type, handler, false);
        } else if (element.attachEvent) {
            element.detachEvent("on" + type, handler);
        } else {
            element["on" + type] = null;
        }
    },
    getEvent:function(event) {
        return event ? event: window.event;
    },
    getTarget: function(event) {
        return event.target || event.srcElement;
    },
    removeHandler: function(element, type, handler) {
        if (element.removeEventListener) {
            element.removeEventListener(type, handler, false);
        } else if (element.attachEvent) {
            element.detachEvent("on" + type, handler);
        } else {
            element["on" + type] = null;
        }
    }
};

/**
 * ajax工具对象
 */
var AjaxUtil = {
		get:function(url,params,handler){
		  	AjaxUtil.ajax('GET',url,params,handler);
		},
		post:function(url,params,handler){
			AjaxUtil.ajax('POST',url,params,handler);
		},
		
		ajax : function(method,url,params,handler){
			var xmlHttp = false;			
			if(window.XMLHttpRequest){
				xmlHttp = new XMLHttpRequest();//非IE
			}else if(window.ActiveXObject){
				try{
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); //IE6.0之后
				}catch(e){
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//IE6.0之前 
				}
			}
			
			if(!xmlHttp){
				alert("您的浏览器不支持ajax,请更换浏览器再访问 !");
				return;
			}

			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					if(handler){
						handler(xmlHttp.responseText);
					}
				}
			};

			if("POST"==method.toUpperCase()){			
				xmlHttp.open('POST',url,true);
				xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xmlHttp.send(params);
			}else {
				if(params){
					url = url+"?"+params;
				}
				xmlHttp.open('GET',url,true);
				xmlHttp.send(null);
			}
		}
}
