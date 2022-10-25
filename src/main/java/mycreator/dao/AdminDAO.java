package mycreator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mycreator.model.Department;

public class AdminDAO {
	static Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	SimpleDateFormat sDate = new SimpleDateFormat("dd/MM/yyyy");

	private void getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mycreator?characterEncoding=latin1&useConfigs=maxPerformance", "root",
				"root");
	}

	public void addDepartmentDetails(String departmentName) throws SQLException, ClassNotFoundException {
		getConnection();						
		String sqlQuery = "INSERT INTO DEPARTMENT (NAME,ADDED_ON,ADDED_BY) VALUES(?,?,?)";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, departmentName);
		
		
		preparedStatement.setString(3, sDate.format(new Date()));
		preparedStatement.setInt(2, 2);
		

		preparedStatement.executeUpdate();
		
		
		
	}
	
	public Department fetchDepartmentDetails(Integer departmentId)  throws SQLException, ClassNotFoundException {
		Department department = new Department();
		getConnection();
		String departmentQuery = "select department.*, concat(u1.first_name ,' ', u1.last_name) as added_user_name, concat(u2.first_name,' ', u2.last_name) as modified_user_name from department inner join user u1 on department.added_on = u1.id LEFT JOIN User u2 on department.modified_on = u2.id where department.status=1 and department.id = ?";
		preparedStatement = connection.prepareStatement(departmentQuery);
		preparedStatement.setInt(1, departmentId);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			
			department.setDepartmentId(resultSet.getInt( resultSet.findColumn("id")));
			department.setDepartmentName(resultSet.getString(resultSet.findColumn("name")));
			department.setDepartmentAddedBy(resultSet.getString( resultSet.findColumn("added_by")));
			department.setDepartmentModifiedBy(resultSet.getString( resultSet.findColumn("modified_by")));
			department.setDepartmentAddedOn(resultSet.getString( resultSet.findColumn("added_user_name")));
			department.setDepartmentModifiedOn(resultSet.getString( resultSet.findColumn("modified_user_name")));
			
			
		}
		return department;
	}
	
	public List<Department> fetchListofDepartments()  throws SQLException, ClassNotFoundException 
	{
		List<Department> departments = new ArrayList<Department>();
		getConnection();

		String departmentQuery = "select department.*, concat(u1.first_name ,' ', u1.last_name) as added_user_name, concat(u2.first_name,' ', u2.last_name) as modified_user_name from department inner join user u1 on department.added_on = u1.id LEFT JOIN User u2 on department.modified_on = u2.id where department.status=1";
		preparedStatement = connection.prepareStatement(departmentQuery);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Department department = new Department();
			department.setDepartmentId(resultSet.getInt( resultSet.findColumn("id")));
			department.setDepartmentName(resultSet.getString(resultSet.findColumn("name")));
			department.setDepartmentAddedBy(resultSet.getString( resultSet.findColumn("added_by")));
			department.setDepartmentModifiedBy(resultSet.getString( resultSet.findColumn("modified_by")));
			department.setDepartmentAddedOn(resultSet.getString( resultSet.findColumn("added_user_name")));
			department.setDepartmentModifiedOn(resultSet.getString( resultSet.findColumn("modified_user_name")));
			
			departments.add(department);

		}
		
		
		return departments;
	}
	public void deleteTheDepartment(Integer departmentId)throws SQLException, ClassNotFoundException
	{
		String sqlQuery = "Update department set status =0 where id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setInt(1, departmentId);
		int result = preparedStatement.executeUpdate();
		
		
	}
	
	public void updateDepartmentDetails(Integer departmentId, String departmentName) throws SQLException, ClassNotFoundException 
	{
		String sqlQuery = "Update department set name  = ? , modified_on = ? , modified_by =  ?  where id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, departmentName);
		preparedStatement.setInt(2, 2);
		preparedStatement.setString(3, sDate.format(new Date()));
		preparedStatement.setInt(4, departmentId);
		
		
		int result = preparedStatement.executeUpdate();
	}

}
