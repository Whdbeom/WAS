package edu.kh.test.user.model.vo;

public class UserDTO {

	
	
	
	public UserDTO(String userNo, String userId, String userName, String userAge) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String userNo;
	private String userId;
	private String userName;
	private String userAge;
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userAge=" + userAge
				+ "]";
	}

	
	
}
