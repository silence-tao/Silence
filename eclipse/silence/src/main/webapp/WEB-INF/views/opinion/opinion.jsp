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
		<title>陈涛个人博客-做一个热爱生活的人</title>
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
		
		<div class="path-bar container clear-both">
			<div class="fl">
				<a href="#">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">分享生活</a>
			</div>
			<div class="module-intro">
				生活的本意是爱，谁不会爱，谁就不能理解生活
			</div>
		</div>
		
		<div class="life-bar">
			<div class="life-list clear-both">
				<div class="container">
					<div class="row">
						<div class="col-lg-4">
							<div class="life-img">
								<img src="/silence/resources/img/14761734963351905.jpg" class="img-responsive" />
							</div>
							<div class="life-bottom">
								<h2 class="life-title">
									生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱
								</h2>
								<div class="life-time clear-both">
									<span class="fl">2017-02-03 13:40 By Silence</span>
									<span class="icon-bubble fr"></span>
									<span class="fr">24</span>
								</div>
								<p class="life-sumary">
									生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱。
								</p>
								<div class="life-btn">
									<a href="#" class="link-button">查看全文</a>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="life-img">
								<img src="/silence/resources/img/14761734963351905.jpg" class="img-responsive" />
							</div>
							<div class="life-bottom">
								<h2 class="life-title">
									生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱
								</h2>
								<div class="life-time clear-both">
									<span class="fl">2017-02-03 13:40 By Silence</span>
									<span class="icon-bubble fr"></span>
									<span class="fr">24</span>
								</div>
								<p class="life-sumary">
									生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱。
								</p>
								<div class="life-btn">
									<a href="#" class="link-button">查看全文</a>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="life-img">
								<img src="/silence/resources/img/14761734963351905.jpg" class="img-responsive" />
							</div>
							<div class="life-bottom">
								<h2 class="life-title">
									生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱
								</h2>
								<div class="life-time clear-both">
									<span class="fl">2017-02-03 13:40 By Silence</span>
									<span class="icon-bubble fr"></span>
									<span class="fr">24</span>
								</div>
								<p class="life-sumary">
									生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱。
								</p>
								<div class="life-btn">
									<a href="#" class="link-button">查看全文</a>
								</div>
							</div>
						</div>
						
						<div class="col-lg-4">
							<div class="life-img">
								<img src="/silence/resources/img/14761734963351905.jpg" class="img-responsive" />
							</div>
							<div class="life-bottom">
								<h2 class="life-title">
									生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱
								</h2>
								<div class="life-time clear-both">
									<span class="fl">2017-02-03 13:40 By Silence</span>
									<span class="icon-bubble fr"></span>
									<span class="fr">24</span>
								</div>
								<p class="life-sumary">
									生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱。
								</p>
								<div class="life-btn">
									<a href="#" class="link-button">查看全文</a>
								</div>
							</div>
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
	<script src="/silence/resources/js/opinion.js" type="text/javascript" charset="utf-8"></script>
</html>