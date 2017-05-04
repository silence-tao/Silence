$(function() {
	getTechnicals(1);
});

function getTechnicals(currentPage) {
	var pages = {};
	pages.currentPage = currentPage;
	pages.pageSize = 6;
	silence.ajaxCurrent('/silence/technical/getTechnicals', pages,
		function(data) {
			showTechnicals(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function showTechnicals(data) {
	var technicals = data.data.technicals;
	var tpl_technical_detail = $('#tpl_technical_detail').html();
	var technicalList = [];
	for(var i = 0; i < technicals.length; i++) {
		var technical = technicals[i];
		var technical_detail = tpl_technical_detail.replace(/\{nikename\}/g, technical.nikename)
										.replace(/\{header\}/g, technical.header)
										.replace(/\{publishTime\}/g, dateFormat(new Date(technical.publishTime), "yyyy-MM-dd HH:mm"))
										.replace(/\{cover\}/g, technical.cover == null ? '/silence/resources/img/14761734963351905.jpg' : technical.cover)
										.replace(/\{title\}/g, technical.title)
										.replace(/\{classify\}/g, technical.classify)
										.replace(/\{summary\}/g, technical.summary)
										.replace(/\{technicalId\}/g, technical.essayId);
		technicalList.push(technical_detail);
	}
	$('#technical-list').html(technicalList.join(''));
	showPages(data.data.pages);
}

function toPage(page) {
	getTechnicals(page);
	move(0, 350);
}