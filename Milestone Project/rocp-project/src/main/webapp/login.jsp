
	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	
	  
	
	
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
		</form>	

	  </div>
	</header>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />