<%@page import="com.shubham.dao.UserDao"%>
<%@page import="com.shubham.beans.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul class="nav justify-content-end">
  <li class="nav-item">
    <a class="nav-link active" href="LoginHandler?operation=homepage">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="user.jsp">Add User</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="LoginHandler?operation=logout">Logout</a>
  </li>
  </ul>
<%
UserDao u=new UserDao();
List<UserBean> l=u.getUsers();
%>
<div class="container"><br>
<h1>List of all users</h1><br><br>
<table class="table table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">User id</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Operations</th>
    </tr>
  </thead>
<% for(UserBean ub: l) { %>
<tbody>
    <tr>
      <td><%=ub.getId() %></td>
      <td><%=ub.getFirstName() %></td>
      <td><%=ub.getLastName() %></td>
      <td><a href='UserHandler?operation=update&id=<%=ub.getId()%>'>Update</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href='UserHandler?operation=delete&id=<%=ub.getId()%>'>Delete</a></td>
    </tr>
<% } %>
</table>
</div>
</body>
</html>