package com.nf.service;

import java.util.Date;
import java.util.List;

import com.nf.model.Mood;
import com.nf.model.User;

/**
 * 编写者：ZHJ
 * 功能：心情处理服务抽象层
 * 编写时间：2014-9-14
 */
public interface MoodService
{

	/**
	 * 添加一条心情;
	 * @param mood 心情Entity
	 * @return 若操作成功返回字符串长度为0，若操作失败返回错误信息;
	 */
	public abstract String addmood(Mood mood,User user);

	/**
	 * @param moodId 心情表中的id
	 * @return 若操作成功返回字符串长度为0，若操作失败返回错误信息;
	 */
	public abstract String deleteOneMoodById(int moodId);

	/**
	 * 1.用户登录成功后，校园动态展示时心情列的展示功能；（异步翻页功能）
	 * @param flushTime 新一次页面刷新时间
	 * @param pageSize 读取条数
	 * @param page 页码
	 * @return 按时间降序排列,返回数据库表中发表时间在clickTime之前的心情
	 */
	public abstract List<Mood> getSchoolMood(Date flushTime, int pageSize,
			int page);

	/**
	 * 1.用户个人主页时心情列展示功能；（异步翻页功能）
	 * 2.用户查看他人主页时心情列展示功能；（异步翻页功能）
	 * 注：只能查询单个用户心情
	 * @param flushTime 新一次页面刷新时间
	 * @param pageSize 读取条数
	 * @param page 页码
	 * @param userId 需要进行查询的用户id
	 * @return 按时间降序排列,返回数据库表中发表时间在clickTime之前的心情
	 */
	public abstract List<Mood> getMoodByUserId(Date flushTime, int pageSize,
			int page, int userId);

	/**
	 * 1.查询好友动态（异步翻页功能）
	 * @param flushTime 新一次页面刷新时间
	 * @param pageSize 读取条数
	 * @param page 页码
	 * *@param userId 当前用户id
	 * @return 按时间降序排列,返回数据库表中发表时间在clickTime之前的心情
	 */
	public abstract List<Mood> getFriendMood(Date flushTime, int pageSize,
			int page, int userId);

}