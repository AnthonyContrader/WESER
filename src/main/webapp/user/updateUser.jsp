<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>


<%
	UserDTO updateUser = (UserDTO) request.getAttribute("userUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>User Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/JspApp/UserServlet?richiesta=update">

					
			<input type="hidden" name="user_id" value="<%=updateUser.getId()%>" />
			<br>
			<br>
			Username: <input type="text" size="40" maxlength="40" name="username" value="<%=updateUser.getUsername()%>" />
			<br>
			<br>
			User type: <input type="text" size="40" maxlength="40" name="usertype" value="<%=updateUser.getUsertype()%>" />
			<br>
			<br>
			Password: <input type="text" size="40" maxlength="40" name="password" value="<%=updateUser.getPassword()%>" />
			<br>
			<br>
			Name: <input type="text" size="40" maxlength="40" name="name" value="<%=updateUser.getName()%>" />
			<br>
			<br>
			Surname: <input type="text" size="40" maxlength="40" name="surname" value="<%=updateUser.getSurname()%>" />
			<br>
			<br>
			Social secure code: <input type="text" size="40" maxlength="40" name="user_pass" value="<%=updateUser.getCf()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/UserServlet?richiesta=UserManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>