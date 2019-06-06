<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Doctor</title>

</head>
<body>
	<div class="pre_contenitore">

		<p>Welcome!</p>

	</div>
	<div class="contenitore">
		<a href="DoctorServlet?richiesta=CareManager"><span class="fs"> Care Management </span></a>
		<br>
		<a href="DeviceServlet?richiesta=DeviceManager"><span class="fs"> Update device parameters </span></a>
		<br>
		<a href="LogoutServlet" target="self"><span class="fs"> Logout </span></a>
	</div>
</body>
</html>