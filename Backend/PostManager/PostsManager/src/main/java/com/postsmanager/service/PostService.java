package com.postsmanager.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.postsmanager.dto.AllPostResponse;
import com.postsmanager.dto.PostCountResponse;
import com.postsmanager.dto.PostDataRequest;
import com.postsmanager.dto.PostDataResponse;
import com.postsmanager.dto.PostLikeRequest;
import com.postsmanager.dto.PostLikeResponse;
import com.postsmanager.dto.Request;
import com.postsmanager.dto.Response;


public interface PostService {

	Response addPost(PostDataRequest postDataRequest) throws IOException;

	Response deletePost(Request request);

	AllPostResponse getAllPost(String userName);

	PostDataResponse getPost(Request request);

	PostLikeResponse likePost(PostLikeRequest request);

	PostLikeResponse dislikePost(PostLikeRequest request);

	AllPostResponse getAllPostForAll();

	PostLikeResponse getListOfLikesForPost(String postUser, int id);

	PostCountResponse getPostCount(String userName);

	
}
