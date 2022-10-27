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

import mycreator.model.Batch;
import mycreator.model.Branch;
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

		String sqlQuery = "select department.*, concat(u1.first_name ,' ', u1.last_name) as added_user_name, concat(u2.first_name,' ', u2.last_name) as modified_user_name from department inner join user u1 on department.added_on = u1.id LEFT JOIN User u2 on department.modified_on = u2.id where department.status=1";
		preparedStatement = connection.prepareStatement(sqlQuery);
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
		getConnection();
		String sqlQuery = "Update department set status =0 where id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setInt(1, departmentId);
		int result = preparedStatement.executeUpdate();
		
		
	}
	
	public void updateDepartmentDetails(Integer departmentId, String departmentName) throws SQLException, ClassNotFoundException 
	{
		getConnection();
		String sqlQuery = "Update department set name  = ? , modified_on = ? , modified_by =  ?  where id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, departmentName);
		preparedStatement.setInt(2, 2);
		preparedStatement.setString(3, sDate.format(new Date()));
		preparedStatement.setInt(4, departmentId);
		preparedStatement.executeUpdate();
	}

	public List<Branch> fetchListOfBranchs() throws SQLException, ClassNotFoundException {
		List<Branch> branchs = new ArrayList<>();
		getConnection();

		String sqlQuery = "select branch.*, concat(u1.first_name ,' ', u1.last_name) as added_user_name, concat(u2.first_name,' ', u2.last_name) as modified_user_name from branch inner join user u1 on branch.added_on = u1.id LEFT JOIN User u2 on branch.modified_on = u2.id where branch.status=1";
		preparedStatement = connection.prepareStatement(sqlQuery);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Branch branch = new Branch();
			branch.setBranchId(resultSet.getInt( resultSet.findColumn("id")));
			branch.setBranchArea(resultSet.getString(resultSet.findColumn("area")));
			branch.setBranchDistrict(resultSet.getString(resultSet.findColumn("district")));
			branch.setBranchPincode(resultSet.getInt( resultSet.findColumn("pincode")));
			branch.setBranchState(resultSet.getString(resultSet.findColumn("state")));
			branch.setBranchAddedBy(resultSet.getString(resultSet.findColumn("added_by")));
			branch.setBranchmodifiedBy(resultSet.getString( resultSet.findColumn("modified_by")));
			branch.setBranchAddedOn(resultSet.getString( resultSet.findColumn("added_user_name")));
			branch.setBranchModifiedOn(resultSet.getString( resultSet.findColumn("modified_user_name")));
			
			branchs.add(branch);
			
			
		}
		
		
		return branchs;
		
	}

	public void addBranch(Branch branch) throws SQLException, ClassNotFoundException {
		getConnection();						
		String sqlQuery = "INSERT INTO Branch (area,district,state,pincode,ADDED_ON,ADDED_BY) VALUES(?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, branch.getBranchArea());
		preparedStatement.setString(2, branch.getBranchDistrict());
		preparedStatement.setString(3, branch.getBranchState());
		preparedStatement.setInt(4, branch.getBranchPincode());
		preparedStatement.setInt(5, 2);
		preparedStatement.setString(6, sDate.format(new Date()));
		

		preparedStatement.executeUpdate();
		
		
	}

	public void deleteTheBranch(Integer branchId) throws SQLException, ClassNotFoundException {
		getConnection();
		String sqlQuery = "Update branch set status =0 where id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setInt(1, branchId);
		preparedStatement.executeUpdate();
		
	}

	public Branch fetchBranchDetails(Integer branchtId) throws SQLException, ClassNotFoundException {
		Branch branch = new Branch();
		getConnection();
		String sqlQuery = "select branch.*, concat(u1.first_name ,' ', u1.last_name) as added_user_name, concat(u2.first_name,' ', u2.last_name) as modified_user_name from branch inner join user u1 on branch.added_on = u1.id LEFT JOIN User u2 on branch.modified_on = u2.id where branch.status=1 and branch.id = ?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, branchtId);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			
			branch.setBranchId(resultSet.getInt( resultSet.findColumn("id")));
			branch.setBranchArea(resultSet.getString(resultSet.findColumn("area")));
			branch.setBranchDistrict(resultSet.getString(resultSet.findColumn("district")));
			branch.setBranchState(resultSet.getString(resultSet.findColumn("state")));
			branch.setBranchPincode(resultSet.getInt(resultSet.findColumn("pincode")));
			branch.setBranchAddedBy(resultSet.getString( resultSet.findColumn("added_by")));
			branch.setBranchmodifiedBy(resultSet.getString( resultSet.findColumn("modified_by")));
			branch.setBranchAddedOn(resultSet.getString( resultSet.findColumn("added_user_name")));
			branch.setBranchModifiedOn(resultSet.getString( resultSet.findColumn("modified_user_name")));
			
			
		}
		return branch;
	}

	public void updateBranchDetails(Branch branch) throws ClassNotFoundException, SQLException {
		getConnection();
		String sqlQuery = "Update branch set area = ? ,district=?,state=?,pincode=?, modified_on = ? , modified_by =  ?  where id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, branch.getBranchArea());
		preparedStatement.setString(2, branch.getBranchDistrict());
		preparedStatement.setString(3, branch.getBranchState());
		preparedStatement.setInt(4, branch.getBranchPincode());
		preparedStatement.setInt(5, 2);
		preparedStatement.setString(6, sDate.format(new Date()));
		preparedStatement.setInt(7, branch.getBranchId());
		preparedStatement.executeUpdate();
		
	}

	public List<Batch> fetchListOfBatches() throws SQLException, ClassNotFoundException {
		List<Batch> batchs = new ArrayList<>();
		getConnection();

		String sqlQuery = "select batch.*, concat(u1.first_name ,' ', u1.last_name) as added_user_name, concat(u2.first_name,' ', u2.last_name) as modified_user_name from batch inner join user u1 on batch.added_on = u1.id LEFT JOIN User u2 on batch.modified_on = u2.id where batch.batch_status=1";
		preparedStatement = connection.prepareStatement(sqlQuery);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Batch batch = new Batch();
			batch.setBatchId(resultSet.getInt( resultSet.findColumn("id")));
			batch.setBatchStartDate(resultSet.getString(resultSet.findColumn("start_date")));
			batch.setBatchEndDate(resultSet.getString(resultSet.findColumn("end_date")));
			batch.setBatch(resultSet.getByte( resultSet.findColumn("batch")));
			
			batch.setBatchAddedBy(resultSet.getString(resultSet.findColumn("added_by")));
			batch.setBatchModifiedBy(resultSet.getString( resultSet.findColumn("modified_by")));
			batch.setBatchAddedOn(resultSet.getString( resultSet.findColumn("added_user_name")));
			batch.setBatchModifiedOn(resultSet.getString( resultSet.findColumn("modified_user_name")));
			
			batchs.add(batch);
			
			
		}
		
		
		return batchs;
	}

	public void addBatch(Batch batch) throws SQLException, ClassNotFoundException {
		getConnection();						
		String sqlQuery = "INSERT INTO batch (start_date,end_date,batch,mode,ADDED_ON,ADDED_BY) VALUES(?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, batch.getBatchStartDate());
		preparedStatement.setString(2, batch.getBatchEndDate());
		preparedStatement.setInt(3, batch.getBatch());
		preparedStatement.setString(4, batch.getBatchMode());
		preparedStatement.setInt(5, 2);
		preparedStatement.setString(6, sDate.format(new Date()));
		System.out.println("b"+batch.getBatch());
		System.out.println("m"+batch.getBatchMode());

		preparedStatement.executeUpdate();
		
	}

	public void deleteTheBatch(Integer batchperiodId) throws ClassNotFoundException, SQLException {
		getConnection();
		String sqlQuery = "Update batch set batch_status =0 where id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setInt(1, batchperiodId);
		preparedStatement.executeUpdate();
		
	}

	public Batch fetchBatchDetails(Integer batchperiodId) throws ClassNotFoundException, SQLException {
		Batch batch = new Batch();
		getConnection();
		String sqlQuery = "select batch.*, concat(u1.first_name ,' ', u1.last_name) as added_user_name, concat(u2.first_name,' ', u2.last_name) as modified_user_name from batch inner join user u1 on batch.added_on = u1.id LEFT JOIN User u2 on batch.modified_on = u2.id where batch.batch_status=1 and batch.id = ?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, batchperiodId);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			
			batch.setBatchId(resultSet.getInt( resultSet.findColumn("id")));
			batch.setBatchStartDate(resultSet.getString(resultSet.findColumn("start_date")));
			batch.setBatchEndDate(resultSet.getString(resultSet.findColumn("end_date")));
			batch.setBatch(resultSet.getByte(resultSet.findColumn("batch")));
			batch.setBatchMode(resultSet.getString(resultSet.findColumn("mode")));
			batch.setBatchAddedBy(resultSet.getString( resultSet.findColumn("added_by")));
			batch.setBatchModifiedBy(resultSet.getString( resultSet.findColumn("modified_by")));
			batch.setBatchAddedOn(resultSet.getString( resultSet.findColumn("added_user_name")));
			batch.setBatchModifiedOn(resultSet.getString( resultSet.findColumn("modified_user_name")));
			
			
		}
		return batch;
	}

	public void updateBatchDetails(Batch batch) throws ClassNotFoundException, SQLException {
		getConnection();
		String sqlQuery = "Update batch set start_date = ? ,end_date=?,batch=?,mode=?, modified_on = ? , modified_by =  ?  where id =?";
		preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, batch.getBatchStartDate());
		preparedStatement.setString(2, batch.getBatchEndDate());
		preparedStatement.setByte(3, batch.getBatch());
		preparedStatement.setString(4, batch.getBatchMode());
		preparedStatement.setInt(5, 2);
		preparedStatement.setString(6, sDate.format(new Date()));
		preparedStatement.setInt(7, batch.getBatchId());
		preparedStatement.executeUpdate();
		
	}

}
