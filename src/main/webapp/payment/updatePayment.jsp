<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
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

<%
	PaymentDTO updatePayment = (PaymentDTO) request.getAttribute("paymentUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>Payment Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/JspApp/PaymentServlet?richiesta=update">

					
			<input type="hidden" name="payId" value="<%=updatePayment.getPayId()%>" />
			<br>
			<br>
			Card type: <input type="text" size="40" maxlength="40" name="cardtype" value="<%=updatePayment.getCardtype()%>" />
			<br>
			<br>
			Card number: <input type="text" size="40" maxlength="40" name="cardnum" value="<%=updatePayment.getCardnum()%>" />
			<br>
			<br>
			Card owner: <input type="text" size="40" maxlength="40" name="cardown" value="<%=updatePayment.getCardown()%>" />
			<br>
			<br>
			Card Expire: <input type="text" size="40" maxlength="40" name="cardexp" value="<%=updatePayment.getCardexp()%>" />
			<br>
			<br>
			CVV: <input type="text" size="40" maxlength="40" name="cvv" value="<%=updatePayment.getCVV()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/PaymentServlet?richiesta=PaymentManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>