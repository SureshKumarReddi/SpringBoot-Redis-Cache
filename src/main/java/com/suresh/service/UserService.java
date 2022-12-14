package com.suresh.service;

import java.util.List;

import com.suresh.domain.User;

public interface UserService {

	public User getUser(long id);
	public List<User> getAll();
	public void delete(long id);
	public User update(User user);
	public User create(User user);
}
