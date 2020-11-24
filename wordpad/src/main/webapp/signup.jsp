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
    <a class="nav-link active" href="index.jsp">Home</a>
  </li>
 <li class="nav-item">
    <a class="nav-link active" href="login.jsp">Login</a>
  </li>
  </ul>
<br>
<form action="LoginHandler?operation=signin" method="post">
<div class="container">
<h1>SignUp</h1>
<p>Please fill in this form to create an account.</p>
    <hr>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" placeholder="Enter name">
    </div>
  </div>
  <div class="form-group row">
    <label for="password" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="password" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group row" style="text-align:center;">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Sign In</button>
    </div>
  </div>
  </div>
</form>
</body>
</html>