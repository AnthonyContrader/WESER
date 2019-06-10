<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert new reading</title>
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

		<p>New Reading</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/ReadingServlet?richiesta=insert">
		<br>
	    <br>
		Patient ssc: <input type="text" size="40" maxlength="40" name="patcf" />
		<br>
		<br>
		Reg device: <input type="text" size="40" maxlength="40" name="regdev" />
		<br>
		<br>
		Min press: <input type="text" size="40" maxlength="40" name="minpress" />
		<br>
		<br>
		Max press: <input type="text" size="40" maxlength="40" name="maxpress" />
		<br>
		<br>
		Min circ: <input type="text" size="40" maxlength="40" name="mincir" />
		<br>
		<br>
		Max circ: <input type="text" size="40" maxlength="40" name="maxcir" />
		<br>
		<br>
		Min breath: <input type="text" size="40" maxlength="40" name="minbreath" />
		<br>
		<br>
		Max breath: <input type="text" size="40" maxlength="40" name="maxbreath" />
		<br>
		<br>
		Min temp: <input type="text" size="40" maxlength="40" name="mintemp" />
		<br>
		<br>
		Max temp: <input type="text" size="40" maxlength="40" name="maxtemp" />
		<br>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/ReadingServlet?richiesta=ReadingManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>