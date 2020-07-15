<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="center">
	<div align="center">
		<a href="${pageContext.request.contextPath}/">
			<img src="images/hr.png" />
		</a>
	</div>
	
	<div align="center">
		
			
					
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<c:if test="${loggedManager == null}">
				<a href="login">Sign In</a> |
				<a href="register">Register</a> |			
			</c:if>
			
			<c:if test="${loggedManager != null}">
				<a href="view_profile">Welcome, ${loggedManager.fullname}</a> |
				
				<a href="logout">Logout</a> 
			</c:if>
			
			
		
	</div>
	<div>&nbsp;</div>
	<div>
		<c:forEach var="category" items="${listCategory}" varStatus="status">
			<a href="view_category?id=${category.categoryId}">
				<font size="+1"><b><c:out value="${category.name}" /></b></font>
			</a>
			<c:if test="${not status.last}">
			&nbsp; | &nbsp;
			</c:if>
		</c:forEach>
	</div>
</div>