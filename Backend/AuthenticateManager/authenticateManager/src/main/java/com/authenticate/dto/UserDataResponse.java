package com.authenticate.dto;

import com.authenticate.model.User;

public class UserDataResponse {

	private int statusCode;
	private String message;
	private User user;
	public UserDataResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDataResponse(int statusCode, String message, User user) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.user = user;
	}

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserDataResponse [statusCode=" + statusCode + ", message=" + message + ", user=" + user + "]";
	}
	
	
}
