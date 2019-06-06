<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert new payment</title>

</head>
<body>
	<div class="pre_contenitore">

		<p>New Payment</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/PaymentServlet?richiesta=insert">

		
		</select>
		<br>
		<br>
		Card Type: <input type="text" size="40" maxlength="40" name="cardtype" />
		<br>
		<br>
		Card Number: <input type="password" size="40" maxlength="40" name="cardnum" />
		<br>
		<br>
		Card Owner: <input type="text" size="40" maxlength="40" name="cardown" />
		<br>
		<br>
		Card Expire: <input type="text" size="40" maxlength="40" name="cardexp" />
		<br>
		<br>
		CVV: <input type="text" size="40" maxlength="40" name="cvv" />
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/PaymentServlet?richiesta=PaymentManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>