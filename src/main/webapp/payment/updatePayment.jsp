<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>


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