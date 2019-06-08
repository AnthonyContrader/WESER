<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<style>
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 0px 0px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: orange;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
 
body {
	background-image:
		url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
}

.contenitore {
	border: 1px solid black;
	margin: auto;
	width: 320px;
	height: 390px;
	border-radius: 0px 0px 40px 40px;
	padding: 20px;
	background-color: rgba(0, 0, 0, 0.8);
	box-shadow: 20px 20px 20px #000000;
	color: orange;
}

.contenitore input {
	width: 100%;
	margin-bottom: 20px;
	border: none;
	border: 1px solid black;
	height: 30px;
}

.contenitore input[type="text"], input[type="password"]
	/* i css si riferiscono solo alla barra ditesto */ {
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
}

.contenitore p {
	
}

.contenitore input[type="submit"] {
	/* i css si riferiscono solo al pulsante */
	border-radius: 14px;
	height: 40px;
}

.contenitore input[type="submit"]:hover {
	background: lightblue;
}
</style>
</head>
<body>

	<div class="pre_contenitore">
		<p>Login</p>
	</div>
	<div class="contenitore">
		<form action="LoginServlet" method="post">
			<p>Enter your login details</p>
			<p>
				<br>
				<label>Username</label>
				<br>
				<input type="text" name="username" id="username" class="username" placeholder="Username">
			</p>
			<p>
				<label>Password</label>
				<br>
				<input type="Password" name="password" id="password" class="password" placeholder="Password">
			</p>
			<h3><font color="red" name="error">${error}</font></h3>
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