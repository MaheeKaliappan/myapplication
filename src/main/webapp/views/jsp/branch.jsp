<%@page import="mycreator.model.Branch"%>
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
<title>Department Details</title>
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
      <li><a href="#">Branch</a></li>
    
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
		<h2><center>Branch</center></h2>
		<br>
		
		<div class="col-md-12">
			<div class="row text-right">
				<a href="branch/add" class="btn btn-success">Add Branch</a>
			</div>
			<br><br>
		  	<table class="table table-hover">
			    <thead>
			      <tr>
			        <th>S.No</th>
			        <th>Branch Area</th>
			        <th>Branch District</th>
			        <th>Branch State</th>
			        <th>Branch pincode</th>
			        <th>Added On</th>
			        <th>Added By</th>
			        <th>Modified On</th>
			        <th>Modified By</th>
			        <th>Action</th>
			      </tr>
			    </thead>
			    <tbody>
			    <%
				List<Branch> branches = (List<Branch>) request.getAttribute("listOfBranches");
				for(int index = 0; index < branches.size(); index++) {
					
					out.print("<tr>");
					
					out.print("<td>"+(index+1)+"</td>");
					out.print("<td>"+(branches.get(index).getBranchArea())+"</td>");
					out.print("<td>"+(branches.get(index).getBranchDistrict())+"</td>");
					out.print("<td>"+(branches.get(index).getBranchState())+"</td>");
					out.print("<td>"+(branches.get(index).getBranchPincode())+"</td>");
					out.print("<td>"+(branches.get(index).getBranchAddedOn() != null ? branches.get(index).getBranchAddedOn() : "-" )+"</td>");
					out.print("<td>"+(branches.get(index).getBranchAddedBy() != null ? branches.get(index).getBranchAddedBy() : "-" )+"</td>");
					out.print("<td>"+(branches.get(index).getBranchModifiedOn() != null ? branches.get(index).getBranchModifiedOn() : "-" )+"</td>");
					out.print("<td>"+(branches.get(index).getBranchmodifiedBy() != null ? branches.get(index).getBranchmodifiedBy() : "-")+"</td>");
					out.print("<td><a href='branch/edit?id="+branches.get(index).getBranchId()+"' class='btn btn-primary'>Edit</a> <a href='branch/delete?id="+branches.get(index).getBranchId()+"' class='btn btn-danger'>Delete</a> </td>");
					
					out.print("</tr>");
				} %>
			    </tbody>
			</table>
					
					
					
			
   		</div>
	</div>
</body>






</html>