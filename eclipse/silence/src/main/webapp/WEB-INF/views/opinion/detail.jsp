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
		<title>生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱</title>
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
				<a href="#">首页</a>&nbsp;/&nbsp;<a href="#">分享生活</a>&nbsp;/&nbsp;
				<a href="#" class="no-pointer">生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱</a>
			</div>
		</div>
		
		<div class="detail-bar clear-both">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 detail-box">
						<h1>生活的本意是爱，谁不会爱生活的本意是爱，谁不会爱</h1>
						<div class="opinion-info">
							发布时间：2017-04-20 21:39&nbsp;&nbsp;&nbsp;&nbsp;编辑：Silence&nbsp;&nbsp;458<span class="icon-eye2"></span>&nbsp;&nbsp;21<span class="icon-bubble"></span>
						</div>
						<div class="opinion-content">
							
						</div>
						<div class="opinion-near">
							<p>上一篇：<a href="#">关于什么</a></p>
							<p>下一篇：<a href="#">热爱生活家</a></p>
						</div>
						<div class="comment-box">
							<h2>用户评论区</h2>
							<div class="comment-publish">
								<textarea name=""></textarea>
								<input type="button" name="" id="" value="发表" />
							</div>
							<div class="comment-list">
								<div class="comment-detail clear-both">
									<div class="fl father-header">
										<img src="../resources/img/14749103673516675.jpg"/>
									</div>
									<div class="fl comment-content">
										<div class="father-info">
											<a href="#">Silence</a>：搞了一会才发现，finslly语句中的return会吃掉throw的异常，我也是醉了
											<p>2017-04-20 23:17&nbsp;<a href="#">回复</a></p>
										</div>
										<div id="">
											<div class="sub-publish clear-both">
												<div class="fl sub-header">
													<img src="../resources/img/14749103850681742.jpg"/>
												</div>
												<div class="fl sub-input">
													<input type="text" name="" id="" value="" />
												</div>
											</div>
											<div class="sub-btn clear-both">
												<input type="button" name="" id="" value="回复" />
											</div>
										</div>
										<div class="sub-detail clear-both">
											<div class="fl sub-header">
												<img src="../resources/img/14749103673516675.jpg"/>
											</div>
											<div class="fl sub-info">
												<a href="#">Silence</a>：搞了一会才发现，finslly语句中的return会吃掉throw的异常，我也是醉了
												<p>2017-04-20 23:17&nbsp;<a href="#">回复</a></p>
											</div>
										</div>
										<div id="">
											<div class="sub-publish clear-both">
												<div class="fl sub-header">
													<img src="../resources/img/14749103850681742.jpg"/>
												</div>
												<div class="fl sub-input">
													<input type="text" name="" id="" value="" />
												</div>
											</div>
											<div class="sub-btn clear-both">
												<input type="button" name="" id="" value="回复" />
											</div>
										</div>
										<div class="sub-detail clear-both">
											<div class="fl sub-header">
												<img src="../resources/img/14749103673516675.jpg"/>
											</div>
											<div class="fl sub-info">
												<a href="#">Silence</a>：搞了一会才发现，finslly语句中的return会吃掉throw的异常，我也是醉了
												<p>2017-04-20 23:17&nbsp;<a href="#">回复</a></p>
											</div>
										</div>
									</div>
								</div>
								
								<div class="comment-detail">
									<div class="fl father-header">
										<img src="../resources/img/14749103673516675.jpg"/>
									</div>
									<div class="fl comment-content">
										<div class="father-info">
											<a href="#">Silence</a>：搞了一会才发现，finslly语句中的return会吃掉throw的异常，我也是醉了搞了一会才发现，finslly语句中的return会吃掉throw的异常，我也是醉了搞了一会才发现，finslly语句中的return会吃掉throw的异常，我也是醉了
											<p>2017-04-20 23:17&nbsp;<a href="#">回复</a></p>
										</div>
										<div id="">
											<div class="sub-publish clear-both">
												<div class="fl sub-header">
													<img src="../resources/img/14749103850681742.jpg"/>
												</div>
												<div class="fl sub-input">
													<input type="text" name="" id="" value="" />
												</div>
											</div>
											<div class="sub-btn clear-both">
												<input type="button" name="" id="" value="回复" />
											</div>
										</div>
									</div>
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
		
	</body>
	<script src="/silence/resources/js/common/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/common/silence.js" type="text/javascript" charset="utf-8"></script>
	<script src="/silence/resources/js/opinion.js" type="text/javascript" charset="utf-8"></script>
</html>
