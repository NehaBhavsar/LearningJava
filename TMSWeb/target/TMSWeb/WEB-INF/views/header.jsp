<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Management System</title>
</head>
<body onload="noBack();" onunload="">
	<table>
		<tr>
			<td><div class="imgbg">
					<img src="../images/home_bg2.jpg">
				</div></td>
		</tr>
		<tr>
			<td>
				<header class="header">
				<div class="right">
					<ul class="top_link">
						<li><a href="home.do">Home</a></li>
						<li>Welcome, ${username}</li>
						<li>Role : ${rolename}</li>
						<li><a href="logout.do">Logout</a></li>
					</ul>
				</div>
				</header>
			</td>
		</tr>
	</table>
	<jsp:include page="sidebar.jsp" />

</body>
</html>