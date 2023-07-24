package com.commentmanager.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.commentmanager.dto.AllCommentsResponse;
import com.commentmanager.dto.CommentDelRequest;
import com.commentmanager.dto.CommentLikeRequest;
import com.commentmanager.dto.CommentRequest;
import com.commentmanager.dto.GetAllCommentRequest;
import com.commentmanager.dto.GetCommentResponse;
import com.commentmanager.dto.LikeResponse;
import com.commentmanager.dto.Response;
import com.commentmanager.model.Comment;
import com.commentmanager.model.Index;
import com.commentmanager.model.Likes;
import com.commentmanager.repository.CommentRepository;
import com.commentmanager.repository.IndexRepository;
import com.commentmanager.repository.LikesRepository;
import com.commentmanager.service.AutoIncreamentService;
import com.commentmanager.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	LikesRepository likesRepository;
	
	@Autowired
	AutoIncreamentService autoIncreamentService;
	
	@Override
	public Response postComment(CommentRequest commentRequest) {
		// TODO Auto-generated method stub
		int id=autoIncreamentService.generateSequence(Comment.SEQUENCE_NAME);
		List<String> likedby=new ArrayList<>();
		Likes like1=new Likes(id,commentRequest.getPostId(),0,commentRequest.getUserName(),likedby);
		likesRepository.save(like1);
		Comment comment=commentRepository.save(new Comment(id,commentRequest.getPostId(),commentRequest.getUserName(),commentRequest.getCommenterUserName(),commentRequest.getMessage(),like1));
	    if(comment.equals(null))
	    {
	    	Response response=new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to post comment....");
	    	return response;
	    }
	    Response response=new Response(HttpStatus.OK.value(),"Comment posted successfully....");
    	return response;
	}

	@Override
	public Response deleteComment(CommentDelRequest commentDelRequest) {
		// TODO Auto-generated method stub
		Optional<Comment> comment=commentRepository.findByIdAndPostIdAndUserName(commentDelRequest.getId(),commentDelRequest.getPostId(),commentDelRequest.getUserName());
		if(comment.isEmpty())
		{
			Response response=new Response(HttpStatus.NOT_FOUND.value(),"Faild to delete comment....");
	    	return response;
	    }
		commentRepository.deleteById(commentDelRequest.getId());
	    Response response=new Response(HttpStatus.OK.value(),"Comment deleted successfully....");
    	return response;
	}

	@Override
	public AllCommentsResponse getAllComments(int postId) {
		// TODO Auto-generated method stub
		List<Comment> comments=commentRepository.findByPostId(postId);
		if(comments.isEmpty())
		{
			AllCommentsResponse response=new AllCommentsResponse(HttpStatus.NOT_FOUND.value(),"Faild to fetch comments....",null);
	    	return response;
	    }
		AllCommentsResponse response=new AllCommentsResponse(HttpStatus.OK.value(),"Comments fetched successfully....",comments);
    	return response;
	}

	@Override
	public GetCommentResponse getComment(CommentDelRequest commentDelRequest) {
		// TODO Auto-generated method stub
		Optional<Comment> comment=commentRepository.findByIdAndPostIdAndUserName(commentDelRequest.getId(),commentDelRequest.getPostId(),commentDelRequest.getUserName());
		if(comment.isEmpty())
		{
			GetCommentResponse response=new GetCommentResponse(HttpStatus.NOT_FOUND.value(),"Faild to fetch comment....",null);
	    	return response;
	    }
		GetCommentResponse response=new GetCommentResponse(HttpStatus.OK.value(),"Comment fetched successfully....",comment.get());
    	return response;
	}

	@Override
	public Response likeComment(CommentLikeRequest commentlikeRequest) {
		// TODO Auto-generated method stub
		System.out.println(commentlikeRequest);
		Optional<Comment> comment=commentRepository.findByIdAndPostIdAndUserName(commentlikeRequest.getId(),commentlikeRequest.getPostId(),commentlikeRequest.getUserName());
		System.out.println(comment);
		if(comment.isEmpty())
		{
			Response response=new Response(HttpStatus.NOT_FOUND.value(),"Faild to fetch comment....");
	    	return response;
	    }
		Optional<Likes> likes=likesRepository.findById(comment.get().getLikes().getId());
		if(likes.isEmpty())
		{
			Response response=new Response(HttpStatus.NOT_FOUND.value(),"Faild to fetch like....");
	    	return response;
	    }
		likes.get().getLikedBy().add(commentlikeRequest.getLikedBy());
		likes.get().setLikedBy(likes.get().getLikedBy());
		likes.get().setLikes(likes.get().getLikes()+1);
		comment.get().setLikes(likes.get());;
		commentRepository.save(comment.get());
		likesRepository.save(likes.get());
		Response response=new Response(HttpStatus.OK.value(),"Comment liked successfully....");
    	return response;
	}

	@Override
	public Response dislikeComment(CommentLikeRequest commentlikeRequest) {
		// TODO Auto-generated method stub
		Optional<Comment> comment=commentRepository.findByIdAndPostIdAndUserName(commentlikeRequest.getId(),commentlikeRequest.getPostId(),commentlikeRequest.getUserName());
		if(comment.isEmpty())
		{
			Response response=new Response(HttpStatus.NOT_FOUND.value(),"Faild to fetch comment....");
	    	return response;
	    }
		Optional<Likes> likes=likesRepository.findById(comment.get().getLikes().getId());
		if(likes.isEmpty())
		{
			Response response=new Response(HttpStatus.NOT_FOUND.value(),"Faild to fetch like....");
	    	return response;
	    }
		likes.get().getLikedBy().remove(commentlikeRequest.getLikedBy());
		likes.get().setLikedBy(likes.get().getLikedBy());
		likes.get().setLikes(likes.get().getLikes()-1);
		comment.get().setLikes(likes.get());;
		commentRepository.save(comment.get());
		likesRepository.save(likes.get());
		Response response=new Response(HttpStatus.OK.value(),"Comment disliked successfully....");
    	return response;
	}

	@Override
	public LikeResponse getLikes(int id) {
		// TODO Auto-generated method stub
		Optional<Likes> likes=likesRepository.findById(id);
		if(likes.isEmpty())
		{
			LikeResponse likeResponse=new LikeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed to fetch likes...",null);
			return likeResponse;
		}
		else
		{
			LikeResponse likeResponse=new LikeResponse(HttpStatus.OK.value(),"Likes fetched successfully...",likes.get());
			return likeResponse;
		}
	}

}
