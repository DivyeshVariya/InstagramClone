package com.postsmanager.dto;

import com.postsmanager.model.Likes;
import com.postsmanager.model.Post;

public class PostLikeResponse {

	private int statusCode;
	private String message;
	private Likes likes;
	public PostLikeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostLikeResponse(int statusCode, String message, Likes likes) {
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
		return "PostLikeResponse [statusCode=" + statusCode + ", message=" + message + ", likes=" + likes + "]";
	}
	
	
}
