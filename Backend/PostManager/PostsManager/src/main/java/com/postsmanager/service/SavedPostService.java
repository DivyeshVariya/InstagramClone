package com.postsmanager.service;

import com.postsmanager.dto.AllPostResponse;
import com.postsmanager.dto.Response;
import com.postsmanager.dto.SavedPostRequest;
import com.postsmanager.model.Post;

public interface SavedPostService {

	Response savePost(SavedPostRequest savedPostRequest);

	AllPostResponse getSavedPost(String userName);

	Response removeAllSavedPost(String userName);

	Response removeSavedPost(String userName, Post post);

}
