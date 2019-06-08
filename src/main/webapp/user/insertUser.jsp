<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci new user</title>
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

		<p>New User</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/UserServlet?richiesta=insert">
		<br>
	    <br>
		Username: <input type="text" size="40" maxlength="40" name="username" />
		<br>
		<br>
		User type: <input type="text" size="40" maxlength="40" name="usertype" />
		<br>
		<br>
		Password: <input type="password" size="40" maxlength="40" name="password" />
		<br>
		<br>
		name: <input type="text" size="40" maxlength="40" name="name" />
		<br>
		<br>
		surname: <input type="text" size="40" maxlength="40" name="surname" />
		<br>
		<br>
		social secure code: <input type="text" size="40" maxlength="40" name="cf" />
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/UserServlet?richiesta=UserManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>