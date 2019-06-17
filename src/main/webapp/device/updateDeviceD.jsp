<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.contrader.dto.DeviceDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DEVICE UPDATE</title>

<%
	DeviceDTO deviceUpdate = (DeviceDTO) request.getAttribute("device");
%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Update Devices</title>

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
          <!-- device login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              <li>
                <a href="/Device/logout"><i class="icon_key_alt"></i> Log Out</a>
              </li>
            </ul>
          </li>
          <!-- device login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
  <%@ include file="/function/menuDoctor.jsp" %>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> Device Update</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="homeAdmin.jsp">Home</a></li>
              <li><i class="fa fa-laptop"></i>Device Update</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form method="POST" action="/Device/updateDevice">
			<input type="hidden" name="id" value="<%=deviceUpdate.getId()%>" />
			<table class="table">

			<tr>
				<td><b>Reg number:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="regnum" value="<%=deviceUpdate.getRegnum()%>" /></td>
			</tr>
			<tr>
				<td><b>Dev type:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="devtype" value="<%=deviceUpdate.getDevtype()%>" /></td>
			</tr>
			<tr>
					<td><b>Description:</b></td>
					<td> <input type="text" size="40" maxlenght="40" name="descr" value=<%=deviceUpdate.getDescr() %>></td>
			</tr>
			<tr>
				<td><b>Min cir:</b></td>
				<td> <input type="number" size="40" maxlength="40" name="mincir" value="<%=deviceUpdate.getMincir()%>" /></td>
			</tr>
			<tr>
				<td><b>Max Cir:</b></td> 
				<td> <input type="number" size="40" maxlength="40" name="maxcir" value="<%=deviceUpdate.getMaxcir()%>" /></td>
			</tr>
			<tr>
				<td><b>Min pres:</b></td>
				<td> <input type="number" size="40" maxlength="40" name="minpress" value="<%=deviceUpdate.getMinpress()%>" /></td>
			</tr>
			<tr>
				<td><b>Max pres:</b></td> 
				<td> <input type="number" size="40" maxlength="40" name="maxpress" value="<%=deviceUpdate.getMaxpress()%>" /></td>
			</tr>
			<tr>
				<td><b>Min breath:</b></td>
				<td> <input type="number" size="40" maxlength="40" name="minbreath" value="<%=deviceUpdate.getMinbreath()%>" /></td>
			</tr>
			<tr>
				<td><b>Max breath:</b></td> 
				<td> <input type="number" size="40" maxlength="40" name="maxbreath" value="<%=deviceUpdate.getMaxbreath()%>" /></td>
			</tr>
			<tr>
				<td><b>Min temp:</b></td>
				<td> <input type="number" size="40" maxlength="40" name="mintemp" value="<%=deviceUpdate.getMintemp()%>" /></td>
			</tr>
			<tr>
				<td><b>Max temp:</b></td> 
				<td> <input type="number" size="40" maxlength="40" name="maxtemp" value="<%=deviceUpdate.getMaxtemp()%>" /></td>
			</tr>
			
			
			</table>
			<br>
			<br>
			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a class="btn btn-primary btn-lg btn-block" href="/Device/deviceManagement">Back</a>

		</form>
            </div>
        </div>

      </section>
    </section>
    <!--main content end-->
  </section>
<%@ include file="/function/footer.jsp" %>