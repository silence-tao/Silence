$(function() {
	getAllUser(1);
});

function getAllUser(currentPage) {
	var json = {};
	json.currentPage = currentPage;
	json.pageSize = 20;
	silence.ajaxCurrent('/silence/user/getAllUser', json,
		function(data) {
//			showAllEssay(data);
			console.log(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function showAllEssay(data) {
	var essays = data.data.essays;
	var essayList = [];
	var tpl_switch_btn = $('#tpl_switch_btn').html();
	for(var i = 0; i < essays.length; i++) {
		var param = [];
		var essay = essays[i];
		param.push('<td>' + (i + 1) + '</td>');
		var title = '';
		if(essay.classCode == 'message') {
			title = essay.title.substr(0, 20);
		} else {
			title = '<a href="/silence/' + essay.classCode + '/detail/' + essay.essayId + '">' + essay.title.substr(0, 20) + '</a>';
		}
		var switch_btn = tpl_switch_btn.replace(/\{essaySign\}/g, essay.essaySign)
									.replace(/\{checked\}/g, essay.homeShow == 1 ? 'checked' : '')
									.replace(/\{classCode\}/g, essay.classCode);
		title += '<span class="grey-time">（' + dateFormat(new Date(essay.publishTime), "yyyy-MM-dd HH:mm") + '）</span>';
		param.push('<td>' + title + '</td>');
		param.push('<td>' + essay.classify + '</td>');
		param.push('<td>' + essay.nikename + '</td>');
		param.push('<td>' + essay.visitorNum + '</td>');
		param.push('<td>' + essay.commentNum + '</td>');
		param.push('<td>' + switch_btn + '</td>');
		param.push('<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>');
		essayList.push('<tr>' + param.join('') + '</tr>');
	}
	$('tbody').html(essayList.join(''));
	showPages(data.data.pages);
}

function toPage(page) {
	getAllEssay(page);
	move(120, 350);
}

function isHomeShow(essaySign, classCode) {
	var json = {};
	json.essaySign = essaySign;
	if($('#' + essaySign).attr('checked') == 'checked') {
		json.homeShow = 1;
	} else {
		json.homeShow = 0;
	}
	silence.ajaxCurrent('/silence/' + classCode + '/isHomeShow', json,
		function(data) {
			tipsBar(data.success, data.message);
		},
		function(data) {
			console.log(data);
		}
	);
}