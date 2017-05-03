<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge, chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>陈涛个人博客-大家怎么看我的？</title>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/icomoon.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/silence.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/message.css"/>
		<!--[if lt IE 9]>
			<script src="/silence/resources/js/common/html5shiv.js" type="text/javascript" charset="utf-8"></script>
			<script src="/silence/resources/js/common/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<![endif]-->
	</head>
	<body>
		<%@ include file="/resources/pages/header.jsp" %>
		
		<div class="hide" id="tpl_message_detail">
			<div class="message-detail">
				<div class="user-info">
					<div class="user-header">
						<img src="{header}"/>
					</div>
					<a href="#">{nikename}</a>
					<p>第{floor}楼</p>
				</div>
				<div class="message-info">
					<p class="message-content">{content}</p>
					<p class="message-time">{messageTime}</p>
					{reply-list}
					<div class="reply-box" id="reply-box-{messageId}">
						<textarea id="reply-text-{messageId}" name="" rows="" cols=""></textarea>
						<div class="reply-btn">
							<input type="button" name="" id="" onclick="replyMessage({messageId})" value="回复" />
							<a href="javascript:;" onclick="boxToggle('reply-box-{messageId}')">取消</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="hide" id="tpl_reply_list">
			<div class="reply-list">
				{replyDetail}
			</div>
		</div>
		
		<div class="hide" id="tpl_reply_detail">
			<div class="reply-detail clear-both">
				<div class="user-header">
					<img src="{header}"/>
				</div>
				<div class="reply-info">
					<p class="reply-content"><a href="#">{nikename}&nbsp;&nbsp;</a>{content}</p>
					<p class="reply-time">{messageTime}</p>
				</div>
			</div>
		</div>
		
		
		
		<div class="path-bar container clear-both">
			<div class="fl">
				<a href="/silence">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">留言板</a>
			</div>
			<div class="module-intro">
				最好的朋友是那种不喜欢多说，能与你默默相对而又息息相通的人
			</div>
		</div>
		
		<div class="mywords-bar">
			<div class="container">
				<div class="mywords-top">
				<h2>博主寄语</h2>
				<p>一个不会写bug的Silence,只是自我安慰罢了</p>
				</div>
				<div class="my-header">
					<a href="/silence/about">
						<img src="/silence/resources/img/head.jpg" />
						<div class="header-tips">
							<span>陈涛</span>
						</div>
					</a>
				</div>
				<p class="words-content">一个不会写bug的Silence,只是自我安慰罢了一个不会写bug的Silence,只是自我安慰罢了一个不会写bug的Silence,只是自我安慰罢了一个不会写bug的Silence,只是自我安慰罢了。</p>
			</div>
		</div>
		
		<div class="message-bar clear-both">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 left-box">
						<div class="message-publish">
							<p>发表您的留言</p>
							<textarea name="" id="message-text" ></textarea>
							<input type="button" name="" id="" onclick="submitMessage()" value="发表" />
						</div>
						<h2 class="message-title">留言(<span id="message-num"></span>)</h2>
						<div class="message-list" id="message-list">
							
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
		
		<div class="page-bar">
			
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
					<a href="/silence/user/login">已有账号，立即登录</a>
					<a href="/silence/user/register">不想录入，直接注册</a>
				</div>
			</div>
		</div>
		
		<div class="tips-bar" id="tips-bar">
			<span class="icon-check" id="tips-icon"></span>&nbsp;<span id="tips-box">发表成功</span>
		</div>
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/message.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/comment.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/essay.js" type="text/javascript" charset="utf-8"></script>
</html>
