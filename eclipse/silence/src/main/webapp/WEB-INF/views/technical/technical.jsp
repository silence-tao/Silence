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
		<title>陈涛个人博客-追求技术是一种态度</title>
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
		
		<div class="hide" id="tpl_technical_detail">
			<div class="col-lg-6">
				<div class="technical-detail">
					<div class="user-info">
						<div class="user-header"><img src="{header}" /></div>
						<a href="#">{nikename}</a>
						<p>{publishTime}</p>
					</div>
					<div class="technical-content">
						<div class="technical-img">
							<img src="{cover}" class="img-responsive" />
						</div>
						<div class="technical-info">
							<h2 class="technical-title">{title}<a href="#">[{classify}]</a></h2>
							<p class="technical-sumary">{summary}</p>
						</div>
						<a href="/silence/technical/detail/{technicalId}" class="link-button">详细信息</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="path-bar container clear-both">
			<div class="fl">
				<a href="/silence/">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">技术分享</a>
			</div>
			<div class="module-intro">
				学无止境,无论何时,无论何地,都不要停止学习
			</div>
		</div>
		
		<div class="technical-bar">
			<div class="technical-list clear-both">
				<div class="container">
					<div class="row" id="technical-list">
						
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
		
		<footer>
			<div class="container">
				<div class="footer-box">
					友情链接：
					<a href="http://www.yangqq.com" target="_blank">杨青个人博客</a>
					<a href="http://www.chinaliaowei.com/zhenshifu/#/" target="_blank">臻食府</a>
					<a href="http://www.szqlovepk.club/" target="_blank">花之物语</a>
				</div>
				<div class="footer-box">
					<a href="/silence/about">关于博主</a>
					<a href="https://user.qzone.qq.com/1228714091/infocenter?ptsig=Wp3IEfUGFRD4hWZB8B0K7MyKkV8KHx--NqiifhxuwX4_" target="_blank">QQ空间</a>
					<a href="http://weibo.com/3749857687/profile?rightmod=1&wvr=6&mod=personinfo&is_all=1" target="_blank">新浪微博</a>
					<a href="" target="_blank"></a>
					<a href="" target="_blank"></a>
				</div>
				<div class="footer-box">
					Copyright&nbsp;&copy;&nbsp;Design By Silence and All Rights Reversed.&nbsp;赣ICP备16012352号-1
				</div>
			</div>
		</footer>
		
		<div class="toolbar hidden-md hidden-sm hidden-xs">
			<c:choose>
				<c:when test="${empty userInfo }">
					<a href="/silence/user/login" title="我要登录" class="toolbar-item toolbar-item-login">
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
								<c:if test="${userInfo.userRank >= 6 }">
									<a href="/silence/essay/manage" title="文章管理"><span class="icon-books"></span></a>
									<a href="/silence/user/manage" title="用户管理"><span class="icon-users2"></span></a>
								</c:if>
								<a href="javascript:;" onclick="loginOut()" title="安全退出"><span class="icon-power-off"></span></a>
							</div>
						</div>
						<span class="msg-num">9</span>
					</div>
					<a href="/silence/technical/newtechnical" title="新建文章" class="toolbar-item toolbar-item-add">
						<span class="toolbar-btn"></span>
					</a>
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
			
			<a href="javascript:;" id="backTop" title="回到顶部" class="toolbar-item toolbar-item-top" onclick="move(0, 350)">
				<span class="toolbar-btn"></span>
			</a>
		</div>
		
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/technical.js" type="text/javascript" charset="utf-8"></script>
</html>
