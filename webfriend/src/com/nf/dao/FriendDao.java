package com.nf.dao;

import org.springframework.dao.DataAccessException;

import com.nf.model.Friend;
import com.nf.model.User;

/**
 * 编写者：ZHJ
 * 功能：好友数据持久化抽象类
 * 编写时间：2014-9-16
 */
public interface FriendDao
{

	/**
	 * 保存一个好友
	 * @param friend 进行保存的对象
	 * @return 保存成功为ture,失败为false
	 */
	public abstract boolean addFriend(Friend friend);

	/**
	 * 删除一个好友 ,传进来的friend对象user.getId()与friend_id不能为空
	 * @param friend 进行操作的对象
	 * @return 操作成功为ture,失败为false
	 */
	public abstract boolean deleteFriend(Friend friend);

	/**
	 * 依据frienId 返回一个Entity	 
	 * @param frienId 被查询的好友id
	 * @return 找到的对象
	 * @throws DataAccessException 存在异常则操作表示失败 
	 */
	public abstract Friend loadFriendById(int frienId)
			throws DataAccessException;

	/**
	 * 依据条件查询指定数量的好友ID
	 * @param user 主用户（或进行该操作的用户）
	 * @param fromIndex 起始位置
	 * @param toIndex 结束位置
	 * @return 好友ID的数组
	 * @throws DataAccessException 存在异常则操作表示失败 
	 */
	public abstract int[] loadFriendIdAarryByUser(User user, int fromIndex,
			int toIndex) throws DataAccessException;

}