package mycreator.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mycreator.dao.AdminDAO;
import mycreator.dao.StudentDao;
import mycreator.dao.UserDAO;
import mycreator.model.StudentDetails;
import mycreator.model.User;
import mycreator.model.UserDetails;

public class UserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		UserDAO userDAO = new UserDAO();
		if (uri.contains("dailyupdates")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/dailyupdates.jsp");
			requestDispatcher.forward(request, response);
		} else if (uri.contains("currentstatus")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/currentstatus.jsp");
			requestDispatcher.forward(request, response);
		} else if (uri.contains("previousstatus")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/previousstatus.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		UserDAO userDAO = new UserDAO();
		try {
			if (uri.contains("dailyupdates")) {
				HttpSession session = request.getSession();
				UserDetails userDetails = new UserDetails();
				userDetails.setUserId((int) session.getAttribute("userId"));
				userDetails.setReasonForLeaave(request.getParameter("leave"));

				if (userDetails.getReasonForLeaave() == "") {
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

					userDetails.setDate(formatter.format(date));

					userDetails.setStatus(userDAO.fetchUserStatus(userDetails.getUserId()));

					if (userDetails.getStatus() == 0) {
						userDetails.setStatus(1);
						userDetails.setInTime(request.getParameter("time"));
						userDAO.insertCheckInStatus(userDetails);

					} else {

						userDetails.setOutTime(request.getParameter("time"));
						userDetails.setStatus(0);
						userDAO.updateCheckOutStatus(userDetails);

					}
				} else {
					userDAO.updateLeave(userDetails);

				}

				userDAO.fetchPreviousRecords((int) session.getAttribute("userId"));
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/previousstatus.jsp");
				requestDispatcher.forward(request, response);

			} else if (uri.contains("currentstatus")) {
				UserDetails userDetails = new UserDetails();
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				userDetails.setDate(formatter.format(date));
				Date time = new Date();
				SimpleDateFormat formatt = new SimpleDateFormat("HH:mm:ss");
				userDetails.setInTime(formatt.format(time));
				HttpSession session = request.getSession();
				userDetails.setUserId((int) session.getAttribute("userId"));
				userDetails.setiDid(request.getParameter("idid"));
				userDAO.insertIdidStatus(userDetails);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/previousstatus.jsp");
				requestDispatcher.forward(request, response);
			}
		}

		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
