<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//String basePath = "https://www.silencetao.com/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=Edge, chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>陈涛个人博客-我要注册</title>
		<link rel="shortcut icon" href="/silence/resources/img/logo.jpg" />
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/silence.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/login.css"/>
		<!--[if lt IE 9]>
			<script src="/silence/resources/js/common/html5shiv.js" type="text/javascript" charset="utf-8"></script>
			<script src="/silence/resources/js/common/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<![endif]-->
	</head>
	<body>
		<div class="filter-bar">
		</div>
		<div class="form-box">
			<div class="header-picture header-picture-register" onclick="getHeader()">
				<img src="/silence/resources/img/head.jpg" id="user-header" />
				<span class="tips">点击更换头像</span>
			</div>
			<div class="form-group first-form">
				<input type="text" name="nikename" class="input-text" id="nikename" placeholder="请输入昵称" />
				<div class="form-tips">
					
				</div>
			</div>
			<div class="form-group">
				<input type="text" name="username" class="input-text" id="username" placeholder="请输入邮箱" />
				<div class="form-tips">
					
				</div>
			</div>
			<div class="form-group last-form">
				<input type="password" name="password" class="input-text" id="password" placeholder="请输入密码" />
				<div class="form-tips">
					
				</div>
			</div>
			<div class="form-btn">
				<input type="button" id="" class="input-btn" onclick="register()" value="注册" />
			</div>
		</div>
		
		<div class="toolbar hidden-md hidden-sm hidden-xs">
			<a href="<%=basePath %>" title="返回前页" class="toolbar-item toolbar-item-back">
				<span class="toolbar-btn"></span>
			</a>
			
			<a href="login" title="我要登录" class="toolbar-item toolbar-item-login">
				<span class="toolbar-btn"></span>
			</a>
			
			<div class="qrcode-box">
				<a href="javascript:;" title="加我好友" class="toolbar-item toolbar-item-qq">
					<span class="toolbar-btn"></span>
				</a>
				<div class="qrcode">
					扫描二维码<br />
					加我为QQ好友
					<img src="/silence/resources/img/qrcodeforqq.jpg" width="160" height="160"/>
				</div>
			</div>
			
			<a href="javascript:;" id="backTop" title="回到顶部" class="toolbar-item toolbar-item-top" onclick="move(0, 350)">
				<span class="toolbar-btn"></span>
			</a>
		</div>
		
		<div class="nav-top hidden-lg">
			<a href="javascript:;" id="top-left-btn" onclick=""><span class="icon-angle-left"></span><span class="left-title"></span></a>
			<span class="center-title" id="top-center-title"></span>
			<a href="javascript:;" onclick="" id="top-right-btn"><span class=""></span></a>
		</div>
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/register.js" type="text/javascript" charset="utf-8"></script>
</html>


