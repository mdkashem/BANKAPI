
	<!-- Header -->
	<jsp:include page="header.jsp" />
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	
	  
	  <p><c:out value="${message_log}"/></p>
	
	<c:choose>
	     <c:when test="${not empty message }">
	      <p class="alert ${messageClass}">${message }</p>
	   <%
	     session.setAttribute("message", null);
	     session.setAttribute("messageClass", null);
	    %>
	</c:when>
	</c:choose>
	
	
		<h1>Log in </h1>
		
		<hr class="book-primary">

		<!-- NOTE: This form uses the enctype="multipart/form-data" attribute because it contains a file upload control (<input type="file" ... />).
				To support this special enctype, the PublishBookServlet also has the @MultiPartConfig annotation. You only need to use this
				enctype and its corresponding annotation if you need to use a file upload control. Do not use it otherwise. -->
				
		<form action="AdminLogin" method="post" class="form-horizontal">
		       
		       
		        
		    <div class="form-group">
		  			 <label  class="col-sm-4 control-label">User Name </label>
		          <div class="col-sm-5">
		             <input type="text" class="form-control"  name="userNameTextBox">
		        </div>
		    </div>
		     <!-- Password dev bellow -->   
		      <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Password</label>
		          <div class="col-sm-5">
		            
		              <input type="password" class="form-control" name="passwordTextBox">
		        </div>
		    </div>
		       	
		 <button type="submit">submit</button>
		 <a href="Register.jsp" style="color:blue;font-size:20px;">/Register</a>
		</form>	
       
	  </div>
	</header>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />