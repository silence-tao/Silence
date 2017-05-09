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
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge, chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>陈涛个人博客-做一个热爱生活的人</title>
		<meta name="Keywords" content="分享生活,陈涛的个人博客,陈涛,个人博客,个人,博客,Silence,Silencetao,涛涛,小涛涛" />
		<meta name="Description" content="陈涛的个人博客,是完全由草根站长陈涛一个人自主设计开发的个人博客系统,目的是打造一个技术分享的平台" />
		<link rel="shortcut icon" href="/silence/resources/img/logo.jpg" />
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/icomoon.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/silence.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/opinion.css"/>
		<!--[if lt IE 9]>
			<script src="/silence/resources/js/common/html5shiv.js" type="text/javascript" charset="utf-8"></script>
			<script src="/silence/resources/js/common/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<![endif]-->
	</head>
	<body>
		<%@ include file="/resources/pages/header.jsp" %>
		
		<div class="hide" id="tpl_opinion_detail">
			<div class="col-lg-4">
				<div class="life-img">
					<img src="{cover}" class="img-responsive" />
				</div>
				<div class="life-bottom">
					<h2 class="life-title">
						{title}
					</h2>
					<div class="life-time clear-both">
						<span class="fl">{publishTime} By {nikename}</span>
						<span class="icon-bubble fr"></span>
						<span class="fr">{commentNum}</span>
					</div>
					<p class="life-sumary">
						{summary}
					</p>
					<div class="life-btn">
						<a href="<%=basePath %>opinion/detail/{opinionId}" class="link-button">查看全文</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="path-bar container clear-both">
			<div class="fl">
				<a href="<%=basePath %>">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">分享生活</a>
			</div>
			<div class="module-intro">
				生活的本意是爱，谁不会爱，谁就不能理解生活
			</div>
		</div>
		
		<div class="life-bar">
			<div class="life-list clear-both">
				<div class="container">
					<div class="row" id="opinion-list">
						
					</div>
				</div>
			</div>
		</div>
		
		<div class="page-bar">
			
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
					<a href="<%=basePath %>about">关于博主</a>
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
					<a href="<%=basePath %>user/login" title="我要登录" class="toolbar-item toolbar-item-login">
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
								<a href="<%=basePath %>user/info" title="个人中心"><span class="icon-home2"></span></a>
								<!-- <a href="<%=basePath %>user/message" title="消息中心"><span class="icon-envelope"><span class="message-num">9</span></span></a> -->
								<c:if test="${userInfo.userRank >= 6 }">
									<a href="<%=basePath %>essay/manage" title="文章管理"><span class="icon-books"></span></a>
									<a href="<%=basePath %>user/manage" title="用户管理"><span class="icon-users2"></span></a>
								</c:if>
								<a href="javascript:;" onclick="loginOut()" title="安全退出"><span class="icon-power-off"></span></a>
							</div>
						</div>
						<!-- <span class="msg-num">9</span> -->
					</div>
				</c:otherwise>
			</c:choose>
			
			<c:if test="${userInfo.userRank >= 6 }">
				<a href="<%=basePath %>opinion/newopinion" title="添加一条" class="toolbar-item toolbar-item-add">
					<span class="toolbar-btn"></span>
				</a>
			</c:if>
			
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
	<script src="/silence/resources/js/opinion.js" type="text/javascript" charset="utf-8"></script>
</html>
