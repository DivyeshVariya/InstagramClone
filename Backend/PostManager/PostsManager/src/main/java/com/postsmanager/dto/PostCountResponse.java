package com.postsmanager.dto;

public class PostCountResponse {

	private int statusCode;
	private String message;
	private int count;
	public PostCountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostCountResponse(int statusCode, String message, int count) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.count = count;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "PostCountResponse [statusCode=" + statusCode + ", message=" + message + ", count=" + count + "]";
	}
	
}
