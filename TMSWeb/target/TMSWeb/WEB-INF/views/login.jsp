<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/webstyle.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link rel="stylesheet" type="text/css" href="../css/tms_style.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="../css/ui-lightness/jquery-ui-1.8.6.custom.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="../css/ui.jqgrid.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script language="javascript" src="../js/jquery-1.6.4.js"></script>
<script src="../js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="../js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="../tms_js/forgotpwd.js" type="text/javascript"></script>
<link href="../css/thickbox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/thickbox.js"></script>
<script type="text/javascript" src="../js/html5.js"></script>
<script src="../tms_js/googleSeoScript.js" type="text/javascript"></script>

<title>Ticket Management System</title>

<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
		$("#userName").focus();
	}
	
	 function refresh()
     {       
        // alert("call...");
         var d = new Date();
         $("#captcha").attr("src", "../CaptchServlet.jpg?"+d.getTime());
     }
     jQuery(document).ready(function(){
         $("#showdialog").click(function(){ 
             tb_show("Forgot Password","forgotpassword.do?height=130&width=300");
         });
         window.onload = function() 
         {
             $('#captchafield').bind("cut copy paste",function(e) 
             {
                 e.preventDefault();
             });
         };
         $("#username").focus();
         //FUNCTION USED TO VALIDATE USERNAME AND PASSWORD ON CLICK OF SUBMIT BUTTON
         $("#submit").click(function(){
             var userName = $("#username").val();
             var password = $("#password").val();
             var captchafield = $("#captchafield").val();
             
             userName = jQuery.trim(userName);
             password = jQuery.trim(password);
             captchafield = jQuery.trim(captchafield);
             
             if(userName=="" || password == "" || captchafield == ""){
                 alert("All fields are required.");
                 return false;
             }
           
         });
     });          
     function clearFields()
     {
    	 $("#message").hide();
         $("#username").val("");
         $("#password").val("");
         $("#captchafield").val("");
         return false;
     }
	
</script>
</head>
<body onload="noBack();" onunload="">
	<div class="imgbg">
		<img src="../images/home_bg2.jpg">
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div id="message"><p class="hd" style="text-align: center;">${message}</p></div>
	<form:form action="loginAuth.do" method="post" commandName="uservo">
		<section class="section">
		<div class="box4" style="margin-top: 50px;">
			<p class="hd" style="text-align: center;">Enter Your Login
				Details</p>

			<div class="lable">User Name:</div>
			<div class="lab_rght fb">
				<input type="text" id="username" value="" class="input"
					name="username">
			</div>
			<div class="clear"></div>
			<div class="lable mt10">Password:</div>
			<div class="lab_rght mt10">
				<input type="password" id="password" value="" class="input"
					name="password">
			</div>
			<div class="clear"></div>
			<div class="lable mt10"></div>
			<div class="right">
				<table>
					<tr>
						<td><img src="../CaptchServlet.jpg" id="captcha" /></td>
						<td><img src="../images/download.jpg" height="40" width="40"
							alt="Refresh" onclick="return refresh();" /> <br /></td>
					</tr>
				</table>

				<div class="clear"></div>
			</div>
			<div class="lable mt10">Type the code shown:</div>
			<div class="lab_rght mt10">
				<input type="text" name="captchafield" id="captchafield"
					class="input" value="" autocomplete="off" onDrag="return false"
					onDrop="return false" onselectstart="return false" />
			</div>
			<div class="lable"></div>
			<div class="fgotlink">
				<a class="fgotlink" id="showdialog"
					style="cursor: hand; color: #020E1D; text-decoration: underline; font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold;">
					Forgot Password </a>
			</div>
			<div class="clear"></div>
			<div class="lable"></div>
			<div class="left">
				<input type="submit" id="submit" class="button mt10" value="Login" />
				<input type="reset" class="button mt10 ml5" value="Cancel"
					onclick="clearFields()" />
			</div>
			<div class="clear"></div>
		</div>
		</section>
	</form:form>
</body>
</html>