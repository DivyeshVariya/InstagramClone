package com.postsmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.postsmanager.model.Post;

@Repository
public interface PostsRepository extends MongoRepository<Post, Integer>{

	public Optional<Post> findByUserNameAndId(String userName,int id);
	
	public List<Post> findByUserName(String userName);
}
