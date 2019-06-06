<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Payment Management</title>
	
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
			<td><%=payment.getPayId() %></td>
			<td><%=payment.getCardtype()%></td>
			<td><%=payment.getCardnum() %></td>
			<td><%=payment.getCardown()%></td>
			<td><%=payment.getCardexp()%></td>
			<td><%=payment.getCVV()%></td>

		</tr>
		<%
			}
		%>
	</table>
	<form name="deleteForm">
	<input type="text" name="idDel"value="" method="post" action="/JspApp/PaymentServlet?richiesta=delete?id=idDel">Insert id to delete</form>
	<button name="delete" value="delete" type="submit">Delete</button>
	<br>
	<br>
	<a href="/JspApp/PaymentServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Payment</i></a>
	<a href="/JspApp/PaymentServlet?richiesta=delete"><i class="fas fa-plus-circle fa-lg"> Delete Payment</i></a>

	<br>
	<br>
	<a href="/JspApp/PaymentServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>