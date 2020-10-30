package com.hea.userService.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hea.entity.User;
import com.hea.shared.UtilGeneratedId;
import com.hea.user.Repository.UserRepository;
import com.hea.user.Service.UserService;
import com.hea.user.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	@Autowired
	UtilGeneratedId util;
	
	public UserDto createUser(UserDto userDtao) {
		User userEntity = new User();
		BeanUtils.copyProperties(userDtao, userEntity);
		userEntity.setPassword("pwdddd");
		userEntity.setUserId(util.generateUserId(5));
		
		User sotredUser = userRepo.save(userEntity);
		UserDto returnedValue = new UserDto();
		BeanUtils.copyProperties(sotredUser, returnedValue);
		
		return returnedValue;
	}

	
	
}
