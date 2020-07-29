
	<!-- Header -->
	<jsp:include page="header.jsp" />
	
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
		<h1>Register</h1>
		<hr class="book-primary">

		<!-- NOTE: This form uses the enctype="multipart/form-data" attribute because it contains a file upload control (<input type="file" ... />).
				To support this special enctype, the PublishBookServlet also has the @MultiPartConfig annotation. You only need to use this
				enctype and its corresponding annotation if you need to use a file upload control. Do not use it otherwise. -->
				
		<form action="accounts/register" method="post" class="form-horizontal">     
		    <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Email for User Name </label>
		          <div class="col-sm-5">
		             <input type="email" class="form-control"  name="userNameTextBox" required>
		        </div>
		    </div>
		     <!-- Password dev bellow -->   
		      <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Password</label>
		          <div class="col-sm-5">
		            
		              <input type="password" class="form-control" name="passwordTextBox" required>
		        </div>
		    </div>
		    
		    <div class="form-group">
		  			 <label  class="col-sm-4 control-label">First Name</label>
		          <div class="col-sm-5">
		            
		             <input type="text" class="form-control" name="firstNameTextBox" required>
		        </div>
		    </div>
		        
		     <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Last Name</label>
		          <div class="col-sm-5">
		            
		             <input type="text" class="form-control" name="lastNameTextBox" required>
		        </div>
		    </div> 
		      <!-- Account selection start bellow -->  
		    <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Minimum deposit to open account </label>
		          <div class="col-sm-5">
		            
		             <input type="number"  min="0" value="50.00" step=".01" class="form-control" name="depositBalanceTextBox" required>
		            
		        </div>
		    </div> 
		    
		     <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Account Status</label>
		          <div class="col-sm-5">
		         
		             <select name="statusSelection" class="form-control" id="cars">
                        <option value="UNDER REVIEW">Under Review</option>
                    </select>
		        </div>
		    </div> 
		    
		     <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Type of Account</label>
		          <div class="col-sm-5">
		             <select name="accountTypeSelection" class="form-control" id="cars">
                       <option value="CHECKING">CHECKING</option>
                        <option value="SAVING">SAVING</option>
                        <option value="BUSINESS">BUSINESS</option>   
                
                    </select>
		        </div>
		    </div> 
		    
		     <!-- Account selection end -->
		     
		       
		    <!-- Role selection start bellow -->
		     <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Role</label>
		          <div class="col-sm-5">
		            
		             <select name="roleTextBox" class="form-control" id="cars">
                       		<option value="USER">User</option>
                    </select>
		        </div>
		    </div> 
		     <!-- Role selection end --> 
		     
	      	
		 <button type="submit">Create</button>
		</form>	

	  </div>
	</header>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />