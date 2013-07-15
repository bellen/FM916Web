
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'AddEvent.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript" src="kindeditor/kindeditor-min.js"></script>
	</head>

	<body>
		This is my JSP page.
		<br>		 
		<s:form action="addEvent" method="post" enctype="multipart/form-data">
		    <font color="red"><s:fielderror /></font>
		     <s:textfield name="title" label="标题" cssStyle="width:500px"/>  
			<s:file   name="file" label="展示图片上传"  cssStyle="width: 500px;"></s:file> 
			<s:label label="正文"></s:label>
			<s:textarea id="editor" name="editor"  
				cssStyle="width: 502px; height: 197px; visibility: hidden;"></s:textarea>
			<p> <s:submit value="发布" /><s:reset value="取消"></s:reset> </p>
		</s:form>

			<script type="text/javascript">
	KE.show( {
		id : "editor",
		width : "600px",
		height : "500px",
		resizeMode : 1,
		allowFileManager : true,
		imageUploadJson : "/JSPKindEditor/uploadImage.html",
		fileManagerJson : "/JSPKindEditor/uploadImgManager.html",
		accessoryTypes : "doc|xls|pdf|txt|ppt|rar|zip",
		accessoryUploadJson : "/JSPKindEditor/uploadAccessory.html"
	});
 
	    function an(){
	   //  alert(document.getElementById("vurl").value);
        KE.appendHtml("editor",'<video controls="controls" autoplay="autoplay"><source src='
        +document.getElementById("vurl").value+' type="video/mp4"/></video>');
      
        
    }
</script>
			 

 



	</body>
</html>
