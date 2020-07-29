<jsp:include page="adminHeader.jsp"/>
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
    <!-- Header -->
    <header>
        <div class="container">
         <c:choose>
	          <c:when test="${not empty message }">
	           <p class="alert ${messageClass}">${message }</p>
	
	        </c:when>
	    </c:choose>
	    
            <div class="row">
                <div class="col-lg-12">
<!--                     <img class="img-responsive" src="resources/libraries/img/profile.png" alt=""> -->
                    <div class="intro-text">
                        <span class="name">Employee View</span>
                        <hr class="book-primary">
                       
                    </div>
                </div>
            </div>
        </div>
    </header>
	<section id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1" class=""></li>
            <li data-target="#myCarousel" data-slide-to="2" class=""></li>            
        </ol>

        <!-- Wrapper for Slides -->
        <div class="carousel-inner">
            <div class="item active">
                <!-- Set the first background image using inline CSS below. -->
                <div class="fill" style="background-image:url('${request.contextPath}resources/imgs/deposit.jpg');"></div>
                <div class="carousel-caption">
                   <h2>OPEN SAVING ACCOUNT...</h2>
                </div>
            </div>
            <div class="item">
                <!-- Set the second background image using inline CSS below. -->
                <div class="fill" style="background-image:url('${request.contextPath}resources/imgs/card.jpg');"></div>
                <div class="carousel-caption">
                    <h2>BUSINESS CREDIT CARD WITH LOW INTERREST RATE...</h2>
                </div>
            </div>
            <div class="item">
                <!-- Set the third background image using inline CSS below. -->
                <div class="fill" style="background-image:url('${request.contextPath}resources/imgs/business.jpg');"></div>
                
                <div class="carousel-caption">
                    <h2>WE ARE HERE TO HELP YOUR BUSINESS ...</h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
<!--     </div> -->
    </section>


	<jsp:include page="footer.jsp"/>