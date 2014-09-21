package com.nf.dao;

import java.util.List;

import com.nf.model.Admin;
import com.nf.model.User;

public interface AdminDao {
	public Admin adminvalidate(String username, String password);
	public List<User> getUsers();
	public void userdelete(int id) throws Exception;
	
}
