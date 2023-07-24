package com.commentmanager.dto;

import java.util.List;

import com.commentmanager.model.Comment;

public class AllCommentsResponse {

	private int statusCode;
	private String message;
	private List<Comment> comment;
	public AllCommentsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllCommentsResponse(int statusCode, String message, List<Comment> comment) {
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
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "AllCommentsResponse [statusCode=" + statusCode + ", message=" + message + ", comment=" + comment + "]";
	}
	
	
}
