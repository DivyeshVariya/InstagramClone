package com.authenticate.dto;

public class UserRegisterRequest {
	
	private String email;
	private String fullName;
	private String userName;
	private String password;
	
	
	public UserRegisterRequest() {
		super();
	}
	
	public UserRegisterRequest(String email, String fullName, String userName, String password) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRequest [email=" + email + ", fullName=" + fullName + ", userName=" + userName + ", password="
				+ password + "]";
	}
	
	

}
