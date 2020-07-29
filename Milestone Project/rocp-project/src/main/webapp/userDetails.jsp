	<!-- Header -->
	<jsp:include page="userHeader.jsp" />
	
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
	
		<h1>User<small>User Details - ${user.userId }</small></h1>
		<hr class="book-primary">
		<!-- this form send data to the UpdateUserFinallyserver -->
		<form action="UpdateUserFinally" method="post" class="form-horizontal">
		  
		  <input type="hidden" class="form-control" id="userId" name="userId" required="required" value="${user.userId }" />
		  
		  <div class="form-group">
		    <label for="title" class="col-sm-4 control-label">User name</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="username" name="username" placeholder="username" required="required" value="${user.username }" />
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label for="title" class="col-sm-4 control-label">Password</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="password" name="password" placeholder="password" required="required" value="${user.password }" />
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="author" class="col-sm-4 control-label">First Name</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="fName" name="fName" placeholder="First Name" required="required" value="${user.firstName}" />
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="author" class="col-sm-4 control-label">Last Name</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="lName" name="lName" placeholder="Last Name" required="required" value="${user.lastName}" />
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label for="author" class="col-sm-4 control-label">Account ID</label>
		    <div class="col-sm-5">
		      <input type="number" class="form-control" id="accountId" name="accountId" placeholder="account id" required="required" value="${user.accountId}" />
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="price" class="col-sm-4 control-label">Role id</label>
		    <div class="col-sm-5">
		      <input type="number"  class="form-control" id="roleId" name="roleId" placeholder="role id" required="required" value="${user.roleId }" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Update</button>
		    </div>
		  </div>
		  
		</form>

	  </div>
	</header>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
