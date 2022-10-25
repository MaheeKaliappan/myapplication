package mycreator.model;

public class User {
	
	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String userPersonalmobileNumber;
	private String userPersonalMailId;
	private Integer userStatus;
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	private Integer role;
	
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserPersonalmobileNumber() {
		return userPersonalmobileNumber;
	}
	public void setUserPersonalmobileNumber(String userPersonalmobileNumber) {
		this.userPersonalmobileNumber = userPersonalmobileNumber;
	}
	public String getUserPersonalMailId() {
		return userPersonalMailId;
	}
	public void setUserPersonalMailId(String userPersonalMailId) {
		this.userPersonalMailId = userPersonalMailId;
	}
	

}
