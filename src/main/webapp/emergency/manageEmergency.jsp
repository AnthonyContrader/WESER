<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Emergency Management</title>
	
</head>
<%
	List<EmergencyDTO> allEmergency = (List<EmergencyDTO>) request.getAttribute("allEmergency");
%>

<body>

	<div>

		<p>Emergency Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Emergency Number</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		
			for (EmergencyDTO emergency : allEmergency) {
		%>
		<tr>
			<td><%=emergency.getEmId() %></td>
			<td><%=emergency.getEmnum()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<form name="deleteForm">
	<input type="text" name="idDel"value="" method="post" action="/JspApp/EmergencyServlet?richiesta=delete?id=idDel">Insert id to delete</form>
	<button name="delete" value="delete" type="submit">Delete</button>
	<br>
	<br>
	<a href="/JspApp/EmergencyServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Emergency number</i></a>
	<a href="/JspApp/EmergencyServlet?richiesta=delete"><i class="fas fa-plus-circle fa-lg"> Delete Emergency number</i></a>

	<br>
	<br>
	<a href="/JspApp/EmergencyServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>