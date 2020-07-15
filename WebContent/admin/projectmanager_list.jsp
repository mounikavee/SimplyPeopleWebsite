<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Managers List - Simply People HR Administration</title>
<link rel="stylesheet" href="../css/style.css"/>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>

<jsp:directive.include file="header.jsp" />
	
  <div align="center">
		<h2 class="pageheading">Project Manager Management</h2>
		<h3>
			<a href="projectmanager_form.jsp">Create New Project Manager</a>
		</h3>
	</div>
	<c:if test="${message !=null}">
   <div align="center">
     <h4 class="message">${message}</h4>
   </div>
</c:if>
   
   <div align="center">
   		<table border="1"  cellpadding="5">
   			<tr>
   				<th>Index</th>
   				<th>ID</th>
   				<th>ProjectID</th>
   				<th>Email</th>
   				<th>Full Name</th>
   				
   				<th>Actions</th>
   			</tr>
   			
   			<c:forEach var = "manager" items="${listManager}" varStatus="status">
   				<tr>
   					<td>${status.index + 1}</td>
   					<td>${manager.pmid}</td>
   					<td>${manager.pid}</td>
   					<td>${manager.email}</td>
   					<td>${manager.fullname}</td>
   					
   					
   					<td>
   						<a href="edit_manager?pmid=${manager.pmid}">Edit</a> &nbsp;
   						<a href="javascript:confirmDelete(${manager.pmid})">Delete</a>
   					</td>
   					
   				</tr>
   			
   			</c:forEach>
   		
   		</table>
   
   </div>
   
   <jsp:directive.include file="footer.jsp" />	
   
   <script>
	function confirmDelete(pmid) {
	   if(confirm('Are you sure you want to delete the manager with ID' + pmid + ' ?')) {

		   window.location = 'delete_manager?pmid=' + pmid ;

		   }
	}
	
		
   </script>
   
   
</body>
</html>