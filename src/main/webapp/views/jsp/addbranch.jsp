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
	 <li><a href="#"><span class="glyphicon glyphicon-user"></span><%out.print(session.getAttribute("email")); %></a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
	<br><br>
	<div class="container">
		<h2><center>Add Branch</center></h2>
		<div class="col-md-offset-3 col-md-7">
   <div class="panel panel-default">
   <div class="panel-body">
		
		<form class="form-horizontal" action="branch" method="post">
			<div class="form-group">
				<label class="control-label col-sm-3" for="areaName">Area Name:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control " id="areaName"
						placeholder="Enter Area Name" name="areaName">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="districtName">District Name:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control " id="districtName"
						placeholder="Enter District Name" name="districtName">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="state">State Name:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control " id="state"
						placeholder="Enter State Name" name="state">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="pincode">Pincode:</label>
				<div class="col-sm-6">
					<input type="number" class="form-control " id="pincode"
						placeholder="Enter Pincode Number" name="pincode">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<button type="submit" class="btn btn-dark">Add Branch</button>
					
				</div>
			</div>
		</form>
   </div>
   </div>
   </div>
		
	</div>
</body>
</html>