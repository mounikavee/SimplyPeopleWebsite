<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Manager</title>
<link rel="stylesheet" href="../css/style.css"/>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
	
		<h2 class="pageheading">
		<c:if test="${projectmanager!=null }">
		Edit Manager
		</c:if>
		<c:if test="${projectmanager==null }">
		Create New Manager
		</c:if>
		</h2>
	</div>


	<div align="center">
	    <c:if test="${projectmanager!=null }">
	    <form action="update_manager" method="post" id="managerForm">
	    <input type="hidden" name="pmid" value="${projectmanager.pmid}">
	    </c:if>
	    <c:if test="${projectmanager==null }">
		<form action="create_manager" method="post" id="managerForm">
		</c:if>
			<table class="form">
			
				<tr>
					<td align="right">Project ID:</td>
					<td align="left"><input type="text" value="${projectmanager.pid}"id="pid" name="pid" size="20"></td>
				</tr>
				
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" value="${projectmanager.email}"id="email" name="email" size="20"></td>
				</tr>
				
				
				<tr>
					<td align="right">Full name:</td>
					<td align="left"><input type="text"  value="${projectmanager.fullname}" id="fullname" name="fullname" size="20"></td>
				</tr>
				
				
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" value="${projectmanager.password}"id="password" name="password"
						size="20"></td>
				</tr>

				<tr>
					<td align="right">Confirm Password:</td>
					<td align="left"><input type="password" value="${projectmanager.password}"id="confirmpassword" name="confirmpassword"
						size="20"></td>
				</tr>
				
				

				

				<tr>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
					<button type="submit">Save</button>&nbsp;&nbsp;&nbsp; 
						<button id="buttonCancel">Cancel</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />

</body>

<script type="text/javascript">
$(document).ready(function(){
	$("#managerForm").validate({
		rules :{
			email:{
				required:true,
				email:true
			},
			
			pid:"required",
	        fullname: "required",
	       
	        password: "required",
	        confirmpassword: "required"
		},
		messages:{
			email:{
				required:"Please enter email",
				email :"Please enter a valid email address"
			}, 
			fullname: "Please enter full name",
			password: "Please enter password",
			confirmpassword: "Please confirm password"
		}
	});
	$("#buttonCancel").click(function(){
		history.go(-1);
	});
});
</script>
</html>