package com.hea.user.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hea.user.shared.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto userDtao);
}
