<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Reading management</title>
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
	List<ReadingDTO> allReading = (List<ReadingDTO>) request.getAttribute("allReading");
%>

<body>

	<div>

		<p>Reading Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Patient cf</th>
			<th>Reg device</th>
			<th>Min press</th>
			<th>Max press</th>
			<th>Min circ</th>
			<th>Max circ</th>
			<th>Min breath</th>
			<th>Max breath</th>
			<th>Min temp</th>
			<th>Max temp</th>
			<th>Delete</th>
		</tr>
		<%
			for (ReadingDTO reading : allReading) {
		%>
		<tr>
			<td><%=reading.getReadId() %></td>
			<td><%=reading.getPatcf() %></td>
			<td><%=reading.getRegdev()%></td>
			<td><%=reading.getMinpress()%></td>
			<td><%=reading.getMaxpress()%></td>
			<td><%=reading.getMincir()%></td>
			<td><%=reading.getMaxcir()%></td>
			<td><%=reading.getMinbreath()%></td>
			<td><%=reading.getMaxbreath()%></td>
			<td><%=reading.getMintemp()%></td>
			<td><%=reading.getMaxtemp()%></td>
			<td><a href="ReadingServlet?richiesta=delete&id=<%=reading.getReadId() %>" >Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<br>
	<a href="/JspApp/ReadingServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Reading</i></a>
	<br>	
	<a href="ReadingServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>