<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
	
</head>
<%
	List<UserDTO> allUser = (List<UserDTO>) request.getAttribute("allUser");
%>

<body>

	<div>

		<p>User Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>User Type</th>
			<th>Password</th>
			<th>Name</th>
			<th>Surname</th>
			<th>SSC</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (UserDTO user : allUser) {
		%>
		<tr>
			<td><%=user.getId() %></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getUsertype()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getSurname()%></td>
			<td><%=user.getCf()%></td>
			<td><a href="UserServlet?richiesta=updateRedirect&id=<%=user.getId() %>">Update</a></td>
			<td><a href="UserServlet?richiesta=delete&id=<%=user.getId() %>" >Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<br>
	<a href="/JspApp/UserServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New User</i></a>
	<br>	
	<a href="UserServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>