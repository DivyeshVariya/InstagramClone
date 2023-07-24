package com.commentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commentmanager.dto.AllCommentsResponse;
import com.commentmanager.dto.CommentDelRequest;
import com.commentmanager.dto.CommentLikeRequest;
import com.commentmanager.dto.CommentRequest;
import com.commentmanager.dto.GetAllCommentRequest;
import com.commentmanager.dto.GetCommentResponse;
import com.commentmanager.dto.LikeResponse;
import com.commentmanager.dto.Response;
import com.commentmanager.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/postComment")
	public Response postComment(@RequestBody CommentRequest commentRequest)
	{
		System.out.println(commentRequest);
		return commentService.postComment(commentRequest);
	}
	
	@DeleteMapping("/deleteComment")
	public Response deleteComment(@RequestParam int id,@RequestParam int postId,@RequestParam String userName)
	{
		CommentDelRequest commentDelRequest=new CommentDelRequest(id,postId,userName);
		return commentService.deleteComment(commentDelRequest);
	}
	
	@GetMapping("/getAllComments")
	public AllCommentsResponse getAllComments(@RequestParam("postId") int postId)
	{
//		GetAllCommentRequest getAllCommentRequest=new GetAllCommentRequest(postId);
		return commentService.getAllComments(postId);
	}
	
	@GetMapping("/getComment")
	public GetCommentResponse getComment(@RequestBody CommentDelRequest CommentDelRequest)
	{
		return commentService.getComment(CommentDelRequest);
	}
	
	@PutMapping("/likeComment")
	public Response likeComment(@RequestBody CommentLikeRequest commentDelRequest)
	{
		return commentService.likeComment(commentDelRequest);
	}
	
	@PutMapping("/dislikeComment")
	public Response dislikeComment(@RequestBody CommentLikeRequest commentDelRequest)
	{
		return commentService.dislikeComment(commentDelRequest);
	}
	
	@GetMapping("/getLikes")
	public LikeResponse getLikes(@RequestParam int id)
	{
		return commentService.getLikes(id);
	}
}
