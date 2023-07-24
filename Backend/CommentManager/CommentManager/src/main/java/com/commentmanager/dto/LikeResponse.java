package com.commentmanager.dto;

import com.commentmanager.model.Likes;

public class LikeResponse {

	private int statusCode;
	private String message;
	private Likes likes;
	public LikeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LikeResponse(int statusCode, String message, Likes likes) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.likes = likes;
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
	public Likes getLikes() {
		return likes;
	}
	public void setLikes(Likes likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "LikeResponse [statusCode=" + statusCode + ", message=" + message + ", likes=" + likes + "]";
	}
		
	
}
