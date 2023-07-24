package com.authenticate.dto;

import org.springframework.web.multipart.MultipartFile;

import com.authenticate.model.ProfilePic;
import com.authenticate.model.User;

public class UserPicResponse {

	private int statusCode;
	private String message;
	private ProfilePic pic;
	public UserPicResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPicResponse(int statusCode, String message, ProfilePic pic) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.pic = pic;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ProfilePic getPic() {
		return pic;
	}
	public void setPic(ProfilePic pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "UserPicResponse [statusCode=" + statusCode + ", message=" + message + ", pic=" + pic + "]";
	}	
	
	
}
