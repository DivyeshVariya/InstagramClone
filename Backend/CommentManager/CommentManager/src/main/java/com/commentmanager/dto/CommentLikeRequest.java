package com.commentmanager.dto;

public class CommentLikeRequest {

	private int id;
	private int postId;
	private String userName;
	private String likedBy;
	public CommentLikeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentLikeRequest(int id, int postId, String userName, String likedBy) {
		super();
		this.id = id;
		this.postId = postId;
		this.userName = userName;
		this.likedBy = likedBy;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getLikedBy() {
		return likedBy;
	}
	public void setLikedBy(String likedBy) {
		this.likedBy = likedBy;
	}
	@Override
	public String toString() {
		return "CommentLikeRequest [id=" + id + ", postId=" + postId + ", userName=" + userName + ", likedBy=" + likedBy
				+ "]";
	}
	
	
}
