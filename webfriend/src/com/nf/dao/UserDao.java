package com.nf.dao;


import java.util.List;

import com.nf.model.User;

public interface UserDao {
	//用户注册
	public void save(User user) throws Exception;
	//用户登录
	public User loginvalidate(String username,String password);
	//判断是否存在某个用户名
	public boolean checkByPropertyExists(String name,String value);
	//查看某个用户的个人信息
	public User UserInformation(String username);
	//查看符合条件的用户
	public List<User> findUser(String alais);
	//查看我的好友
//	public List<User> findMyFriend(User user);

	
	
	

}
