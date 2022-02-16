<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>

	<form action="form-handler" method="post">
	EmployeeName:<input type="text" name="eName"><br>
	EmployeeSuraname:<input type="text" name="eSurname"><br>
	EmployeeDesignation:<input type="text" name="eDesi"><br>
	<input type="submit" value="Add">
    <a href="<%=request.getContextPath()%>/">Back</a>	
	
	
	</form>

</body>
</html>