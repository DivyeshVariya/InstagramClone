package com.postsmanager.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.postsmanager.dto.AllPostResponse;
import com.postsmanager.dto.PostCountResponse;
import com.postsmanager.dto.PostDataRequest;
import com.postsmanager.dto.PostDataResponse;
import com.postsmanager.dto.PostLikeRequest;
import com.postsmanager.dto.PostLikeResponse;
import com.postsmanager.dto.Request;
import com.postsmanager.dto.Response;
import com.postsmanager.model.Index;
import com.postsmanager.model.Likes;
import com.postsmanager.model.Post;
import com.postsmanager.repository.IndexRepository;
import com.postsmanager.repository.LikesRepository;
import com.postsmanager.repository.PostsRepository;
import com.postsmanager.service.AutoIncreamentService;
import com.postsmanager.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostsRepository postsRepository;
	
	@Autowired
	LikesRepository likesRepository;
	
	@Autowired
	AutoIncreamentService autoIncreamentService;
	
	@Override
	public Response addPost(PostDataRequest postDataRequest) throws IOException {
		// TODO Auto-generated method stub
		int id=autoIncreamentService.generateSequence(Post.SEQUENCE_NAME);
		String imageStr = Base64.getEncoder().encodeToString(postDataRequest.getImage().getBytes());
		Likes like1=new Likes(id,0,postDataRequest.getUserName(),new ArrayList<>());
	    Post p=	postsRepository.save(new Post(id,postDataRequest.getUserName(),postDataRequest.getTitle(),postDataRequest.getLocation(),imageStr,postDataRequest.getHashtsges(),postDataRequest.getCaption(),like1));
	    likesRepository.save(like1);
	    if(p.equals(null))
	    {
	    	Response response=new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to post....");
	    	return response;
	    }
	    Response response=new Response(HttpStatus.OK.value(),"Post added Successfully....");
    	return response;
	}

	@Override
	public Response deletePost(Request request) {
		// TODO Auto-generated method stub
		Optional<Post> p=postsRepository.findByUserNameAndId(request.getUserName(), request.getId());
		System.out.println(p);
		if(p.isEmpty())
	    {
	    	Response response=new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to delete post....");
	    	return response;
	    }
		postsRepository.deleteById(request.getId());
	    Response response=new Response(HttpStatus.OK.value(),"Post deleted Successfully....");
    	return response;
	}

	@Override
	public AllPostResponse getAllPost(String userName) {
		// TODO Auto-generated method stub
		List<Post> p=postsRepository.findByUserName(userName);
		if(p.isEmpty())
	    {
			AllPostResponse response=new AllPostResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to fetch posts....",null);
	    	return response;
	    }
		AllPostResponse response=new AllPostResponse(HttpStatus.OK.value(),"All Posts fetched Successfully....",p);
    	return response;
	}

	@Override
	public PostDataResponse getPost(Request request) {
		// TODO Auto-generated method stub
		Optional<Post> p=postsRepository.findByUserNameAndId(request.getUserName(), request.getId());
		System.out.println(p);
		if(p.isEmpty())
	    {
			PostDataResponse response=new PostDataResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to fetch post....",null);
	    	return response;
	    }
		PostDataResponse response=new PostDataResponse(HttpStatus.OK.value(),"Post fetched Successfully....",p.get());
    	return response;
	}

	@Override
	public PostLikeResponse likePost(PostLikeRequest request) {
		// TODO Auto-generated method stub
		System.out.println(request);
		Optional<Post> p=postsRepository.findByUserNameAndId(request.getUserName(), request.getId());
		if(p.isEmpty())
	    {
			PostLikeResponse response=new PostLikeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to like post....",null);
	    	return response;
	    }
		else
		{
		Optional<Likes> l=likesRepository.findById((long) request.getId());
		if(!l.isEmpty())
		{
		l.get().setLikes(l.get().getLikes()+1);
		List<String> temp=l.get().getLikedBy();
		temp.add(request.getLikedBy());
		l.get().setLikedBy(temp);
		p.get().setLikes(l.get());
		postsRepository.save(p.get());
		likesRepository.save(l.get());
		System.out.println("jqoiqs");
		}
		else
		{
		List<String> likedby=new ArrayList<>();likedby.add(request.getLikedBy());
		Likes likes= new Likes(request.getId(),p.get().getLikes().getLikes()+1,request.getUserName(),likedby);
		p.get().setLikes(likes);
		postsRepository.save(p.get());
		likesRepository.save(likes);
		System.out.println("qpk,o,");
		}
		System.out.println("sahbhj");
		PostLikeResponse response=new PostLikeResponse(HttpStatus.OK.value(),"Post Liked Successfully....",l.get());
    	return response;
    	}
	}

	@Override
	public PostLikeResponse dislikePost(PostLikeRequest request) {
		// TODO Auto-generated method stub
		Optional<Post> p=postsRepository.findByUserNameAndId(request.getUserName(), request.getId());
		if(p.isEmpty())
	    {
			PostLikeResponse response=new PostLikeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to dislike post....",null);
	    	return response;
	    }
		else
		{
			Optional<Likes> l=likesRepository.findById((long) request.getId());
			if(!l.isEmpty())
			{
				if(l.get().getLikes()>0)
				{
				l.get().setLikes(l.get().getLikes()-1);
				List<String> temp=l.get().getLikedBy();
				temp.remove(request.getLikedBy());
				l.get().setLikedBy(temp);
				p.get().setLikes(l.get());
				postsRepository.save(p.get());
				likesRepository.save(l.get());
				}
				else {
					likesRepository.deleteById((long) l.get().getId());
				}
			}
			else
			{
				PostLikeResponse response=new PostLikeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed to disLike the post....",null);
		    	return response;
			}
			PostLikeResponse response=new PostLikeResponse(HttpStatus.OK.value(),"Post disLiked Successfully....",l.get());
    	return response;
		}
	}

	@Override
	public AllPostResponse getAllPostForAll() {
		// TODO Auto-generated method stub
		List<Post> p=postsRepository.findAll();
		if(p.isEmpty())
	    {
			AllPostResponse response=new AllPostResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to fetch posts....",null);
	    	return response;
	    }
		AllPostResponse response=new AllPostResponse(HttpStatus.OK.value(),"All Posts fetched Successfully....",p);
    	return response;
	}

	@Override
	public PostLikeResponse getListOfLikesForPost(String postUser, int id) {
		// TODO Auto-generated method stub
		Optional<Likes> l=likesRepository.findById((long) id);
		if(l.isEmpty())
		{
			PostLikeResponse response=new PostLikeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed to get Like of this post....",null);
	    	return response;
		}
		PostLikeResponse response=new PostLikeResponse(HttpStatus.OK.value(),"Likes fetched Successfully....",l.get());
    	return response;
	}

	@Override
	public PostCountResponse getPostCount(String userName) {
		// TODO Auto-generated method stub
		List<Post> p=postsRepository.findByUserName(userName);
		if(p.isEmpty())
	    {
			PostCountResponse response=new PostCountResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Faild to fetch posts count....",0);
	    	return response;
	    }
		PostCountResponse response=new PostCountResponse(HttpStatus.OK.value(),"Posts count fetched Successfully....",p.size());
    	return response;
	}

}
