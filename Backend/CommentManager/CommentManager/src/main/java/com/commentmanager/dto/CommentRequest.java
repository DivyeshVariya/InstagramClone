package com.commentmanager.dto;

public class CommentRequest {
	
	private int postId;
	private String userName;
	private String commenterUserName;
	private String message;
	public CommentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentRequest(int postId, String userName, String commenterUserName, String message) {
		super();
		this.postId = postId;
		this.userName = userName;
		this.commenterUserName = commenterUserName;
		this.message = message;
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
	public String getCommenterUserName() {
		return commenterUserName;
	}
	public void setCommenterUserName(String commenterUserName) {
		this.commenterUserName = commenterUserName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "CommentRequest [postId=" + postId + ", userName=" + userName + ", commenterUserName="
				+ commenterUserName + ", message=" + message + "]";
	}
	
	

}
