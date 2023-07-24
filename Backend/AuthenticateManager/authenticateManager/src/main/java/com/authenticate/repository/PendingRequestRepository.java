package com.authenticate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.authenticate.model.PendingRequest;

@Repository
public interface PendingRequestRepository extends MongoRepository<PendingRequest, String>{

	public Optional<PendingRequest> findByLoggedUserNameAndRequestedUserName(String userName,String requestedUserName);
}
