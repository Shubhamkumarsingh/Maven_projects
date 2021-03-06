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
    <a class="nav-link active" href="listUser.jsp">View All Users</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="LoginHandler?operation=logout">Logout</a>
  </li>
  </ul>
<br><br>
<div class="container">
<h1>Add User</h1>
<form action="UserHandler?operation=addUser" method="post">
<div class="form-group row">
    <label for="userid" class="col-sm-2 col-form-label">User ID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="id" placeholder="Enter userid">
    </div>
  </div>
  <div class="form-group row">
    <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="firstName" placeholder="Enter first name">
    </div>
  </div>
  <div class="form-group row">
    <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="lastName" placeholder="Enter last name">
    </div>
  </div>
  <div class="form-group row" style="text-align:center;">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Add User</button>
    </div>
  </div>
</form>
<a href='UserHandler?operation=listUsers'>View All Users</a>
</div>
</body>
</html>