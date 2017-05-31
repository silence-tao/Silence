<%@page import="com.silencetao.utils.PropertiesUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	String basePath = PropertiesUtil.getProperties("basePath");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge, chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>${historyView.title }</title>
		<meta name="Keywords" content="${historyView.title }" />
		<meta name="Description" content="陈涛的个人博客,是完全由草根站长陈涛一个人自主设计开发的个人博客系统,目的是打造一个技术分享的平台" />
		<link rel="shortcut icon" href="/silence/resources/img/logo.jpg" />
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/icomoon.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/silence.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/history.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/opinion.css"/>
		<!--[if lt IE 9]>
			<script src="/silence/resources/js/common/html5shiv.js" type="text/javascript" charset="utf-8"></script>
			<script src="/silence/resources/js/common/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<![endif]-->
	</head>
	<body>
		<%@ include file="/resources/pages/header.jsp" %>
		
		<div class="hide" id="tpl_comment_detail">
			<div class="comment-detail clear-both">
				<div class="fl father-header">
					<img src="{header}"/>
				</div>
				<div class="fl comment-content">
					<div class="father-info">
						<a href="#">{nikename}</a>：{content}
						<p>{commentTime}&nbsp;<a href="javacript:;" onclick="showCommentBox({commentId}, {id})">回复</a></p>
					</div>
					<div class="hide" id="comment-box-{commentId}" data-sign="{userSign}">
						
					</div>
					{replyList}
				</div>
			</div>
		</div>
		
		<div class="hide" id="tpl_comment_box">
			<div class="sub-publish clear-both">
				<div class="fl sub-header">
					<img src="{header}" />
				</div>
				<div class="fl sub-input">
					<input type="text" name="" id="comment-text-{commentId}" data-commentid="{id}" value="" />
				</div>
			</div>
			<div class="sub-btn clear-both">
				<input type="button" name="" id="" onclick="replyComment({commentId}, ${historyView.historyId })" value="回复" />
			</div>
		</div>
		
		<div class="hide" id="tpl_sub_detail">
			<div class="sub-detail clear-both">
				<div class="fl sub-header">
					<img src="{header}"/>
				</div>
				<div class="fl sub-info">
					<a href="#">{nikename}</a>回复<a href="#">{name}</a>：{content}
					<p>{commentTime}&nbsp;<a href="javacript:;" onclick="showCommentBox({commentId}, {id})">回复</a></p>
				</div>
			</div>
			<div class="hide" id="comment-box-{commentId}" data-sign="{userSign}">
				
			</div>
		</div>
		
		<div class="path-bar container clear-both">
			<div class="fl">
				<a href="<%=basePath %>">首页</a>&nbsp;/&nbsp;<a href="<%=basePath %>history">心路历程</a>&nbsp;/&nbsp;
				<a href="#" class="no-pointer">${historyView.title }</a>
			</div>
		</div>
		
		<div class="detail-bar clear-both">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 detail-box">
						<h1>${historyView.title }</h1>
						<div class="opinion-info">
							发布时间：<fmt:formatDate value="${historyView.recordTime }" pattern="yyyy-MM-dd HH:mm" />&nbsp;&nbsp;&nbsp;&nbsp;编辑：Silence&nbsp;&nbsp;${historyView.visitorNum }<span class="icon-eye2"></span>&nbsp;&nbsp;${historyView.commentNum }<span class="icon-bubble"></span>
						</div>
						<div class="history-detail">
							<div id="slideBox" class="slideBox">
								<div class="hd">
									<ul>
										<c:forEach items="${historyView.pictures }" var="picture" varStatus="status">
											<li>${status.index + 1 }</li>
										</c:forEach>
									</ul>
								</div>
								<div class="bd">
									<ul>
										<c:forEach items="${historyView.pictures }" var="picture" varStatus="status">
											<c:choose>
												<c:when test="${status.index == 0 }">
													<li><img id="img-silde" src="${picture }" /></li>
												</c:when>
												<c:otherwise>
													<li><img src="${picture }" /></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</ul>
								</div>
								<a class="prev" href="javascript:void(0)"></a>
								<a class="next" href="javascript:void(0)"></a>
							</div>
							<p class="history-content">${historyView.content }</p>
						</div>
						
						<div class="comment-box">
							<h2>用户评论区</h2>
							<div class="comment-publish">
								<textarea name="" id="commnet-text" data-sign="${historyView.historySign }"></textarea>
								<input type="button" name="" id="" onclick="submitComment('${historyView.historySign }')" value="发表" />
							</div>
							<div class="comment-list" id="comment-list">
								<div class="comment-detail clear-both">
									<p class="comment-tips">暂时还没有人，快来留下第一条评论吧！</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 rank-bar">
						<p>最新文章&nbsp;&nbsp;<span class="icon-bookmark"></span></p>
						<div class="essay-list">
							<ul id="newEssay-list">
								
							</ul>
						</div>
						<p>点击排行&nbsp;&nbsp;<span class="icon-sort-amount-asc"></span></p>
						<div class="essay-list">
							<ul id="hotEssay-list">
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<%@ include file="/resources/pages/footer.jsp" %>
		
		<div class="shade-bar" id="userinfo-bar">
			<div class="user-edit">
				<div class="box-top">
					<span class="title">请录入基本信息</span>
					<span class="icon-close" onclick="outShade('userinfo-bar')"></span>
				</div>
				<div class="header-box">
					<img src="/silence/resources/img/14749103673516675.jpg" id="user-header" />
					<div class="tips-box">
						<a href="javascript:;" onclick="getHeader()" class="link-change">更换头像</a>
					</div>
				</div>
				<div class="edit-list">
					<div class="input-box clear-both">
						<div class="fl title">
							昵称：
						</div>
						<div class="fl input-text">
							<input type="text" name="" id="nikename" value="" placeholder="请输入昵称" />
							<p></p>
						</div>
					</div>
					<div class="input-box clear-both">
						<div class="fl title">
							邮箱：
						</div>
						<div class="fl input-text">
							<input type="text" name="" id="username" value="" placeholder="请输入邮箱" />
							<p></p>
						</div>
					</div>
				</div>
				<div class="box-btn">
					<input type="button" name="" id="" onclick="visitorRegister()" value="确定" />
					<input type="button" name="" id="" onclick="outShade('userinfo-bar')" value="取消" />
				</div>
				<div class="box-btn">
					<a href="<%=basePath %>user/login">已有账号，立即登录</a>
					<a href="<%=basePath %>user/register">不想录入，直接注册</a>
				</div>
			</div>
		</div>
		
		<div class="tips-bar" id="tips-bar">
			<span class="icon-check" id="tips-icon"></span>&nbsp;<span id="tips-box">发表成功</span>
		</div>
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/comment.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/essay.js" type="text/javascript" charset="utf-8"></script>
	<script id="jsID" type="text/javascript">
		var img = new Image();
		img.src = $('#img-silde').attr('src');
		img.onload = function() {
			$('.slideBox').css('width', img.width + 'px').css('height', img.height + 'px');
		}
		var ary = location.href.split("&");
		jQuery(".slideBox").slide( { mainCell:".bd ul", effect:ary[1],autoPlay:ary[2],trigger:ary[3],easing:ary[4],delayTime:ary[5],mouseOverStop:ary[6],pnLoop:ary[7] });
	</script>
	<%@include file="/resources/pages/statistic.jsp" %>
</html>
