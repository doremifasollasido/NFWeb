package com.nf.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nf.dao.FriendDao;
import com.nf.dao.UserDao;
import com.nf.model.Friend;
import com.nf.model.User;
import com.nf.service.UserService;
@Component("userservice")
public class UserServiceImpl implements UserService{
	private FriendDao frienddao;
	
	public FriendDao getFrienddao() {
		return frienddao;
	}
	@Resource
	public void setFrienddao(FriendDao frienddao) {
		this.frienddao = frienddao;
	}

	private UserDao userdao;
	public UserDao getUserdao() {
		return userdao;
	}
    @Resource(name="userdao")
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public void save(User user) throws Exception{
		
      userdao.save(user);
	}
	@Override
	public User login(String username, String password) {
		User user = new User();
		if(null != username&&null !=password)
		{
			user =userdao.loginvalidate(username, password);
		}
	
		return user;
	}
	@Override
	public String exists(User user) {
		String str = "";
		if(!userdao.checkByPropertyExists("username",user.getUsername())){
			if(!userdao.checkByPropertyExists("sno",user.getSno())){
				if(!userdao.checkByPropertyExists("alais",user.getAlais())){
					if(!userdao.checkByPropertyExists("email",user.getEmail())){
						System.out.println("success!!!");
						
					}else{
						str +="email exists";
					}
				}else{
					str +="alais exists/";
				}
			}else{
				str +="sno exists/";
			}
		}else{
			str +="username exists/";
		}
		return str;
	}
	@Override
	public User CheckUserInformation(String username) {
		// TODO Auto-generated method stub
		return userdao.UserInformation(username);
	}
	@Override
	public List<User> findUser(String alais) {
		System.out.println("service invoke");
		return userdao.findUser(alais);
	}
	
	public boolean addfriend(Friend friend)
	{
		return frienddao.addFriend(friend);
	}
//	@Override
//	public List<User> findMyFriend(List id) {
//		// TODO Auto-generated method stub
//		return userdao.findMyFriend(user);
//	}
	@Override
	public List<User> loadFriendByUser(User user, int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return frienddao.loadFriendByUser(user, fromIndex, toIndex);
	}
	@Override
	public boolean deleteFriend(Friend friend) {
		// TODO Auto-generated method stub
		return frienddao.deleteFriend(friend);
	}


}
