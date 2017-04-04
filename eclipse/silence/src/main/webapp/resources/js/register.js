$(function() {
	topMobile('backPrevious()', '返回', '登录', 'openPopup()', 'icon-plus-circle', '');
	
	
});

function register() {
	var data = {};
	var nikename = $('#nikename').val().trim();
	if(nikename.length == 0) {
		alert("昵称不能为空");
		return ;
	}
	var username = $('#username').val().trim();
	var emailt = /^([\.a-zA-Z0-9_-])+@([\.a-zA-Z0-9_-])+(\.[cn_-])+/;
	if(username.length == 0) {
		alert("邮箱不能为空");
		return ;
	} else if(!emailt.test(username)) {
		alert("邮箱格式不正确");
		return ;
	}
	var password = $('#password').val().trim();
	if(password.length == 0) {
		alert("昵称不能为空");
		return ;
	}
	data.nikename = nikename;
	data.username = username;
	data.password = password;
	silence.ajaxCurrent('/silence/user/userRegister', data,
		function(data) {
			console.log(data);
		},
		function(data) {
			console.log(data);
		}
	);
}