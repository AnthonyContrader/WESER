<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Cares Management</title>
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
	List<DoctorDTO> allDoctor = (List<DoctorDTO>) request.getAttribute("allDoctor");
%>

<body>

	<div>

		<p>Cares Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Patient</th>
			<th>Patient SSC</th>
			<th>Patient age</th>
			<th>Pathology</th>
			<th>Care name</th>
			<th>Quantity</th>
			<th>Notes</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (DoctorDTO doctor : allDoctor) {
		%>
		<tr>
			<td><%=doctor.getCareid() %></td>
			<td><%=doctor.getPatname()%></td>
			<td><%=doctor.getPatcf()%></td>
			<td><%=doctor.getPatage()%></td>
			<td><%=doctor.getPatology()%></td>
			<td><%=doctor.getCarename()%></td>
			<td><%=doctor.getQuantity()%></td>
			<td><%=doctor.getNotes()%></td>
			<td><a href="DoctorServlet?richiesta=updateRedirect&id=<%=doctor.getCareid() %>">Update</a></td>
			<td><a href="DoctorServlet?richiesta=delete&id=<%=doctor.getCareid() %>" >Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<br>
	<a href="DoctorServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Care</i></a>
	<br><br>
	<a href=""><i class="fas fa-binoculars fa-lg"> Search patology care</i></a><br>
	<br>	
	<a href="/JspApp/homeDoctor.jsp"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>