<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Simply People HR Administration</title>
	<link rel="stylesheet" href="../css/style.css" >
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Administrative Dashboard</h2>
	</div>
	
	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Quick Actions:</h2>
		<b>
		
		<a href="user_form.jsp">New User</a> &nbsp;
		<a href="category_form.jsp">New Category</a> &nbsp;
		
		</b>
	</div>
	
	
	<jsp:directive.include file="footer.jsp" />
</body>
</html>