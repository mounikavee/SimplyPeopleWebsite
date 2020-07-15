<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../css/style.css" >
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>	
<title>Create New Review</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">
		<c:if test="${review!=null }">
		Edit Review
		</c:if>
		<c:if test="${review==null }">
		Create New Review
		</c:if>
		</h2>
	</div>
	
	<div align="center">
	<c:if test="${review!=null }">
	    <form action="update_review" method="post" id="reviewForm">
	    <input type="hidden" name="reviewId" value="${review.reviewId}">
	   
	    </c:if>
	    <c:if test="${review==null }">
		<form action="create_review" method="post" id="reviewForm">
		
		</c:if>
		

		
		<table class="form">
			
			<tr>
				<td align="right">Employee Id:</td>
				<td align="left"><b><input type="text" value="${review.employee.employeeId}" id="empid" name="empid" size="20"></b></td>
			</tr>
			
			<tr>
				<td align="right">ProjectManager Id:</td>
				<td align="left"><b><input type="text" value="${review.projectmanager.pmid}" id="pmid" name="pmid" size="20"></b></td>
			</tr>
			
			<tr>
				<td align="right">Rating:</td>
				<td align="left"><b><input type="text" value="${review.rating}" id="rating" name="rating" size="20"></b></td>
			</tr>
			
			
			
			<tr>
				<td align="right">Comment:</td>
				<td align="left">
					<textarea rows="5" cols="70" id="comment" name="comment">${review.comment}</textarea>
				</td>
			</tr>			
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
					<input type="button" id="buttonCancel" value="Cancel" />
				</td>
			</tr>				
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
$(document).ready(function() {
	$("#reviewForm").validate({
		rules: {	
			
			comment: "required"
		},
		
		messages: {
			
			comment: "Please enter comment",
		}
	});
	
	$("#buttonCancel").click(function() {
		history.go(-1);
	});	
});
</script>
</html>