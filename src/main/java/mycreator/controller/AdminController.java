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
import mycreator.model.Batch;
import mycreator.model.Branch;
import mycreator.model.Department;

public class AdminController extends HttpServlet {

	AdminDAO adminDAO = new AdminDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		try {
			System.out.println("hiii");
			if (uri.contains("departement")) {
				System.out.println("dep");
				List<Department> departments = adminDAO.fetchListofDepartments();
				request.setAttribute("departments", departments);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/departement.jsp");
				requestDispatcher.forward(request, response);
			} else if (uri.contains("department/delete")) {
				System.out.println("delete");
				Integer departmentId = Integer.parseInt(request.getParameter("id"));
				adminDAO.deleteTheDepartment(departmentId);
				response.sendRedirect("/mycreator/departement");
			} else if (uri.contains("department/add")) {
				System.out.println("add");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/newdepartment.jsp");
				requestDispatcher.forward(request, response);
			} else if (uri.contains("department/edit")) {
				System.out.println("edit");
				Integer departmentId = Integer.parseInt(request.getParameter("id"));
				Department department = adminDAO.fetchDepartmentDetails(departmentId);
				request.setAttribute("department", department);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/editdepartment.jsp");
				requestDispatcher.forward(request, response);
			} else if (uri.contains("branch")) {
				if (uri.contains("delete")) {
					System.out.println("delete");
					Integer branchId = Integer.parseInt(request.getParameter("id"));
					adminDAO.deleteTheBranch(branchId);
					response.sendRedirect("/mycreator/branch");
				} else if (uri.contains("branch/edit")) {
					System.out.println("edit");
					Integer branchtId = Integer.parseInt(request.getParameter("id"));
					Branch branch = adminDAO.fetchBranchDetails(branchtId);
					request.setAttribute("branch", branch);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/editbranch.jsp");
					requestDispatcher.forward(request, response);
				} else if (uri.contains("branch/add")) {
					System.out.println("add");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/addbranch.jsp");
					requestDispatcher.forward(request, response);
				} else if (uri.contains("branch")) {
					System.out.println("branch");
					List<Branch> listOfBranches = adminDAO.fetchListOfBranchs();
					request.setAttribute("listOfBranches", listOfBranches);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/branch.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			else if (uri.contains("batchperiod")) {
				if (uri.contains("delete")) {
					System.out.println("delete");
					Integer batchperiodId = Integer.parseInt(request.getParameter("id"));
					adminDAO.deleteTheBatch(batchperiodId);
					response.sendRedirect("/mycreator/batchperiod");
				
				} else if (uri.contains("batchperiod/edit")) {
					System.out.println("batch/edit");
					Integer batchperiodId = Integer.parseInt(request.getParameter("id"));
					Batch batch = adminDAO.fetchBatchDetails(batchperiodId);
					request.setAttribute("batch", batch);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/editbatchperiod.jsp");
					requestDispatcher.forward(request, response);
				
				} else if (uri.contains("batchperiod/add")) {
					System.out.println("add");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/addbatchperiod.jsp");
					requestDispatcher.forward(request, response);
				
				} else if (uri.contains("batchperiod")) {
					System.out.println("batchperiod");
					List<Batch> listOfBatches = adminDAO.fetchListOfBatches();
					request.setAttribute("listOfBatches", listOfBatches);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/batchperiod.jsp");
					requestDispatcher.forward(request, response);
				}
			}
//			else if (uri.contains("branch")) {
//				System.out.println("branch");
//				List<Branch> listOfBranches = adminDAO.fetchListOfBranchs();
//				request.setAttribute("listOfBranches", listOfBranches);
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/branch.jsp");
//				requestDispatcher.forward(request, response);
//			} else if (uri.contains("branch/delete")) {
//				System.out.println("delete");
//				Integer branchId = Integer.parseInt(request.getParameter("id"));
//				adminDAO.deleteTheBranch(branchId);
//				response.sendRedirect("/mycreator/branch");
//			} else if (uri.contains("branch/add")) {
//				System.out.println("add");
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/addbranch.jsp");
//				requestDispatcher.forward(request, response);
//			} else if (uri.contains("branch/edit")) {
//				System.out.println("edit");
//				Integer branchtId = Integer.parseInt(request.getParameter("id"));
//				Branch branch = adminDAO.fetchBranchDetails(branchtId);
//				request.setAttribute("branch", branch);
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/editbranch.jsp");
//				requestDispatcher.forward(request, response);
//			
//			
//			} 
//			else if (uri.contains("batchperiod")) {
//				System.out.println("batchperiod");
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/addbatchperiod.jsp");
//				requestDispatcher.forward(request, response);
//			} else if (uri.contains("compliationstatus")) {
//				System.out.println("compliationstatus");
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/jsp/addnewuser.jsp");
//				requestDispatcher.forward(request, response);
//			}
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

			} else if (uri.contains("department/update")) {
				Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
				String departmentName = request.getParameter("departmentName");
				adminDAO.updateDepartmentDetails(departmentId, departmentName);
				response.sendRedirect("/mycreator/departement");

			} else if (uri.contains("branch")) {
				if (uri.contains("save")) {
					Branch branch = new Branch();
					branch.setBranchArea(request.getParameter("areaName"));
					branch.setBranchDistrict(request.getParameter("districtName"));
					branch.setBranchState(request.getParameter("state"));
					branch.setBranchPincode(Integer.parseInt(request.getParameter("pincode")));
					adminDAO.addBranch(branch);
					response.sendRedirect("/mycreator/branch");

				} else if (uri.contains("update")) {
					Branch branch = new Branch();
					branch.setBranchId(Integer.parseInt(request.getParameter("branchId")));
					branch.setBranchArea(request.getParameter("area"));
					branch.setBranchDistrict(request.getParameter("district"));
					branch.setBranchState(request.getParameter("state"));
					branch.setBranchPincode(Integer.parseInt(request.getParameter("pincode")));

					adminDAO.updateBranchDetails(branch);
					response.sendRedirect("/mycreator/branch");
				}

			}else if (uri.contains("batch")) {
				if (uri.contains("save")) {
					Batch batch = new Batch();
					batch.setBatchStartDate(request.getParameter("startdate"));
					batch.setBatchEndDate(request.getParameter("enddate"));
					batch.setBatch(Byte.parseByte(request.getParameter("batchno")));
					
					batch.setBatchMode(request.getParameter("mode"));
					
					
					adminDAO.addBatch(batch);
					response.sendRedirect("/mycreator/batchperiod");

				} else if (uri.contains("update")) {
					Batch batch = new Batch();
					batch.setBatchId(Integer.parseInt(request.getParameter("branchId")));
					batch.setBatchStartDate(request.getParameter("startDate"));
					batch.setBatchEndDate(request.getParameter("endDate"));
					batch.setBatch(Byte.parseByte(request.getParameter("batchNumber")));
					batch.setBatchMode(request.getParameter("mode"));

					adminDAO.updateBatchDetails(batch);
					response.sendRedirect("/mycreator/batchperiod");
				}

			} else if (uri.contains("compliationstatus")) {

			}

		}

		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
