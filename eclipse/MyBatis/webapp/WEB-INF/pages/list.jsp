<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>文章列表</title>
	</head>
	<body>
		<c:forEach items="${articles }" var="article">
			${article.id }--${article.title }--${article.content }<br />
		</c:forEach>
	</body>
</html>