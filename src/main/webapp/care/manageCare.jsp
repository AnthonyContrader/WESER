<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
	
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
			<td><%=doctor.getPatage()%></td>
			<td><%=doctor.getPatcf()%></td>
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
	<a href="/JspApp/DoctorServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Doctor</i></a>
	<br>	
	<a href="DoctorServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>