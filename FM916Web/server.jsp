<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'server.jsp' starting page</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="resources/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.date.js"></script>

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
		<table width="100%" height="700" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="30%" height="100%" valign="top">
					<div id="sidebar">
						<div id="sidebar-wrapper">
							<!-- Sidebar with logo and menu -->
							<h1 id="sidebar-title">
								<a href="#">Simpla Admin</a>
							</h1>
							<!-- Logo (221px wide) -->
							<a href="#"><img id="logo"
									src="resources/images/logo.png" alt="Simpla Admin logo" />
							</a>
							<!-- Sidebar Profile links -->
							<div id="profile-links">
								 
								<a href="#" title="View the Site">View the Site</a> |
								<a href="#" title="Sign Out">Sign Out</a>
							</div>
							<ul id="main-nav">
								<!-- Accordion Menu -->
								<li>
									<a href="#" class="nav-top-item no-submenu">
										<!-- Add the class "no-submenu" to menu items with no sub menu -->
										首页管理 </a>
								</li>
								<li>
									<a href="#" class="nav-top-item current"> <!-- Add the class "current" to current menu item -->
										事件 </a>
									<ul>
										<li>
											<a href="AddEvent.jsp" target="mainFrame" >添加</a>
										</li>
										<li>
											<a class="current" href="#" target="mainFrame" >管理</a>
										</li>
										 
									</ul>
								</li>
								<li>
									<a href="#" class="nav-top-item"> 节目 </a>
									<ul>
										<li>
											<a href="#" target="mainFrame" >上传节目单</a>
										</li>
										 
									</ul>
								</li>
								<li>
									<a href="#" class="nav-top-item"> 视频</a>
									<ul>
										<li>
											<a href="#">添加</a>
										</li>
										<li>
											<a href="#">删除</a>
										</li>
									
									</ul>
								</li>
								<li>
									<a href="#" class="nav-top-item">主持人 </a>
									<ul>
										<li>
											<a href="#">添加</a>
										</li>
										<li>
											<a href="#">删除</a>
										</li> 
									</ul>
								</li>
							 
							</ul>
							<!-- End #main-nav -->
							<div id="messages" style="display: none">
								<!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
								<h3>
									3 Messages
								</h3>
								<p>
									<strong>17th May 2009</strong> by Admin
									<br />
									Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Vivamus magna. Cras in mi at felis aliquet congue.
									<small><a href="#" class="remove-link"
										title="Remove message">Remove</a>
									</small>
								</p>
								<p>
									<strong>2nd May 2009</strong> by Jane Doe
									<br />
									Ut a est eget ligula molestie gravida. Curabitur massa. Donec
									eleifend, libero at sagittis mollis, tellus est malesuada
									tellus, at luctus turpis elit sit amet quam. Vivamus pretium
									ornare est.
									<small><a href="#" class="remove-link"
										title="Remove message">Remove</a>
									</small>
								</p>
								<p>
									<strong>25th April 2009</strong> by Admin
									<br />
									Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Vivamus magna. Cras in mi at felis aliquet congue.
									<small><a href="#" class="remove-link"
										title="Remove message">Remove</a>
									</small>
								</p>
								<form action="#" method="post">
									<h4>
										New Message
									</h4>
									<fieldset>
										<textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
									</fieldset>
									<fieldset>
										<select name="dropdown" class="small-input">
											<option value="option1">
												Send to...
											</option>
											<option value="option2">
												Everyone
											</option>
											<option value="option3">
												Admin
											</option>
											<option value="option4">
												Jane Doe
											</option>
										</select>
										<input class="button" type="submit" value="Send" />
									</fieldset>
								</form>
							</div>
							<!-- End #messages -->
						</div>
					</div>

				</td>
				<td width="80%" valign="top" >
					<iframe src="#" name="mainFrame" frameborder="0" marginheight="0"
						marginwidth="0" height="700" width="100%" align="left"></iframe>
				</td>
			</tr>
		</table>
	</body>
</html>
