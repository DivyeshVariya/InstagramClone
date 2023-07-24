package com.postsmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.postsmanager.model.Likes;

@Repository
public interface LikesRepository extends MongoRepository<Likes, Long>{

}
