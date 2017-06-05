<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>登陆页面</title>

    <!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />	

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="post" action="<c:url value="/signin"/>">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="username" class="sr-only">用户名</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
        <c:if test="${ message!=null}">
	        <div class="row">
				<div class="col-sm-12">
					<div class="alert alert-danger" role="alert">
		        		<strong>${message }</strong> 
		      		</div>
				</div>
			</div>
		</c:if>
      </form>

    </div> <!-- /container -->


  </body>
</html>
