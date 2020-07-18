
	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	
	  
	
	
		
       <%! String tagName = " "; %>
       <%
         tagName = (String)session.getAttribute("tag_name");
        %>
     
     <table class="table table-striped table-hover table-responsive pubhub-datatable">
			<thead>
				<tr>
					
					<td>Tag Name:</td>
					
				</tr>
			</thead>
			<tbody>
				
					<tr>
						
						
						<td> <%=tagName %> </td>
						
						
							
					</tr>
			
			</tbody>
		</table>

	  </div>
	</header>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />