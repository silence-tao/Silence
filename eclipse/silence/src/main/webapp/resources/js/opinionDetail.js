$(function() {
	getOpinions(1);
});

function getOpinions(currentPage) {
	var pages = {};
	pages.currentPage = currentPage;
	pages.pageSize = 6;
	silence.ajaxCurrent('/silence/opinion/getOpinions', pages,
		function(data) {
			showOpinion(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function showOpinion(data) {
	var opinions = data.data.opinions;
	var tpl_opinion_detail = $('#tpl_opinion_detail').html();
	var opinionList = [];
	for(var i = 0; i < opinions.length; i++) {
		var opinion = opinions[i];
		var opinion_detail = tpl_opinion_detail.replace(/\{nikename\}/g, opinion.nikename)
									.replace(/\{cover\}/g, opinion.cover == null ? '/silence/resources/img/14761734963351905.jpg' : opinion.cover)
									.replace(/\{title\}/g, opinion.title)
									.replace(/\{commentNum\}/g, opinion.commentNum)
									.replace(/\{summary\}/g, opinion.summary)
									.replace(/\{publishTime\}/g, dateFormat(new Date(opinion.publishTime), "yyyy-MM-dd HH:mm"))
									.replace(/\{opinionId\}/g, opinion.opinionId);
		opinionList.push(opinion_detail);
	}
	$('#opinion-list').html(opinionList.join(''));
	showPages(data.data.pages);
}

function toPage(page) {
	getOpinions(page);
}