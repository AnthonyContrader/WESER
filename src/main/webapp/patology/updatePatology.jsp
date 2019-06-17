<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.contrader.dto.PatologyDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PATOLOGY UPDATE</title>

<%
	PatologyDTO patologyUpdate = (PatologyDTO) request.getAttribute("patology");
%>
<meta charset="utf-8">
  <meta name="viewport" content="width=patology-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Update Patologys</title>

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
      <a href="/homeDoctor.jsp" class="logo">WESER</a>
      <!--logo end-->

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
          <!-- patology login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              <li>
                <a href="/Patology/logout"><i class="icon_key_alt"></i> Log Out</a>
              </li>
            </ul>
          </li>
          <!-- patology login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
    <%@ include file="/function/menuAdmin.jsp" %>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> Patology Update</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="homeDoctor.jsp">Home</a></li>
              <li><i class="fa fa-laptop"></i>Patology Update</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form method="POST" action="/Patology/updatePatology">
			<input type="hidden" name="id" value="<%=patologyUpdate.getId()%>" />
			<table class="table">

			<tr>
				<td><b>Patology:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="pato" value="<%=patologyUpdate.getPato()%>" /></td>
			</tr>
			<tr>
				<td><b>Cure name:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="carename" value="<%=patologyUpdate.getCarename()%>" /></td>
			</tr>
			<tr>
					<td><b>Patient ssn:</b></td>
					<td> <input type="text" size="40" maxlenght="40" name="patcf" value=<%=patologyUpdate.getPatcf() %>></td>
			</tr>
			<tr>
					<td><b>Quantity:</b></td>
					<td> <input type="text" size="40" maxlenght="40" name="quantity" value=<%=patologyUpdate.getQuantity() %>></td>
			</tr>
			<tr>
					<td><b>Patominpress:</b></td>
					<td> <input type="number"  name="patominpress" value=<%=patologyUpdate.getPatominpress() %>></td>
			</tr>
			<tr>
				<td><b>Patomaxpress:</b></td>
				<td> <input type="number"  name="patomaxpress" value="<%=patologyUpdate.getPatomaxpress()%>" /></td>
			</tr>
			<tr>
				<td><b>Patomincir:</b></td> 
				<td> <input type="number"  name="patomincir" value="<%=patologyUpdate.getPatomincir()%>" /></td>
			</tr>
			<tr>
				<td><b>Patomaxcir:</b></td>
				<td> <input type="number"  name="patomaxcir" value="<%=patologyUpdate.getPatomaxcir()%>" /></td>
			</tr>
			<tr>
				<td><b>Patominbreath:</b></td> 
				<td> <input type="number"  name="patominbreath" value="<%=patologyUpdate.getPatominbreath()%>" /></td>
			</tr>
			<tr>
				<td><b>Patomaxbreath:</b></td>
				<td> <input type="number"  name="patomaxbreath" value="<%=patologyUpdate.getPatomaxbreath()%>" /></td>
			</tr>
			<tr>
				<td><b>Patomintemp:</b></td>
				<td> <input type="number"  name="patomintemp" value="<%=patologyUpdate.getPatomintemp()%>" /></td>
			</tr>
			<tr>
				<td><b>Patomaxtemp:</b></td> 
				<td> <input type="number"  name="patomaxtemp" value="<%=patologyUpdate.getPatomaxtemp()%>" /></td>
			</tr>
			
			
			</table>
			<br>
			<br>
			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a class="btn btn-primary btn-lg btn-block" href="/Patology/patologyManagement">Back</a>

		</form>
            </div>
        </div>

      </section>
    </section>
    <!--main content end-->
  </section>
<%@ include file="/function/footer.jsp" %>