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
<title>Login Page</title>
<style>
	button {background-color: #555555;}
	button {color : white; }
</style>
</head>
<body>
	<br><br><br><br><br><br><br>
	<div class="container">
		<h2><center>Login</center></h2>
		<div class="col-md-offset-3 col-md-7">
   <div class="panel panel-default">
   <div class="panel-body">
		
		<form class="form-horizontal" action="login" method="post">
			<div class="form-group">
				<label class="control-label col-sm-3" for="email">Email:</label>
				<div class="col-sm-6">
					<input type="email" class="form-control " id="email"
						placeholder="Enter Email" name="email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="password">Password:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control " id="password"
						placeholder="Enter Password" name="password">
				</div>
			</div>
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<button type="submit" class="btn btn-dark">Login</button>
					
				</div>
			</div>
		</form>
   </div>
   </div>
   </div>
		
	</div>
</body>
</html>