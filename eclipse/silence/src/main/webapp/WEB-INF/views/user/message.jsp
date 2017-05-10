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
		<title>陈涛个人博客-消息中心</title>
		<link rel="shortcut icon" href="/silence/resources/img/logo.jpg" />
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/icomoon.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/silence.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/user.css"/>
		<!--[if lt IE 9]>
			<script src="/silence/resources/js/common/html5shiv.js" type="text/javascript" charset="utf-8"></script>
			<script src="/silence/resources/js/common/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<![endif]-->
	</head>
	<body>
		<%@ include file="/resources/pages/header.jsp" %>
		
		<div class="path-bar container clear-both">
			<div class="fl">
				<a href="<%=basePath %>">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">消息中心</a>
			</div>
		</div>
		
		<div class="message-bar clear-both">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 message-box">
						<div class="message-detail">
							<div class="user-info clear-both">
								<div class="user-header">
									<img src="/silence/resources/img/14749103673516675.jpg"/>
								</div>
								<div class="user-detail">
									<p class="user-name"><a href="#" class="name username">Silence</a>&nbsp;回复</p>
									<p class="time">2017-04-24 14:13</p>
								</div>
							</div>
							<div class="essay-summary">
								<div class="essay-img">
									<img src="/silence/resources/img/slide04.jpg" />
								</div>
								<div class="summary-content">
									<p class="username"><a href="#" class="username">Silence</a></p>
									<p class="title"><a href="#">生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱</a>[心路历程]</p>
									<p class="summary">生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱，谁不会爱生活的本意是爱，谁不会爱，谁不会爱生活的本意是爱，谁不会爱。</p>
								</div>
							</div>
							<div class="comment-detail clear-both">
								<div class="user-header">
									<img src="../resources/img/14749103673516675.jpg"/>
								</div>
								<div class="comment-content">
									<p class="name"><a href="#" class="username">Silence</a>：是啊是啊！，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱</p>
									<p class="time">2017-04-24 17:04&nbsp;&nbsp;<a href="#">回复</a></p>
									<div class="comment clear-both">
										<div class="user-header">
											<img src="../resources/img/14749103673516675.jpg"/>
										</div>
										<div class="content">
											<p class="name"><a href="#" class="username">Silence</a>：是啊是啊！，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱</p>
											<p class="time">2017-04-24 17:04&nbsp;&nbsp;<a href="#">回复</a></p>
											<div class="long-bar">
												<input type="text" name="" id="" value="" />
												<input type="button" name="" id="" value="发表" />
											</div>
										</div>
									</div>
									<div class="comment clear-both">
										<div class="user-header">
											<img src="../resources/img/14749103673516675.jpg"/>
										</div>
										<div class="content">
											<p class="name"><a href="#" class="username">Silence</a>：是啊是啊！，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱</p>
											<p class="time">2017-04-24 17:04&nbsp;&nbsp;<a href="#">回复</a></p>
											<!--<div class="long-bar">
												<input type="text" name="" id="" value="" />
												<input type="button" name="" id="" value="发表" />
											</div>-->
										</div>
									</div>
									<div class="long-bar">
										<input type="text" name="" id="" value="" />
										<input type="button" name="" id="" value="发表" />
									</div>
								</div>
							</div>
						</div>
						
						<div class="message-detail">
							<div class="user-info clear-both">
								<div class="user-header">
									<img src="/silence/resources/img/14749103673516675.jpg"/>
								</div>
								<div class="user-detail">
									<p class="user-name"><a href="#" class="name username">Silence</a>&nbsp;评论</p>
									<p class="time">2017-04-24 14:13</p>
								</div>
							</div>
							<div class="essay-summary">
								<div class="essay-img">
									<img src="/silence/resources/img/slide04.jpg" />
								</div>
								<div class="summary-content">
									<p class="username"><a href="#" class="username">Silence</a></p>
									<p class="title"><a href="#">生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱</a>[心路历程]</p>
									<p class="summary">生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱，谁不会爱生活的本意是爱，谁不会爱，谁不会爱生活的本意是爱，谁不会爱。</p>
								</div>
							</div>
							<div class="comment-detail clear-both">
								<div class="user-header">
									<img src="../resources/img/14749103673516675.jpg"/>
								</div>
								<div class="comment-content">
									<p class="name"><a href="#" class="username">Silence</a>：是啊是啊！，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱</p>
									<p class="time">2017-04-24 17:04&nbsp;&nbsp;<a href="#" class="replay">回复</a></p>
									<div class="comment clear-both">
										<div class="user-header">
											<img src="../resources/img/14749103673516675.jpg"/>
										</div>
										<div class="content">
											<p class="name"><a href="#" class="username">Silence</a>：是啊是啊！，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱</p>
											<p class="time">2017-04-24 17:04&nbsp;&nbsp;<a href="#">回复</a></p>
										</div>
									</div>
									<div class="comment clear-both">
										<div class="user-header">
											<img src="../resources/img/14749103673516675.jpg"/>
										</div>
										<div class="content">
											<p class="name"><a href="#" class="username">Silence</a>回复<a href="#" class="username">Lucky</a>：是啊是啊！，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱</p>
											<p class="time">2017-04-24 17:04&nbsp;&nbsp;<a href="#">回复</a></p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 rank-bar">
						<p>最新文章&nbsp;&nbsp;<span class="icon-bookmark"></span></p>
						<div class="essay-list">
							<ul>
								<li><span class="icon-asterisk"></span>&nbsp;<a href="#">学无止境,无论何时,无论何地无论何时,无论何地无论何时,无论何地无论何时,无论何地</a></li>
								<li><span class="icon-asterisk"></span>&nbsp;<a href="#">学无止境,无论何时,无论何地</a></li>
								<li><span class="icon-asterisk"></span>&nbsp;<a href="#">学无止境,无论何时,无论何地</a></li>
								<li><span class="icon-asterisk"></span>&nbsp;<a href="#">学无止境,无论何时,无论何地</a></li>
							</ul>
						</div>
						<p>点击排行&nbsp;&nbsp;<span class="icon-sort-amount-asc"></span></p>
						<div class="essay-list">
							<ul>
								<li><span class="icon-num top-3">1</span>&nbsp;<a href="#">学无止境,无论何时,无论何地无论何时,无论何地无论何时,无论何地无论何时,无论何地</a></li>
								<li><span class="icon-num top-3">2</span>&nbsp;<a href="#">学无止境,无论何时,无论何地</a></li>
								<li><span class="icon-num top-3">3</span>&nbsp;<a href="#">学无止境,无论何时,无论何地</a></li>
								<li><span class="icon-num">4</span>&nbsp;<a href="#">学无止境,无论何时,无论何地</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="page-bar">
			<a href="#" class="noclick">&lt;&lt;</a>
			<a href="#" class="noclick">&lt;</a>
			<a href="#" class="pre-page">1</a>
			<a href="#">2</a>
			<a href="#">3</a>
			<a href="#">4</a>
			<a href="#">5</a>
			<a href="#">&gt;</a>
			<a href="#">&gt;&gt;</a>
		</div>
		
		<%@ include file="/resources/pages/footer.jsp" %>
		
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/message.js" type="text/javascript" charset="utf-8"></script>
</html>
