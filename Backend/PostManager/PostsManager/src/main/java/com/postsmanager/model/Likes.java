package com.postsmanager.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Likes")
public class Likes {
	@Id
	private int id;
	private int likes;
	private String userName;
	private List<String> likedBy;
	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Likes(int id, int likes, String userName, List<String> likedBy) {
		super();
		this.id = id;
		this.likes = likes;
		this.userName = userName;
		this.likedBy = likedBy;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getLikedBy() {
		return likedBy;
	}
	public void setLikedBy(List<String> likedBy) {
		this.likedBy = likedBy;
	}
	@Override
	public String toString() {
		return "Likes [id=" + id + ", likes=" + likes + ", userName=" + userName + ", likedBy=" + likedBy + "]";
	}
		
}
