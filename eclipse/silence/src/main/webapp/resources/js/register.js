var flag = [false, false, false];

$(function() {
	getHeader();
	
	$('#nikename').focus(function() {
		flag[0] = false;
		var nikename = $('#nikename').val().trim();
		if(nikename.length == 0) {
			$(this).next().text('请输入昵称').fadeIn();
		}
	});
	
	$('#nikename').blur(function() {
		flag[0] = false;
		var nikename = $('#nikename').val().trim();
		if(nikename.length == 0) {
			$(this).next().text('').fadeOut();
		} else {
			var json = {};
			json.name = nikename;
			json.action = 1;
			silence.ajaxCurrent('user/checkName', json,
				function(data) {
					if(data.success) {
						$('#nikename').next().text('').fadeOut();
						flag[0] = true;
					} else {
						$('#nikename').next().text(data.message).fadeIn();
					}
				},
				function(data) {
					console.log(data);
				}
			);
		}
	});
	
	
	$('#username').focus(function() {
		flag[1] = false;
		var username = $('#username').val().trim();
		if(username.length == 0) {
			$(this).next().text('请输入邮箱').fadeIn();
		}
	});
	
	$('#username').blur(function() {
		flag[1] = false;
		var username = $('#username').val().trim();
		if(username.length == 0) {
			$(this).next().text('').fadeOut();
		} else {
			var emailt = /^([\.a-zA-Z0-9_-])+@([\.a-zA-Z0-9_-])+(\.[cn_-])+/;
			if(emailt.test(username)) {
				var json = {};
				json.name = username;
				json.action = 2;
				silence.ajaxCurrent('user/checkName', json,
					function(data) {
						if(data.success) {
							$('#username').next().text('').fadeOut();
							flag[1] = true;
						} else {
							$('#username').next().text(data.message).fadeIn();
						}
					},
					function(data) {
						console.log(data);
					}
				);
			} else {
				$(this).next().text('邮箱格式不正确').fadeIn();
			}
		}
	});
	
	$('#password').focus(function() {
		flag[2] = false;
		var password = $('#password').val().trim();
		if(password.length == 0) {
			$(this).next().text('6-16位字符').fadeIn();
		}
	});
	
	$('#password').blur(function() {
		flag[2] = false;
		var password = $('#password').val().trim();
		if(password.length == 0) {
			$(this).next().text('').fadeOut();
		} else if(password.length < 6 || password.length > 16) {
			$(this).next().text('6-16位字符').fadeIn();
		} else {
			$(this).next().text('').fadeOut();
			flag[2] = true;
		}
	});
});

function register() {
	var data = {};
	var nikename = $('#nikename').val().trim();
	if(nikename.length == 0) {
		$('#nikename').next().text('昵称不能为空').fadeIn();
		return ;
	} else if(!flag[0]) {
		return ;
	}
	var username = $('#username').val().trim();
	if(username.length == 0) {
		$('#username').next().text('邮箱不能为空').fadeIn();
		return ;
	} else if(!flag[1]) {
		return ;
	}
	var password = $('#password').val().trim();
	if(password.length == 0) {
		$('#password').next().text('密码不能为空').fadeIn();
		return ;
	} else if(!flag[2]) {
		return ;
	}
	data.nikename = nikename;
	data.username = username;
	data.password = password;
	data.header = $('#user-header').attr('src');
	silence.ajaxCurrent('user/userRegister', data,
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