<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/register.css"/>"/>

	<title>注册</title>
</head>
<body>
		<%@ include file="..\..\header.jsp"%>
		<br>
		<br>
		<div class="container">
			
			<form action="<c:url value="user?register"/>" method="post"> 
				
				<div class="form-group">
					<label for="username">用户名：</label>
					<input type="text" name="username" class="form-control" id="username" placeholder="用户名">
				</div>
				<c:if test="${error.username!=null}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>错误！</strong> ${error["username"]}
					</div>
				</c:if>
					
				<div class="form-group">
					<label for="password">密码：</label>
					<input type="password" name="password" class="form-control" id="password" placeholder="密码">
				</div>
				<c:if test="${error.password!=null}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>错误！</strong> ${error["password"]}
					</div>	
				</c:if>		
			
				<div class="form-group">
					<label for="nickname">昵称：</label>
					<input type="text" name="nickname" class="form-control" id="nickname" placeholder="昵称">
				</div>
				<c:if test="${error.nickname!=null}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>错误！</strong> ${error["nickname"]}
					</div>
				</c:if>
								
				<div class="form-group">
					<label for="email">邮件：</label>
					<input type="email" name="email" class="form-control" id="email" placeholder="邮件">
				</div>
				<c:if test="${error.email!=null}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>错误！</strong> ${error["email"]}
					</div>
				</c:if>
				
				<div class="form-group">
					<label for="phone">手机电话：</label>
					<input type="text" name="phone" class="form-control" id="phone" placeholder="手机电话">
				</div>
				<c:if test="${error.phone!=null}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong>错误！</strong> ${error["phone"]}
					</div>
				</c:if>
				
				<div class="col-sm-offset-5 col-sm-7">
					<input id="submit" type="submit" class="btn btn-default" value="注册">
					<input id="reset" type="reset" class="btn btn-default" value="重置">
				</div>
			</form>
		
		</div>
		<br>
		<br>
		<%@ include file="..\..\footer.jsp"%>
	
</body>
</html>