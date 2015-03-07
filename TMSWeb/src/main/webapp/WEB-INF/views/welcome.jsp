<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Management System</title>
<script type="text/javascript" src="../js/jquery.slidePanel.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/tms_style.css" />
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body onload="return noBack()">

	<jsp:include page="header.jsp" />

	
	<div class="content">
		<div class="hd2" style="margin-bottom: 15px;">USER INFORMATION</div>
		<div class="box3">
			<div class="hd1" style="margin-bottom: 15px;">User Id:
				${userid}</div>
			<div class="clear"></div>

			<div class="hd1" style="margin-bottom: 15px;">User name :
				${username}</div>
			<div class="clear"></div>

			<div class="hd1" style="margin-bottom: 15px;">User Email Id:
				${useremail}</div>
			<div class="clear"></div>


			<div class="hd1" style="margin-bottom: 15px;">Role name:
				${rolename}</div>
			<div class="clear"></div>

		</div>
	</div>

</body>
</html>