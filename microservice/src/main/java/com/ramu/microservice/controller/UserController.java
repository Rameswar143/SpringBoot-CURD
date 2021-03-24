package com.ramu.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramu.microservice.entity.User;
import com.ramu.microservice.service.UserService;

/**
 * @author PRAMESWA
 *
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.ok(service.saveUser(user));
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = service.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(service.getUserById(id));

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
		service.deleteUser(id);
		return ResponseEntity.ok("User '" + id + "' deleted ");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateeUser(@PathVariable("id") Integer id, @RequestBody User user) {
		User users = service.getUserById(id);
		users.setEmail(user.getEmail());
		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		return ResponseEntity.ok(service.saveUser(user));
	}

	@GetMapping("/validateUser/{userName}/{password}")
	public ResponseEntity<User> validateUser(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {
		return ResponseEntity.ok(service.validateUser(userName, password));
	}
}
