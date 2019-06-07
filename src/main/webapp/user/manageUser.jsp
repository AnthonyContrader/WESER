<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
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