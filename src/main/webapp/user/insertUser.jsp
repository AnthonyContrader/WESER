<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo utente</title>

</head>
<body>
	<div class="pre_contenitore">

		<p>New User</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/UserServlet?richiesta=insert">

		User type: <select style="width: 275px;" name="user_type">
			<option value="admin">Admin</option>
			<option value="bo">Business Owner</option>
		</select>
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