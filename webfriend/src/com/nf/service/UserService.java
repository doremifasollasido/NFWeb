package com.nf.service;

import com.nf.model.User;

public interface UserService
{
	public void save(User user) throws Exception;

	public User login(String username, String password);

	public String exists(User user);

}
