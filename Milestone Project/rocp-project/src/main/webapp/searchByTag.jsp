
	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	
	  
	
	
		<h1>PUBHUB <small>Publish</small></h1>
		<hr class="book-primary">

		<!-- NOTE: This form uses the enctype="multipart/form-data" attribute because it contains a file upload control (<input type="file" ... />).
				To support this special enctype, the PublishBookServlet also has the @MultiPartConfig annotation. You only need to use this
				enctype and its corresponding annotation if you need to use a file upload control. Do not use it otherwise. -->
				
		<form action="SearchServlet" method="post" class="form-horizontal">
		 <label>Enter tag name <input type="text" name="searchTextBox"></label>
		 <button type="submit">Search</button>
		</form>	

	  </div>
	</header>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />