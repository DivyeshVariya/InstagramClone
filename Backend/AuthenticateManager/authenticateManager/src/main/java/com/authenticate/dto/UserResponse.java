package com.authenticate.dto;

public class UserResponse {

	private int statusCode;
	private String message;
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
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
	@Override
	public String toString() {
		return "UserResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
}
