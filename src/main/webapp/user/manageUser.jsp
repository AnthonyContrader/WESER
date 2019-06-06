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
			<th>Password</th>
			<th>User Type</th>
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

		</tr>
		<%
			}
		%>
	</table>
	<form name="deleteForm">
	<input type="text" name="idDel"value="" method="post" action="/JspApp/UserServlet?richiesta=delete?id=idDel">Insert id to delete</form>
	<button name="delete" value="delete" type="submit">Delete</button>
	<br>
	<br>
	<a href="/JspApp/UserServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New User</i></a>
	<a href="/JspApp/UserServlet?richiesta=delete"><i class="fas fa-plus-circle fa-lg"> Delete User</i></a>

	<br>
	<br>
	<a href="/JspApp/UserServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>