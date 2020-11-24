<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style type="text/css">
.selector-for-some-widget {
  box-sizing: content-box;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul class="nav justify-content-end">
  <li class="nav-item">
    <a class="nav-link active" href="index.jsp">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="signup.jsp">Sign in</a>
  </li>
  </ul>
<br>
<form action="LoginHandler?operation=login" method="post">
<div class="container">
<h1>Login</h1>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" placeholder="Name">
    </div>
  </div>
  <div class="form-group row">
    <label for="password" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="password" placeholder="Password">
    </div>
  </div>
  <div class="form-group row" style="text-align:center;">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
  </div>
  </div>
</form>
</body>
</html>