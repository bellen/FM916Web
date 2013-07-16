<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EventManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body> 
    PThis is my JSP page. <br>
    <s:form action="getEvent" method="GET">
    <s:iterator value="list" >
      <s:property value="idEvent"/>
       <s:property value="title"/>
      <s:property value="banner"/>
      <br/>
    </s:iterator>
    
    <s:url id="url_pre" value="getEvent.action">
      <s:param name="currentPage" value="currentPage-1"></s:param>
    </s:url>
    <s:url id="url_next" value="getEvent.action">
      <s:param name="currentPage" value="currentPage+1"></s:param>
    </s:url>
    
    <s:a href="%{url_pre}">Pre</s:a>
    <s:iterator value="pageList" status="status">
    <s:url id="url" value="getEvent.action">
    <s:param name="currentPage" value="currentPage"></s:param>
    </s:url>
    <s:a href="%{url}"><s:property value="currentPage"/></s:a>
    </s:iterator>
    <s:a href="%{url_next}">Next</s:a>
    </s:form>
  </body>
</html>
