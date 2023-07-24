package com.authenticate.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("PendingRequests")
public class PendingRequest {

	@Id
	private String id;
	
	private String loggedUserName;
	private String requestedUserName;
	private String status;
	public PendingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PendingRequest(String loggedUserName, String requestedUserName, String status) {
		super();
		this.loggedUserName = loggedUserName;
		this.requestedUserName = requestedUserName;
		this.status = status;
	}
	public String getLoggedUserName() {
		return loggedUserName;
	}
	public void setLoggedUserName(String loggedUserName) {
		this.loggedUserName = loggedUserName;
	}
	public String getRequestedUserName() {
		return requestedUserName;
	}
	public void setRequestedUserName(String requestedUserName) {
		this.requestedUserName = requestedUserName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "PendingRequest [id=" + id + ", loggedUserName=" + loggedUserName + ", requestedUserName="
				+ requestedUserName + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, loggedUserName, requestedUserName, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PendingRequest other = (PendingRequest) obj;
		return Objects.equals(id, other.id) && Objects.equals(loggedUserName, other.loggedUserName)
				&& Objects.equals(requestedUserName, other.requestedUserName) && Objects.equals(status, other.status);
	}
	
		
}
