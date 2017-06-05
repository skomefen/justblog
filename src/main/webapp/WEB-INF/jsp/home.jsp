<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />	
	
<title>首页</title>
</head>
<body>
<div class="container-fluid">
 	<a href="${pageContext.request.contextPath }/login">登陆</a>
 	<c:if test="${user!=null}">
 		Hi!${user.nickname}
 	</c:if>
</div>
</body>
</html>
