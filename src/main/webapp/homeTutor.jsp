<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Tutor</title>

</head>
<body>
	<div class="pre_contenitore">

		<p>Welcome!</p>

	</div>
	<div class="contenitore">
		<a href="UserServlet?richiesta=UserManager"><span class="fs"> Payment Management </span></a>
		<br>
		<a href="DeviceServlet?richiesta=DeviceManager"><span class="fs"> Emergency Number Management </span></a>
		<br>
		<a href="DeviceServlet?richiesta=DeviceManager"><span class="fs"> View patient care </span></a>
		<br>
		<a href="LogoutServlet" target="self"><span class="fs"> Logout </span></a>
	</div>
</body>
</html>