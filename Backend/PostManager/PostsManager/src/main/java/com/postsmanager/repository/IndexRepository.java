package com.postsmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.postsmanager.model.Index;

@Repository
public interface IndexRepository extends MongoRepository<Index, String>{

}
