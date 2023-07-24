package com.commentmanager.dto;

public class GetAllCommentRequest {
	
	private int postId;
	private String userName;
	public GetAllCommentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetAllCommentRequest(int postId, String userName) {
		super();
		this.postId = postId;
		this.userName = userName;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "GetAllCommentRequest [postId=" + postId + ", userName=" + userName + "]";
	}
	
	

}
