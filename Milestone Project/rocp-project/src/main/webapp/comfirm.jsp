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
					<td>Name:</td>
					<td>First Name:</td>
					<td>Last Name:</td>
					<td>Email:</td>
					<td>Role:</td>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${tags}">
					<tr>
						<td><c:out value="${user.userId}" /></td>
						
						<td><c:out value="${user.username}" /></td>
						
						<td><c:out value="${user.firstName}" /></td>
						
						<td><c:out value="${user.lastName}" /></td>
						
						<td><c:out value="${user.email}" /></td>
						
						<td><c:out value="${user.role.role}" /></td>
						
						
							
					</tr>
				</c:forEach>
			</tbody>
		</table>

	  </div>
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />