package com.suresh.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.domain.User;
import com.suresh.repository.UserRepository;
import com.suresh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repo;

	@Override
	public User getUser(long id) {
		logger.debug(" >>  Entering into getUser method..");
		User user = repo.findById(id).get();
		if (user != null) {
			logger.debug(" << UserService : Exiting getUser");
			return user;
		} else
			logger.debug(" << UserService : No Such User Exists : Exiting getUser");
		return null;
	}

	@Override
	public List<User> getAll() {
		logger.debug(" >> UserService : Entering getAll");
		logger.debug(" << UserService : Exiting getAll");
		return repo.findAll();
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);

	}

	@Override
	public User update(User user) {
		long id = user.getId();
		User userInDb = getUser(id);
		if (userInDb != null) {
			logger.debug(">> UserService : User updated : Exiting update");
			return create(user);
		} else
			logger.debug(">> UserService : User with this id does not exist : Exiting update");
		return null;

	}

	@Override
	public User create(User user) {
		logger.debug(" >> UserService : Entering create");

		User userToRet = repo.save(user);
		logger.debug(" << UserService : Exiting create");
		return userToRet;
	}

}
