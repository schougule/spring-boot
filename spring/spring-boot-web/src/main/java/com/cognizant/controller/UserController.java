package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.domain.User;
import com.cognizant.service.UserDetailsService;

@RestController
public class UserController {

	@Autowired
	private UserDetailsService userDetailsService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = URIConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody void createUser(@RequestBody User user) {

		userDetailsService.creatUser(user);

	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = URIConstants.GET_USER, method = RequestMethod.POST)
	public @ResponseBody void getUser(@RequestBody String user) {

		// userDetailsService.creatUser(user);

	}

}