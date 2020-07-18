
	<!-- Header -->
	<jsp:include page="adminHeader.jsp" />
	
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
	
	  <c:import url="/DisplayAllAccountTypeServlet" /> <!-- Call the servlet to load the list of type from database -->
	
	
		<h1>Create New User</h1>
		<hr class="book-primary">

		<!-- NOTE: This form uses the enctype="multipart/form-data" attribute because it contains a file upload control (<input type="file" ... />).
				To support this special enctype, the PublishBookServlet also has the @MultiPartConfig annotation. You only need to use this
				enctype and its corresponding annotation if you need to use a file upload control. Do not use it otherwise. -->
				
		<form action="CreateUserServlet" method="post" class="form-horizontal">
		       
		       
		        
		    <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Email for User Name </label>
		          <div class="col-sm-5">
		             <input type="email" class="form-control"  name="userNameTextBox">
		        </div>
		    </div>
		     <!-- Password dev bellow -->   
		      <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Password</label>
		          <div class="col-sm-5">
		            
		              <input type="password" class="form-control" name="passwordTextBox">
		        </div>
		    </div>
		    
		    <div class="form-group">
		  			 <label  class="col-sm-4 control-label">First Name</label>
		          <div class="col-sm-5">
		            
		             <input type="text" class="form-control" name="firstNameTextBox">
		        </div>
		    </div>
		        
		     <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Last Name</label>
		          <div class="col-sm-5">
		            
		             <input type="text" class="form-control" name="lastNameTextBox">
		        </div>
		    </div> 
		      <!-- Account selection start bellow -->  
		    <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Minimum deposit to open account </label>
		          <div class="col-sm-5">
		            
		             <input type="number"  min="0" value="50.00" step=".01" class="form-control" name="depositBalanceTextBox">
		            
		        </div>
		    </div> 
		    
		     <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Account Status</label>
		          <div class="col-sm-5">
		         
		             <select name="statusSelection" class="form-control" id="cars">
                     <!--   <option value="Under Review">Under Review</option>
                        <option value="Pending">Pending</option>
                        <option value="Approved">Approved</option> -->
                         <c:forEach var="statusReference" items="${statusListServlet}">
					
						          <option><c:out value="${statusReference.status}" /> </option>
						
			
				            </c:forEach>
                        
                
                    </select>
		        </div>
		    </div> 
		    
		     <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Type of Account</label>
		          <div class="col-sm-5">
		             <select name="accountTypeSelection" class="form-control" id="cars">
                      <!--  <option value="Checking">Checking</option>
                        <option value="Saving">Saving</option>
                        <option value="Business">Business</option>  --> 
                            <c:forEach var="typeReference" items="${typeFromServlet}">
					
						          <option><c:out value="${typeReference.type}" /> </option>
						
			
				            </c:forEach>
                
                    </select>
		        </div>
		    </div> 
		    
		     <!-- Account selection end -->
		     
		       
		    <!-- Role selection start bellow -->
		     <div class="form-group">
		  			 <label  class="col-sm-4 control-label">Role</label>
		          <div class="col-sm-5">
		            
		             <select name="roleTextBox" class="form-control" id="cars">
                       		<c:forEach var="roleReference" items="${roleListServlet}">
					
						          <option><c:out value="${roleReference.role}" /> </option>
						
			
				            </c:forEach>
                
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