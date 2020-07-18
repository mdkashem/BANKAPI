	<!-- Header -->
	<jsp:include page="adminHeader.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	  
	  
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>Users <small>All Users</small></h1>
		<hr class="book-primary">
         
		<table class="table table-striped table-hover table-responsive pubhub-datatable">
			<thead>
				<tr>
					<td>User Id:</td>
					<td>User Name:</td>
					<td>First Name:</td>
					<td>Last Name:</td>
					<td>Account number:</td>
					<td>Role ID:</td>
					<td>Delete:</td>
					<td>Update:</td>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${tags}">
					<tr>
						<td><c:out value="${user.userId}" /></td>
						
						<td><c:out value="${user.username}" /></td>
						
						<td><c:out value="${user.firstName}" /></td>
						
						<td><c:out value="${user.lastName}" /></td>
						
						<td><c:out value="${user.accountId}" /></td>
						
						<td><c:out value="${user.roleId}" /></td>
						<td><form action="DeleteUserServlet?userID=${user.userId}" method="get">
								<input type="hidden" name="userId" value="${user.userId}">
								<button class="btn btn-primary">Delete</button>
							</form></td>
						<td><form action="UpdateUserServlet?userID=${user.userId}" method="get">
								<input type="hidden" name="userId" value="${user.userId}">
								<button class="btn btn-primary">Update</button>
							</form></td>
						
							
					</tr>
				</c:forEach>
			</tbody>
		</table>

	  </div>
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />