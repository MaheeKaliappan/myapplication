<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>User Details</title>
<style>
	button {background-color: #555555;}
	button {color : white; }
</style>
</head>
<body>
<br>
<h3>Graduation Studies</h3>
<br>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">ZAdmin</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    
      <li><a href="departement">Department</a></li>
      <li><a href="branch">Branch</a></li>
      <li><a href="batchperiod">Batch Period</a></li>
      <li><a href="addnewuser">New User</a></li>
	  <li><a href="compliationstatus">Compliation Status</a></li>
      
      
   
    </ul>
    <ul class="nav navbar-nav navbar-right">
	
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%out.print(session.getAttribute("email")); %></a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
	<br><br>
	<div class="container">
		<h2><center>User Details</center></h2>
		<div class="col-md-offset-3 col-md-7">
   <div class="panel panel-default">
   <div class="panel-body">
		
		<form class="form-horizontal" action="addnewuser" method="post">
			<div class="form-group">
				<label class="control-label col-sm-3" for="email">First Name:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control " id="firstName"
						placeholder="Enter First Name" name="firstName">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="lastName">Last Name:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control " id="lastName"
						placeholder="Enter  Last Name" name="lastName">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="mobileNumber">Personal Mobile Number:</label>
				<div class="col-sm-6">
					<input type="number" class="form-control " id="mobileNumber"
						placeholder="Enter Personal Mobile Number " name="mobileNumber">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="mailId">Personal Mail Id:</label>
				<div class="col-sm-6">
					<input type="email" class="form-control " id="mailId"
						placeholder="Enter Personal Mail Id" name="mailId">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="role">Role:</label>
				<div class="col-sm-6">
				 <select name="role" id="role" class="form-control">
					<option value="admin">Admin</option>
					<option value="student">Student</option>
					
					
				  </select>
				  </div>
				
			</div>
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<button type="submit" class="btn btn-dark">Add User</button>
					
				</div>
			</div>
		</form>
   </div>
   </div>
   </div>
		
	</div>
</body>
</html>