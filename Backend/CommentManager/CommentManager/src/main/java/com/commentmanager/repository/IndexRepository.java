package com.commentmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.commentmanager.model.Index;
@Repository
public interface IndexRepository extends MongoRepository<Index, String>{

}
