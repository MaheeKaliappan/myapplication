package mycreator.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mycreator.dao.AdminDAO;
import mycreator.dao.StudentDao;
import mycreator.model.Branch;
import mycreator.model.Department;

public class AdminController extends HttpServlet {

	AdminDAO adminDAO = new AdminDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		try {
			if (uri.contains("departement")) {
				List<Department> departments = adminDAO.fetchListofDepartments();

				request.setAttribute("departments", departments);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/departement.jsp");
				requestDispatcher.forward(request, response);
			}  else if (uri.contains("department/delete")) {
				Integer departmentId = Integer.parseInt(request.getParameter("id"));
				adminDAO.deleteTheDepartment(departmentId);
				response.sendRedirect("/mycreator/departement");
			}else if (uri.contains("department/add")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/newdepartment.jsp");
				requestDispatcher.forward(request, response);
				
			}else if (uri.contains("department/edit")) {
				Integer departmentId = Integer.parseInt(request.getParameter("id"));
				Department department = adminDAO.fetchDepartmentDetails(departmentId);
				request.setAttribute("department", department);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/editdepartment.jsp");
				requestDispatcher.forward(request, response);
				
			}else if (uri.contains("branch")) {
				System.out.println("branch");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/addbranch.jsp");
				requestDispatcher.forward(request, response);
			} else if (uri.contains("batchperiod")) {
				System.out.println("batchperiod");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/addbatchperiod.jsp");
				requestDispatcher.forward(request, response);
			} else if (uri.contains("compliationstatus")) {
				System.out.println("compliationstatus");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/addnewuser.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		try {
		if (uri.contains("department/save")) {
			
			String departmentName = request.getParameter("departmentName");
			
			
				adminDAO.addDepartmentDetails(departmentName);
				response.sendRedirect("/mycreator/departement");
				
			} 
			else if (uri.contains("branch")) {
			Branch branch = new Branch();
			branch.setBranchArea(request.getParameter("areaName"));
			branch.setBranchDistrict(request.getParameter("districtName"));
			branch.setBranchState(request.getParameter("state"));
			branch.setBranchPincode(Integer.parseInt(request.getParameter("pincode")));
			System.out.println(branch.getBranchArea());
			System.out.println(branch.getBranchDistrict());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jsp/addbranch.jsp");
			requestDispatcher.forward(request, response);

		} else if (uri.contains("department/update")) {
			
			Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
			String departmentName = request.getParameter("departmentName");
			adminDAO.updateDepartmentDetails(departmentId, departmentName);
			response.sendRedirect("/mycreator/departement");
		}else if (uri.contains("compliationstatus")) {

		}
		
	}
	
		 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
