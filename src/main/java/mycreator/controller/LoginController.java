package mycreator.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mycreator.dao.LoginDAO;
import mycreator.dao.StudentDao;
import mycreator.model.StudentDetails;
import mycreator.model.User;

public class LoginController extends HttpServlet {
	public LoginController() {
		
	}
	String email ="";
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		
		if(uri.contains("login"))
		{
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		LoginDAO loginDao = new LoginDAO();
		
		try {
		if(uri.contains("login"))
		{
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("email",request.getParameter("email"));
			//System.out.println("Session "+httpSession.getAttribute("email"));
			StudentDetails studentDetails = new StudentDetails();
			studentDetails.setStudentZmailId(request.getParameter("email"));
			studentDetails.setStudentPassword(request.getParameter("password"));
			email=request.getParameter("email");
			
			
				Integer result = loginDao.fetchUserInformation(studentDetails);
				
				if(result==1)
				{
					String password="";
					for(int index = 0;index<studentDetails.getStudentPassword().length();index++)
					{
						password+= String.valueOf((int)studentDetails.getStudentPassword().charAt(index));
					}
					//System.out.println(password);
					Integer userId = loginDao.checkMailIdAndPassword(password,email);
					httpSession.setAttribute("userId", userId);
					User user = loginDao.findUserStatusAndRole(userId);
					//role == 1 (admin) 2 = student
					if(user.getUserStatus() == 1)
					{
						if(user.getRole() == 1)
						{
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/adminpage.jsp");
							requestDispatcher.forward(request, response);
						}
						else if(user.getRole() == 2)
						{
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/dailyupdates.jsp");
							requestDispatcher.forward(request, response);
						}
					}
					else {
						System.out.println("Inactive user");
					}
					
					
				}
				else
				{
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/resetpasswordpage.jsp");
					requestDispatcher.forward(request, response);
				}
		
			
		}
		else if(uri.contains("resetpassword"))
		{
			
				
					String resetPassword = request.getParameter("resetpassword");
					String conformPassword = request.getParameter("conformpassword");
					String password ="";
					if(resetPassword.equalsIgnoreCase(conformPassword))
					{
						for(int index = 0;index<resetPassword.length();index++)
						{
							password+= String.valueOf((int)resetPassword.charAt(index));
						}
						
					}
					
					loginDao.changePassword(password,email);
				
			}
			else
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/resetpasswordpage.jsp");
				requestDispatcher.forward(request, response);
			}
		
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
