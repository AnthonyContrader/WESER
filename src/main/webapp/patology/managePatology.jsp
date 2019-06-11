<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Patology Management</title>
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
	List<PatologyDTO> allPatology = (List<PatologyDTO>) request.getAttribute("allPatology");
%>

<body>

	<div>

		<p>Patology Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Patology</th>
			<th>Carename</th>
			<th>Quantity</th>
			<th>Patient SSC</th>
			<th>Min press</th>
			<th>Max press</th>
			<th>Min cir</th>
			<th>Max cir</th>
			<th>Min breath</th>
			<th>Max breath</th>
			<th>Min temp</th>
			<th>Max temp</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (PatologyDTO patology : allPatology) {
		%>
		<tr>
			<td><%=patology.getPatologyid() %></td>
			<td><%=patology.getPatology()%></td>
			<td><%=patology.getCarename()%></td>
			<td><%=patology.getQuantity()%></td>
			<td><%=patology.getPatcf()%></td>
			<td><%=patology.getPatominpress()%></td>
			<td><%=patology.getPatomaxpress()%></td>
			<td><%=patology.getPatomincir() %></td>
			<td><%=patology.getPatomaxcir() %></td>
			<td><%=patology.getPatominbreath()%></td>
			<td><%=patology.getPatomaxbreath() %></td>
			<td><%=patology.getPatomintemp() %></td>
			<td><%=patology.getPatomaxtemp() %></td>
			
			<td><a href="PatologyServlet?richiesta=updateRedirect&id=<%=patology.getPatologyid() %>">Update</a></td>
			<td><a href="PatologyServlet?richiesta=delete&id=<%=patology.getPatologyid()%>" >Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<br>
	<a href="/JspApp/PatologyServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Patology</i></a>
	<br>	
	<a href="/JspApp/homeDoctor.jsp"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>