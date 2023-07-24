package com.commentmanager.dto;

public class CommentDelRequest {

	private int id;
	private int postId;
	private String userName;
	public CommentDelRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentDelRequest(int id, int postId, String userName) {
		super();
		this.id = id;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CommentDelRequest [id=" + id + ", postId=" + postId + ", userName=" + userName + "]";
	}
	
	
}
