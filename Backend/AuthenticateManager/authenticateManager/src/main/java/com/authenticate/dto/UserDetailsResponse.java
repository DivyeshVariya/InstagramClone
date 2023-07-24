package com.authenticate.dto;

import com.authenticate.model.HandleRequest;

public class UserDetailsResponse {

	private int statusCode;
	private String message;
	private HandleRequest details;
	public UserDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetailsResponse(int statusCode, String message, HandleRequest details) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.details = details;
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
	public HandleRequest getDetails() {
		return details;
	}
	public void setDetails(HandleRequest details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "UserDetailsResponse [statusCode=" + statusCode + ", message=" + message + ", details=" + details + "]";
	}
	
	
}
