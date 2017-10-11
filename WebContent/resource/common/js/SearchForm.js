//SearchForm提交js代码
function search(){
	    var searchPage = document.createElement("input");
	    searchPage.name = "page";
	    searchPage.value = sv;
	    searchPage.type = "hidden";
	    
	    var searchRows = document.createElement("input");
	    searchRows.name = "rows";
	    searchRows.value = sr;
	    searchRows.type = "hidden";
	    
		var sform = document.getElementById("SearchForm");
	    sform.appendChild(searchPage); 
	    sform.appendChild(searchRows);
	    sform.submit();
}