package com.cognizant.service;

import java.util.Optional;

import com.cognizant.domain.User;

public interface UserDetailsService {

	public Optional<User> getUserDetails(String username);

	public void creatUser(User user);

}
