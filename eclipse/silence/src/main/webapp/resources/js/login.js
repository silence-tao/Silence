$(function() {
	topMobile('backPrevious()', '返回', '登录', 'openPopup()', 'icon-plus-circle', '');
	
});

function login() {
	var data = {};
	var username = $('#username').val().trim();
	if(username.length == 0) {
		alert("邮箱/昵称不能为空");
		return ;
	}
	var password = $('#password').val().trim();
	if(password.length == 0) {
		alert("昵称不能为空");
		return ;
	}
	data.username = username;
	data.password = password;
	silence.ajaxCurrent('/silence/user/userLogin', data,
		function(data) {
			console.log(data);
		},
		function(data) {
			console.log(data);
		}
	);
}