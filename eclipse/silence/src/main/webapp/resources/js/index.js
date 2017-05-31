$(function() {
	var isRequest = true;
	var action = 0;
	if (document.getElementById("loading-bottom").offsetTop < $(window).height()) {
		getHistory(0);
	}
	$(window).scroll(function () {
        var a = document.getElementById("loading-bottom").offsetTop;
        if (a >= $(window).scrollTop() && a < ($(window).scrollTop()+$(window).height() - 28)) {
            if(isRequest) {
            	isRequest = false;
            	switch (action) {
            		case 0 : getHistory(a);
            		break;
            		case 1 : getMessage(a);
            		break;
            		case 2 : getOpinion(a);
            		break;
            		case 3 : getTechnical(a);
            		break;
            	}
            	action++;
            }
        }
    });
	
	function getHistory(height) {
		silence.ajaxCurrent('history/getHistoryHome', {},
			function(data) {
				isRequest = true;
				if(data.data.length == 0) {
					return ;
				}
				var tpl_history_bar = $('#tpl_history_bar').html();
				var tpl_history_top = $('#tpl_history_top').html();
				var tpl_history_bottom = $('#tpl_history_bottom').html();
				var historyList = [];
				var history_top = '';
				var history_bottom = '';
				if(data.data[0]) {
					history_top = tpl_history_top.replace(/\{cover\}/g, data.data[0].cover)
												.replace(/\{title\}/g, data.data[0].title)
												.replace(/\{content\}/g, data.data[0].content)
												.replace(/\{historyId\}/g, data.data[0].historyId);
				}
				if(data.data[1]) {
					history_bottom = tpl_history_bottom.replace(/\{cover\}/g, data.data[1].cover)
														.replace(/\{title\}/g, data.data[1].title)
														.replace(/\{content\}/g, data.data[1].content)
														.replace(/\{historyId\}/g, data.data[1].historyId);
				}
				historyList.push(history_top);
				historyList.push(history_bottom);
				var history_bar = tpl_history_bar.replace(/\{historyList\}/g, historyList.join(''));
				$('#history-box').html(history_bar);
				move(height, 350);
			},
			function(data) {
				console.log(data);
			}
		);
	}
	
	function getMessage(height) {
		silence.ajaxCurrent('message/getMessageHome', {},
			function(data) {
				isRequest = true;
				if(data.data.length == 0) {
					return ;
				}
				var tpl_message_detail = $('#tpl_message_detail').html();
				var tpl_message_bar = $('#tpl_message_bar').html();
				var messages = data.data;
				var messageList = [];
				for(var i = 0; i < messages.length; i++) {
					var message = messages[i];
					var message_detail = tpl_message_detail.replace(/\{content\}/g, message.content.substr(0, 115))
														.replace(/\{nikename\}/g, message.nikename)
														.replace(/\{header\}/g, message.header);
					messageList.push(message_detail);
				}
				var message_bar = tpl_message_bar.replace(/\{messageList\}/g, messageList.join(''));
				$('#message-box').html(message_bar);
				move(height - 170, 350);
			},
			function(data) {
				console.log(data);
			}
		);
	}
	
	function getOpinion(height) {
		silence.ajaxCurrent('opinion/getOpinionHome', {},
			function(data) {
				isRequest = true;
				if(data.data.length == 0) {
					return ;
				}
				var tpl_opinion_bar = $('#tpl_opinion_bar').html();
				var tpl_opinion_detail = $('#tpl_opinion_detail').html();
				var opinions = data.data;
				var opinionList = [];
				for(var i = 0; i < opinions.length; i++) {
					var opinion = opinions[i];
					var opinion_detail = tpl_opinion_detail.replace(/\{title\}/g, opinion.title)
														.replace(/\{cover\}/g, opinion.cover)
														.replace(/\{essayId\}/g, opinion.essayId)
														.replace(/\{publishTime\}/g, dateFormat(new Date(opinion.publishTime), "yyyy-MM-dd HH:mm"))
														.replace(/\{commentNum\}/g, opinion.commentNum)
														.replace(/\{summary\}/g, opinion.summary);
					opinionList.push(opinion_detail);
				}
				var opinion_bar = tpl_opinion_bar.replace(/\{opinionList\}/g, opinionList.join(''));
				$('#opinion-box').html(opinion_bar);
				move(height, 350);
			},
			function(data) {
				console.log(data);
			}
		);
	}
	
	function getTechnical(height) {
		silence.ajaxCurrent('technical/getTechnicalHome', {},
			function(data) {
				var tpl_technical_detail = $('#tpl_technical_detail').html();
				var tpl_technical_bar = $('#tpl_technical_bar').html();
				var technicals = data.data;
				var technicalLst = [];
				for(var i = 0; i < technicals.length; i++) {
					var technical = technicals[i];
					var technical_detail = tpl_technical_detail.replace(/\{title\}/g, technical.title)
															.replace(/\{header\}/g, technical.header)
															.replace(/\{nikename\}/g, technical.nikename)
															.replace(/\{publishTime\}/g, dateFormat(new Date(technical.publishTime), "yyyy-MM-dd HH:mm"))
															.replace(/\{cover\}/g, technical.cover)
															.replace(/\{classify\}/g, technical.classify)
															.replace(/\{summary\}/g, technical.summary)
															.replace(/\{essayId\}/g, technical.essayId);
					technicalLst.push(technical_detail);
				}
				var technical_bar = tpl_technical_bar.replace(/\{technicalLst\}/g, technicalLst.join(''));
				if(data.data.length != 0) {
					$('#technical-box').html(technical_bar);
				}
				$('#loading-bottom').hide();
				inShade('footer-box');
				move(height, 350);
			},
			function(data) {
				console.log(data);
			}
		);
	}
});
