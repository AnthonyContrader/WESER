<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert new care</title>

</head>
<body>
	<div class="pre_contenitore">

		<p>New User</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/DoctorServlet?richiesta=insert">

		
		patient name: <input type="text" size="40" maxlength="40" name="patname" />
		<br>
		<br>
		Patient SSC: <input type="text" size="40" maxlength="40" name="patcf" />
		<br>
		<br>
		Patient age: <input type="password" size="40" maxlength="40" name="patage" />
		<br>
		<br>
		Patology: <input type="text" size="40" maxlength="40" name="patology" />
		<br>
		<br>
		Care name: <input type="text" size="40" maxlength="40" name="carename" />
		<br>
		<br>
		Quantity: <input type="text" size="40" maxlength="40" name="quantity" />
		<br>
		<br>
		Notes: <input type="text" size="40" maxlength="40" name="notes" />
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/DoctorServlet?richiesta=DoctorManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>