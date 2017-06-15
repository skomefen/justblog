<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
	
<title>添加博客</title>
</head>
<body>
	<c:forEach var="e" items="${error }">
		${e}<br>
	</c:forEach>
	<form action="<c:url value="/post?add"/>" method="post">
		标题：<input type="text" name="title" maxlength="40">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%;">
			<tbody>
				<tr>
					<td valign="top" style="width:50%;">
						<div id="wmd-toolbar" class="wmd-toolbar"></div>
						<textarea id="wmd-input" name="context" class="wmd-input" rows="8" cols="40"></textarea>
					</td>
					<td valign="top">
						<br/>
						<div id="preview"  class="wmd-preview"></div>
						&nbsp;
					</td>
				</tr>
			</tbody>
		</table>
		作者：<input type="text" name="author">
		题头缩略图图片地址：<input type="text" name="thumbnail">
		类别：	
		<select name="postClass">
	      <optgroup label="类别" >
	      <option value = "其他">其他</option>
	      <option value ="Java">Java</option>
	      <option value ="javascript">javascript</option>
	      <option value ="mysql">mysql</option> 
	      </optgroup>
		</select> </br>
		属性：<textarea rows="8" cols="40" name="description"></textarea><br>
		标签:
		<div>
			<input id="post_tag1" type="checkbox" name = "post_tag" value="aaa">
			<label for="post_tag1">aaa</label>
		</div>
		<div>
			<input id="post_tag2" type="checkbox" name = "post_tag" value="bbb">
			<label for="post_tag2">bbb</label>
		</div>
		<br>
		<input type="submit">
	</form>
</body>
</html>