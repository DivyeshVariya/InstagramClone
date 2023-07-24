package com.postsmanager.dto;

import java.util.List;

import com.postsmanager.model.Post;

public class AllPostResponse {

	private int statusCode;
	private String message;
	private List<Post> post;
	public AllPostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllPostResponse(int statusCode, String message, List<Post> post) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.post = post;
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
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "AllPostResponse [statusCode=" + statusCode + ", message=" + message + ", post=" + post + "]";
	}
	
}
