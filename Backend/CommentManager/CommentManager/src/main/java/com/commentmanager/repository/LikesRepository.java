package com.commentmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.commentmanager.model.Likes;

@Repository
public interface LikesRepository extends MongoRepository<Likes, Integer>{

}
