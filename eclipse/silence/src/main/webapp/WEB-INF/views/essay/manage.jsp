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
		<title>陈涛个人博客-全部文章管理</title>
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
				<a href="<%=basePath %>">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">全部文章管理</a>
			</div>
		</div>
		
		<div class="message-bar clear-both">
			<div class="container">
				<div class="left-box">
					<div class="manage-menu">
						<ul>
							<li><a href="<%=basePath %>essay/manage" class="visited">全部文章</a></li>
							<!-- <li><a href="<%=basePath %>essay/history">心路历程</a></li>
							<li><a href="<%=basePath %>essay/opinion">分享生活</a></li>
							<li><a href="<%=basePath %>essay/technical">技术分享</a></li>
							<li><a href="<%=basePath %>essay/message">留言管理</a></li> -->
						</ul>
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>编号</th>
								<th>标题</th>
								<th>类别</th>
								<th>发布者</th>
								<th>阅读量</th>
								<th>评论量</th>
								<th>是否在首页显示</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="page-bar">
			
		</div>
		
		<div class="hide" id="tpl_switch_btn">
			<div class="sex-switch">
				<input type="checkbox" onchange="isHomeShow('{essaySign}', '{classCode}')" class="hide" id="{essaySign}" {checked} />
				<label for="{essaySign}" class="radio">
					<span class="circle"></span>
				</label>
			</div>
		</div>
		
		<%@ include file="/resources/pages/footer.jsp" %>

		<div class="tips-bar" id="tips-bar">
			<span class="icon-check" id="tips-icon"></span>&nbsp;<span id="tips-box">发表成功</span>
		</div>
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/essay/manage.js" type="text/javascript" charset="utf-8"></script>
</html>
