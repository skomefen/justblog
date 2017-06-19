<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<c:url value="/resources/css/showPost.css" />" rel="stylesheet" type="text/css" />	
	
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    
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
<title>博客</title>
</head>
<body>
	<%@ include file="..\..\header.jsp"%>
	<div class="container">
	
		<div id="title" class="page-header">
			<h1>${post.title } <br><small>by:${post.author}</small> </h1>
		</div>

		<textarea id="wmd-input" name="context" class="wmd-input"  style="display:none">${context }</textarea>
		<div id="preview"  class="wmd-preview"></div>
	</div>
	<%@ include file="..\..\footer.jsp"%>
	
</body>
</html>