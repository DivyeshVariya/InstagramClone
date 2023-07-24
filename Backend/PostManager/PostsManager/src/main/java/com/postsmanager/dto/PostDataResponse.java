package com.postsmanager.dto;

import com.postsmanager.model.Post;

public class PostDataResponse {

	private int statusCode;
	private String message;
	private Post post;
	public PostDataResponse(int statusCode, String message, Post post) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.post = post;
	}
	public PostDataResponse() {
		super();
		// TODO Auto-generated constructor stub
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
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "PostDataResponse [statusCode=" + statusCode + ", message=" + message + ", post=" + post + "]";
	}
	
}
