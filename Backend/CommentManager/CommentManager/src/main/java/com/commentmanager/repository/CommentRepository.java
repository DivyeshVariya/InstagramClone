package com.commentmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.commentmanager.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Integer>{

	public Optional<Comment> findByIdAndPostIdAndUserName(int id,int postId,String userName);
	public List<Comment> findByPostIdAndUserName(int postId,String userName);
	public List<Comment> findByPostId(int postId);
}
