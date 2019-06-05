<html>
<head>
<title>Administrator menu</title>
</head>
<body>
	<h1>Welcome: ${nomeUtente}</h1>
<h2>Administrator Menu </h2>

	<h3>1. Users Administration</h3>
	<form action="UserServlet?action=UsersList" method="post">
		<button type="submit">Users</button>
	</form>
	
	<h3>2. Devices Administration</h3>
	<form action="device.jsp" method="post">
		<button type="submit">Devices</button>
	</form>
	
	<h3>3. Pathologies Administration</h3>
	<form action="adminPathologies.jsp" method="post">
		<button type="submit">Pathologies</button>
	</form>

	<form action="index.jsp" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			Exit</button>
	</form>
	
</body>
</html>