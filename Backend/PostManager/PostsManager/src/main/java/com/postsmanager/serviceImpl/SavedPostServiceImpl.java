package com.postsmanager.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.postsmanager.dto.AllPostResponse;
import com.postsmanager.dto.Response;
import com.postsmanager.dto.SavedPostRequest;
import com.postsmanager.model.Post;
import com.postsmanager.model.SavedPost;
import com.postsmanager.repository.SavedPostRepository;
import com.postsmanager.service.SavedPostService;
@Service
public class SavedPostServiceImpl implements SavedPostService{

	@Autowired
	SavedPostRepository savedPostRepository;
	
	@Override
	public Response savePost(SavedPostRequest savedPostRequest) {
		// TODO Auto-generated method stub
		Optional<SavedPost> spSavedPost=savedPostRepository.findById(savedPostRequest.getUserName());
		if(spSavedPost.isEmpty())
		{
			List<Post> post=new ArrayList<>();
			post.add(savedPostRequest.getPosts());
			savedPostRepository.save(new SavedPost(savedPostRequest.getUserName(),post));
			Response response=new Response(HttpStatus.OK.value(),"Post saved successfully...");
			return response;
		}
		List<Post> post=spSavedPost.get().getPosts();
		post.add(savedPostRequest.getPosts());
		savedPostRepository.save(new SavedPost(savedPostRequest.getUserName(),post));
		Response response=new Response(HttpStatus.OK.value(),"Post saved successfully...");
		return response;
	}

	@Override
	public AllPostResponse getSavedPost(String userName) {
		// TODO Auto-generated method stub
		Optional<SavedPost> spSavedPost=savedPostRepository.findById(userName);
		if(spSavedPost.isEmpty())
		{
			AllPostResponse response=new AllPostResponse(HttpStatus.OK.value(),"No Post Saved Yet...",null);
			return response;
		}
		else
		{
			AllPostResponse response=new AllPostResponse(HttpStatus.OK.value(),"Saved post fetched successfully...",spSavedPost.get().getPosts());
			return response;
		}
	}

	@Override
	public Response removeSavedPost(String userName,Post post) {
		// TODO Auto-generated method stub
		Optional<SavedPost> spSavedPost=savedPostRepository.findById(userName);
		if(spSavedPost.isEmpty())
		{
			Response response=new Response(HttpStatus.OK.value(),"Failed to remove post from saved because this post not saved...");
			return response;
		}
		spSavedPost.get().getPosts().remove(post);
		savedPostRepository.save(spSavedPost.get());
		Response response=new Response(HttpStatus.OK.value(),"Saved Post removed successfully...");
		return response;
	}

	@Override
	public Response removeAllSavedPost(String userName) {
		// TODO Auto-generated method stub
		Optional<SavedPost> spSavedPost=savedPostRepository.findById(userName);
		if(spSavedPost.isEmpty())
		{
			Response response=new Response(HttpStatus.OK.value(),"Failed to remove saved posts because no post saved yet...");
			return response;
		}
		savedPostRepository.deleteById(userName);
		Response response=new Response(HttpStatus.OK.value(),"All Saved Posts removed successfully...");
		return response;
	}

}
