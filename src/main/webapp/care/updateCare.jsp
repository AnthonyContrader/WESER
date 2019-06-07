<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>


<%
	DoctorDTO updateDoctor = (DoctorDTO) request.getAttribute("doctorUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Doctor Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="DoctorServlet?richiesta=update">

					
			<input type="hidden" name="careid" value="<%=updateDoctor.getCareid()%>" />
			<br>
			<br>
			Patient name: <input type="text" size="40" maxlength="40" name="patname" value="<%=updateDoctor.getPatname()%>" />
			<br>
			<br>
			Patient SSC: <input type="text" size="40" maxlength="40" name="patcf" value="<%=updateDoctor.getPatcf()%>" />
			<br>
			<br>
			Patient age: <input type="text" size="40" maxlength="40" name="patage" value="<%=updateDoctor.getPatage()%>" />
			<br>
			<br>
			Patology: <input type="text" size="40" maxlength="40" name="patology" value="<%=updateDoctor.getPatology()%>" />
			<br>
			<br>
			Care name: <input type="text" size="40" maxlength="40" name="carename" value="<%=updateDoctor.getCarename()%>" />
			<br>
			<br>
			Quantity: <input type="text" size="40" maxlength="40" name="quantity" value="<%=updateDoctor.getQuantity() %>" />
			<br>
			<br>
			Notes <input type="text" size="40" maxlength="40" name="notes" value="<%=updateDoctor.getNotes() %>" />
			<br>
			<br>
			<input type="submit" value="Update">
			<br>
			<br>
			<a href="/JspApp/DoctorServlet?richiesta=CareManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>