package com.nf.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nf.model.Mood;

/**
 * 编写者：ZHJ
 * 功能：心情数据持久化抽象类
 * 编写时间：2014-9-14
 */
public interface MoodDao
{

	/**
	 * 持久化一条心情;
	 * @param mood 心情Entity
	 * @return 操作成功返回true，否则为false
	 */
	public abstract boolean addmood(Mood mood);

	/**
	 * @param moodId 进行查询的moodId
	 * @return 返回一个mood
	 * @throws DataAccessException
	 */
	public abstract Mood loadMoodById(int moodId) throws DataAccessException;
	/**
	 * 删除一条心情
	 * @param mood 需要删除的对象
	 * @return 操作成功返回true，否则为false
	 */
	public abstract boolean deleteMood(Mood mood);

	/**
	 * @param flushTime 早于该时间的心情数据
	 * @param fromIndex 起始位置
	 * @param toIndex 结束位置
	 * @return 对应条件的好友心情列表
	 */
	public abstract List<Mood> querySchoolMood(Date flushTime, int fromIndex,
			int toIndex);

	/**
	 * @param flushTime 早于该时间的心情数据
	 * @param fromIndex 起始位置
	 * @param toIndex 结束位置
	 * @param userId 被查询的用户id
	 * @return 对应条件的好友心情列表
	 */
	public abstract List<Mood> queryMoodByUserId(Date flushTime, int fromIndex,
			int toIndex, int userId);

	/**
	 * @param flushTime 早于该时间的心情数据
	 * @param fromIndex 起始位置
	 * @param toIndex 结束位置
	 * @param userId 当前用户id
	 * @return 对应条件的好友心情列表
	 */
	public abstract List<Mood> queryFriendMood(Date flushTime, int fromIndex,
			int toIndex, int userId);

}