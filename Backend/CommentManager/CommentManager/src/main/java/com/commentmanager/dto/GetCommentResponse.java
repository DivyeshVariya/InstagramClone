package com.commentmanager.dto;


import com.commentmanager.model.Comment;

public class GetCommentResponse {
	
	private int statusCode;
	private String message;
	private Comment comment;
	public GetCommentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetCommentResponse(int statusCode, String message, Comment comment) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.comment = comment;
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
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "GetCommentResponse [statusCode=" + statusCode + ", message=" + message + ", comment=" + comment + "]";
	}
	
	

}
