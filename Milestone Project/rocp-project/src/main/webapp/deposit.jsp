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
	
		<h1>User<small>Transfer Money - ${user.userId }</small></h1>
		<hr class="book-primary">
		<!-- this form send data to the UpdateUserFinallyserver -->
		<form action="accounts\depositConfirm" method="post" class="form-horizontal">
		  
		  <input type="hidden" class="form-control" id="userId" name="userId" required="required" value="${user.userId }" />
		  
		  <div class="form-group">
		    <label for="title" class="col-sm-4 control-label">Your available balance :</label>
		    <div class="col-sm-5">
		      <label type="text" class="col-sm-4 control-label" id="username" name="username" placeholder="username" >$ ${userBalance } </label>
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label for="title" class="col-sm-4 control-label">Enter the amount to be withdraw : </label>
		    <div class="col-sm-5">
		      <input type="number" step ="0.01" class="form-control" id="depositAmount" name="depositAmount" placeholder="0.00" required="required" />
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Deposit Money</button>
		    </div>
		  </div>
		  
		</form>

	  </div>
	</header>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
