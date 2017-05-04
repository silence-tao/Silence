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
		<title>陈涛个人博客-修改密码</title>
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
				<a href="/silence">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">修改密码</a>
			</div>
		</div>
		
		<div class="message-bar clear-both">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 user-setting">
						<div class="fl user-menu">
							<div class="user-header">
								<img src="${userInfo.header }"/>
								<div class="action-box">
									<a href="javascript:;" onclick="inShade('header-change')" class="link-change">更换头像</a>
								</div>
							</div>
							<p class="user-name">${userInfo.nikename }</p>
							<h2>个人中心</h2>
							<ul>
								<li><a href="/silence/user/info">基本信息</a></li>
								<li class="active"><a href="/user/user/password">修改密码</a></li>
							</ul>
						</div>
						<div class="fr menu-aciton">
							<div class="user-info">
								<span class="title">修改密码</span>
							</div>
							<div class="form-group">
								<div class="input-box">
									<input type="password" name="" id="oldPass" value="" placeholder="请输入原始密码" />
									<p></p>
								</div>
								<div class="input-box">
									<input type="password" name="" id="newPass" value="" placeholder="请输入新密码" />
									<p></p>
								</div>
								<div class="input-box">
									<input type="button" name="" id="" onclick="savePass()" value="确认修改" />
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
		
		<div class="shade-bar" id="header-change">
			<div class="header-box">
				<div class="box-top">
					<span class="title">更换头像</span>
					<span class="icon-close" onclick="outShade('header-change')"></span>
				</div>
				<div class="header-img">
					<img src="${userInfo.header }" id="user-header" />
					<input type="file" class="hide" name="" id="header-picture" value="" onchange="changeHeader(1, this)" />
				</div>
				<p class="aciton-link"><a href="javasript:;" onclick="changeHeader(2)">换一换</a><a href="javasript:;" onclick="$('#header-picture').click();">上传头像</a></p>
				<div class="box-btn">
					<input type="button" name="" id="" onclick="saveHeader()" value="确定" />
					<input type="button" name="" id="" onclick="outShade('header-change')" value="取消" />
				</div>
			</div>
		</div>
		
		<div class="tips-bar" id="tips-bar">
			<span class="icon-check" id="tips-icon"></span>&nbsp;<span id="tips-box">发表成功</span>
		</div>
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/ajaxfileupload.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/user.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/essay.js" type="text/javascript" charset="utf-8"></script>
</html>
