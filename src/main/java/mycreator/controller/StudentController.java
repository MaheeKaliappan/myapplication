package mycreator.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mycreator.dao.StudentDao;
import mycreator.model.Batch;
import mycreator.model.Branch;
import mycreator.model.Department;
import mycreator.model.StudentDetails;
import mycreator.model.User;

public class StudentController extends HttpServlet {
	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI().toString();
		StudentDao studentDao = new StudentDao();
		
		if(uri.contains("addnewuser"))
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/addnewuser.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else if(uri.contains("studentdetails"))
		{
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/addnewuser.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else if(uri.contains("addnewuser"))
		{
			User user = new User();
			user.setUserFirstName(request.getParameter("firstName"));
			user.setUserLastName(request.getParameter("lastName"));
			user.setUserPersonalmobileNumber(request.getParameter("mobileNumber"));
			user.setUserPersonalMailId(request.getParameter("mailId"));
			if(request.getParameter("role").equals("student"))
			{
				user.setRole(2);
			}
			else if(request.getParameter("role").equals("admin"))
			{
				user.setRole(1);
			}
			try {
				studentDao.addNewUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if(user.getRole()== 2)
			{
				User student;
				List<Department> departments;
				List <Branch> branchs;
				Batch batch;
				try {
					
					 student     = studentDao.fetchNotAddedDetailsStudent();
					 
					 departments = studentDao.fetchDepartmentDetails();
					 branchs     = studentDao.fetchBranchsDetails();
					 batch       = studentDao.fetchBatchDetails();
					 
					 request.setAttribute("student", student);
			         request.setAttribute("departments", departments);
			         request.setAttribute("branchs", branchs);
			         request.setAttribute("batch", batch);
					 
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//response.sendRedirect("views/jsp/addstudentdetails.jsp"); 
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/addstudentdetails.jsp");
				requestDispatcher.forward(request, response);
			}
			
		}
		else if(uri.contains("studentdetails"))
		{
			
			try {
				StudentDetails studentDetails = new StudentDetails();
				System.out.println("user"+request.getParameter("userid"));
				studentDetails.setStudentId(Integer.parseInt(request.getParameter("userid")));
				
				studentDetails.setStudentQualification(request.getParameter("qualification"));
				 
				studentDetails.setStudentDepartmentId(Integer.parseInt(request.getParameter("departmentid")));
				studentDetails.setStudentBatchId(Integer.parseInt(request.getParameter("batchid")));
				studentDetails.setStudentBranchId(Integer.parseInt(request.getParameter("branchid")));
				studentDetails.setStudentZmailId(request.getParameter("zmail"));
				studentDetails.setStudentZId(request.getParameter("zid"));
				studentDao.addStudentDetails(studentDetails);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/addnewuser.jsp");
				requestDispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest
			request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
	}

}
