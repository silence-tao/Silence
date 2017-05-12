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
		<title>陈涛个人博客-分享生活管理</title>
		<link rel="shortcut icon" href="/silence/resources/img/logo.jpg" />
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/icomoon.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/silence.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/technical.css"/>
		<!--[if lt IE 9]>
			<script src="/silence/resources/js/common/html5shiv.js" type="text/javascript" charset="utf-8"></script>
			<script src="/silence/resources/js/common/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<![endif]-->
	</head>
	<body>
		<%@ include file="/resources/pages/header.jsp" %>
		
		<div class="path-bar container clear-both">
			<div class="fl">
				<a href="<%=basePath %>">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">分享生活管理</a>
			</div>
		</div>
		
		<div class="message-bar clear-both">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 left-box">
						<div class="manage-menu">
							<ul>
								<li><a href="<%=basePath %>essay/manage">全部文章</a></li>
								<li><a href="<%=basePath %>essay/history">心路历程</a></li>
								<li><a href="<%=basePath %>essay/opinion" class="visited">分享生活</a></li>
								<li><a href="<%=basePath %>essay/technical">技术分享</a></li>
								<li><a href="<%=basePath %>essay/message">留言管理</a></li>
							</ul>
						</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>标题</th>
									<th>类别</th>
									<th>阅读</th>
									<th>评论</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td><a href="#">生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱</a><span class="grey-time">（2017-04-23 20:40）</span></td>
									<th>心路历程</th>
									<td>2234</td>
									<td>323</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
								<tr>
									<td>2</td>
									<td><a href="#">不忘初心</a><span class="grey-time">（2017-04-23 20:40）</span></td>
									<th>心路历程</th>
									<td>2234</td>
									<td>323</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
								<tr>
									<td>3</td>
									<td><a href="#">不忘初心</a><span class="grey-time">（2017-04-23 20:40）</span></td>
									<th>分享生活</th>
									<td>2234</td>
									<td>323</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
								<tr>
									<td>4</td>
									<td><a href="#">不忘初心</a><span class="grey-time">（2017-04-23 20:40）</span></td>
									<th>生活分享</th>
									<td>2234</td>
									<td>323</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
								<tr>
									<td>5</td>
									<td><a href="#">不忘初心</a><span class="grey-time">（2017-04-23 20:40）</span></td>
									<th>技术分享</th>
									<td>2234</td>
									<td>323</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
							</tbody>
						</table>
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
	<script src="/silence/resources/js/essay.js" type="text/javascript" charset="utf-8"></script>
	<%@include file="/resources/pages/statistic.jsp" %>
</html>
