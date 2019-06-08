<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Payment Management</title>
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
</head>
<%
	List<PaymentDTO> allPayment = (List<PaymentDTO>) request.getAttribute("allPayment");
%>

<body>

	<div>

		<p>Payment Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Card Number</th>
			<th>Card Type</th>
			<th>Card Owner</th>
			<th>Card Expire</th>
			<th>CVV</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (PaymentDTO payment : allPayment) {
		%>
		<tr>
			<td><%=payment.getPayId()%></td>
			<td><%=payment.getCardtype()%></td>
			<td><%=payment.getCardnum()%></td>
			<td><%=payment.getCardown()%></td>
			<td><%=payment.getCardexp()%></td>
			<td><%=payment.getCVV()%></td>
			<td><a href="PaymenServlet?richiesta=updateRedirect&id=<%=payment.getPayId() %>">Update</a></td>
			<td><a href="PaymentServlet?richiesta=delete&id=<%=payment.getPayId() %>" >Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<br>
	<a href="PaymentServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Payment</i></a>
	<br>	
	<a href="PaymentServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>