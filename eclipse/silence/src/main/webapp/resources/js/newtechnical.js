$(function() {
	
});

function saveTechnical() {
	var title = $('#essay-title').val();
	var classify = $('#essay-classify').val();
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
	json.summary = code.substr(0, 68);
	json.classify = classify;
	silence.ajaxCurrent('/silence/technical/saveTechnical', json,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				window.location.href = '/silence/technical';
			} else {
				if(data.status == 0) {
					tipsBar(data.success, data.message);
					window.location.href = '/silence/user/login';
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