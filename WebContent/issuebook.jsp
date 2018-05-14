<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css"/>
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
      <a class="navbar-brand" href="index.html">eLibrary</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index.html">Home</a></li>
        <li><a href="addbookform.jsp">Add Book</a></li>
        <li><a href="ViewBook">View Book</a></li>
        <li><a href="issuebook.jsp">Issue Book</a></li>
        <li><a href="ViewIssuedBook">View Issued Book</a></li>
        <li><a href="returnbookform.jsp">Return Book</a></li>
        <li><a href="LogoutAdmin.jsp">Logout</a></li>
       </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="container">


<h3>Issue Book Form</h3>
  <form action="IssueBook" method="post" style="width:300px">
  <div class="form-group">
    <label for="callno1">Book Callno</label>
    <input type="text" class="form-control" name="callno" id="callno1" placeholder="Callno"/>
  </div>
  <div class="form-group">
    <label for="id1">Student Id</label>
    <input type="text" class="form-control" name="studentid" id="id1" placeholder="Student Id"/>
  </div>
  <div class="form-group">
    <label for="name1">Student Name</label>
    <input type="text" class="form-control" name="studentname" id="name1" placeholder="Student Name"/>
  </div>
  <div class="form-group">
    <label for="mobile1">Student Mobile</label>
    <input type="number" class="form-control" name="studentmobile" id="mobile1" placeholder="Student Mobile"/>
  </div>
  <button type="submit" class="btn btn-primary">Issue Book</button>
</form>
</div>

</body>
</html>