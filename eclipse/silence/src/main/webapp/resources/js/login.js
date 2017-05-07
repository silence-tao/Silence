$(function() {
	getAccount();
	
	$('#username').blur(function() {
		$('#username').next().text('').fadeOut();
		getHeader();
	});
	
	$('#password').blur(function() {
		$('#password').next().text('').fadeOut();
	});
});

function getAccount() {
	silence.ajaxCurrent('user/getUserSign', {},
		function(data) {
			if(data.success) {
				$('#username').val(data.data.username);
				$('#password').val(data.data.password);
				$('#save-pass').attr('checked', 'checked');
				getHeader();
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
		$('#username').next().text('不能为空').fadeIn();
		return ;
	}
	var password = $('#password').val().trim();
	if(password.length == 0) {
		$('#password').next().text('密码不能为空').fadeIn();
		return ;
	} else if(password.length < 6 || password.length > 16) {
		$('#password').next().text('6-16位字符').fadeIn();
	}
	data.username = username;
	data.password = password;
	data.remember = $('#save-pass').attr('checked');
	silence.ajaxCurrent('user/userLogin', data,
		function(data) {
			if(data.success) {
				window.location.href = basePath;
			} else {
				$('#password').next().text(data.message).fadeIn();
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

function getHeader() {
	var username = $('#username').val();
	var data = {};
	if(username.length == 0) {
		return ;
	}
	data.username = username;
	silence.ajaxCurrent('user/getHeader', data,
		function(data) {
			if(data.success) {
				$('#user-header').attr('src', data.message);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}