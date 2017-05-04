<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge, chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>陈涛个人博客-草根博主Silence的心路历程</title>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/icomoon.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/silence.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/history.css"/>
		<!--[if lt IE 9]>
			<script src="/silence/resources/js/common/html5shiv.js" type="text/javascript" charset="utf-8"></script>
			<script src="/silence/resources/js/common/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<![endif]-->
	</head>
	<body>
		<div class="hide" id="tpl_history_html">
			<div class="cd-timeline-block">
				<div class="cd-timeline-img">
					{time}
				</div>
				<div class="cd-timeline-content">
					<h2><a href="/silence/history/detail/{historyId}">{title}</a></h2>
					<p>{content}</p>
					<div class="img-box">
						{pictures}
					</div>
					<span class="history-date">{date}</span>
				</div>
			</div>
		</div>
		
		<section id="cd-timeline" class="cd-container">
			
		</section>
		
		<div class="loading-bottom">
			<span class="icon-spinner9"></span>加载中
		</div>
		
		<div class="toolbar hidden-md hidden-sm hidden-xs">
			<a href="/silence" title="返回前页" class="toolbar-item toolbar-item-back">
				<span class="toolbar-btn"></span>
			</a>
			
			<c:choose>
				<c:when test="${empty userInfo }">
					<a href="user/login" title="我要登录" class="toolbar-item toolbar-item-login">
						<span class="toolbar-btn"></span>
					</a>
				</c:when>
				<c:otherwise>
					<div class="user-box">
						<a href="javascript:;" title="Silence" class="toolbar-item toolbar-item-user">
							<span class="toolbar-img">
								<img src="${userInfo.header }" />
							</span>
						</a>
						<div class="user-card">
							<div class="user-info">
								<div class="user-bg">
									<img src="/silence/resources/img/background.jpg" class="img-responsive" />
								</div>
								<div class="user-header">
									<a href="#" title="个人中心"><img src="${userInfo.header }"/></a>
								</div>
								<p class="user-name">${userInfo.nikename }</p>
							</div>
							<div class="menu-list">
								<a href="/silence/user/info" title="个人中心"><span class="icon-home2"></span></a>
								<a href="/silence/user/message" title="消息中心"><span class="icon-envelope"><span class="message-num">9</span></span></a>
								<a href="/silence/essay/manage" title="文章管理"><span class="icon-books"></span></a>
								<c:if test="${userInfo.userRank >= 6 }">
									<a href="/silence/user/manage" title="用户管理"><span class="icon-users2"></span></a>
								</c:if>
								<a href="javascript:;" onclick="loginOut()" title="安全退出"><span class="icon-power-off"></span></a>
							</div>
						</div>
						<span class="msg-num">9</span>
					</div>
				</c:otherwise>
			</c:choose>
			
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
			
			<c:if test="${userInfo.userRank >= 6 }">
				<a href="javascript:;" onclick="popupBar()" title="添加一条" class="toolbar-item toolbar-item-add">
					<span class="toolbar-btn"></span>
				</a>
			</c:if>
			
			<a href="javascript:;" id="backTop" title="回到顶部" class="toolbar-item toolbar-item-top" onclick="move(0, 350)">
				<span class="toolbar-btn"></span>
			</a>
		</div>
		
		<div class="shade-bar" id="popup-bar">
			<div class="popup-box clear-both">
				<div class="box-top hidden-md hidden-sm hidden-xs">
					添加动态
					<span class="icon-close" onclick="outShade('popup-bar')"></span>
				</div>
				<div class="form-group">
					<input type="text" name="title" id="history-title" placeholder="请输入标题" />
				</div>
				<div class="form-group">
					<textarea name="content" id="history-content" placeholder="请输入内容"></textarea>
				</div>
				<div class="picture-list clear-both" id="picture-list-bar">
					<div class="picture-show add-btn">
						<img src="" class="img-responsive" />
						<input type="file" class="hide" name="pricture" id="pricture-1" onchange="showImage(this)" />
						<label for="pricture-1"><span class="icon-plus2"></span></label>
					</div>
				</div>
				<div class="form-message" id="popup-box-message"></div>
				<div class="form-group hidden-md hidden-sm hidden-xs">
					<input type="button" name="" id="" value="保存" onclick="saveHistory()" />
				</div>
			</div>
		</div>
		
		<div class="hide" id="tpl-picture-show">
			<div class="picture-show add-btn">
				<img src="" class="img-responsive" />
				<input type="file" class="hide" name="pricture" id="pricture-{id}" onchange="showImage(this)" />
				<label for="pricture-{id}"><span class="icon-plus2"></span></label>
			</div>
		</div>
		
		<div class="loading-shade">
			<span class="icon-spinner10"></span>
			<p>正在初始化页面……</p>
		</div>
		<input type="hidden" value="http://resources.silencetao.com/" id="basePath" >
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/ajaxfileupload.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/history.js" type="text/javascript" charset="utf-8"></script>
</html>

<!--
	时间:2016-12-05 16:25
	建立前端Web项目
	开始总是那么的艰难，尽管如此，还是要去做的。
	给自己无数的心里暗示，一定要把这件事情做好，是时候证明一下自己了。
-->