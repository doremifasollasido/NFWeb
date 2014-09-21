package com.nf.service;

import java.util.List;

import com.nf.model.Friend;
import com.nf.model.User;

/**
 * 编写者：ZHJ
 * 功能：好友处理服务抽象层
 * 编写时间：2014-9-16
 */
public interface FriendService
{

	/**
	 * 用户添加好友
	 * @param user 当前用户（id不为空即可）
	 * @param friendId  好友id
	 * @return 操作成功返回""，失败返回提示语句
	 */
	public abstract String addFriend(User user,int friendId);

	/**
	 * 用户删除好友
	 * @param friend 若存在id，则根据表id主键删除，否则根据user_id+friend_id进行删除
	 * @return 操作成功返回""，失败返回提示语句
	 */
	public abstract String deleteOneFriendById(Friend friend);

	/**
	 * 用户查询指定数量的好友对象
	 * @param user 当前用户
	 * @param pageSize 返回数量
	 * @param page 需要查询的页码（>0）
	 * @return 查询指定数量的好友对象
	 */
	public abstract List<User> getFriendByUser(User user,int pageSize,int page);

	
}