<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />	
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet" type="text/css" />	
<title>首页</title>
</head>
<body>
<div class="container">
 	<div class="row">
		<div class="header">
			<div id="user_nav">
				<c:if test="${user==null }">
			 		<a href="${pageContext.request.contextPath }/login">登陆</a>
			 	</c:if>
			 	<c:if test="${user!=null}">
			 		Hi!! ${user.nickname}
			 		<a href="${pageContext.request.contextPath }/signout" >注销</a>
			 	</c:if>
		 	</div>
	 	</div>
 	</div>
 	<div class="page">
 		<div class="row">
	 		<div id="branding" class="col-md-12">
	 			<span>justblog</span>
	 		</div>
 		</div>
 		<div id="context">
	 		<div class="row" >
		   		<c:forEach var="post" items="${ queryResult.result}">
		   			<div class="postlist">
		   				<div class="row">
			   				<div class="col-xs-12 col-sm-4 col-md-2">
			   					<div class="thumbnail"><img src="${post.thumbnail}" ></div>
			   				</div>
				 			<div class="col-xs-12 col-sm-8 col-md-4 title">&nbsp;<a href="${pageContext.request.contextPath }/post?show&postId=${post.id}">${post.title }</a></div>
				 	   		<div class="col-xs-12 col-sm-6 col-md-4 author"> &nbsp;作者：${post.author }</div>
			 	   		</div>
			 	   		<div class="row">
			 				<div class="col-xs-12 col-sm-12 col-md-12">&nbsp;描述：${post.description }</div>
			 				<div class="col-xs-12 col-sm-2 col-md-2"> &nbsp;类别：${post[postClass] }</div>
				 			<div class="col-xs-12 col-sm-12 col-md-4">
				 				&nbsp;标签：
				 				<c:forEach var="tag" items="${post.post_tag }">
				 					&nbsp;${tag}
				 				</c:forEach>
				 			</div>
				 			<div class="col-ma-4">&nbsp;更新时间：${post.udate}</div>
			 			</div>
						<br>
						<br>
					</div>
		 		</c:forEach>	 			
		 	</div>
	 	</div>
	</div>
</div>
</body>
</html>
