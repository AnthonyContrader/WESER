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
	DoctorDTO updateDoctor = (DoctorDTO) request.getAttribute("doctorUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Cares Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="DoctorServlet?richiesta=update">

					
			<input type="hidden" name="care_id" value="<%=updateDoctor.getCareid()%>" />
			<br>
			<br>
			Patient Name: <input type="text" size="40" maxlength="40" name="patname" value="<%=updateDoctor.getPatname()%>" />
			<br>
			<br>
			Patient ssc: <input type="text" size="40" maxlength="40" name="patcf" value="<%=updateDoctor.getPatcf()%>" />
			<br>
			<br>
			Patient Age: <input type="text" size="40" maxlength="40" name="patage" value="<%=updateDoctor.getPatage()%>" />
			<br>
			<br>
			Patology: <input type="text" size="40" maxlength="40" name="patology" value="<%=updateDoctor.getPatology()%>" />
			<br>
			<br>
			Care: <input type="text" size="40" maxlength="40" name="carename" value="<%=updateDoctor.getCarename() %>" />
			<br>
			<br>
			Quantity: <input type="text" size="40" maxlength="40" name="quantity" value="<%=updateDoctor.getQuantity() %>" />
			<br>
			<br>
			NOtes: <input type="text" size="40" maxlength="40" name="notes" value="<%=updateDoctor.getNotes() %>" />
			<br>
			<br>
			<input type="submit" value="Update">
			<br>
			<br>
			
		<a href="DoctorServlet?richiesta=CareManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
		</form>

	</div>
</body>
</html>