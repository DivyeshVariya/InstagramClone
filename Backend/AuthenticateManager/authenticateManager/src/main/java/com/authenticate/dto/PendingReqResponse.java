package com.authenticate.dto;

import java.util.List;

import com.authenticate.model.PendingRequest;

public class PendingReqResponse {
	
	private int statusCode;
	private String message;
	private PendingRequest requests;
	public PendingReqResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PendingReqResponse [statusCode=" + statusCode + ", message=" + message + ", requests=" + requests + "]";
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
	public PendingRequest getRequests() {
		return requests;
	}
	public void setRequests(PendingRequest requests) {
		this.requests = requests;
	}
	public PendingReqResponse(int statusCode, String message, PendingRequest requests) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.requests = requests;
	}
	
	

}
