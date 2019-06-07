<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>


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
			Dev type: <input type="text" size="40" maxlength="40" name="devtype" value="<%=updateDevice.getDevtype()%>" />
			<br>
			<br>
			Min press: <input type="text" size="40" maxlength="40" name="minpress" value="<%=updateDevice.getDescription() %>" />
			<br>
			<br>
			Max press: <input type="text" size="40" maxlength="40" name="maxpress" value="<%=updateDevice.getMinpress()%>" />
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
			Max temp: <input type="text" size="40" maxlength="40" name="cf" value="<%=updateDevice.getMintemp() %>" />
			<br>
			<br>
			Max temp: <input type="text" size="40" maxlength="40" name="cf" value="<%=updateDevice.getMaxtemp() %>" />
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