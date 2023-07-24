package com.commentmanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Comments")
public class Comment {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	
	@Id
	private int id;
	private int postId;
	private String userName;
	private String commenterUserName;
	private String message;
	private Likes likes;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Comment(int id, int postId, String userName, String commenterUserName, String message, Likes likes) {
		super();
		this.id = id;
		this.postId = postId;
		this.userName = userName;
		this.commenterUserName = commenterUserName;
		this.message = message;
		this.likes = likes;
	}


	public Likes getLikes() {
		return likes;
	}


	public void setLikes(Likes likes) {
		this.likes = likes;
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
		return "Comment [id=" + id + ", postId=" + postId + ", userName=" + userName + ", commenterUserName="
				+ commenterUserName + ", message=" + message + ", likes=" + likes + "]";
	}
	

}
