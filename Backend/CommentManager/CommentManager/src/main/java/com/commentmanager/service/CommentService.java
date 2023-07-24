package com.commentmanager.service;

import com.commentmanager.dto.AllCommentsResponse;
import com.commentmanager.dto.CommentDelRequest;
import com.commentmanager.dto.CommentLikeRequest;
import com.commentmanager.dto.CommentRequest;
import com.commentmanager.dto.GetAllCommentRequest;
import com.commentmanager.dto.GetCommentResponse;
import com.commentmanager.dto.LikeResponse;
import com.commentmanager.dto.Response;

public interface CommentService {

	public Response postComment(CommentRequest commentRequest);

	public Response deleteComment(CommentDelRequest commentDelRequest);

	public AllCommentsResponse getAllComments(int postId);

	public GetCommentResponse getComment(CommentDelRequest commentDelRequest);

	public Response likeComment(CommentLikeRequest commentlikeRequest);

	public Response dislikeComment(CommentLikeRequest commentlikeRequest);

	public LikeResponse getLikes(int id);

}
