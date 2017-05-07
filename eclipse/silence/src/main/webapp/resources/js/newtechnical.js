$(function() {
	
});

function saveTechnical() {
	var title = $('#essay-title').val();
	var classify;
	if($('#classify-check').attr('checked') != 'checked') {
		classify = $('#essay-classify').val();
	} else {
		classify = $('#essay-classify-select').val();
	}
	var content = UE.getEditor('editor').getContent();
	var code = UE.getEditor('editor').getContentTxt();
	if(title.length == 0) {
		tipsBar(false, '标题不能为空');
		return ;
	}
	if(classify.length == 0) {
		tipsBar(false, '分类不能为空');
		return ;
	}
	if(code.length < 100) {
		tipsBar(false, '内容不能少于100字');
		return ;
	}
	var json = {};
	json.title = title;
	json.content = content;
	json.summary = code.substr(0, 40);
	json.classify = classify;
	silence.ajaxCurrent('technical/saveTechnical', json,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				window.location.href = basePath + 'technical';
			} else {
				if(data.status == 0) {
					tipsBar(data.success, data.message);
					window.location.href = basePath + 'user/login';
				} else {
					tipsBar(data.success, data.message);
				}
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

function toTechnicl() {
	window.location.href = '/silence/technical';
}

function switchInput(target) {
	if($(target).attr('checked') != 'checked') {
		$('#essay-classify').attr('disabled', false);
		$('#essay-classify-select').attr('disabled', 'disabled');
	} else {
		$('#essay-classify-select').attr('disabled', false);
		$('#essay-classify').attr('disabled', 'disabled');
		silence.ajaxCurrent('classify/getClassifies', {},
			function(data) {
				var classifies = data.data;
				for(var i = 0; i < classifies.length; i++) {
					$('#essay-classify-select').append('<option value="' + classifies[i].classifyName + '">' + classifies[i].classifyName + '</option>');
				}
			},
			function(data) {
				console.log(data);
			}
		);
	}
}