<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USERS UPDATE</title>

<%
	UserDTO userUpdate = (UserDTO) request.getAttribute("user");
%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Update Users</title>

  <!-- Bootstrap CSS -->
  <link href="/dash/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="/dash/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="/dash/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="/dash/css/font-awesome.min.css" rel="stylesheet" />
  <!-- full calendar css-->
  <link href="/dash/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
  <link href="/dash/assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
  <!-- easy pie chart-->
  <link href="/dash/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
  <!-- owl carousel -->
  <link rel="stylesheet" href="/dash/css/owl.carousel.css" type="text/css">
  <link href="/dash/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
  <!-- Custom styles -->
  <link rel="stylesheet" href="/css/fullcalendar.css">
  <link href="/dash/css/widgets.css" rel="stylesheet">
  <link href="/dash/css/style.css" rel="stylesheet">
  <link href="/dash/css/style-responsive.css" rel="stylesheet" />
  <link href="/dash/css/xcharts.min.css" rel=" stylesheet">
  <link href="/dash/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
  <!-- =======================================================
    Theme Name: NiceAdmin
    Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>
<body>

 <!-- container section start -->
  <section id="container" class="">


    <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>

      <!--logo start-->
      <a href="/homeAdmin.jsp" class="logo">WESER</a>
      <!--logo end-->

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="username">${utenteCollegato}</span>
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              <li>
                <a href="/User/logout"><i class="icon_key_alt"></i> Log Out</a>
              </li>
            </ul>
          </li>
          <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="sub-menu">
            <a class="" href="/homeDoctor.jsp">
                          <i class="icon_house_alt"></i>
                          <span>Dashboard</span>
                      </a>
          </li>
          <li class="active">
            <a href="/Doctor/userManagement" class="">
                          <i class="icon_document_alt"></i>
                          <span>User Management</span>
                      </a>
          </li>
          <li class="sub-menu">
            <a href="/Doctor/matchRobotRedirect" class="">
                          <i class="icon_desktop"></i>
                          <span>Device Management</span>
                      </a>
          </li>
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> User Update</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
              <li><i class="fa fa-laptop"></i>User Update</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form method="POST" action="/User/updateUser">
			<input type="hidden" name="id" value="<%=userUpdate.getId()%>" />
			<table class="table">

			<tr>
				<td><b>Username:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="username" value="<%=userUpdate.getUsername()%>" /></td>
			</tr>
			<tr>
				<td><b>Password:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="password" value="<%=userUpdate.getPassword()%>" /></td>
			</tr>
			<tr>
					<td><b>Usertype:</b></td>
					<td> <input type="text" size="40" maxlenght="40" name="usertype" value=<%=userUpdate.getUsertype() %>></td>
			</tr>
			<tr>
				<td><b>Name:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="name" value="<%=userUpdate.getName()%>" /></td>
			</tr>
			<tr>
				<td><b>Surname:</b></td> 
				<td> <input type="text" size="40" maxlength="40" name="surname" value="<%=userUpdate.getSurname()%>" /></td>
			</tr>
			
			<tr>
				<td><b>SSN:</b></td> 
				<td> <input type="text" size="40" maxlength="40" name="ssn" value="<%=userUpdate.getSsn() %>" /></td>
			</tr>
			
			
			</table>
			<br>
			<br>
			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a class="btn btn-primary btn-lg btn-block" href="/User/userManagement">Back</a>

		</form>
            </div>
        </div>

      </section>
    </section>
    <!--main content end-->
  </section>
<%@ include file="/function/footer.jsp" %>