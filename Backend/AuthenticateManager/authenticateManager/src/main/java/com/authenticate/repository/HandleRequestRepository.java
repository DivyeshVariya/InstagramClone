package com.authenticate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.authenticate.model.HandleRequest;

@Repository
public interface HandleRequestRepository extends MongoRepository<HandleRequest, String>{

}
