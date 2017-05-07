var flag = [false, false];

$(function() {
	getComments(1);
	
	$('#nikename').focus(function() {
		flag[0] = false;
		var nikename = $('#nikename').val().trim();
		if(nikename.length == 0) {
			$(this).next().text('请输入昵称');
		}
	});
	
	$('#nikename').blur(function() {
		flag[0] = false;
		var nikename = $('#nikename').val().trim();
		if(nikename.length == 0) {
			$(this).next().text('');
		} else {
			var json = {};
			json.name = nikename;
			json.action = 1;
			silence.ajaxCurrent('user/checkName', json,
				function(data) {
					if(data.success) {
						$('#nikename').next().text('');
						flag[0] = true;
					} else {
						$('#nikename').next().text(data.message);
					}
				},
				function(data) {
					console.log(data);
				}
			);
		}
	});
	
	
	$('#username').focus(function() {
		flag[1] = false;
		var username = $('#username').val().trim();
		if(username.length == 0) {
			$(this).next().text('请输入邮箱');
		}
	});
	
	$('#username').blur(function() {
		flag[1] = false;
		var username = $('#username').val().trim();
		if(username.length == 0) {
			$(this).next().text('');
		} else {
			var emailt = /^([\.a-zA-Z0-9_-])+@([\.a-zA-Z0-9_-])+(\.[cn_-])+/;
			if(emailt.test(username)) {
				var json = {};
				json.name = username;
				json.action = 2;
				silence.ajaxCurrent('user/checkName', json,
					function(data) {
						if(data.success) {
							$('#username').next().text('');
							flag[1] = true;
						} else {
							$('#username').next().text(data.message);
						}
					},
					function(data) {
						console.log(data);
					}
				);
			} else {
				$(this).next().text('邮箱格式不正确');
			}
		}
	});
});

function visitorRegister() {
	var data = {};
	var nikename = $('#nikename').val().trim();
	if(nikename.length == 0) {
		$('#nikename').next().text('昵称不能为空');
		return ;
	} else if(!flag[0]) {
		return ;
	}
	var username = $('#username').val().trim();
	if(username.length == 0) {
		$('#username').next().text('邮箱不能为空');
		return ;
	} else if(!flag[1]) {
		return ;
	}
	var data = {};
	data.nikename = nikename;
	data.username = username;
	data.header = $('#user-header').attr('src');
	silence.ajaxCurrent('visitorRegister', data,
		function(data) {
			outShade('userinfo-bar');
			tipsBar(data.success, data.message);
			var fun = window[funName];
			fun(parameter1, parameter2);
		},
		function(data) {
			console.log(data);
		}
	);
}

var funName;
var parameter1;
var parameter2;

function showUserInfoBar(name, para1, para2) {
	getHeader();
	inShade('userinfo-bar');
	funName = name;
	parameter1 = para1;
	parameter2 = para2;
}

function getComments(currentPage) {
	var data = {};
	data.ownerSign = $('#commnet-text').data('sign');
	data.pageSize = 5;
	data.currentPage = currentPage;
	silence.ajaxCurrent('comment/getComments', data,
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
	silence.ajaxCurrent('comment/saveComment', data,
		function(data) {
			if(data.success) {
				tipsBar(data.success, data.message);
				$('#commnet-text').val('');
				showComment(data);
			} else {
				tipsBar(data.success, data.message);
				showUserInfoBar('submitComment', sign);
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
	silence.ajaxCurrent('user/getHeaderBySign', {},
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
	silence.ajaxCurrent('comment/saveComment', data,
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