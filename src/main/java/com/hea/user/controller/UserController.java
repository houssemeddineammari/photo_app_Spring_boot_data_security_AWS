package com.hea.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hea.ui.user.model.response.UserRest;
import com.hea.user.Service.UserService;
import com.hea.user.shared.dto.UserDto;
import com.hea.user.ui.user.model.request.UserDetailsRequestModel;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(path = "/users")
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) {
		UserRest returnedValue = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetailsRequestModel, userDto);
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnedValue);
		return returnedValue;

	}

	@GetMapping(path = "/users/user")
	public String ShowUser() {
		return "User Displayed ....";
	}

	@PutMapping(path = "/users/user")
	public String UpdateUser() {
		return "User Updated Successfully ....";
	}

	@DeleteMapping(path = "/users/user")
	public String DeleteUser() {
		return "User Deleted ....";
	}
}
