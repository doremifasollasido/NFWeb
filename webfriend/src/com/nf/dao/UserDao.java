package com.nf.dao;

import java.util.List;

import com.nf.model.User;

public interface UserDao
{
	public void save(User user) throws Exception;

	public User loginvalidate(String username, String password);

	// 判断是否存在某个用户名
	public boolean checkByPropertyExists(String name, String value);

}
