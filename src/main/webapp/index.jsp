<html>
<head>
<title>Login WESER</title>
</head>
<body>

	<h2 style="color: blue; background=white; align:center;" >------- USER LOGIN -------</h2>
	<div>
		<form action="LoginServlet" method="post">
			<h3 style="color:red; ">
				username: <input type="text" id="user" name="username"
					placeholder="Insert username">
			</h3>
			<h3 style="color:red;">
				password: <input type="password" id="pass" name="password"
					placeholder="Insert password">
			</h3>
			<button type="submit" value="Login" name="pulsante">Sign in</button>
			<br>
		</form>
	<a href="register.jsp" target="_blank">Register</a>
</div>
</body>
</html>