package com.postsmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.postsmanager.model.SavedPost;

@Repository
public interface SavedPostRepository extends MongoRepository<SavedPost, String>{

}
