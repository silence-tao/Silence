$(function() {
	getAllTechnical(1);
});

function getAllTechnical(currentPage) {
	var json = {};
	json.currentPage = currentPage;
	json.pageSize = 20;
	silence.ajaxCurrent('technical/getAllTechnical', json,
		function(data) {
			showAllTechnical(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function showAllTechnical(data) {
	var essays = data.data.technicals;
	var essayList = [];
	var tpl_switch_btn = $('#tpl_switch_btn').html();
	for(var i = 0; i < essays.length; i++) {
		var param = [];
		var essay = essays[i];
		param.push('<td>' + (i + 1) + '</td>');
		var auditStatus = '';
		var status = false;
		if(essay.auditStatus == 1) {
			auditStatus = '审核通过';
			status = true;
		} else if(essay.auditStatus == 0) {
			auditStatus = '<a href="' + basePath + 'technical/audit?technicalId=' + essay.essayId + '">待审核</a>';
		} else if(essay.auditStatus == -1) {
			auditStatus = '<a href="' + basePath + 'technical/audit?technicalId=' + essay.essayId + '">审核未通过</a>';
		}
		var title = '';
		var editEssay = '';
		var switch_btn = '';
		if(status) {
			title = '<a href="'+ basePath +  essay.classCode + '/detail/' + essay.essayId + '">' + essay.title.substr(0, 20) + '</a>';
			editEssay = '<td><a href="' + basePath + 'technical/edit?technicalId=' + essay.essayId + '">编辑</a>&nbsp;|&nbsp;';
			editEssay += '<a href="javascript:;" onclick="deleteById(' + essay.essayId + ')">删除</a></td>';
			switch_btn = tpl_switch_btn.replace(/\{essaySign\}/g, essay.essaySign)
				.replace(/\{checked\}/g, essay.homeShow == 1 ? 'checked' : '')
				.replace(/\{classCode\}/g, essay.classCode);
		} else {
			title = essay.title.substr(0, 20);
			editEssay = '<td>编辑&nbsp;|&nbsp;删除</td>';
		}
		title += '<span class="grey-time">（' + dateFormat(new Date(essay.publishTime), "yyyy-MM-dd HH:mm") + '）</span>';
		param.push('<td>' + title + '</td>');
		param.push('<td>' + essay.classify + '</td>');
		param.push('<td>' + essay.nikename + '</td>');
		param.push('<td>' + essay.visitorNum + '</td>');
		param.push('<td>' + essay.commentNum + '</td>');
		param.push('<td>' + auditStatus + '</td>');
		param.push('<td>' + switch_btn + '</td>');
		param.push(editEssay);
		essayList.push('<tr>' + param.join('') + '</tr>');
	}
	$('tbody').html(essayList.join(''));
	showPages(data.data.pages);
}

function toPage(page) {
	getAllTechnical(page);
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

function deleteById(technicalId) {
	dialog('确认要删除吗?', function() {
		silence.ajaxCurrent('technical/deleteById?technicalId=' + technicalId, {},
			function(data) {
				tipsBar(data.success, data.message);
				getAllTechnical($('.page-bar a.pre-page').text());
			},
			function(data) {
				console.log(data);
			}
		);
	});
}