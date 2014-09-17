package com.nf.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nf.dao.MoodDao;
import com.nf.dao.UserDao;
import com.nf.model.Mood;
import com.nf.model.User;
import com.nf.service.MoodService;

/**
 * 编写者：ZHJ
 * 功能：心情处理服务实现层
 * 编写时间：2014-9-14
 */
@Component("moodServiceImpl")
public class MoodServiceImpl implements MoodService
{	
	private MoodDao moodDao;
	
	private UserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.nf.service.impl.MoodService#addmood()
	 */
	@Override
	public String addmood(Mood mood,User user){
		String resultStr = "";
		mood.setUser(user);
		mood.setUptime(new Date());//作为发表心情的时间
		if(!moodDao.addmood(mood)){
			resultStr="add fail";
		}
		return resultStr;
	}
	/* (non-Javadoc)
	 * @see com.nf.service.impl.MoodService#delectOneMoodById(int)
	 */
	@Override
	public String deleteOneMoodById(int moodId){
		String resultStr = "";
		Mood mood = new Mood();
		mood.setId(moodId);
		moodDao.deleteMood(mood);
		return resultStr;
	}
	/* (non-Javadoc)
	 * @see com.nf.service.impl.MoodService#querySchoolMood(java.sql.Date, int, int)
	 */
	@Override
	public List<Mood> getSchoolMood(Date flushTime,int pageSize,int page){
		List<Mood> resultList = new ArrayList<Mood>();
		resultList = moodDao.querySchoolMood(flushTime, (pageSize*(page-1)), pageSize);
		return resultList;
	}
	/* (non-Javadoc)
	 * @see com.nf.service.impl.MoodService#getMoodByUserId(java.sql.Date, int, int, int)
	 */
	@Override
	public List<Mood> getMoodByUserId(Date flushTime,int pageSize,int page,int userId){
		List<Mood> resultList = new ArrayList<Mood>();
		resultList = moodDao.queryMoodByUserId(flushTime,  (pageSize*(page-1)), pageSize, userId);
		return resultList;
	}
	/* (non-Javadoc)
	 * @see com.nf.service.impl.MoodService#queryFriendMood(java.sql.Date, int, int)
	 */
	@Override
	public List<Mood> getFriendMood(Date flushTime,int pageSize,int page,int userId){
		List<Mood> resultList = new ArrayList<Mood>();
		
		return resultList;
	}
	
	
	public MoodDao getMoodDao()
	{
		return moodDao;
	}
	@Resource(name="moodDaoImpl")
	public void setMoodDao(MoodDao moodDao)
	{
		this.moodDao = moodDao;
	}
	public UserDao getUserDao()
	{
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	
}
