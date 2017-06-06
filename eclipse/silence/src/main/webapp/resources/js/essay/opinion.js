$(function() {
	getAllOpinion(1);
});

function getAllOpinion(currentPage) {
	var json = {};
	json.currentPage = currentPage;
	json.pageSize = 20;
	silence.ajaxCurrent('opinion/getAllOpinion', json,
		function(data) {
			showAllOpinion(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function showAllOpinion(data) {
	var essays = data.data.opinions;
	var essayList = [];
	var tpl_switch_btn = $('#tpl_switch_btn').html();
	for(var i = 0; i < essays.length; i++) {
		var param = [];
		var essay = essays[i];
		param.push('<td>' + (i + 1) + '</td>');
		var switch_btn = tpl_switch_btn.replace(/\{essaySign\}/g, essay.essaySign)
		.replace(/\{checked\}/g, essay.homeShow == 1 ? 'checked' : '')
		.replace(/\{classCode\}/g, essay.classCode);
		var title = '<a href="'+ basePath +  essay.classCode + '/detail/' + essay.essayId + '">' + essay.title.substr(0, 20) + '</a>';
		title += '<span class="grey-time">（' + dateFormat(new Date(essay.publishTime), "yyyy-MM-dd HH:mm") + '）</span>';
		var editEssay = '<td><a href="' + basePath + 'opinion/edit?opinionId=' + essay.essayId + '">编辑</a>&nbsp;|&nbsp;';
		editEssay += '<a href="javascript:;" onclick="deleteById(' + essay.essayId + ')">删除</a></td>';
		param.push('<td>' + title + '</td>');
		param.push('<td>' + essay.nikename + '</td>');
		param.push('<td>' + essay.visitorNum + '</td>');
		param.push('<td>' + essay.commentNum + '</td>');
		param.push('<td>' + switch_btn + '</td>');
		param.push(editEssay);
		essayList.push('<tr>' + param.join('') + '</tr>');
	}
	$('tbody').html(essayList.join(''));
	showPages(data.data.pages);
}

function toPage(page) {
	getAllOpinion(page);
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
	silence.ajaxCurrent(classCode + '/isHomeShow', json,
		function(data) {
			tipsBar(data.success, data.message);
		},
		function(data) {
			console.log(data);
		}
	);
}

function deleteById(opinionId) {
	dialog('确认要删除吗?', function() {
		silence.ajaxCurrent('opinion/deleteById?opinionId=' + opinionId, {},
			function(data) {
				tipsBar(data.success, data.message);
				getAllOpinion($('.page-bar a.pre-page').text());
			},
			function(data) {
				console.log(data);
			}
		);
	});
}