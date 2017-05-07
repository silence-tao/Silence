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
		<title>陈涛个人博客-一个不会写bug的Silence个人博客网站</title>
		<link rel="shortcut icon" href="/silence/resources/img/logo.jpg" />
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/icomoon.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/animate.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/common/silence.css"/>
		<link rel="stylesheet" type="text/css" href="/silence/resources/css/index.css"/>
		<!--[if lt IE 9]>
			<script src="/silence/resources/js/common/html5shiv.js" type="text/javascript" charset="utf-8"></script>
			<script src="/silence/resources/js/common/respond.min.js" type="text/javascript" charset="utf-8"></script>
		<![endif]-->
	</head>
	<body>
		<header>
			<div class="shade-bg">
				<div class="container header-top">
					<div class="html-logo">
						Silence
					</div>
					<nav>
						<ul>
							<li><a href="<%=basePath %>message">留言板</a></li>
							<li class="pull-bar">
								<span>关于&nbsp;<span class="icon-caret-down"></span></span>
								<div class="pull-nav">
									<a href="<%=basePath %>history">心路历程</a><br />
									<a href="<%=basePath %>about">关于博主</a>
								</div>
							</li>
							<li><a href="<%=basePath %>technical">技术分享</a></li>
							<li><a href="<%=basePath %>opinion">分享生活</a></li>
							<li><a href="<%=basePath %>">首页</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-12 header-center animated bounce">
					<p class="cn">路漫漫其修远兮</p>
					<p class="en">You cannot improve your past, but you can improve your future.</p>
				</div>
			</div>
		</header>
		
		<div id="history-box">
			
		</div>
		
		<div id="message-box">
			
		</div>
		
		<div id="opinion-box">
			
		</div>
		
		<div id="technical-box">
			
		</div>
		
		<div class="loading-bottom" id="loading-bottom">
			<span class="icon-spinner22"></span>加载中
		</div>
		
		<div class="hide" id="tpl_history_top">
			<div class="col-lg-6">
				<img src="{cover}" class="img-responsive center-block" />
			</div>
			<div class="col-lg-6 history-box">
				<div class="history-detail">
					<h2>{title}</h2>
					<p>{content}</p>
					<a href="<%=basePath %>history/detail/{historyId}" class="link-button">查看全文</a>
				</div>
			</div>
		</div>
		
		<div class="hide" id="tpl_history_bottom">
			<div class="col-lg-6 history-box">
				<div class="history-detail">
					<h2>{title}</h2>
					<p>{content}</p>
					<a href="<%=basePath %>history/detail/{historyId}" class="link-button">查看全文</a>
				</div>
			</div>
			<div class="col-lg-6">
				<img src="{cover}" class="img-responsive center-block" />
			</div>
		</div>
		
		<div class="hide" id="tpl_history_bar">
			<div class="history-bar clear-both" id="history-bar">
				<div class="container">
					<div class="row">
						{historyList}
					</div>
				</div>
			</div>
		</div>
		
		<div class="hide" id="tpl_message_detail">
			<div class="col-lg-3 message-detail">
				<div class="message-content">
					<span class="icon-quote-left"></span>
					<p>{content}</p>
					<p class="user-name">——{nikename}</p>
					<span class="icon-quote-right"></span>
				</div>
				<div class="user-header">
					<img src="{header}"/>
				</div>
			</div>
		</div>
		
		<div class="hide" id="tpl_message_bar">
			<div class="message-bar">
				<div class="message-top">
					<h2>大家怎么看我的？</h2>
					<p>最好的朋友是那种不喜欢多说，能与你默默相对而又息息相通的人</p>
				</div>
				<div class="message-list">
					<div class="container">
						<div class="row">
							{messageList}
						</div>
					</div>
				</div>
			</div>
		</div>
		
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
						<span class="fl">{publishTime}</span>
						<span class="icon-bubble fr"></span>
						<span class="fr">{commentNum}</span>
					</div>
					<p class="life-sumary">
						{summary}
					</p>
					<div class="life-btn">
						<a href="<%=basePath %>opinion/detail/{essayId}" class="link-button">查看全文</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="hide" id="tpl_opinion_bar">
			<div class="life-bar">
				<div class="life-top">
					<h2>做一个热爱生活的人</h2>
					<p>生活的本意是爱，谁不会爱，谁就不能理解生活</p>
				</div>
				<div class="life-list clear-both">
					<div class="container">
						<div class="row">
							{opinionList}
						</div>
					</div>
				</div>
			</div>
		</div>
		
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
						<a href="<%=basePath %>technical/detail/{essayId}" class="link-button">详细信息</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="hide" id="tpl_technical_bar">
			<div class="technical-bar">
				<div class="technical-top">
					<h2>追求技术是一种态度</h2>
					<p>学无止境,无论何时,无论何地,都不要停止学习</p>
				</div>
				<div class="technical-list clear-both">
					<div class="container">
						<div class="row">
							{technicalLst}
						</div>
					</div>
				</div>
			</div>
			
			<div class="mywords-bar">
				<div class="container">
					<div class="mywords-top">
					<h2>博主寄语</h2>
					<p>一个不会写bug的Silence</p>
					</div>
					<div class="my-header">
						<a href="<%=basePath %>about">
							<img src="/silence/resources/img/head.jpg" />
							<div class="header-tips">
								<span>陈涛</span>
							</div>
						</a>
					</div>
					<p class="words-content">你的遇事慌乱、抱怨、一脸苦相、不敢扛事儿、推脱、找借口、逻辑不清、没有反馈、不拘小节、不动脑、不走心的举动都会出卖你，阳光、沉稳、乐观、抗击打、思路清晰、勇于奉献、耐得住寂寞、不怕犯错、有进步、打鸡血的每一天会成就连自己都惊讶的未来。</p>
				</div>
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
		</div>
		
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
	<script src="/silence/resources/js/index.js" type="text/javascript" charset="utf-8"></script>
</html>
