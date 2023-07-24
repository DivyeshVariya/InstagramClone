package com.authenticate.service;

import com.authenticate.dto.PendingReqResponse;
import com.authenticate.dto.UserDetailsResponse;
import com.authenticate.dto.UserResponse;
import com.authenticate.model.HandleRequest;
import com.authenticate.model.PendingRequest;

public interface RequestHandlingService {

	UserResponse sendRequest(PendingRequest pendingRequest);

	PendingReqResponse getPendingRequests(String loggedInUserName,String requestedUserName);

	UserDetailsResponse getRequestDetails(String loggedInUserName);

	UserResponse add(HandleRequest request);

	UserResponse confirmRequest(PendingRequest pendingRequest);


}
