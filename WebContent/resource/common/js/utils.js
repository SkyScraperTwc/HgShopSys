	function deleteChecked(checkboxName, deleteUrl) {
			var checkboxObjs = document.getElementsByName(checkboxName);
			var vals = new Array();
			var params = "";
			for (var i = 0; i < checkboxObjs.length; i++) {
				var chObjs = checkboxObjs[i];
				if (chObjs.checked == true) {
					vals.push(chObjs.value);
					params+=chObjs.value+"&id=";
				} 
			} 
//			alert(params);
			if(params.length>0){
				params = params.substring(0, params.length-4);
			}
//			alert(params);
			if (vals.length==0){   
				alert("请选择要删除的记录！");
			}else{
					var b = confirm("您确定要删除选中的记录吗？")
				if(b==true){
//					alert(deleteUrl+"?id="+params);
					window.location.href=deleteUrl+"?id="+params;
				}
			}
		}
	
	//全选	
		function checkAll(checkboxName){
			var checkboxObjs = document.getElementsByName(checkboxName);
			for(var i = 0;i<checkboxObjs.length;i++){
				checkboxObjs[i].checked = true;
			}
		}
	//取消选择	
	    function cancelCheck(checkboxName){
			var checkboxObjs = document.getElementsByName(checkboxName);
			for(var i = 0;i<checkboxObjs.length;i++){
				checkboxObjs[i].checked = false;
			}
		}
	 //反选   
	    function reverseCheck(checkboxName){
			var checkboxObjs = document.getElementsByName(checkboxName);
			for(var i = 0;i<checkboxObjs.length;i++){
			if(checkboxObjs[i].checked==true){
					checkboxObjs[i].checked = false ;
				}else{
					checkboxObjs[i].checked = true;
				}
			}
		}
	    //定义
	    function hightLightShow(){
	    	var listTb = document.getElementById("list_tb");
	    	var trs = listTb.rows;
	    	for(var i = 0;i<trs.length;i++){
		    		if(i>0 && i<trs.length-2){
		    		var tr = trs[i];
		    		//鼠标悬停
		    		tr.onmouseover = function(){
		    			this.style.backgroundColor = "#FFFFBB";
		    		}
		    		//鼠标离开
		    		tr.onmouseout = function(){
		    			this.style.backgroundColor = "";
		    		}
	    		}
	    	}
	    }
