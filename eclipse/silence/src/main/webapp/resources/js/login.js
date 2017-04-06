$(function() {
	topMobile('backPrevious()', '返回', '登录', 'openPopup()', 'icon-plus-circle', '');
	getAccount();
});

function getAccount() {
	silence.ajaxCurrent('/silence/user/getUserSign', {},
		function(data) {
			if(data.success) {
				$('#username').val(data.data.username);
				$('#password').val(data.data.password);
				$('#save-pass').attr('checked', 'checked');
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

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
	data.remember = $('#save-pass').attr('checked');
	silence.ajaxCurrent('/silence/user/userLogin', data,
		function(data) {
			if(data.success) {
				window.location.href = '/silence';
			}
		},
		function(data) {
			console.log(data);
		}
	);
}