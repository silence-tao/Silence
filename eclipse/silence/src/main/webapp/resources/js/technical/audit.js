$(function() {
	getTechnical();
});

var technical;

function getTechnical() {
	var param = getUrlParam();
	silence.ajaxCurrent('technical/findTechnicalById', param,
		function(data) {
			technical = data.data;
			showTechnical();
		},
		function(data) {
			console.log(data);
		}
	);
}

function saveTechnical(auditStatus) {
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
	json.technicalId = technical.technicalId;
	json.auditStatus = auditStatus;
	
	silence.ajaxCurrent('technical/editTechnical', json,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				if(auditStatus == 1) {
					window.location.href = basePath + 'technical/detail/' + technical.technicalId;
				} else {
					window.location.href = basePath + 'essay/technical';
				}
			} else {
				tipsBar(data.success, data.message);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

function showTechnical() {
	$('#essay-title').val(technical.title);
	$('#essay-classify').val(technical.classify);
	UE.getEditor('editor').addListener("ready", function () {
		UE.getEditor('editor').setContent(technical.content);
    });
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