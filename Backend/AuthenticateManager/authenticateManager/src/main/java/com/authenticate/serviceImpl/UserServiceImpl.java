package com.authenticate.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.authenticate.dto.UserDataResponse;
import com.authenticate.dto.UserLoginRequest;
import com.authenticate.dto.UserPicRequest;
import com.authenticate.dto.UserPicResponse;
import com.authenticate.dto.UserRegisterRequest;
import com.authenticate.dto.UserResponse;
import com.authenticate.model.HandleRequest;
import com.authenticate.model.ProfilePic;
import com.authenticate.model.User;
import com.authenticate.repository.HandleRequestRepository;
import com.authenticate.repository.ProfilePicRepository;
import com.authenticate.repository.UserRespository;
import com.authenticate.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRespository userRespository;
	
	@Autowired
	ProfilePicRepository picRepository;
	
	@Autowired
	HandleRequestRepository handleRequestRepository;
	
	@Override
	public UserResponse register(UserRegisterRequest userRequest) {
		// TODO Auto-generated method stub
		User newUser=new User();
		newUser.setEmail(userRequest.getEmail());
		newUser.setFullName(userRequest.getFullName());
		newUser.setUserName(userRequest.getUserName());
		newUser.setPassword(userRequest.getPassword());
		 User savedUser = userRespository.save(newUser);
		 if(savedUser.equals(null))
		 {
			 UserResponse response=new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed to Register...");
			 return response;
		 }
		 handleRequestRepository.save(new HandleRequest(userRequest.getUserName(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
		 UserResponse response=new UserResponse(HttpStatus.OK.value(),"User register successfully...");
		 return response;
	}

	@Override
	public UserResponse login(UserLoginRequest userRequest) {
		// TODO Auto-generated method stub
		
		Optional<User> user=userRespository.findByUserName(userRequest.getUserName());
		if(user.isEmpty())
		 {
			 UserResponse response=new UserResponse(HttpStatus.NOT_FOUND.value(),"User Not Found...");
			 return response;
		 }
		else if(!user.isEmpty()&& !user.get().getPassword().equals(userRequest.getPassword()))
		{
			UserResponse response=new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Invaild Username or Password...");
			 return response;
		}
		else {
		UserResponse response=new UserResponse(HttpStatus.OK.value(),"Login successfully...");
		 return response;
		}
	}

	@Override
	public UserResponse checkUserName(String userName) {
		// TODO Auto-generated method stub
		Optional<User> user=userRespository.findByUserName(userName);
		if(user.isEmpty())
		 {
			 UserResponse response=new UserResponse(HttpStatus.OK.value(),"This Username is available...");
			 return response;
		 }
		UserResponse response=new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Username is already exist...");
		 return response;
	}

	@Override
	public UserDataResponse findByUserName(String userName) {
		// TODO Auto-generated method stub
		Optional<User> user=userRespository.findByUserName(userName);
		if(user.isEmpty())
		 {
			 UserDataResponse response=new UserDataResponse(HttpStatus.NOT_FOUND.value(),"User not found...",null);
			 return response;
		 }
		UserDataResponse response=new UserDataResponse(HttpStatus.OK.value(),"User found...",user.get());
		 return response;
	}

	@Override
	public UserResponse checkEmail(String email) {
		// TODO Auto-generated method stub
		Optional<User> user=userRespository.findById(email);
		if(user.isEmpty())
		 {
			 UserResponse response=new UserResponse(HttpStatus.OK.value(),"This EmailID is available...");
			 return response;
		 }
		UserResponse response=new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"EmailID is already exist...");
		 return response;
	}

	@Override
	public UserDataResponse findByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<User> user=userRespository.findById(email);
		if(user.isEmpty())
		 {
			 UserDataResponse response=new UserDataResponse(HttpStatus.NOT_FOUND.value(),"User not found...",null);
			 return response;
		 }
		UserDataResponse response=new UserDataResponse(HttpStatus.OK.value(),"User found...",user.get());
		 return response;
	}

	@Override
	public UserResponse editProfile(User user) {
		// TODO Auto-generated method stub
		Optional<User> getuser=userRespository.findByUserName(user.getUserName());
		if(getuser.isEmpty())
		 {
			 UserResponse response=new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed to update profile...");
			 return response;
		 }
		userRespository.save(user);
		UserResponse response=new UserResponse(HttpStatus.OK.value(),"Profile Updated Successfully...");
		 return response;
	}

	@Override
	public UserResponse setProfilePic(UserPicRequest pic) throws IOException {
		// TODO Auto-generated method stub
		Optional<User> getuser=userRespository.findByUserName(pic.getUserName());
		if(getuser.isEmpty())
		 {
			 UserResponse response=new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed to set profile picture...");
			 return response;
		 }
		picRepository.save(new ProfilePic(pic.getUserName(),Base64.getEncoder().encodeToString(pic.getPicture().getBytes())));
		UserResponse response=new UserResponse(HttpStatus.OK.value(),"Profile picture Updated Successfully...");
		 return response;
	}

	@Override
	public UserPicResponse getProfilePic(String userName) {
		// TODO Auto-generated method stub
		Optional<ProfilePic> pp=picRepository.findById(userName);
		if(pp.isEmpty())
		{
			UserPicResponse response=new UserPicResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed to fetch profile picture...",null);
			 return response;
		}
		UserPicResponse response=new UserPicResponse(HttpStatus.OK.value(),"Profile picture fetched Successfully...",pp.get());
		 return response;
	}

	@Override
	public UserResponse deleteProfilePic(String userName) {
		// TODO Auto-generated method stub
		Optional<ProfilePic> pp=picRepository.findById(userName);
		if(pp.isEmpty())
		{
			UserResponse response=new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Profile picture not exits...");
			 return response;
		}
		picRepository.deleteById(userName);
		UserResponse response=new UserResponse(HttpStatus.OK.value(),"Profile picture deleted Successfully...");
		 return response;
	}

	@Override
	public UserResponse getBio(String userName) {
		// TODO Auto-generated method stub
		Optional<User> u=userRespository.findByUserName(userName);
		if(u.isEmpty())
		{
			UserResponse response=new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed to fetch bio...");
			 return response;
		}
		UserResponse response=new UserResponse(HttpStatus.OK.value(),u.get().getBio());
		 return response;
	}

}
