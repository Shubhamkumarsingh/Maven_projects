<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String statusMessage= (String)session.getAttribute("status");
int statusCode= (Integer)session.getAttribute("statuscode"); 
%>
<%if(statusCode==0 || statusCode==2) { %>
<div class="alert alert-danger container" role="alert">
  <%=statusMessage %>
</div>

<%if(statusMessage.equals("Username doesn't exists.")){ %>
<div class="alert alert-danger container" role="alert">
  Please sign in first
</div>
<%@include file="signup.jsp" %>
<%}else { %>
  <%@include file="login.jsp" %>
  <%} %>
<% } else{ %>
<%if(statusMessage.equals("logged in successfully.")){ %>
<div class="alert alert-success container" role="alert">
  <%=statusMessage %>
</div>
<ul class="nav justify-content-end">
  <li class="nav-item">
    <a class="nav-link active" href="LoginHandler?operation=logout">LogOut</a>
  </li>
  </ul>
<div class="list-group container">
<h1>Click below to perform any action</h1>
  <a href="user.jsp" class="list-group-item list-group-item-action">Add User</a>
  <a href="listUser.jsp" class="list-group-item list-group-item-action">View All Users</a>
  </div>
<%}else{ %>
<div class="alert alert-success container" role="alert">
  <%=statusMessage %>
  Please login.
</div>
<%@include file="login.jsp" %>
<%} %>
<%}%>
</body>
</html>