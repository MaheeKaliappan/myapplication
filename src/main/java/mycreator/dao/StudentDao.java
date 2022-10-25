package mycreator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mycreator.model.Batch;
import mycreator.model.Branch;
import mycreator.model.Department;
import mycreator.model.StudentDetails;
import mycreator.model.User;

public class StudentDao {
	static Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	private void getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mycreator?characterEncoding=latin1&useConfigs=maxPerformance", "root",
				"root");
	}

	public void addNewUser(User user) throws SQLException, ClassNotFoundException {
		getConnection();

		String sqlQuery = "INSERT INTO USER (FIRST_NAME,LAST_NAME,PERSONAL_MOBILE_NUMBER,PERSONAL_MAIL_ID,ROLE_ID) VALUES(?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, user.getUserFirstName());
		preparedStatement.setString(2, user.getUserLastName());
		preparedStatement.setString(3, user.getUserPersonalmobileNumber());
		preparedStatement.setString(4, user.getUserPersonalMailId());
		preparedStatement.setInt(5, user.getRole());

		preparedStatement.executeUpdate();

	}

	public User fetchNotAddedDetailsStudent() throws SQLException, ClassNotFoundException {
		getConnection();
		User user = new User();
		String sqlQuery = "SELECT ID,FIRST_NAME,LAST_NAME FROM USER WHERE ROLE_ID=?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setInt(1, 2);

		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			user.setUserId(resultSet.getInt(1));
			user.setUserFirstName(resultSet.getString(2));
			user.setUserLastName(resultSet.getString(3));

		}
		return user;
	}

	public List<Department> fetchDepartmentDetails() throws SQLException, ClassNotFoundException {
		getConnection();
		List<Department> departments = new ArrayList();
		String sqlQuery = "SELECT ID,NAME FROM DEPARTMENT";
		preparedStatement = connection.prepareStatement(sqlQuery);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Department department = new Department();
			department.setDepartmentId(resultSet.getInt(1));
			department.setDepartmentName(resultSet.getString(2));
			departments.add(department);

		}
		return departments;
	}

	public List<Branch> fetchBranchsDetails() throws SQLException, ClassNotFoundException {
		getConnection();
		List<Branch> branches = new ArrayList();
		String sqlQuery = "SELECT ID,DISTRICT FROM BRANCH";
		preparedStatement = connection.prepareStatement(sqlQuery);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Branch branch = new Branch();
			branch.setBranchId(resultSet.getInt(1));
			branch.setBranchDistrict(resultSet.getString(2));
			branches.add(branch);

		}
		return branches;
	}

	public Batch fetchBatchDetails() throws SQLException, ClassNotFoundException {
		getConnection();
		Batch batch = new Batch();
		String sqlQuery = "SELECT ID,BATCH FROM BATCH WHERE BATCH_STATUS =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, 1);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			batch.setBatchId(resultSet.getInt(1));
			batch.setBatch(resultSet.getByte(2));
		}
		return batch;
	}

	public void addStudentDetails(StudentDetails studentDetails) throws SQLException, ClassNotFoundException {
		getConnection();

		String sqlQuery = "INSERT INTO student_details (user_id,qualification,department_id,branch_id,batch_id,z_mail_id,z_id) VALUES(?,?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, studentDetails.getStudentId());
		preparedStatement.setString(2, studentDetails.getStudentQualification());
		preparedStatement.setInt(3, studentDetails.getStudentDepartmentId());
		preparedStatement.setInt(4, studentDetails.getStudentBranchId());
		preparedStatement.setInt(5, studentDetails.getStudentBatchId());
		preparedStatement.setString(6, studentDetails.getStudentZmailId());
		preparedStatement.setString(7, studentDetails.getStudentZId());

		preparedStatement.executeUpdate();

	}

	

	

	
	

}

