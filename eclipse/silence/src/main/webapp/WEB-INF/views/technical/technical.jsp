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
		
		<div class="path-bar container clear-both">
			<div class="fl">
				<a href="#">首页</a>&nbsp;/&nbsp;<a href="#" class="no-pointer">技术分享</a>
			</div>
			<div class="module-intro">
				学无止境,无论何时,无论何地,都不要停止学习
			</div>
		</div>
		
		<div class="technical-bar">
			<div class="technical-list clear-both">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">
							<div class="technical-detail">
								<div class="user-info">
									<div class="user-header"><img src="/silence/resources/img/14749103850681742.jpg" /></div>
									<a href="#">Silence</a>
									<p>2017-04-19 17:45</p>
								</div>
								<div class="technical-content">
									<div class="technical-img">
										<img src="/silence/resources/img/14749103673516675.jpg" class="img-responsive" />
									</div>
									<div class="technical-info">
										<h2 class="technical-title">学无止境,无论何时,无论何地<a href="#">[技术分类]</a></h2>
										<p class="technical-sumary">何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地</p>
									</div>
									<a href="#" class="link-button">详细信息</a>
								</div>
							</div>
						</div>
						
						<div class="col-lg-6">
							<div class="technical-detail">
								<div class="user-info">
									<div class="user-header"><img src="/silence/resources/img/14749103850681742.jpg" /></div>
									<a href="#">Silence</a>
									<p>2017-04-19 17:45</p>
								</div>
								<div class="technical-content">
									<div class="technical-img">
										<img src="/silence/resources/img/14749103673516675.jpg" class="img-responsive" />
									</div>
									<div class="technical-info">
										<h2 class="technical-title">学无止境,无论何时,无论何地<a href="#">[技术分类]</a></h2>
										<p class="technical-sumary">何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地</p>
									</div>
									<a href="#" class="link-button">详细信息</a>
								</div>
							</div>
						</div>
						
						<div class="col-lg-6">
							<div class="technical-detail">
								<div class="user-info">
									<div class="user-header"><img src="/silence/resources/img/14749103850681742.jpg" /></div>
									<a href="#">Silence</a>
									<p>2017-04-19 17:45</p>
								</div>
								<div class="technical-content">
									<div class="technical-img">
										<img src="/silence/resources/img/14749103673516675.jpg" class="img-responsive" />
									</div>
									<div class="technical-info">
										<h2 class="technical-title">学无止境,无论何时,无论何地<a href="#">[技术分类]</a></h2>
										<p class="technical-sumary">何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地</p>
									</div>
									<a href="#" class="link-button">详细信息</a>
								</div>
							</div>
						</div>
						
						<div class="col-lg-6">
							<div class="technical-detail">
								<div class="user-info">
									<div class="user-header"><img src="/silence/resources/img/14749103850681742.jpg" /></div>
									<a href="#">Silence</a>
									<p>2017-04-19 17:45</p>
								</div>
								<div class="technical-content">
									<div class="technical-img">
										<img src="/silence/resources/img/14749103673516675.jpg" class="img-responsive" />
									</div>
									<div class="technical-info">
										<h2 class="technical-title">学无止境,无论何时,无论何地<a href="#">[技术分类]</a></h2>
										<p class="technical-sumary">何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地无止境,无论何时,无论何地学无止境,无论何时,无论何地</p>
									</div>
									<a href="#" class="link-button">详细信息</a>
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
	<script src="/silence/resources/js/technical.js" type="text/javascript" charset="utf-8"></script>
</html>
