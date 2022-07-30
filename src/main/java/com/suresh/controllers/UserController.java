package com.suresh.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.domain.User;
import com.suresh.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@GetMapping("/user/{id}")
	@Cacheable(value = "users",key = "#id",unless = "#result.id<50")
	public User getUser(@PathVariable long id) {
		logger.debug(" Entering getUser() in Controller ");
		return service.getUser(id);
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		logger.debug(" Entering CreateUser() in Controller ");
		return service.create(user);
	}

	@GetMapping("/users")
	public List<User> getAll() {
		logger.debug(" Entering getAll () in Controller ");
		return service.getAll();
	}

	@PutMapping("/update")
	@CachePut(key = "#users.id",value = "users")
	public User updateUser(@RequestBody User user) {
		logger.debug(" Entering updateUser in Controller ");
		return service.update(user);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		logger.debug(" >> UserController : /delete : ", id);
		service.delete(id);
		logger.debug(" << UserController : /delete : ", id);

	}
}
