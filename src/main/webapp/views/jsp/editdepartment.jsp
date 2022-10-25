<%@page import="mycreator.model.Department"%>
<%@page import="java.util.List"%>
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
      <li><a href="#">Home</a></li>
    
      <li class="active"><a href="departement">Department</a></li>
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
		<h2><center>Departments</center></h2>
		<br>
		
		<div class="col-md-offset-2 col-md-8">
			
		  	<%Department department =  (Department) request.getAttribute("department"); %>
			<form class="form-horizontal" action="update" method="post">
						<div class="form-group">
							<label class="control-label col-sm-3" for="departmentName">Department Name:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control " value = "<%=department.getDepartmentName() %>" placeholder="Enter Department Name" name="departmentName">
									<input type="hidden" name="departmentId" value="<%=department.getDepartmentId()%>">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3" for="departmentName">Added by:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control " value = "<%=department.getDepartmentAddedBy() %>" placeholder="Enter Department Name" name="departmentName" disabled="disabled">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3" for="departmentName">Added On:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control " value = "<%=department.getDepartmentAddedOn() %>" placeholder="Enter Department Name" name="departmentName" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="departmentName">Modified By:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control " value = "<%=department.getDepartmentModifiedBy() != null ? department.getDepartmentModifiedBy() : " - " %>" placeholder="Enter Department Name" name="departmentName" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="departmentName">Modified On:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control " value = "<%=department.getDepartmentModifiedOn() != null ? department.getDepartmentModifiedOn() : " - " %>" placeholder="Enter Department Name" name="departmentName" disabled="disabled">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-3">
								<button type="submit" class="btn btn-dark">Update Department</button>
								
							</div>
						</div>
					</form>		
					
			
   		</div>
	</div>
</body>





</html>