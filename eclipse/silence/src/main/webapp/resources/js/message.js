$(function() {
	getMessages(1);
});

function showPages(pages) {
	if(pages.totalCount == 0) {
		return ;
	}
	var pages_list = [];
	var begin = 1;
	if(pages.totalPage > 5 && pages.currentPage > 3) {
		if((pages.currentPage + 2) >= pages.totalPage) {
			begin = pages.totalPage - 4;
		} else {
			begin = pages.currentPage - 2;
		}
	}
	pages_list.push('<a href="javascript:;" onclick="toPage(1)" class="' + (pages.currentPage == 1 ? 'noclick' : '') + '">&lt;&lt;</a>');
	pages_list.push('<a href="javascript:;" onclick="toPage(' + (pages.currentPage - 1) + ')" class="' + (pages.currentPage == 1 ? 'noclick' : '') + '">&lt;</a>');
	for(var i = begin; i <= pages.totalPage && i < begin + 5; i++) {
		pages_list.push('<a href="javascript:;" onclick="toPage(' + i + ')" class="' + (pages.currentPage == i ? 'pre-page' : '') + '">' + i + '</a>');
	}
	pages_list.push('<a href="javascript:;" onclick="toPage(' + (pages.currentPage + 1) + ')" class="' + (pages.currentPage == pages.totalPage ? 'noclick' : '') + '">&gt;&gt;</a>');
	pages_list.push('<a href="javascript:;" onclick="toPage(' + (pages.totalPage) + ')" class="' + (pages.currentPage == pages.totalPage ? 'noclick' : '') + '">&gt;</a>');
	$('.page-bar').html(pages_list.join(''));
}

function toPage(page) {
	getMessages(page);
	move(570, 350);
}

function getMessages(currentPage) {
	var pages = {};
	pages.currentPage = currentPage;
	silence.ajaxCurrent('/silence/message/getMessages', pages,
		function(data) {
			showMessage(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function submitMessage() {
	var message = $('#message-text').val();
	if(message.length == 0) {
		tipsBar(false, '留言不能为空');
		return ;
	}
	silence.ajaxCurrent('/silence/message/saveMessage', {content : message},
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				$('#message-text').val('');
				showMessage(data);
			} else {
				tipsBar(data.success, data.message);
				showUserInfoBar('submitMessage');
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

function showMessage(data) {
	$('#message-num').text(data.data.messageNum);
	var messageNum = data.data.pages.totalCount - (data.data.pages.currentPage - 1) * data.data.pages.pageSize;
	var tpl_message_detail = $('#tpl_message_detail').html();
	var tpl_reply_list = $('#tpl_reply_list').html();
	var tpl_reply_detail = $('#tpl_reply_detail').html();
	var messages = data.data.messages;
	var messageList = [];
	for(var i = 0; i < messages.length; i++) {
		var message = messages[i];
		var replyList = [];
		var replyBtn = '';
		if(message.permitReply) {
			replyBtn = '&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" onclick="boxToggle(\'reply-box-' + message.messageId + '\')">回复</a>';
		}
		for(var j = 0; j < message.replyList.length; j++) {
			var reply = message.replyList[j];
			var messageTime = '';
			var reply_detail = tpl_reply_detail.replace(/\{nikename\}/g, reply.nikename)
									.replace(/\{content\}/g, reply.content)
									.replace(/\{header\}/g, reply.header)
									.replace(/\{messageId\}/g, reply.messageId)
									.replace(/\{messageTime\}/g, dateFormat(new Date(reply.messageTime), "yyyy-MM-dd HH:mm") + (j == (message.replyList.length - 1) ? replyBtn : ''));
			replyList.push(reply_detail);
		}
		var reply_list = '';
		if(message.replyList.length != 0) {
			reply_list = tpl_reply_list.replace(/\{replyDetail\}/g, replyList.join(''));
		}
		var message_detail = tpl_message_detail.replace(/\{nikename\}/g, message.nikename)
								.replace(/\{floor\}/g, messageNum--)
								.replace(/\{content\}/g, message.content)
								.replace(/\{header\}/g, message.header)
								.replace(/\{messageId\}/g, message.messageId)
								.replace(/\{messageTime\}/g, dateFormat(new Date(message.messageTime), "yyyy-MM-dd HH:mm")
								+ (message.replyList.length != 0 ? '' : replyBtn))
								.replace(/\{reply-list\}/g, reply_list);
		messageList.push(message_detail);
	}
	$('#message-list').html(messageList.join(''));
	showPages(data.data.pages);
}

function replyMessage(messageId) {
	var data = {};
	data.content = $('#reply-text-' + messageId).val();
	if(data.content.length == 0) {
		tipsBar(false, '回复不能为空');
		return ;
	}
	data.fatherId = messageId;
	silence.ajaxCurrent('/silence/message/saveMessage', data,
		function(data) {
			if(data.success) {
				tipsBar(data.success, '回复成功');
				$('#reply-text' + messageId).val('');
				showMessage(data);
			} else {
				tipsBar(data.success, data.message);
				showUserInfoBar('replyMessage', messageId);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}