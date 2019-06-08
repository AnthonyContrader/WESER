<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Device Management</title>
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
	List<DeviceDTO> allDevice = (List<DeviceDTO>) request.getAttribute("allDevice");
%>

<body>

	<div>

		<p>Device Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Registration N°</th>
			<th>Device Type</th>
			<th>Description</th>
			<th>Min press</th>
			<th>Max press</th>
			<th>Min circ</th>
			<th>Max circ</th>
			<th>Min breath</th>
			<th>Max breath</th>
			<th>Min temp</th>
			<th>Max temp</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (DeviceDTO device : allDevice) {
		%>
		<tr>
			<td><%=device.getDevId() %></td>
			<td><%=device.getRegnumber()%></td>
			<td><%=device.getDevtype()%></td>
			<td><%=device.getDescription()%></td>
			<td><%=device.getMinpress()%></td>
			<td><%=device.getMaxpress()%></td>
			<td><%=device.getMincir() %></td>
			<td><%=device.getMaxcir() %></td>
			<td><%=device.getMinbreath()%></td>
			<td><%=device.getMaxbreath() %></td>
			<td><%=device.getMintemp() %></td>
			<td><%=device.getMaxtemp() %></td>
			
			<td><a href="DeviceServlet?richiesta=updateRedirect&id=<%=device.getDevId() %>">Update</a></td>
			<td><a href="DeviceServlet?richiesta=delete&id=<%=device.getDevId() %>" >Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<br>
	<a href="/JspApp/DeviceServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Device</i></a>
	<br>	
	<a href="/JspApp/homeAdmin.jsp"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>