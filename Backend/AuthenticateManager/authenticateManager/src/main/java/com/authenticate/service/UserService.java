package com.authenticate.service;

import java.io.IOException;

import com.authenticate.dto.UserDataResponse;
import com.authenticate.dto.UserLoginRequest;
import com.authenticate.dto.UserPicRequest;
import com.authenticate.dto.UserPicResponse;
import com.authenticate.dto.UserRegisterRequest;
import com.authenticate.dto.UserResponse;
import com.authenticate.model.ProfilePic;
import com.authenticate.model.User;

public interface UserService {

	public UserResponse register(UserRegisterRequest userRequest);

	public UserResponse login(UserLoginRequest userRequest);

	public UserResponse checkUserName(String userName);

	public UserDataResponse findByUserName(String userName);

	public UserResponse checkEmail(String email);

	public UserDataResponse findByEmail(String email);

	public UserResponse editProfile(User user);

	public UserResponse setProfilePic(UserPicRequest pic) throws IOException;

	public UserPicResponse getProfilePic(String userName);

	public UserResponse deleteProfilePic(String userName);

	public UserResponse getBio(String userName);
}
