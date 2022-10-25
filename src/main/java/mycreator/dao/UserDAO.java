package mycreator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mycreator.model.Batch;
import mycreator.model.UserDetails;

public class UserDAO {
	static Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	private void getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mycreator?characterEncoding=latin1&useConfigs=maxPerformance", "root",
				"root");
	}

	public Integer fetchUserStatus(Integer userId) throws ClassNotFoundException, SQLException {
		getConnection();
		Integer result = null;
		String sqlQuery = "SELECT Status FROM user_details WHERE user_id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, userId);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			result =resultSet.getInt(1);
			
		}
		
		return result;
	}

	public void insertCheckInStatus(UserDetails userDetails) throws SQLException, ClassNotFoundException {
		getConnection();
		
		String sqlQuery = "INSERT INTO user_details (date,in_time,status,user_id) VALUES(?,?,?,?)";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, userDetails.getDate());
		preparedStatement.setString(2, userDetails.getInTime());
		preparedStatement.setInt(3,userDetails.getStatus());
		preparedStatement.setInt(4, userDetails.getUserId());
		

		preparedStatement.executeUpdate();
		
	}

	public void updateCheckOutStatus(UserDetails userDetails) throws ClassNotFoundException, SQLException {
		getConnection();
		String sqlQuery ="UPDATE user_details SET status = ?,out_time =? WHERE user_id =? ";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1,0);
		preparedStatement.setString(2,userDetails.getOutTime());
		preparedStatement.setInt(3,userDetails.getUserId());
		

		preparedStatement.executeUpdate();
		
		
	}

	public void updateLeave(UserDetails userDetails) throws ClassNotFoundException, SQLException {
		getConnection();
		String sqlQuery ="UPDATE user_details set user_leave=? WHERE user_id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,userDetails.getReasonForLeaave());
		preparedStatement.setInt(2,userDetails.getUserId());
		preparedStatement.executeUpdate();
		
	}
	//SELECT * FROM user_details where status =1 ORDER BY date desc limit 1;

	public void fetchPreviousRecords(int attribute) {
		// TODO Auto-generated method stub
		
	}

	public void insertIdidStatus(UserDetails userDetails) throws SQLException, ClassNotFoundException {
getConnection();
		
		String sqlQuery = "insert into user_did(date,did_time,i_did,user_id)value(?,?,?,?)";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, userDetails.getDate());
		preparedStatement.setString(2, userDetails.getInTime());
		preparedStatement.setString(3,userDetails.getiDid());
		preparedStatement.setInt(4, userDetails.getUserId());
		

		preparedStatement.executeUpdate();
		
		
	} 
}
