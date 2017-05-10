<%@page import="com.silencetao.utils.PropertiesUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	String basePath = PropertiesUtil.getProperties("basePath");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>抱歉-页面好像出错了</title>
		<link rel="shortcut icon" href="../img/logo.png" />
		<style type="text/css">
			/********************404页面CSS代码********************/
			.error-404 {
				text-align: center;
				margin: 100px auto;
			}
			
			.error-404 h1 {
				font-size: 160px;
				font-family: "agency fb";
				color: #627492;
				line-height: 180px;
				margin: 0;
			}
			
			.error-404 p,
			.error-404 a {
				font-family: "微软雅黑";
				color: rgba(73, 94, 130, 0.5);
				text-decoration: none;
			}
			/********************404页面CSS代码********************/
		</style>
	</head>
	<body style="background: #F4F4F4;">
		<div class="error-404">
			<h1>500</h1>
			<p>您要访问的页面好像出错了</p>
			<a href="<%=basePath %>">返回主页</a>
		</div>
	</body>
</html>
