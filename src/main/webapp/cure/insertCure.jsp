<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
    <%@ page import="it.contrader.dto.CureDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Cure</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Insert Cure</title>

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
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
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
 <%@ include file="/function/menuDoctor.jsp" %>
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> Insert Cure</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i>Home</a></li>
              <li><i class="fa fa-laptop"></i>Insert Cure</li>
            </ol>
          </div>
        </div>
        
        <div class="row">
        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        		<form class="insert-form" action="/Cure/insertCure" method="post">
		<table>
			<tr>
				<td>Patient name</td><td><input type="text" name="patname" placeholder="Patname"></td>
			</tr>
			
			<tr>
				<td>Patient Ssn</td><td><input type="text" name="patcf" placeholder="Patcf"></td>
			</tr>
			
			<tr>
				<td>Patient age</td><td><input type="number" name="patage" placeholder="Patage"></td>
			</tr>
			
			<tr>
				<td>Pathology</td><td><input type="text" name="pato" placeholder="Pato"></td>
			</tr>
			<tr>
				<td>Cure name</td><td><input type="text" name="curename" placeholder="Curename"></td>
			</tr>
			<tr>
				<td>Quantity</td><td><input type="text" name="quantity" placeholder="Quantity"></td>
			</tr>
			<tr>
				<td>Notes</td><td><input type="text" name="notes" placeholder="Notes"></td>
			</tr>
		</table>
		<br>
		<button class="btn btn-primary btn-lg btn-block" type="submit">Insert</button>
	</form>
	<br>
	<a class="btn btn-primary btn-lg btn-block" href="/Cure/cureManagement">Back</a>
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
    <script src="/js/jquery.customSelect.min.js"></script>
    <script src="/assets/chart-master/Chart.js"></script>

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