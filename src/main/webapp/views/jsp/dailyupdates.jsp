<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.xml.crypto.Data"%>
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
<title>Student Page</title>
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
      <a class="navbar-brand" href="#">ZStudent</a>
    </div>
    <ul class="nav navbar-nav">
      
    
      <li><a href="previousstatus">Previous Status</a></li>
      <li><a href="dailyupdates">Daily Updates</a></li>
      <li><a href="currentstatus">Current Status</a></li>
     
      
      
   
    </ul>
    <ul class="nav navbar-nav navbar-right">
	 <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%out.print(session.getAttribute("email")); %></a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
	<br><br>
	<div class="container">
		<h3><center>We did this</center></h3>
		<div class="col-md-offset-3 col-md-7">
		
   <div class="panel panel-default">
   <div class="panel-body">
		
		<form class="form-horizontal" action="dailyupdates" method="post">
			<div class="form-group">
				<label class="control-label col-sm-3" for="candidate">Candidate:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control " id="candidate"
						placeholder="<%out.print(session.getAttribute("email")); %>"name="candidate">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="date">Date:</label>
				<div class="col-sm-6">
				<%Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");%>
					<input type="text" class="form-control " id="date"
						placeholder="<%out.print(formatter.format(date)); %>" name="date">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="time">Check In Status:</label>
				<div class="col-sm-6">
				 <select name="time" id="time" class="form-control">
				 <%SimpleDateFormat formatt = new SimpleDateFormat("HH:mm:ss");
					Date time = new Date();
					formatt.format(time); %>
					<option value="<%out.println(formatt.format(time));%>">Check In</option>
					<option value="<%out.println(formatt.format(time));%>">Check Out</option>
					
					
				  </select>
				  </div>
				
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="leave">Leave:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control " id="leave"
						placeholder="Leave For Reason" name="leave">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-3">
					<button type="submit" class="btn btn-dark">Submit</button>
					 
					
				</div>
				<div class="col-sm-3">
					
					 <button type="reset"  class="btn btn-dark">Reset</button>
					
				</div>
			</div>
		</form>
   </div>
   </div>
   </div>
		
	</div>
</body>
</html>