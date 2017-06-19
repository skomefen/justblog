<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet" type="text/css" />



<title>首页</title>
</head>
<body>

<%@ include file="header.jsp" %>
 <div class="page">
 	<div id="context">
 		<div class="container">
	 		<div class="row">
	 			<c:forEach var="post" items="${ queryResult.result}">
	 			
				  <div class="col-sm-6 col-md-4">
				    <div class="thumbnail">
				    	<c:set var="temp" value=""></c:set>
					    <c:if test="${post.thumbnail==temp}">
					    	<img alt="挂了" src="${pageContext.request.contextPath }/resources/img/404.jpg" >
					    </c:if>
					    <c:if test="${post.thumbnail!=temp}">
							 <img src="${post.thumbnail}" alt="挂了">    
					    </c:if>
				      <div class="caption">
				        <h3><a href="${pageContext.request.contextPath }/post?show&postId=${post.id}">${post.title }</a></h3>
				        <small>
					        <p>${post.description }</p>
					        <strong><p>作者:${post.author} </p></strong>
					        <p>
					       	类别:${post["postClass"] } &nbsp;
						           标签:  
						       <c:forEach var="tag" items="${post.post_tag }">
						 			${tag}
						 		</c:forEach>
					 		</p>
					 		<p>${post.udate}</p>
				 		</small>
				      </div>
				    </div>
				  </div>
				</c:forEach>	 							  
				</div>
	 		</div>
		</div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
