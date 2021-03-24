package com.ramu.microservice.service;

import java.util.List;

import com.ramu.microservice.entity.User;
import com.ramu.microservice.exception.UserNotFoundException;

/**
 * @author PRAMESWA
 *
 */
public interface UserService {

	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(Integer id) throws UserNotFoundException;

	void deleteUser(Integer id) throws UserNotFoundException;

	User validateUser(String userName, String password);

}
