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
<script type="text/javascript" src="../js/jquery.jqGrid.min.js"></script>

<link rel="stylesheet" type="text/css" href="../css/ui.jqgrid.css">
<link rel="stylesheet" type="text/css"
	href="../css/ui-lightness/jquery-ui-1.8.6.custom.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/tms_style.css" />
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}

	jQuery(document).ready(
			function() {
				jQuery("#ticketDetails").jqGrid(
						{

							url : 'ticketDetails.do',
							datatype : "json",
							width : 500,
							height : 180,
							colNames : [ 'TxnId', 'TicketType', 'CreatedUser',
									'CreatedOn', 'Status' ],
							colModel : [ {
								name : 'txnid',
								index : 'txnid',
								align : 'center',
								sortable : false
							}, {
								name : 'ticketype',
								index : 'ticketype',
								align : 'center',
								sortable : false
							}, {
								name : 'cruser',
								index : 'cruser',
								align : 'center',
								sortable : false
							}, {
								name : 'crdate',
								index : 'crdate',
								align : 'center',
								sortable : false
							}, {
								name : 'status',
								index : 'status',
								align : 'center',
								sortable : false
							}, ],
							rowNum : 10,
							rowList : [ 5, 10, 15 ],
							viewrecords : true,
							pager : '#ticketDetailsPager',
							multiselect : false,
							ignoreCase : true,
							imgpath : "themes/basic/images",
							caption : "Ticket Details",
							loadComplete : function() {
								var grid = $("#ticketDetails");
								grid.setGridHeight('auto');
							}
						});
			});
</script>
</head>
<body onload="return noBack()">

	<jsp:include page="header.jsp" />

	<div class="searchcontent">

		<table>
			<tr>
				<td>
					<div class="clear"></div>
					<div>
						<table id="ticketDetails"></table>
						<div id="ticketDetailsPager"></div>
					</div>
					<div class="clear"></div>
				</td>
				<td>Update</td>
			</tr>
		</table>

	</div>

</body>
</html>