<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>


<%
	EmergencyDTO updateEmergency = (EmergencyDTO) request.getAttribute("emergencyUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Emergency Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/JspApp/EmergencyServlet?richiesta=update">

					
			<input type="hidden" name="emId" value="<%=updateEmergency.getEmId()%>" />
			<br>
			<br>
			Emergency number: <input type="text" size="40" maxlength="40" name="emnum" value="<%=updateEmergency.getEmnum()%>" />
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/EmergencyServlet?richiesta=EmergencyManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>