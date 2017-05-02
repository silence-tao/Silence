$(function() {
	getComments(1);
});

function getComments(currentPage) {
	var data = {};
	data.ownerSign = $('#commnet-text').data('sign');
	data.pageSize = 5;
	data.currentPage = currentPage;
	silence.ajaxCurrent('/silence/comment/getComments', data,
		function(data) {
			showComment(data);
		},
		function(data) {
			console.log(data);
		}
	);
}

function submitComment(sign) {
	var content = $('#commnet-text').val();
	if(content.length == 0) {
		tipsBar(false, '评论不能为空');
		return ;
	}
	var data = {};
	data.ownerSign = sign;
	data.content = content;
	silence.ajaxCurrent('/silence/comment/saveComment', data,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				$('#commnet-text').val('');
				showComment(data);
			} else {
				tipsBar(data.success, data.message);
				showUserInfoBar('submitComment', historySign);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

function showComment(data) {
	var comments = data.data.comments;
	var pages = data.data.pages;
	if(comments.length == 0) {
		return ;
	} else if(pages.currentPage == 1) {
		$('#comment-list').html('');
	}
	var tpl_comment_detail = $('#tpl_comment_detail').html();
	var tpl_sub_detail = $('#tpl_sub_detail').html();
	var commentList = [];
	for(var i = 0; i < comments.length; i++) {
		var comment = comments[i];
		var replies = comment.replyList;
		var replyList = [];
		for(var j = 0; j < replies.length; j++) {
			var reply = replies[j];
			var sub_detail = tpl_sub_detail.replace(/\{nikename\}/g, reply.nikename)
								.replace(/\{header\}/g, reply.header)
								.replace(/\{content\}/g, reply.content)
								.replace(/\{userSign\}/g, reply.userSign)
								.replace(/\{commentId\}/g, reply.commentId)
								.replace(/\{name\}/g, reply.name)
								.replace(/\{id\}/g, comment.commentId)
								.replace(/\{commentTime\}/g, dateFormat(new Date(reply.commentTime), "yyyy-MM-dd HH:mm"));
			replyList.push(sub_detail);
		}
		var comment_detail = tpl_comment_detail.replace(/\{nikename\}/g, comment.nikename)
									.replace(/\{header\}/g, comment.header)
									.replace(/\{content\}/g, comment.content)
									.replace(/\{userSign\}/g, comment.userSign)
									.replace(/\{commentId\}/g, comment.commentId)
									.replace(/\{id\}/g, comment.commentId)
									.replace(/\{replyList\}/g, replyList.join(''))
									.replace(/\{commentTime\}/g, dateFormat(new Date(comment.commentTime), "yyyy-MM-dd HH:mm"));
		commentList.push(comment_detail);
	}
	$('#comment-list').append(commentList.join(''));
	if(pages.currentPage < pages.totalPage) {
		$('#comment-list').append('<div class="read-more"><a href="javascript:;" onclick="nextPage(' + (pages.currentPage + 1) + ', this)">查看更多</a></div>');
	}
}

function nextPage(currentPage, target) {
	$(target).parent().remove();
	getComments(currentPage);
}

function showCommentBox(commentId, id) {
	var tpl_comment_box = $('#tpl_comment_box').html();
	silence.ajaxCurrent('/silence/user/getHeaderBySign', {},
		function(data) {
			if(data.success) {
				var comment_box = tpl_comment_box.replace(/\{header\}/g, data.message)
										.replace(/\{commentId\}/g, commentId)
										.replace(/\{id\}/g, id);
				$('#comment-box-' + commentId).html(comment_box);
				boxToggle('comment-box-' + commentId);
			} else {
				tipsBar(data.success, data.message);
				showUserInfoBar('showCommentBox', commentId, id);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}

function replyComment(commentId) {
	var content = $('#comment-text-' + commentId).val();
	if(content.length == 0) {
		tipsBar(false, '回复不能为空');
		return ;
	}
	var data = {};
	data.ownerSign = $('#commnet-text').data('sign');
	data.content = content;
	data.toSign = $('#comment-box-' + commentId).data('sign');
	data.fatherId = $('#comment-text-' + commentId).data('commentid');
	silence.ajaxCurrent('/silence/comment/saveComment', data,
		function(data) {
			if(data.success) {
				tipsBar(data.success, '回复成功');
				$('#commnet-text').val('');
				showComment(data);
			} else {
				tipsBar(data.success, data.message);
			}
		},
		function(data) {
			console.log(data);
		}
	);
}