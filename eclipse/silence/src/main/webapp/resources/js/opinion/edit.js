$(function() {
	getOpinion();
});

var opinion;

function getOpinion() {
	var param = getUrlParam();
	silence.ajaxCurrent('opinion/findOpinionById', param,
		function(data) {
			opinion = data.data;
			showOpinion();
		},
		function(data) {
			console.log(data);
		}
	);
}

function saveOpinion() {
	var title = $('#essay-title').val();
	var content = UE.getEditor('editor').getContent();
	var code = UE.getEditor('editor').getContentTxt();
	if(title.length == 0) {
		tipsBar(false, '标题不能为空');
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
	json.opinionId = opinion.opinionId;
	
	silence.ajaxCurrent('opinion/editOpinion', json,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				window.location.href = basePath + 'opinion/detail/' + opinion.opinionId;
			} else {
				tipsBar(data.success, data.message);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

function showOpinion() {
	$('#essay-title').val(opinion.title);
	UE.getEditor('editor').addListener("ready", function () {
		UE.getEditor('editor').setContent(opinion.content);
    });
}

function toOpinion() {
	dialog('确定要舍弃编辑?', function() {
		window.location.href = basePath + 'essay/technical';
	});
}