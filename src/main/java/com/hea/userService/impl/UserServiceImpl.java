package com.hea.userService.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UtilGeneratedId util;
	
	public UserDto createUser(UserDto userDtao) {
		User userEntity = new User();
		BeanUtils.copyProperties(userDtao, userEntity);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDtao.getPassword()));
		//userEntity.setPassword("pwdddd");
		userEntity.setUserId(util.generateUserId(5));
		
		User sotredUser = userRepo.save(userEntity);
		UserDto returnedValue = new UserDto();
		BeanUtils.copyProperties(sotredUser, returnedValue);
		
		return returnedValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	
	
}
