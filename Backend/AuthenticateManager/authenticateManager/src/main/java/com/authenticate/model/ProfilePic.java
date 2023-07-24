package com.authenticate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ProfilePic")
public class ProfilePic {
	@Id
	private String userName;
	private String picture;
	public ProfilePic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfilePic(String userName, String picture) {
		super();
		this.userName = userName;
		this.picture = picture;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "ProfilePic [userName=" + userName + ", picture=" + picture + "]";
	}
	
	

}
