package com.nf.service;

import java.util.List;

import com.nf.model.Admin;
import com.nf.model.User;

public interface AdminService {
	public Admin login(String username,String password);
	public List<User> showUsers();
	public void userdelete(int id);
	
	

}
