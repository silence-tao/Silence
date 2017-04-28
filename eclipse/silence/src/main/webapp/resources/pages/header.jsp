<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	String pathHeader = request.getContextPath();
	String baseHeader = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathHeader+"/";
%>
<header class="container">
	<div class="html-logo">
		Silence
	</div>
	<nav>
		<ul>
			<li><a href="/silence/message">留言板</a></li>
			<li class="pull-bar">
				<span>关于&nbsp;<span class="icon-caret-down"></span></span>
				<div class="pull-nav">
					<a href="/silence/history">心路历程</a><br />
					<a href="/silence/about">关于博主</a>
				</div>
			</li>
			<li><a href="/silence/technical">技术分享</a></li>
			<li><a href="/silence/opinion">分享生活</a></li>
			<li><a href="/silence">首页</a></li>
		</ul>
	</nav>
</header>