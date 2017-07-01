<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />	

<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet" type="text/css" />	

<div id="header">
 	<div class="container">
		<div class="page-header">
			<div id="user_nav">
				<c:if test="${user==null }">
			 		<a class="btn btn-lg btn-default " href="${pageContext.request.contextPath }/login">登陆</a>
			 		<a class="btn btn-lg btn-default " href="${pageContext.request.contextPath }/user?register">注册</a>
			 		
			 	</c:if>
			 	<c:if test="${user!=null}">
			 		<div class="btn-group">
			 		  <button type="button" class="btn btn-lg btn-default">Hi!! ${user.nickname}</button>
					  <button class="btn btn-lg btn-default dropdown-toggle "  type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    <span class="caret"></span>
					    <span class="sr-only">Toggle Dropdown</span>
					  </button>
					  <ul id="menu" class="dropdown-menu pull-right" >
					  	 <li><a href="${pageContext.request.contextPath }/post?add">写博客</a></li>
					     <li role="separator" class="divider"></li>
					    <li><a href="${pageContext.request.contextPath }/signout">注销</a></li>
					  </ul>
					</div>
			 	</c:if>
	 		</div>
			<div id="brand"><h1>justblog</h1></div>
	
	 	</div>
	</div>
 </div>
