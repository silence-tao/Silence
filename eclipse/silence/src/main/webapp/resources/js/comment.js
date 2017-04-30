var flag = [false, false];

$(function() {
	$('#nikename').focus(function() {
		flag[0] = false;
		var nikename = $('#nikename').val().trim();
		if(nikename.length == 0) {
			$(this).next().text('请输入昵称');
		}
	});
	
	$('#nikename').blur(function() {
		flag[0] = false;
		var nikename = $('#nikename').val().trim();
		if(nikename.length == 0) {
			$(this).next().text('');
		} else {
			var json = {};
			json.name = nikename;
			json.action = 1;
			silence.ajaxCurrent('/silence/user/checkName', json,
				function(data) {
					if(data.success) {
						$('#nikename').next().text('');
						flag[0] = true;
					} else {
						$('#nikename').next().text(data.message);
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
			$(this).next().text('请输入邮箱');
		}
	});
	
	$('#username').blur(function() {
		flag[1] = false;
		var username = $('#username').val().trim();
		if(username.length == 0) {
			$(this).next().text('');
		} else {
			var emailt = /^([\.a-zA-Z0-9_-])+@([\.a-zA-Z0-9_-])+(\.[cn_-])+/;
			if(emailt.test(username)) {
				var json = {};
				json.name = username;
				json.action = 2;
				silence.ajaxCurrent('/silence/user/checkName', json,
					function(data) {
						if(data.success) {
							$('#username').next().text('');
							flag[1] = true;
						} else {
							$('#username').next().text(data.message);
						}
					},
					function(data) {
						console.log(data);
					}
				);
			} else {
				$(this).next().text('邮箱格式不正确');
			}
		}
	});
});

function visitorRegister() {
	var data = {};
	var nikename = $('#nikename').val().trim();
	if(nikename.length == 0) {
		$('#nikename').next().text('昵称不能为空');
		return ;
	} else if(!flag[0]) {
		return ;
	}
	var username = $('#username').val().trim();
	if(username.length == 0) {
		$('#username').next().text('邮箱不能为空');
		return ;
	} else if(!flag[1]) {
		return ;
	}
	var data = {};
	data.nikename = nikename;
	data.username = username;
	data.header = $('#user-header').attr('src');
	silence.ajaxCurrent('/silence/visitorRegister', data,
		function(data) {
			outShade('userinfo-bar');
			tipsBar(data.success, data.message);
			var fun = window[funName];
			fun(parameter1, parameter2);
		},
		function(data) {
			console.log(data);
		}
	);
}

var funName;
var parameter1;
var parameter2;

function showUserInfoBar(name, para1, para2) {
	getHeader();
	inShade('userinfo-bar');
	funName = name;
	parameter1 = para1;
	parameter2 = para2;
}