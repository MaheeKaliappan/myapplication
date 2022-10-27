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
button {
	background-color: #555555;
}

button {
	color: white;
}
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
				<li><a href="login"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<div class="container">
		<h2>
			<center>Batch</center>
		</h2>
		<div class="col-md-offset-3 col-md-7">
			<div class="panel panel-default">
				<div class="panel-body">

					<form class="form-horizontal" action="save" method="post">
					<div class="form-group">
							<label class="control-label col-sm-3" for="startdate">Start Date:</label>
							<div class="col-sm-6">
								<input type="date" class="form-control " id="startdate"
									placeholder="Enter Batch startdate" name="startdate">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="enddate">End Date:</label>
							<div class="col-sm-6">
								<input type="date" class="form-control " id="enddate"
									placeholder="Enter Batch startdate" name="enddate">
							</div>
						</div>
					
					
					
						<div class="form-group">
							<label class="control-label col-sm-3" for="batchno">Batch
								Number:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control " id="batchno"
									placeholder="Enter Batch Number" name="batchno">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="mode">Mode:</label>
							<div class="col-sm-6">
								<select name="mode" id="mode" class="form-control">
									
									<option value="online">Online</option>
									<option value="offline">Offline</option>
									<option value="both">Both</option>


								</select>
							</div>

						</div>

						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-3">
								<button type="submit" class="btn btn-dark">Add Batch</button>

							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</body>
</html>