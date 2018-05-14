<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap.min.css"/>
<title>Login</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="homepage.jsp">eLibrary</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="homepage.jsp" class="active">Home</a></li>
        <li><a href="#">Admin</a></li>
        <li><a href="#">Librarian</a></li>
       </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
<h3>Invalid Login id</h3>

<h3>Admin Login</h3>
  <form action="AdminLogin" method="post" style="width:300px">
  <div class="form-group">
    <label for="email1">Email address</label>
    <input type="email" class="form-control" name="email" id="email1" placeholder="Email"/>
  </div>
  <div class="form-group">
    <label for="password1">Password</label>
    <input type="password" class="form-control" name="password" id="password1" placeholder="Password"/>
  </div>  
  <button type="submit" class="btn btn-primary">Login</button>
</form>
</div>

</body>
</html>