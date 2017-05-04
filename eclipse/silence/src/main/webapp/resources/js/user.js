function saveInformation() {
	var json = {};
	json.name = $('#name').val();
	if($('#sex-check').attr('checked')) {
		json.sex = 0;
	} else {
		json.sex = 1;
	}
	json.birth = $('#birthday').val();
	json.virtue = '';
	$('#virtue input').each(function() {
		if($(this).attr('checked') == 'checked') {
			json.virtue += $(this).val() + ',';
		}
	});
	json.proverbs = $('#proverbs').val();
	
	silence.ajaxCurrent('/silence/user/saveInformation', json,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				outShade('userinfo-edit');
				window.location.reload();
			} else {
				tipsBar(data.success, data.message);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

var action;
function changeHeader(action, target) {
	action = action;
	if(action == 1) {
		picturePrev(target);
	} else {
		getHeader();
	}
}

function saveHeader() {
	var json = {};
	var fileElementIds = new Array();
	if(action == 1) {
		fileElementIds.push('header-picture');
	} else {
		json.header = $('#user-header').attr('src');
	}
	silence.ajaxFilesUpload('/silence/user/saveHeader',
		json,
		fileElementIds,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				outShade('userinfo-edit');
				window.location.reload();
			} else {
				tipsBar(data.success, data.message);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

function savePass() {
	var oldPass = $('#oldPass').val();
	var newPass = $('#newPass').val();
	if(newPass.length == 0) {
		tipsBar(false, "旧密码不能为空");
		return ;
	}
	if(newPass.length == 0) {
		tipsBar(false, "新密码不能为空");
		return ;
	} else if(newPass.length < 6 || newPass.length > 16) {
		tipsBar(false, "密码为6-16位字符");
		return ;
	}
	var json = {};
	json.oldPass = oldPass;
	json.newPass = newPass;
	silence.ajaxCurrent('/silence/user/savePassword', json,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				window.location.href = "/silence/user/login";
			} else {
				tipsBar(data.success, data.message);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}