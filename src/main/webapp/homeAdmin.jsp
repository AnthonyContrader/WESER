<html>
<head>
<title>Administrator menu</title>
</head>
<body>
	<h1>Welcome: ${utente}</h1>
	<h2>------- Administrator Menu -------</h2>

	<h3>1. User Administrator</h3>
	<form action="adminUsers.jsp" method="post">
		<button type="submit">Users</button>
	</form>
	

	<form action="index.jsp" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			Exit</button>
	</form>
	

</body>
</html>