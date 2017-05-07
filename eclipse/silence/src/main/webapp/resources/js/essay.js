$(function() {
	getEssay();
});

function getEssay() {
	silence.ajaxCurrent('essay/getEssay', {},
		function(data) {
			showEssay(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function showEssay(data) {
	var newEssay = data.data.newEssay;
	var newEssayList = [];
	for(var i = 0; i < newEssay.length; i++) {
		var essay = newEssay[i];
		var essay_link = '<li><span class="icon-asterisk"></span>&nbsp;<a href="' + basePath + essay.summary + '/detail/' + essay.essayId + '">' + essay.title + '</a></li>';
		newEssayList.push(essay_link);
	}
	$('#newEssay-list').html(newEssayList.join(''));
	var hotEssay = data.data.hotEssay;
	var hotEssayList = [];
	for(var i = 0; i < hotEssay.length; i++) {
		var essay = hotEssay[i];
		var essay_link;
		if(i < 3) {
			essay_link = '<li><span class="icon-num top-3">' + (i + 1) + '</span>&nbsp;<a href="' + basePath + essay.summary + '/detail/' + essay.essayId + '">' + essay.title + '</a></li>';
		} else {
			essay_link = '<li><span class="icon-num">' + (i + 1) + '</span>&nbsp;<a href="' + basePath + essay.summary + '/detail/' + essay.essayId + '">' + essay.title + '</a></li>';
		}
		hotEssayList.push(essay_link);
	}
	$('#hotEssay-list').html(hotEssayList.join(''));
}