package com.nf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nf.dao.FriendDao;
import com.nf.model.Friend;
import com.nf.model.User;
import com.nf.service.FriendService;

/**
 * 编写者：ZHJ
 * 功能：好友处理服务实现层
 * 编写时间：2014-9-16
 */
@Component("friendServiceImpl")
public class FriendServiceImpl implements FriendService
{
	private FriendDao friendDao;

	/* (non-Javadoc)
	 * @see com.nf.service.impl.FriendService#addFriend(com.nf.model.User, com.nf.model.Friend)
	 */
	@Override
	public String addFriend(User user,int friendId){
		String resultStr = "";
		Friend friend = new Friend();
		friend.setUser(user);
		friend.setFriend_id(friendId);
		if(!friendDao.addFriend(friend)){
			resultStr += "add friend fail!!";
		}
		
		return resultStr;
	}
	
	/* (non-Javadoc)
	 * @see com.nf.service.impl.FriendService#deleteOneFriendById(com.nf.model.User, int)
	 */
	@Override
	public String deleteOneFriendById(Friend friend){
		String resultStr = "";
		if(!friendDao.deleteFriend(friend)){
			resultStr += "delete friend fail!!";
		}
		
		return resultStr;
	}
	
	/* (non-Javadoc)
	 * @see com.nf.service.impl.FriendService#getFriendByUser(com.nf.model.User)
	 */
	@Override
	public List<User> getFriendByUser(User user,int pageSize,int page){
		List<User> resultList =null;
		System.out.println("dao");
		resultList = friendDao.loadFriendByUser(user, pageSize*(page-1), pageSize);
		return resultList;
	}
	
	
	
	public FriendDao getFriendDao()
	{
		return friendDao;
	}

	@Resource(name="friendDaoImpl")
	public void setFriendDao(FriendDao friendDao)
	{
		this.friendDao = friendDao;
	}
}
