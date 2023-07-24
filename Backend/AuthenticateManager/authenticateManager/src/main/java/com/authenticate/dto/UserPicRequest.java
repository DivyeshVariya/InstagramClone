package com.authenticate.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserPicRequest {

	private String userName;
	private MultipartFile picture;
	public UserPicRequest(String userName, MultipartFile picture) {
		super();
		this.userName = userName;
		this.picture = picture;
	}
	public UserPicRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "UserPicRequest [userName=" + userName + ", picture=" + picture + "]";
	}
	
	
}
