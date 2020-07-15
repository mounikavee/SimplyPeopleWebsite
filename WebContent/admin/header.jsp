<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}/admin/">
			<img src="../images/hradmin.png" />
		</a>
	</div>
	<div>
		Welcome, <c:out value="${sessionScope.useremail}" /> | <a href="logout">Logout</a>
		<br/><br/>
	</div>
	<div id="headermenu">
		<div>
			<a href="list_users">
				Users
			</a>
		</div>
		<div>
			<a href="list_category">
				Categories
			</a>
		</div>
		  <div>
			<a href="list_employee">
				Employees
			</a>
		</div>
		<div>
			<a href="list_Projectmanager">
				Projectmanagers
			</a>
		</div>
		
		<div>
			<a href="list_review">
				Reviews
			</a>
		</div>
		<div>
			<a href="list_grievance">
				Grievances
			</a>
		</div>
			
	</div>
</div>