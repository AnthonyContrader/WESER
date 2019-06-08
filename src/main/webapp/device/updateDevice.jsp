<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
/*contenitore in cima dove c'è scritto "Login"*/
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 40px 40px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: white;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>

<%
	DeviceDTO updateDevice = (DeviceDTO) request.getAttribute("deviceUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Device Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="DeviceServlet?richiesta=update">

					
			<input type="hidden" name="dev_id" value="<%=updateDevice.getDevId()%>" />
			<br>
			<br>
			Reg number: <input type="text" size="40" maxlength="40" name="regnumber" value="<%=updateDevice.getRegnumber() %>"/>
			<br>
			<br>
			Dev type: <input type="text" size="40" maxlength="40" name="devtype" value="<%=updateDevice.getDevtype() %>" />
			<br>
			<br>
			Description: <input type="text" size="40" maxlength="40" name="description" value="<%=updateDevice.getDescription() %>" />
			<br>
			<br>
			Min press: <input type="text" size="40" maxlength="40" name="minpress" value="<%=updateDevice.getMinpress()%>" />
			<br>
			<br>
			Max press: <input type="text" size="40" maxlength="40" name="maxpress" value="<%=updateDevice.getMaxpress()%>" />
			<br>
			<br>
			Min cirr: <input type="text" size="40" maxlength="40" name="mincir" value="<%=updateDevice.getMincir()%>" />
			<br>
			<br>
			Max cirr: <input type="text" size="40" maxlength="40" name="maxcir" value="<%=updateDevice.getMaxcir() %>" />
			<br>
			<br>
			Min breath: <input type="text" size="40" maxlength="40" name="minbreath" value="<%=updateDevice.getMinbreath() %>" />
			<br>
			<br>
			Max breath: <input type="text" size="40" maxlength="40" name="maxbreath" value="<%=updateDevice.getMaxbreath() %>" />
			<br>
			<br>
			Min temp: <input type="text" size="40" maxlength="40" name="mintemp" value="<%=updateDevice.getMintemp() %>" />
			<br>
			<br>
			Max temp: <input type="text" size="40" maxlength="40" name="maxtemp" value="<%=updateDevice.getMaxtemp() %>" />
			<br>
			<br>
			<input type="submit" value="Update">
			<br>
			<br>
			<a href="/JspApp/DeviceServlet?richiesta=DeviceManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>

