package com.infy.FTR.UserService;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.infy.FTR.Util.InfyFTRConstants;
import com.infy.FTR.UserDTO.LoginDTO;
import com.infy.FTR.UserDTO.UpdateUserDTO;
import com.infy.FTR.UserDTO.UserDTO;
import com.infy.FTR.UserEntity.UserEntity;
import com.infy.FTR.UserException.NoSuchUserException;
import com.infy.FTR.UserRepo.UserRepo;
@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	private Environment environment;
	public UserDTO createUser(UserDTO userDTO) {
		UserEntity ent=UserDTO.changes(userDTO);
		userRepo.saveAndFlush(ent);
		return UserDTO.changesTo(ent);
		//return Integer.toString(ent.getUserId());
	}
	public UserDTO getUser(Integer userId) {
		
		Optional<UserEntity> ent=userRepo.findById(userId);
		UserDTO dto=UserDTO.changesTo(ent.get());
		return dto;
		
		
	}
	public String updateUser(Integer userId,  UpdateUserDTO updateUserDTO) throws NoSuchUserException{
		Optional<UserEntity> ent=userRepo.findById(userId);
		if(ent.isPresent()) {
			UserEntity ent1=ent.get();
			ent1.setMobileNumber(updateUserDTO.getMobileNumber());
			ent1.setOfficeAddress(updateUserDTO.getOfficeAddress());
			ent1.setPermanentAddress(updateUserDTO.getPermanentAddress());
			userRepo.saveAndFlush(ent1);
			String str = environment.getProperty(InfyFTRConstants.USER_UPDATE_SUCCESS.toString());
			Integer uId = ent1.getUserId();
	
			return str+uId.toString();
			
		}
		else {
			throw new NoSuchUserException(environment.getProperty(InfyFTRConstants.USER_NOT_FOUND.toString()));
		
		}
	}
	public String deleteUser(Integer userId) throws NoSuchUserException {
		Optional<UserEntity> ent=userRepo.findById(userId);
		if(ent.isPresent()) {
		userRepo.deleteById(userId);
		String str = environment.getProperty(InfyFTRConstants.USER_DELETE_SUCCESS.toString());
		
		return str+userId.toString();
		}
		else
			throw new NoSuchUserException(environment.getProperty(InfyFTRConstants.USER_NOT_FOUND.toString()));
		 
	}
	public String loginUser(LoginDTO loginDTO) throws NoSuchUserException {
		Optional<UserEntity> ent=userRepo.findById(loginDTO.getUserId());
		if(ent.isPresent()) {
			UserEntity user = ent.get();
			if(user.getPassword().equals(loginDTO.getPassword())) {
			String str = environment.getProperty(InfyFTRConstants.USER_LOGIN_SUCCESS.toString());
			return str;
			}
			else {
				throw new NoSuchUserException(environment.getProperty(InfyFTRConstants.USER_LOGIN_FAILURE.toString()));
			}
		}
		else
			throw new NoSuchUserException(environment.getProperty(InfyFTRConstants.USER_LOGIN_FAILURE.toString()));
		 
	}

}


	

