<%@ page import="it.contrader.dto.*" %>
<%@ page import="java.util.*" %>

<html>
<head>
<title>Register Payment</title>
</head>
<body>
	<h2>Payment administration</h2>
	<div>
		<form action="PaymentServlet" method="post">
			<h3>
				Card type: <input type="text" id="cardtype" name="cardtype"
					placeholder="insert card type">
			</h3>
			<h3>
				Card number: <input type="text" id="cardnumb" name="usertype"
					placeholder="insert card number ">
			</h3>
			<h3>
				Card owner: <input type="password" id="password" name="password"
					placeholder="insert card owner">
			</h3>
			<h3>
				Card expire: <input type="text" id="name" name="name"
					placeholder="insert card expire">
			</h3>
			<h3>
				CVV: <input type="text" id="surname" name="surname"
					placeholder="insert cvv">
			</h3>
			<button type="submit" value="cardInsert" name="pulsante">Register</button>
			<button type="submit" value="cardUpdate" name="pulsante">Update</button>
			<button type="submit" value="cardDelete" name="pulsante">Delete</button>
			<button type="submit" value="cardRead" name="pulsante">View</button>
			
		</form><br><br>
	</div>
	<div class="main">
		<h1 class="title">Lista utenti</h1>
		<div style="padding-left: 10%; padding-right: 10%">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Card type</th>
						<th>Card number</th>
						<th>Card owner</th>
						<th>Card expire</th>
						<th>CVV</th>
						<th>Elimina</th>
						<th>Modifica</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<PaymentDTO> payments = (List<PaymentDTO>) session.getAttribute("payments_list");
						for (int i = 0; i < payments.size() ;i++) {
					%>

					<tr>

						<th>
							<%
								out.println(payments.get(i).getCard_type());
							%>
						</th>

						<th>
							<%
							out.println(payments.get(i).getCard_number());							%>
						</th>

						<th>
							<%
							out.println(payments.get(i).getCard_owner());							%>
						</th>

						<th>
							<%
								out.println(payments.get(i).getCard_expire());
							%>
						</th>
						<th>
							<%
								out.println(payments.get(i).getCVV());
							%>
						</th>

						<th><a href="PaymentServlet?action=delete&id=<%out.println(payments.get(i).getPay_id());%>">Elimina</a></th>
							


						<th><a href="UsersServlet?action=openUpdate&id=<%out.println(payments.get(i).getPay_id());%>">Modifica</a></th>
                                   
                                   



					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			
		</div>
	</div>
	
</body>
</html>