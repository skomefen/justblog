<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/addPost.css"/>"/>
    
    <!--  wmd  -->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/wmd.css"/>"/>
    <script type="text/javascript" src="<c:url value="/resources/js/wmd/wmd.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/wmd/showdown.js"/>"></script>
    
 	<script type="text/javascript" src="<c:url value="/resources/js/wmd/translator.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/wmd/chunk.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/wmd/inputstate.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/wmd/command.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/wmd/dialog.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/wmd/form.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/wmd/field.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/wmd/linkhelper.js"/>"></script>
	
	<style type="text/css">
		.wmd-command { background-image: url(<c:url value="/resources/img/wmd-toolbar.png"/>); }
		.wmd-input { width: 100%; height: 400px; }
	</style>
	<script type="text/javascript">
		//wmd
		var wmd;
		window.onload = function() {
			wmd = new WMD("wmd-input", "wmd-toolbar", {preview: "preview"});
		};

	</script>
	
<title>添加博客</title>
</head>
<body>
	<%@ include file="..\..\header.jsp"%>
	
	<div class="container">
		<br>
		<c:forEach var="e" items="${error }">
		<div class="alert alert-danger alert-dismissible" role="alert">
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		  <strong>错误！</strong> ${e}
		</div>
			
		</c:forEach>
		<form action="<c:url value="/post?add"/>" method="post">
			<div class="form-group">
			   <label for="title">标题：</label>
			   <input type="text" name="title" class="form-control" id="title" placeholder="标题">
			 </div>
			 
			<div id="wmd-toolbar" class="wmd-toolbar"></div>
			<textarea id="wmd-input" name="context" class="wmd-input form-control" rows="8" cols="40" placeholder="正文"></textarea>
			<br/>
			
			<div id="preview"  class="wmd-preview"></div>
			<br>
			<br>
			<br>
			
			<div class="form-inline">
				<div class="form-group">
					<label for="author">作者：</label>
					<input type="text" name="author" class="form-control" id="author" placeholder="作者">
				</div>
				<div class="form-group">
					<label for="thumbnail">题图：</label>
					<input type="text" name="thumbnail" class="form-control" id="thumbnail" placeholder="图片地址">
				</div>
				<label for="postClass">类别：</label>
				<select class="form-control" name="postClass" id="postClass">
			      <optgroup label="类别" >
			      <option value = "其他">其他</option>
			      <option value ="Java">Java</option>
			      <option value ="javascript">javascript</option>
			      <option value ="mysql">mysql</option> 
			      </optgroup>
				</select>
			</div>
			 </br>
			 <label for="description">描述：</label>
			<textarea id="description" class="form-control" rows="3" name="description" placeholder="描述"></textarea><br>
			<label >标签：</label><br>	
			<div class="form-control">		
				<label class="checkbox-inline">
					<input id="post_tag1" type="checkbox" name = "post_tag" value="aaa">aaa
				</label>
				<label class="checkbox-inline">
					<input id="post_tag2" type="checkbox" name = "post_tag" value="bbb">bbb
				</label>
			</div>
			<div class="col-sm-offset-5 col-sm-7">
				<input id="submit" type="submit" class="btn btn-default" value="写完提交">
			</div>
		</form>
	</div>
	<%@ include file="..\..\footer.jsp"%>
	
</body>
</html>