package com.nf.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nf.dao.MoodDao;
import com.nf.model.Mood;

/**
 * 编写者：ZHJ
 * 功能：心情数据持久化实现类
 * 编写时间：2014-9-14
 */
@Component("moodDaoImpl")
public class MoodDaoImpl implements MoodDao
{
	
	private HibernateTemplate hibernateTemplate;
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.MoodDao#addmood()
	 */
	@Override
	public boolean addmood(Mood mood){
		boolean bl =false;
		try{
			hibernateTemplate.save(mood);
			bl =true;
		}catch(DataAccessException dex){
			dex.printStackTrace();
			bl = false;
		}
		
		return bl;
	}
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.MoodDao#loadMoodById(int)
	 */
	@Override
	public Mood loadMoodById(int moodId) throws DataAccessException{
		return hibernateTemplate.load(Mood.class, moodId);
	}
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.MoodDao#delectMoodById(int)
	 */
	@Override
	public boolean deleteMood(Mood mood){
		boolean bl =false;
		try{
			hibernateTemplate.delete(mood);
			bl =true;
		}catch(DataAccessException dex){
			dex.printStackTrace();
			bl = false;
		}
		return bl;
	}
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.MoodDao#querySchoolMood(java.sql.Date, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Mood> querySchoolMood(final Date maxTime,final int fromIndex,final int toIndex){
		List<Mood> resultList = null;
		try{
		resultList = hibernateTemplate.execute(new HibernateCallback<List<Mood>>(){
			public List<Mood> doInHibernate(Session session)
					{
				Criteria criteria = session.createCriteria(Mood.class).add(Restrictions.le("uptime", maxTime)).addOrder(Order.desc("uptime"));
				criteria.setFirstResult(fromIndex);
				criteria.setMaxResults(toIndex);
				return criteria.list();
			}
		});
			
		}catch(HibernateException ex){
			resultList = null;
			ex.printStackTrace();
		}
		
		return resultList;
	}
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.MoodDao#queryMoodByUserId(java.sql.Date, int, int, int)
	 */
	@Override
	public List<Mood> queryMoodByUserId(final Date maxTime,final int fromIndex,final int toIndex,final int userId){
		/*List<Mood> resultList = new ArrayList<Mood>();
		String hql = "from Mood m where m.uptime <= :maxTime and m.user.id = :userId";
		String[] params = {"maxTime","userId"};
		Object[] args = {maxTime,userId};
		resultList = (List<Mood>) (hibernateTemplate.findByNamedParam(hql, params, args).subList(fromIndex, toIndex));
		*/
		List<Mood> resultList = null;
		try{
		resultList = hibernateTemplate.execute(new HibernateCallback<List<Mood>>(){
			@SuppressWarnings("unchecked")
			public List<Mood> doInHibernate(Session session)
					{
				Criteria criteria = session.createCriteria(Mood.class).add(Restrictions.le("uptime", maxTime)).add(Restrictions.eq("user.id", userId)).addOrder(Order.desc("uptime"));
				criteria.setFirstResult(fromIndex);
				criteria.setMaxResults(toIndex);
				return criteria.list();
			}
		});
			
		}catch(HibernateException ex){
			resultList = null;
			ex.printStackTrace();
		}
		
		return resultList;
	}
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.MoodDao#queryFriendMood(java.sql.Date, int, int, int)
	 */
	@Override
	public List<Mood> queryFriendMood(Date flushTime,int fromIndex,int toIndex,int userId){
		List<Mood> resultList = new ArrayList<Mood>();
		
		return resultList;
	}
	
	
	
	
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
}
