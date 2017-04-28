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
		<title>陈涛个人博客-用户管理</title>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/bootstrap.css"/>
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
				<a href="#">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">用户管理</a>
			</div>
		</div>
		
		<div class="message-bar clear-both">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 left-box">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>用户名</th>
									<th>昵称</th>
									<th>注册IP</th>
									<th>注册时间</th>
									<th>用户权限</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>taogu2010@yeah.net</td>
									<th>Silence</th>
									<td>192.168.0.1</td>
									<td>2017-04-05 10:05:18</td>
									<td>1</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
								<tr>
									<td>2</td>
									<td>taogu2010@yeah.net</td>
									<th>Silence</th>
									<td>192.168.0.1</td>
									<td>2017-04-05 10:05:18</td>
									<td>1</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
								<tr>
									<td>3</td>
									<td>taogu2010@yeah.net</td>
									<th>Silence</th>
									<td>192.168.0.1</td>
									<td>2017-04-05 10:05:18</td>
									<td>1</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
								<tr>
									<td>4</td>
									<td>taogu2010@yeah.net</td>
									<th>Silence</th>
									<td>192.168.0.1</td>
									<td>2017-04-05 10:05:18</td>
									<td>1</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
								<tr>
									<td>5</td>
									<td>taogu2010@yeah.net</td>
									<th>Silence</th>
									<td>192.168.0.1</td>
									<td>2017-04-05 10:05:18</td>
									<td>1</td>
									<td><a href="#">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
								</tr>
							</tbody>
						</table>
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
