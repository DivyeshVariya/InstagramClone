package com.postsmanager.dto;

import java.io.Serializable;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

public class PostDataRequest implements Serializable {

	private String userName;
	private String title;
	private String location;
	private MultipartFile image;
	private String hashtsges;
	private String caption;
	public PostDataRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDataRequest(String userName, String title, String location, MultipartFile image, String hashtsges,
			String caption) {
		super();
		this.userName = userName;
		this.title = title;
		this.location = location;
		this.image = image;
		this.hashtsges = hashtsges;
		this.caption = caption;
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
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
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
		return "PostDataRequest [userName=" + userName + ", title=" + title + ", location=" + location + ", image="
				+ image + ", hashtsges=" + hashtsges + ", caption=" + caption + "]";
	} 
	
	
	
}
