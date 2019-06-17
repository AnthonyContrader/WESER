<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.DeviceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Device Management</title>
	<%
		List<DeviceDTO> listDevice = (List<DeviceDTO>) request.getAttribute("device");
	 %>
	 
	 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Device Management</title>

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
  <link rel="stylesheet" href="/css/owl.carousel.css" type="text/css">
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
     <%@ include file="/function/menuAdmin.jsp" %>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> Admin Management</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i>Home</li>
              <li><i class="fa fa-laptop"></i>Device Management</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            	<table class="table table-striped">
		<tr><th>Id</th><th>Reg. num</th><th>type</th><th>descritpion</th><th>m cir</th><th>M cir</th><th>m press</th><th>M press</th><th>m breath</th><th>M breath</th><th>m temp</th><th>M temp</th><th colspan=2>Manage</th></tr>
		<%
			for(DeviceDTO device: listDevice){
		 %>
		 	<tr>
		 		<td><%=device.getId()%></td>
		 		<td><%=device.getRegnum()%></td>
		 		<td><%=device.getDevtype()%></td>
		 		<td><%=device.getDescr()%></td>
		 		<td><%=device.getMincir()%></td>
		 		<td><%=device.getMaxcir()%></td>
		 		<td><%=device.getMinpress()%></td>
		 		<td><%=device.getMaxpress()%></td>
		 		<td><%=device.getMinbreath()%></td>
		 		<td><%=device.getMaxbreath()%></td>
		 		<td><%=device.getMintemp()%></td>
		 		<td><%=device.getMaxtemp()%></td>
		 		<td><a class="btn btn-primary btn-lg btn-block" href="/Device/deleteDevice?id=<%=device.getId() %>">Delete</a></td>
		 		<td><a class="btn btn-primary btn-lg btn-block"href="/Device/redirectUpdate?id=<%=device.getId()%>">Update</a></td>
		 	</tr>
		<% 
			}
		%>
	</table>
	<a class="btn btn-primary btn-lg btn-block" href="/device/insertDevice.jsp">Insert new Device</a>
	<br>
	<a class="btn btn-primary btn-lg btn-block" href="/homeAdmin.jsp">Back to home</a>
	<br>
            </div>
        </div>

      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section start -->

  <!-- javascripts -->
  <script src="/dash/js/jquery.js"></script>
  <script src="/dash/js/jquery-ui-1.10.4.min.js"></script>
  <script src="/dash/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
  <!-- bootstrap -->
  <script src="/dash/js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="/dash/js/jquery.scrollTo.min.js"></script>
  <script src="/dash/js/jquery.nicescroll.js" type="text/javascript"></script>
  <!-- charts scripts -->
  <script src="/dash/assets/jquery-knob/js/jquery.knob.js"></script>
  <script src="/dash/js/jquery.sparkline.js" type="text/javascript"></script>
  <script src="/dash/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
  <script src="/dash/js/owl.carousel.js"></script>
  <!-- jQuery full calendar -->
  <<script src="/dash/js/fullcalendar.min.js"></script>
    <!-- Full Google Calendar - Calendar -->
    <script src="/dash/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="/dash/js/calendar-custom.js"></script>
    <script src="/dash/js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="/dash/js/jquery.customSelect.min.js"></script>
    <script src="/dash/assets/chart-master/Chart.js"></script>

    <!--custome script for all page-->
    <script src="/dash/js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="/dash/js/sparkline-chart.js"></script>
    <script src="/dash/js/easy-pie-chart.js"></script>
    <script src="/dash/js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="/dash/js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="/dash/js/xcharts.min.js"></script>
    <script src="/dash/js/jquery.autosize.min.js"></script>
    <script src="/dash/js/jquery.placeholder.min.js"></script>
    <script src="/dash/js/gdp-data.js"></script>
    <script src="/dash/js/morris.min.js"></script>
    <script src="/dash/js/sparklines.js"></script>
    <script src="/dash/js/charts.js"></script>
    <script src="/dash/js/jquery.slimscroll.min.js"></script>
    <script>
      //knob
      $(function() {
        $(".knob").knob({
          'draw': function() {
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
        $("#owl-slider").owlCarousel({
          navigation: true,
          slideSpeed: 300,
          paginationSpeed: 400,
          singleItem: true

        });
      });

      //custom select box

      $(function() {
        $('select.styled').customSelect();
      });

      /* ---------- Map ---------- */
      $(function() {
        $('#map').vectorMap({
          map: 'world_mill_en',
          series: {
            regions: [{
              values: gdpData,
              scale: ['#000', '#000'],
              normalizeFunction: 'polynomial'
            }]
          },
          backgroundColor: '#eef3f7',
          onLabelShow: function(e, el, code) {
            el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
          }
        });
      });
    </script>
	
</body>
</html>