<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert new device</title>
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
</head>
<body>
	<div class="pre_contenitore">

		<p>New Device</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/DeviceServlet?richiesta=insert">
		<br>
	    <br>
		Registration number: <input type="text" size="40" maxlength="40" name="regnumber" />
		<br>
		<br>
		Device type: <input type="text" size="40" maxlength="40" name="devtype" />
		<br>
		<br>
		Description: <input type="text" size="40" maxlength="40" name="description" />
		<br>
		<br>
		Min press: <input type="number" min="0" max="999" name="minpress" />
		<br>
		<br>
		Max press: <input type="number" min="0" max="999" name="maxpress" />
		<br>
		<br>
		Min circ: <input type="number" min="0" max="999" name="mincir" />
		<br>
		<br>
		Max circ: <input type="number" min="0" max="999" name="maxcir" />
		<br>
		<br>
		Min breath: <input type="number" min="0" max="999" name="minbreath" />
		<br>
		<br>
		Max breath: <input type="number" min="0" max="999" name="maxbreath" />
		<br>
		<br>
		Min temp: <input type="number" step="any" min="0" max="999" name="mintemp" />
		<br>
		<br>
		Max temp: <input type="number" step="any" min="0" max="999" name="maxtemp" />
		<br>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/DeviceServlet?richiesta=DeviceManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>