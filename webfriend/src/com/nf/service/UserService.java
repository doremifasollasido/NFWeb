package com.nf.service;

import java.util.List;

import com.nf.model.Friend;
import com.nf.model.User;

public interface UserService {
	public void save(User user) throws Exception;
	public User login(String username,String password);
	public String exists(User user);
	public User CheckUserInformation(String username);
	public List<User> findUser(String alais);
	public boolean addfriend(Friend friend);
//	public List<User> findMyFriend(User user);
	public List<User> loadFriendByUser(final User user,final int fromIndex,final int toIndex) ;
	public boolean deleteFriend(Friend friend);
}
