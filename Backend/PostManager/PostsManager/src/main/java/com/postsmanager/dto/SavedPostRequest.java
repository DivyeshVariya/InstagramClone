package com.postsmanager.dto;

import java.util.List;

import com.postsmanager.model.Post;

public class SavedPostRequest {

	private String userName;
	private Post posts;
	public SavedPostRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SavedPostRequest(String userName, Post posts) {
		super();
		this.userName = userName;
		this.posts = posts;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Post getPosts() {
		return posts;
	}
	public void setPosts(Post posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "SavedPostRequest [userName=" + userName + ", posts=" + posts + "]";
	}
	
	
	
}
