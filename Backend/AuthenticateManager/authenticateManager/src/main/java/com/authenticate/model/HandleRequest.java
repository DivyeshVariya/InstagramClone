package com.authenticate.model;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("HandleRequests")
public class HandleRequest {

	@Id
	private String userName;
	private List<String> followers; 
	private List<String> following;
	private List<PendingRequest> requested;
	private List<PendingRequest> pending;
	public HandleRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HandleRequest(String userName, List<String> followers, List<String> following,
			List<PendingRequest> requested, List<PendingRequest> pending) {
		super();
		this.userName = userName;
		this.followers = followers;
		this.following = following;
		this.requested = requested;
		this.pending = pending;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getFollowers() {
		return followers;
	}
	public void setFollowers(List<String> followers) {
		this.followers = followers;
	}
	public List<String> getFollowing() {
		return following;
	}
	public void setFollowing(List<String> following) {
		this.following = following;
	}
	public List<PendingRequest> getRequested() {
		return requested;
	}
	public void setRequested(List<PendingRequest> requested) {
		this.requested = requested;
	}
	public List<PendingRequest> getPending() {
		return pending;
	}
	public void setPending(List<PendingRequest> pending) {
		this.pending = pending;
	}
	@Override
	public String toString() {
		return "HandleRequest [userName=" + userName + ", followers=" + followers + ", following=" + following
				+ ", requested=" + requested + ", pending=" + pending + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(followers, following, pending, requested, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HandleRequest other = (HandleRequest) obj;
		return Objects.equals(followers, other.followers) && Objects.equals(following, other.following)
				&& Objects.equals(pending, other.pending) && Objects.equals(requested, other.requested)
				&& Objects.equals(userName, other.userName);
	}
	
}
