<%@page import="employeeCrud.model.Employee"%>
<%@page import="java.util.List"%>
<html>
<body>
<h2>Hello it''s home page!</h2>

<% List<Employee> emp =(List<Employee>) request.getAttribute("emp"); %>

<table>
  <tr>
    <th>EmployeeName</th>
    <th>EmployeeSurname</th>
    <th>EmployeeDesignation</th>
    <th>EmployeeEmail</th>
    <th>Actions</th>
  </tr>
  <tr>
  <%for(Employee e : emp){ %>
    <td><%=e.geteName() %></td>
    <td><%=e.geteSurname() %></td>
    <td><%=e.geteDesi() %></td>
    <td><%=e.getEmail() %></td>
    <td><a href="update/<%=e.geteId()%>">Edit</a></td>
    <td><a href="delete/<%=e.geteId()%>">Delete</a></td>
  </tr>
 <%} %>
</table>

</body>
</html>
