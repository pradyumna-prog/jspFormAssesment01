<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html> 
<html> 
<head>  
<title>Pradyumna Tripathi MCA B Roll No. 41</title> 
</head> 
<body>  
	<h1>Employee Register Form</h1> 
	<form action="<%= request.getContextPath() %>/addEmployee" method="post"> 
		<table> 
			<tr> 
				<td>First Name</td> 
				<td><input type="text" name="firstName"></td>
			</tr> 
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"></td>
				</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="userName"></td>
				</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td> 
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"></td>
				</tr>
			<tr>
				<td>Contact No</td>
				<td><input type="text" name="contact"></td>
				</tr> 
			</table> 
		<input type="submit" value="Submit">
	</form>
	<%if(request.getAttribute("result") != null)
		out.print((String)request.getAttribute("result"));
		%>
</body>
</html>