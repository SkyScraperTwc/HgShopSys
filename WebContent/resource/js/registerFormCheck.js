/*
	写一个公共的通用的用于鼠标聚焦时的提示函数
	fieldId - 要验证的表单字段域的id
	tipId - 显示提示或错误信息的dom元素id
	tipMsg - 提示的信息
*/
function checkFieldFocus(fieldId,tipId,tipMsg){
	var fieldObj = document.getElementById(fieldId);
	var tipObj = document.getElementById(tipId);
	//让获得焦点的表单域(input)显现高亮
	fieldObj.className = 'text highlight1';
	//显示提示信息
	tipObj.innerHTML = tipMsg;
}

/*校验用户名*/
function checkUsername(){
	//获得表单域对象
	var fieldObj = document.getElementById('username');
	//获得提示信息的div对象
	var errorObj  = document.getElementById('username_error');
	var succedObj = document.getElementById('username_succeed');
	var value = fieldObj.value.trim();//获得用户输入的值
	
	//校验是否为空
	if(validateRules.isNull(value)){
		errorObj.innerHTML = validatePrompt.username.isNull;
		return false;
	}
	//校验长度对不对
	if(!validateRules.betweenLength(value,4,20)){
		errorObj.innerHTML = validatePrompt.username.error.badLength;
		return false;
	}
	
	//校验是不是A-Z,a-z,中文字符组成，这里要用到正则表达式
	if(!validateRules.isUid(value)){
		errorObj.innerHTML = validatePrompt.username.error.badFormat;
		return false;
	}
	
	//把原来设置的提示内容以样式清空掉
	fieldObj.className="text";
	errorObj.innerHTML  = "";
	//succedObj.className = "from-nav blank succeed";
	return true;
}

/*验证密码*/
function checkPassword(){
	var fieldObj = document.getElementById('pwd');//获得用户输入的表单域
	var errorObj = document.getElementById('pwd_error');//获得提示错误的div
	var succedObj = document.getElementById('pwd_succeed');//获得提示成功的div
	var value = fieldObj.value.trim();//获得用户输入的值
	
	//验证是否为空
	if(validateRules.isNull(value)){
		errorObj.innerHTML = validatePrompt.pwd.isNull;
		return false;
	}
	//验证长度
	if(!validateRules.betweenLength(value,6,20)){
		errorObj.innerHTML = validatePrompt.pwd.error.badLength;
		return false;
	}
	//验证是否符合正则表达式规则
	if(!validateRules.isPwd(value)){
		errorObj.innerHTML = validatePrompt.pwd.error.badFormat;
		return false;
	}
	
	//把原来设置的提示内容以样式清空掉
	fieldObj.className="text";
	errorObj.innerHTML  = "";
	//succedObj.className = "from-nav blank succeed";
	return true;
}

/*验证密码2*/
function checkPassword2(){
	var fieldObj = document.getElementById('pwd2');//获得用户输入的表单域
	var errorObj = document.getElementById('pwd2_error');//获得提示错误的div
	var succedObj = document.getElementById('pwd2_succeed');//获得提示成功的div
	var value = fieldObj.value.trim();//获得用户输入的值
	
	//验证是否为空
	if(validateRules.isNull(value)){
		errorObj.innerHTML = validatePrompt.pwd2.isNull;
		return false;
	}
	//验证长度
	if(!validateRules.betweenLength(value,6,20)){
		errorObj.innerHTML = validatePrompt.pwd2.error.badLength;
		return false;
	}
	//验证是否符合正则表达式规则
	if(!validateRules.isPwd(value)){
		errorObj.innerHTML = validatePrompt.pwd2.error.badFormat1;
		return false;
	}
	
	//比较与上一次输入的密码是否相同
	var pwd = document.getElementById('pwd').value;
	if(!validateRules.isPwdRepeat(pwd,value)){
		errorObj.innerHTML = validatePrompt.pwd2.error.badFormat2;
		return false;
	}
	
	//把原来设置的提示内容以样式清空掉
	fieldObj.className="text";
	errorObj.innerHTML  = "";
	//succedObj.className = "from-nav blank succeed";
	return true;
}

/*验证手机*/
function checkMobile(){
	var fieldObj = document.getElementById('mobile');//获得用户输入的表单域
	var errorObj = document.getElementById('mobile_error');//获得提示错误的div
	var succedObj = document.getElementById('mobile_succeed');//获得提示成功的div
	var value = fieldObj.value.trim();//获得用户输入的值
	
	//验证是否为空
	if(validateRules.isNull(value)){
		errorObj.innerHTML = validatePrompt.mobile.isNull;
		return false;
	}
	
	//验证是否符合正则表达式规则
	if(!validateRules.isMobile(value)){
		errorObj.innerHTML = validatePrompt.mobile.error;
		return false;
	}
	
	//把原来设置的提示内容以样式清空掉
	fieldObj.className="text";
	errorObj.innerHTML  = "";
	//succedObj.className = "from-nav blank succeed";
	return true;
}

/*验证邮箱*/
function checkEmail(){
	var fieldObj = document.getElementById('email');//获得用户输入的表单域
	var errorObj = document.getElementById('email_error');//获得提示错误的div
	var succedObj = document.getElementById('email_succeed');//获得提示成功的div
	var value = fieldObj.value.trim();//获得用户输入的值
	
	//验证是否为空
	if(validateRules.isNull(value)){
		errorObj.innerHTML = validatePrompt.email.isNull;
		return false;
	}
	
	//验证长度
	if(!validateRules.maxLength(value,50)){
		errorObj.innerHTML = validatePrompt.email.error.badLength;
		return false;
	}
	
	//验证是否符合正则表达式规则
	if(!validateRules.isEmail(value)){
		errorObj.innerHTML = validatePrompt.email.error.badFormat;
		return false;
	}
	
	//把原来设置的提示内容以样式清空掉
	fieldObj.className="text";
	errorObj.innerHTML  = "";
	//succedObj.className = "from-nav blank succeed";
	return true;
}

/*验证验证码*/
function checkAuthcode(){
	var fieldObj = document.getElementById('authcode');//获得用户输入的表单域
	var errorObj = document.getElementById('authcode_error');//获得提示错误的div
	var succedObj = document.getElementById('authcode_succeed');//获得提示成功的div
	var value = fieldObj.value.trim();//获得用户输入的值
	
	//验证是否为空
	if(validateRules.isNull(value)){
		errorObj.innerHTML = validatePrompt.authcode.isNull;
		return false;
	}
	
	
	//把原来设置的提示内容以样式清空掉
	fieldObj.className="text";
	errorObj.innerHTML  = "";
	return true;
}

/*校验整个表单*/
function checkForm(){
	var isOk1 = checkUsername();
	var isOk2 = checkPassword();
	var isOk3 = checkPassword2();
	var isOk4 = checkMobile();
	var isOk5 = checkEmail();
	var isOk6 = checkAuthcode();
	
	//非常关键，只要一个为false,整体为false,只有全部为true，才为true
	return isOk1&&isOk2&&isOk3&&isOk4&&isOk5&&isOk6;
}


/*初始化整个表单*/
function initForm(){
	//--------用户名
	//获得用户名input 对象
	var usernameInput = document.getElementById('username');
	//注册聚焦事件
	usernameInput.onfocus = function(){
		checkFieldFocus('username','username_error',validatePrompt.username.onFocus);
	}
	//注册失焦事件
	usernameInput.onblur = checkUsername;
	
	//--------密码
	//获得密码input 对象
	var pwdInput = document.getElementById('pwd');
	//注册聚焦事件
	pwdInput.onfocus = function(){
		checkFieldFocus('pwd','pwd_error',validatePrompt.pwd.onFocus);
	}
	//注册失焦事件
	pwdInput.onblur = checkPassword;
	
	//--------重复密码
	//获得重复密码input 对象
	var pwd2Input = document.getElementById('pwd2');
	//注册聚焦事件
	pwd2Input.onfocus = function(){
		checkFieldFocus('pwd2','pwd2_error',validatePrompt.pwd2.onFocus);
	}
	//注册失焦事件
	pwd2Input.onblur = checkPassword2;
	
	//--------手机Mobile
	//获得手机input 对象
	var mobileInput = document.getElementById('mobile');
	//注册聚焦事件
	mobileInput.onfocus = function(){
		checkFieldFocus('mobile','mobile_error',validatePrompt.mobile.onFocus);
	}
	//注册失焦事件
	mobileInput.onblur = checkMobile;
	
	//--------邮箱Email
	//获得Email input 对象
	var emailInput = document.getElementById('email');
	//注册聚焦事件
	emailInput.onfocus = function(){
		checkFieldFocus('email','email_error',validatePrompt.email.onFocus);
	}
	//注册失焦事件
	emailInput.onblur = checkEmail;
	
	//--------验证码
	//获得authcode input 对象
	var authcodeInput = document.getElementById('authcode');
	//注册聚焦事件
	authcodeInput.onfocus = function(){
		checkFieldFocus('authcode','authcode_error',validatePrompt.authcode.onFocus);
	}
	//注册失焦事件
	authcodeInput.onblur = checkAuthcode;
	
	
	//------表单提交时的整体校验
	var registerForm = document.getElementById('register_form');
	//注册表单提交事件
	registerForm.onsubmit = checkForm;//切记后面没有括号

}

initForm();
