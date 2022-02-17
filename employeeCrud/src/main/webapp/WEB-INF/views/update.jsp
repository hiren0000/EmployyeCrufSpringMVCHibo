<%@page import="employeeCrud.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%Employee em = (Employee)request.getAttribute("emp"); %>
	
	<form action="<%=request.getContextPath() %>/form-handler" method="post">
	<input type="hidden" name="eId" value="<%=em.geteId()%>">
	EmployeeName:<input type="text" name="eName" value="<%=em.geteName()%>"><br>
	EmployeeSuraname:<input type="text" name="eSurname" value="<%=em.geteSurname()%>"><br>
	EmployeeDesignation:<input type="text" name="eDesi" value="<%=em.geteDesi()%>"><br>
	EmployeeEmail:<input type="email" name="email" value="<%=em.getEmail()%>"><br>
	<input type="submit" value="Update">
    <a href="<%=request.getContextPath()%>/">Back</a>	
	
	
	</form>

</body>
</html>