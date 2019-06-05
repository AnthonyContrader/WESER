<%@ page import ="java.util.*" %>
<%@ page import ="it.contrader.dto.*" %>
<%@ page import ="it.contrader.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title> Users Administration </title>
</head>
<body>
	<h2> USER ADMINISTRATION </h2>
	<div>
		<form action="UserServlet?action=Insert" method="post">
			<h3>
				Username: <input type="text" id="username" name="username"
					placeholder="Insert username">
			</h3>
			<h3>
				User type: <input type="text" id="usertype" name="usertype"
					placeholder="Insert user type ">
			</h3>
			<h3>
				Password: <input type="password" id="password" name="password"
					placeholder="Insert password">
			</h3>
			<h3>
				Name: <input type="text" id="name" name="name"
					placeholder="Insert name">
			</h3>
			<h3>
				Surname: <input type="text" id="surname" name="surname"
					placeholder="Insert surname">
			</h3>
			<h3>
				Social Security Number: <input type="text" id="cf" name="cf"
					placeholder="Insert Social Security Number">
			</h3>
			<button type="submit" value="Insert" name="pulsante">Insert new user</button>
			
			
			<button type="submit" value="Update" name="pulsante">Update user</button>
			
		
			<button type="submit" value="Delete" name="pulsante">Delete user</button>
			
		</form>
	</div>
	
       <% List<UserDTO> allUser = (List<UserDTO>) request.getAttribute("usersList"); %>

	<table border=2 align="center">
<tr>
<td>User id</td>
<td>Username</td>
<td>User type</td>
<td>Password</td>
<td>Name</td>
<td>Surname</td>
<td>Social Security Number</td>
</tr>

<% for (UserDTO user : allUser) { 

%>
<tr>
	<td><%=user.getUserId() %> </td>
	<td><%=user.getUsername() %> </td>
	<td><%=user.getUsertype() %> </td>
	<td><%=user.getPassword() %> </td>
	<td><%=user.getName() %> </td>
	<td><%=user.getSurname() %> </td>
	<td><%=user.getCf()%> </td>

</tr>
<%
} 
%>
</table>
</body>
</html>