<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MYBANK</title>
<link rel="shortcut icon" href="resources/imgs/favicon.png" type="image/x-icon">

<!-- CSS - Custom fonts -->
<link href="resources/libraries/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
<!-- <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"> -->

<!-- CSS - jQuery DataTables -->
<link href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />

<!-- CSS - Bootstrap -->
<link rel="stylesheet" type="text/css" href="resources/libraries/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="resources/libraries/css/freelancer.css"/>
<link rel="stylesheet" type="text/css" href="resources/libraries/css/half-slider.css"/>

<!-- CSS - Custom -->
<link rel="stylesheet" type="text/css" href="resources/styles/custom.css"/>

</head>
<body id="page-top" class="index">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" style="background-image:url('${request.contextPath}resources/imgs/header.jpg'">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath }">My Bank</a>            
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">User<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="AddUser.jsp">Creat a New User</a></li>
                           <li class="divider"></li>
                          <li><a href="DisplayAllUsersServlet">View All Users</a></li> 
                        </ul>
                    </li> <!--  book tags end -->
				
					<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Accounts<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="accounts/all">View All</a></li>
                          <li class="divider"></li>
                         
                        </ul>
                    </li>
                    	<!--
                    <li class="dropdown">
                    	
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Account<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="getAllAccounts">View All Account </a></li>
                          <li class="divider"></li>
                          <li><a href="PublishBook">Search by Account number</a></li>
                         
                        </ul>
                    </li>
                    // -->
                    <li class ="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">User:  ${username }</a>
                     <ul class="dropdown-menu">
                          <li><a href="logout">Log out</a></li>
                          
                         
                        </ul>
                    </li>
                    
                  
                  

                                       
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
