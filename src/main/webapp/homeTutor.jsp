<html>
<head>
<title>Administrator menu</title>
</head>
<body>
	<h1>Welcome: ${nomeUtente}</h1>
	<center><h2>Tutor Menu</h2></center>

	<h3>1. Payment Administrator</h3>
	<form action="payment.jsp" method="post"><button type="submit">Payment</button>	
	</form>
	<h3>2. Emergency number Administrator</h3>
	<form action="adminDevices.jsp" method="post"><button type="submit">Number</button>
		
	</form>
	
	<h3>3. View patient care</h3>
	<form action=careDoc.jsp" method="post"><button type="submit">Care</button>
		
	</form>
	<form action="index.jsp" method="post">
		<br><button type="submit" value="esempioManager" name="richiesta">
			Exit</button>
	</form>
	

</body>
</html>