package mycreator.model;

public class UserDetails {
	private Integer userId;
	private String 	date;
	private String time;
	private String iDid;
	private String inTime;
	private String outTime;
	private Integer status;
	private String reasonForLeave;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getiDid() {
		return iDid;
	}
	public void setiDid(String iDid) {
		this.iDid = iDid;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReasonForLeaave() {
		return reasonForLeave;
	}
	public void setReasonForLeaave(String reasonForLeave) {
		this.reasonForLeave = reasonForLeave;
	}
	
	

}
