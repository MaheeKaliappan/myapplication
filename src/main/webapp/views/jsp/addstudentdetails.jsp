<%@page import="mycreator.model.Batch"%>
<%@page import="mycreator.model.Branch"%>
<%@page import="java.util.List"%>
<%@page import="mycreator.model.Department"%>
<%@page import="mycreator.model.User"%>
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
<title>Add Student Details Page</title>
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
	
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%out.print(session.getAttribute("email")); %></a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
	<br><br> 
	<div class="container">
		<h2>
			<center>Add Student Details</center>
		</h2>
		<div class="col-md-offset-3 col-md-7">
			<div class="panel panel-default">
				<div class="panel-body">

					<form class="form-horizontal" action="studentdetails"
						method="post">
						<div class="form-group">
							<label class="control-label col-sm-3" for="userid">Student
								Name:</label>
							<div class="col-sm-6">
								<select name="userid" id="userid" class="form-control">
									<%
									User user = (User) request.getAttribute("student");
									%>
									<option value=<%out.print(user.getUserId());%>>
										<%out.print(
										user.getUserFirstName()+""+user.getUserLastName());
										%>
									</option>
									
								</select>
							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="lastName">Qualification:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control " id="qualification"
									placeholder="Enter  Qualification " name="qualification">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="departmentid">Student Department:</label>
							<div class="col-sm-6">
								<select name="departmentid" id="departmentid" class="form-control">
									<%
									 List<Department>departments= (List<Department>) request.getAttribute("departments");
									%>
									<%for(int index =0;index<departments.size();index++)
										{%>
										<option value=<%out.print(departments.get(index).getDepartmentId());%>>
										<%out.print(
										departments.get(index).getDepartmentName());
										%>
									</option>
									<%}%>
								</select>
								
							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="batchid">Student
								Batch:</label>
							<div class="col-sm-6">
								<select name="batchid" id="batchid" class="form-control">
									<%
									Batch batch = (Batch) request.getAttribute("batch");
									%>
									<option value=<%out.print(batch.getBatchId());%>>
										<%out.print(
										batch.getBatch());
										%>
									</option>
									
								</select>
							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="branchid">Student Branch:</label>
							<div class="col-sm-6">
								<select name="branchid" id="branchid" class="form-control">
									<%
									 List<Branch>branches= (List<Branch>) request.getAttribute("branchs");
									%>
									<%for(int index =0;index<branches.size();index++)
										{%>
										<option value=<%out.print(branches.get(index).getBranchId());%>>
										<%out.print(
										branches.get(index).getBranchDistrict());
										%>
									</option>
									<%}%>
								</select>
								
							</div>

						</div>
						
						
						
						<input type="hidden" id="zmail" name="zmail" value=<%out.print(user.getUserFirstName()+""+user.getUserLastName()); %>@zohotrainess.com>
						
						
						<%int value;
					//	if(request.getParameter("departmentid").equals ("1"))
						//	{
							//	 value="zs";
							//}
						//else if(request.getParameter("departmentid").equals("2"))
							//{
								// value="zsm";
							//}
							value = (int)user.getUserId();%>
						<input type="hidden" id="zid" name ="zid" value=<%out.print(value); %>>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-3">
								<button type="submit" class="btn btn-dark">Add Student details</button>

							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</body>
</html>