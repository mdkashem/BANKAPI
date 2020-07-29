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
	
		<h1>Accounts <small>All Accounts</small></h1>
		<hr class="book-primary">
         
		<table class="table table-striped table-hover table-responsive pubhub-datatable">
			<thead>
				<tr>
					<td>Account Id:</td>
					<td>Balance:</td>
					<td>Status Id:</td>
					<td>Type Id:</td>
					<td>Delete:</td>
					<td>Update:</td>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="account" items="${accountFromServlet}">
					<tr>
						<td><c:out value="${account.accountId}" /></td>
						
						<td><c:out value="${account.balance}" /></td>
						
						<td><c:out value="${account.statusId}" /></td>
						
						<td><c:out value="${account.typeId}" /></td>
						
						<td><form action="accounts/accountDelete?accountID=${account.accountId}" method="get">
								<input type="hidden" name="accountId" value="${account.accountId}">
								<button class="btn btn-primary">Delete</button>
							</form></td>
						<td><form action="accounts/accountUpdate?accountID=${account.accountId}" method="get">
								<input type="hidden" name="accountId" value="${account.accountId}">
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