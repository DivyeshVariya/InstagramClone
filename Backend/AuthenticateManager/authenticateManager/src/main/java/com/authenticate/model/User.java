package com.authenticate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class User {
	@Id
	private String email;
	private String fullName;
	private String userName;
	private String password;
	private String mobileNo;
	private String Bio;
	
	
	public User() {
		super();
	}
	public User(String email, String fullName, String userName, String password, String mobileNo, String bio) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
		Bio = bio;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getBio() {
		return Bio;
	}
	public void setBio(String bio) {
		Bio = bio;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", Bio=" + Bio + "]";
	}
	
	
}
