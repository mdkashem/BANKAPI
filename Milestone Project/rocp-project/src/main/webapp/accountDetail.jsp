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
	
		<h1>Account<small>Account Details - ${account.accountId }</small></h1>
		<hr class="book-primary">
		<!-- this form send data to the UpdateUserFinallyserver -->
		<form action="accounts/accountUpdateFinally" method="post" class="form-horizontal">
		  
		  <input type="hidden" class="form-control" id="accountId" name="accountId" required="required" value="${account.accountId }" />
		  
		  <div class="form-group">
		    <label for="title" class="col-sm-4 control-label">Account Balance</label>
		    <div class="col-sm-5">
		      <input type="number" step =0.01 class="form-control" id="balance" name="balance" placeholder="balace" required="required" value="${account.balance}" />
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label for="title" class="col-sm-4 control-label">Status Id</label>
		    <div class="col-sm-5">
		      <input type="number" class="form-control" id="statusId" name="statusId" placeholder="status id" required="required" value="${account.statusId }" />
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="author" class="col-sm-4 control-label">Account type Id</label>
		    <div class="col-sm-5">
		      <input type="number" class="form-control" id="typeId" name="typeId" placeholder="Account type id" required="required" value="${account.typeId}" />
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
