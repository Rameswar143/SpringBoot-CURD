package com.ramu.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramu.microservice.entity.User;
import com.ramu.microservice.exception.UserNotFoundException;
import com.ramu.microservice.repository.UserRepository;

/**
 * @author PRAMESWA
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {
		User userExist = repository.checkUserExistedOrNot(user.getEmail());
		if (userExist != null)
			return user;
		return repository.save(user);

	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User getUserById(Integer id) throws UserNotFoundException {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not Exist"));
	}

	@Override
	public void deleteUser(Integer id) throws UserNotFoundException {
		User user = getUserById(id);
		repository.delete(user);
	}

	@Override
	public User validateUser(String userName, String password) {
		return repository.validateUser(userName, password);
	}

}
