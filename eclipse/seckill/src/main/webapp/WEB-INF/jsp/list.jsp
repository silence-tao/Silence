<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html; charset=UTF-8">
		<title>秒杀列表</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="utf-8">
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
		<!-- 可选的Bootstrap主题文件（一般不使用） -->
		<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap-theme.min.css"></script>
		
		<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
		<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading text-center">
					<h2>秒杀列表</h2>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>名称</th>
								<th>库存</th>
								<th>开始时间</th>
								<th>结束时间</th>
								<th>创建时间</th>
								<th>详情页</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sk" items="${list }">
								<tr>
									<td>${sk.name }</td>
									<td>${sk.number }</td>
									<td>
										<fmt:formatDate value="${sk.startTime }" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
										<fmt:formatDate value="${sk.endTime }" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
										<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
										<a class="btn btn-info" href="/seckill/seckill/${sk.seckillId }/detail" target="_blank">link</a>
									</td>
								</tr>	
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</html>