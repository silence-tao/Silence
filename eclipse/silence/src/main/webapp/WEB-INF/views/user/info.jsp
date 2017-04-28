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
		<title>陈涛个人博客-基本信息</title>
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
				<a href="#">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">基本信息</a>
			</div>
		</div>
		
		<div class="message-bar clear-both">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 user-setting">
						<div class="fl user-menu">
							<div class="user-header">
								<img src="../resources/img/14749103673516675.jpg"/>
								<div class="action-box">
									<a href="#" class="link-change" onclick="inShade('header-change')">更换头像</a>
								</div>
							</div>
							<p class="user-name">Silence</p>
							<h2>个人中心</h2>
							<ul>
								<li class="active"><a href="#">基本信息</a></li>
								<li><a href="#">修改密码</a></li>
							</ul>
						</div>
						<div class="fr menu-aciton">
							<div class="user-info">
								<span class="title">基本信息</span>
								<span class="icon-edit" onclick="inShade('userinfo-edit')" title="编辑个人信息"></span>
							</div>
							<div class="user-detail">
								<div class="info">
									<div class="info-left fl">昵称</div>
									<div class="info-right fr">Silence</div>
								</div>
								<div class="info">
									<div class="info-left fl">邮箱</div>
									<div class="info-right fr">taogu2010@yeah.net</div>
								</div>
								<div class="info">
									<div class="info-left fl">性别</div>
									<div class="info-right fr">男</div>
								</div>
								<div class="info">
									<div class="info-left fl">生日</div>
									<div class="info-right fr">1994-12-15</div>
								</div>
								<div class="info">
									<div class="info-left fl">年龄</div>
									<div class="info-right fr">22</div>
								</div>
								<div class="info">
									<div class="info-left fl">擅长技能</div>
									<div class="info-right fr">Java，HTML5，Linux</div>
								</div>
								<div class="info">
									<div class="info-left fl">个性签名</div>
									<div class="info-right fr">天下武功，唯快不破</div>
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
		
		<%@ include file="/resources/pages/footer.jsp" %>
		
		<div class="shade-bar" id="header-change">
			<div class="header-box">
				<div class="box-top">
					<span class="title">更换头像</span>
					<span class="icon-close" onclick="outShade('header-change')"></span>
				</div>
				<div class="header-img">
					<img src="../resources/img/14749103673516675.jpg"/>
					<input type="file" class="hide" name="" id="header-picture" value="" onchange="picturePrev(this)" />
				</div>
				<p class="aciton-link"><a href="javasript:;">换一换</a><a href="javasript:;" onclick="$('#header-picture').click();">上传头像</a></p>
				<div class="box-btn">
					<input type="button" name="" id="" value="确定" />
					<input type="button" name="" id="" onclick="outShade('header-change')" value="取消" />
				</div>
			</div>
		</div>
		
		<div class="shade-bar" id="userinfo-edit">
			<div class="info-edit">
				<div class="box-top">
					<span class="title">编辑基本信息</span>
					<span class="icon-close" onclick="outShade('userinfo-edit')"></span>
				</div>
				<div class="edit-list">
					<div class="input-box clear-both">
						<div class="fl title">
							昵称：
						</div>
						<div class="fl input-text">
							<input type="text" name="" id="" value="" placeholder="Silence" />
							<p></p>
						</div>
					</div>
					<div class="input-box clear-both">
						<div class="fl title">
							性别：
						</div>
						<div class="fl input-text">
							<div class="sex-switch">
								<input type="checkbox" class="hide" id="sex-check" />
								<label for="sex-check" class="radio">
									<span class="circle"></span>
								</label>
							</div>
						</div>
					</div>
					<div class="input-box clear-both">
						<div class="fl title">
							生日：
						</div>
						<div class="fl input-text">
							<input type="date" name="" id="" value="" />
							<p></p>
						</div>
					</div>
					<div class="input-box clear-both">
						<div class="fl title">
							擅长技能：
						</div>
						<div class="fl input-text">
							<span class="check-box">
								<input type="checkbox" class="hide" name="" id="check-1" value="Java" />
								<label for="check-1" class="class-name">Java</label>
							</span>
							<span class="check-box">
								<input type="checkbox" class="hide" name="" id="check-2" value="Linux" />
								<label for="check-2" class="class-name">Linux</label>
							</span>
							<span class="check-box">
								<input type="checkbox" class="hide" name="" id="check-3" value="数据库" />
								<label for="check-3" class="class-name">数据库</label>
							</span>
							<span class="check-box">
								<input type="checkbox" class="hide" name="" id="check-5" value="HTML" />
								<label for="check-5" class="class-name">HTML</label>
							</span>
							<span class="check-box">
								<input type="checkbox" class="hide" name="" id="check-6" value="数据库" />
								<label for="check-6" class="class-name">数据库</label>
							</span>
							<span class="check-box">
								<input type="checkbox" class="hide" name="" id="check-7" value="HTML" />
								<label for="check-7" class="class-name">HTML</label>
							</span>
							<span class="check-box">
								<input type="checkbox" class="hide" name="" id="check-8" value="数据库" />
								<label for="check-8" class="class-name">数据库</label>
							</span>
							<span class="check-box">
								<input type="checkbox" class="hide" name="" id="check-9" value="HTML" />
								<label for="check-9" class="class-name">HTML</label>
							</span>
						</div>
					</div>
					<div class="input-box clear-both sign">
						<div class="fl title">
							个人签名：
						</div>
						<div class="fl input-text">
							<textarea></textarea>
						</div>
					</div>
				</div>
				<div class="box-btn">
					<input type="button" name="" id="" value="确定" />
					<input type="button" name="" id="" onclick="outShade('userinfo-edit')" value="取消" />
				</div>
			</div>
		</div>
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/message.js" type="text/javascript" charset="utf-8"></script>
</html>
