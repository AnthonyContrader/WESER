<html>
<head>
<title> Devices Administration </title>
</head>
<body>
	<h2> DEVICE ADMINISTRATION </h2>
	<div>
		<form action="DeviceServlet" method="post">
			<h3>
				Registration number: <input type="text" id="regnumber" name="regnumber"
					placeholder="Insert registration number">
			</h3>
			<h3>
				Device type: <input type="text" id="devtype" name="devtype"
					placeholder="Insert device type ">
			</h3>
			<h3>
				Description: <input type="text" id="description" name="description"
					placeholder="Insert description">
			</h3>
			<h3>
				Min pressure: <input type="text" id="minpress" name="minpress"
					placeholder="Insert min pressure">
			</h3>
			<h3>
				Max pressure: <input type="text" id="maxpress" name="maxpress"
					placeholder="Insert max pressure">
			</h3>
			
			<h3>
				Min heartbeats: <input type="text" id="mincir" name="mincir"
					placeholder="Insert min heartbeats">
			</h3>
			<h3>
				Max heartbeats: <input type="text" id="maxcir" name="maxcir"
					placeholder="Insert max heartbeats">
			</h3>
			
				<h3>
				Min breaths: <input type="text" id="minbreath" name="minbreath"
					placeholder="Insert min breaths">
			</h3>
			<h3>
				Max breaths: <input type="text" id="maxbreath" name="maxbreath"
					placeholder="Insert max breaths">
			</h3>
			
			<h3>
				Min temperature: <input type="text" id="mintemp" name="mintemp"
					placeholder="Insert min temperature">
			</h3>
			<h3>
				Max temperature: <input type="text" id="maxtemp" name="maxtemp"
					placeholder="Insert max temperature">
			</h3>
			
			<button type="submit" value="Insert" name="pulsante">Insert new device</button>
			
			
			<button type="submit" value="Update" name="pulsante">Update device</button>
			
		
			<button type="submit" value="Delete" name="pulsante">Delete device</button>
			
		</form>
	</div>
	<table border=2 align="center">
<tr>
<td>Device id</td>
<td>Registration number</td>
<td>Device type</td>
<td>Description</td>
<td>Min pressure</td>
<td>Max pressure</td>
<td>Min heartbeats</td>
<td>Max heartbeats</td>
<td>Min breaths</td>
<td>Max breaths</td>
<td>Min temperature</td>
<td>Max temperature</td>
</tr>
</table>
</body>
</html>