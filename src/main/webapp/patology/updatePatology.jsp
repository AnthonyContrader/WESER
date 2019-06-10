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
	PatologyDTO updatePatology = (PatologyDTO) request.getAttribute("patologyUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Patology Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="PatologyServlet?richiesta=update">

					
			<input type="hidden" name="pat_id" value="<%=updatePatology.getPatologyid()%>" />
			<br>
			<br>
			Patology: <input type="text" size="40" maxlength="40" name="patology" value="<%=updatePatology.getPatology() %>"/>
			<br>
			<br>
			Carename: <input type="text" size="40" maxlength="40" name="carename" value="<%=updatePatology.getCarename() %>"/>
			<br>
			<br>
			Quantity: <input type="text" size="40" maxlength="40" name="quantity" value="<%=updatePatology.getQuantity() %>" />
			<br>
			<br>
			Patient SSC: <input type="text" size="40" maxlength="40" name="patcf" value="<%=updatePatology.getPatcf() %>" />
			<br>
			<br>
			Min press: <input type="text" size="40" maxlength="40" name="patominpress" value="<%=updatePatology.getPatominpress()%>" />
			<br>
			<br>
			Max press: <input type="text" size="40" maxlength="40" name="patomaxpress" value="<%=updatePatology.getPatomaxpress()%>" />
			<br>
			<br>
			Min cir: <input type="text" size="40" maxlength="40" name="patomincir" value="<%=updatePatology.getPatomincir()%>" />
			<br>
			<br>
			Max cir: <input type="text" size="40" maxlength="40" name="patomaxcir" value="<%=updatePatology.getPatomaxcir() %>" />
			<br>
			<br>
			Min breath: <input type="text" size="40" maxlength="40" name="patominbreath" value="<%=updatePatology.getPatominbreath() %>" />
			<br>
			<br>
			Max breath: <input type="text" size="40" maxlength="40" name="patomaxbreath" value="<%=updatePatology.getPatomaxbreath() %>" />
			<br>
			<br>
			Min temp: <input type="text" size="40" maxlength="40" name="patomintemp" value="<%=updatePatology.getPatomintemp() %>" />
			<br>
			<br>
			Max temp: <input type="text" size="40" maxlength="40" name="patomaxtemp" value="<%=updatePatology.getPatomaxtemp() %>" />
			<br>
			<br>
			<input type="submit" value="update">
			<br>
			<br>
			<a href="/JspApp/PatologyServlet?richiesta=PatologyManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>

