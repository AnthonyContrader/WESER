<html>
<head>
<title>Login</title>

</head>
<body>

	<div class="pre_contenitore">
		<p>Login</p>
	</div>
	<div class="contenitore">
		<form action="LoginServlet?session" method="post">
			<p>Enter your login details</p>
			<p>
				<br>
				<label>Username</label>
				<br>
				<input type="text" name="username" class="username" placeholder="Username">
			</p>
			<p>
				<label>Password</label>
				<br>
				<input type="Password" name="password" class="password" placeholder="Password">
			</p>
			<button type="submit" value="Login" class="btn btn-warning">Sign in</button>
	   <!-- <br>
			<br>
			<div class="spinner-border text-muted"></div>
			<div class="spinner-border text-primary"></div>
			<div class="spinner-border text-success"></div>
			<div class="spinner-border text-info"></div>
			<div class="spinner-border text-warning"></div>
			<div class="spinner-border text-danger"></div>
			<div class="spinner-border text-secondary"></div>
-->
		</form>
	</div>

</body>
</html>