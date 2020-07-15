<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Manage Grievances - Simply People HR Administration</title>
	<link rel="stylesheet" href="../css/style.css" >
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>	
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Grievance Management</h2>
		<h3>
			<a href="grievance_form.jsp">Create Grievance</a>
		</h3>		
	</div>
	
	<c:if test="${message != null}">
	<div align="center">
		<h4 class="message">${message}</h4>
	</div>
	</c:if>
	
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				
				<th>Employee ID</th>
				
				<th>Comment</th>
				
				<th>HR Manager ID</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="grievance" items="${listGrievances}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${grievance.grievancesId}</td>
				
				<td>${grievance.employee.employeeId}</td>
				
				<td>${grievance.comment}</td>
				
				<td>${grievance.users.usersId}</td>
				
				<td>
					<a href="edit_grievance?id=${grievance.grievancesId}">Edit</a> &nbsp;
					<a href="javascript:void(0);" class="deleteLink" id="${grievance.grievancesId}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	
	<jsp:directive.include file="footer.jsp" />
	
	<script>
		$(document).ready(function() {
			$(".deleteLink").each(function() {
				$(this).on("click", function() {
					grievancesId = $(this).attr("id");
					if (confirm('Are you sure you want to delete the grievance with ID ' +  grievancesId + '?')) {
						window.location = 'delete_grievance?id=' + grievancesId;
					}					
				});
			});
		});	
	</script>
</body>
</html>