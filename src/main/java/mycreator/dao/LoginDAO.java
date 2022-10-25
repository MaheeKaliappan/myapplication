package mycreator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mycreator.model.StudentDetails;
import mycreator.model.User;

public class LoginDAO {
	
	static Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	private void getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mycreator?characterEncoding=latin1&useConfigs=maxPerformance", "root",
				"root");
	}

	
	public Integer fetchUserInformation(StudentDetails studentDetails) throws ClassNotFoundException, SQLException {
		getConnection();
		int result = 1;
		String sqlQuery = "SELECT  z_mail_id_password_reset_status from  student_details where z_mail_id=? and password=?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, studentDetails.getStudentZmailId());
		preparedStatement.setString(2, studentDetails.getStudentPassword());
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			result = resultSet.getInt(1);

		}
		
		return result;
		
	}
	public void changePassword(String password, String email) throws ClassNotFoundException, SQLException {
		getConnection();
		String sqlQuery ="UPDATE student_details SET z_mail_id_password_reset_status = ?,PASSWORD =? WHERE z_mail_id =? ";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1,1);
		preparedStatement.setString(2,password);
		preparedStatement.setString(3, email);
		

		preparedStatement.executeUpdate();
		
	}
	
	public Integer checkMailIdAndPassword(String password, String email) throws ClassNotFoundException, SQLException {
		getConnection();
		int result = 0;
		String sqlQuery = "SELECT  user_id  from  student_details where z_mail_id=? and password=?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			result = resultSet.getInt(1);
 
		}
		
		return result;
		
	}


	public User findUserStatusAndRole(Integer userId) throws SQLException, ClassNotFoundException {
		
		getConnection();
		
		User user = new User();
		String sqlQuery = "SELECT  status,role_id  from  user where id=?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1,userId);
		
		
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			user.setUserStatus(resultSet.getInt(1));
			user.setRole(resultSet.getInt(2));

		}
		return user;
	}

}
