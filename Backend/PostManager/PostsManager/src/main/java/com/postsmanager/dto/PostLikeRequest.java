package com.postsmanager.dto;

public class PostLikeRequest {

	private String userName;
	private int id;
	private String likedBy;
	public PostLikeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostLikeRequest(String userName, int id, String likedBy) {
		super();
		this.userName = userName;
		this.id = id;
		this.likedBy = likedBy;
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
	public String getLikedBy() {
		return likedBy;
	}
	public void setLikedBy(String likedBy) {
		this.likedBy = likedBy;
	}
	@Override
	public String toString() {
		return "PostLikeRequest [userName=" + userName + ", id=" + id + ", likedBy=" + likedBy + "]";
	}
	
	
}
