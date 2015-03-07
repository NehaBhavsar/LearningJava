<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Management System</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script language="javascript" src="../js/jquery-1.6.4.js"></script>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/tms_style.css" />
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}

	$(document).ready(function(){
	$("#reset").click(function() {		
		$("#txnmessage").hide();
		$("#ticket option[value='']").attr("selected", "selected");
		$("#ticketDesc").val("");
	});
	});
	
</script>
</head>
<body onload="return noBack()">

	<jsp:include page="header.jsp" />
<div id="txnmessage">
				<p class="hd" style="text-align: center;">${txnmessage}</p>
			</div>
	<div class="content">
		<div class="box3">
			
			<form:form action="createticket.do" method="post"
				commandName="ticketvo">
				<p class="hd">Create Ticket</p>

				<div class="lable1">Issue Type:</div>
				<div class="lab_rght fb">
					<form:select path="ticket.ticketId" id="ticket">
						<form:option value="" label="--Please Select--" />
						<form:options items="${ticketList}" itemValue="ticketId"
							itemLabel="ticketType" />
					</form:select>
				</div>
				<div class="clear"></div>
				<div class="lable1">Issue Description:</div>
				<div class="lab_rght fb">
					<textarea id="ticketDesc" value="" class="input" name="ticketDesc"></textarea>
					<%-- <form:textarea path ="ticket.ticketDesc" name = "ticketDesc" id="ticketDesc" /> --%>
				</div>

				<div class="clear"></div>
				<div class="lable1"></div>
				<div class="left">
					<input type="submit" class="button mt10" value="Submit"
						name="submit" /> <input type="reset" id="reset"
						class="button mt10 " value="Reset" name="reset" />


				</div>
				<div class="clear"></div>
				<div class="lable1"></div>
				<div class="clear" style="margin-bottom: 50px;"></div>
			</form:form>
		</div>

	</div>


</body>
</html>