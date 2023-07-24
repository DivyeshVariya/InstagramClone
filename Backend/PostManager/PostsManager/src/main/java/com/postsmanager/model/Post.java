package com.postsmanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Posts")
public class Post {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	
	@Id
	private int id;
	private String userName;
	private String title;
	private String location;
	private String image;
	private String hashtsges;
	private String caption;
	private Likes likes;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Post(String userName, String title, String location, String image, String hashtsges, String caption,
			Likes likes) {
		super();
		this.userName = userName;
		this.title = title;
		this.location = location;
		this.image = image;
		this.hashtsges = hashtsges;
		this.caption = caption;
		this.likes = likes;
	}


	public Post(int id, String userName, String title, String location, String image, String hashtsges, String caption,
			Likes likes) {
		super();
		this.id = id;
		this.userName = userName;
		this.title = title;
		this.location = location;
		this.image = image;
		this.hashtsges = hashtsges;
		this.caption = caption;
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
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getHashtsges() {
		return hashtsges;
	}

	public void setHashtsges(String hashtsges) {
		this.hashtsges = hashtsges;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", userName=" + userName + ", title=" + title + ", location=" + location + ", image="
				+ image + ", hashtsges=" + hashtsges + ", caption=" + caption + ", likes=" + likes + "]";
	}

	
}
