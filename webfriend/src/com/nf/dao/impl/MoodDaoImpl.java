package com.nf.dao.impl;

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
	
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
	
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
	@Override
	public Integer addmoodReturnId(Mood mood){
		Integer a=0;
		try{
			a =(Integer) hibernateTemplate.save(mood);
			
		}catch(DataAccessException dex){
			dex.printStackTrace();
			a=0;
		}
		
		return a;
	}
	
	
	@Override
	public Mood loadMoodById(int moodId) throws DataAccessException{
		return hibernateTemplate.load(Mood.class, moodId);
	}
	
	
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
//			resultList = (List<Mood>) hibernateTemplate.find("from Mood");
			
		}catch(HibernateException ex){
			resultList = null;
			ex.printStackTrace();
		}
		
		return resultList;
	}
	
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
	
	@Override
	public List<Mood> queryMood()
	{
		@SuppressWarnings("unchecked")
		List<Mood> list = (List<Mood>) hibernateTemplate.find("from Mood");
		if (null != list && list.size() > 0)
		{

			return list;
		}
		return null;
	}
	@Override
	public List<Mood> queryFriendMood(final Date flushTime,final int fromIndex,final int toIndex,final int userId ,final Object[] friendId){
		List<Mood> resultList = null;
		try{
		resultList = hibernateTemplate.execute(new HibernateCallback<List<Mood>>(){
			@SuppressWarnings("unchecked")
			public List<Mood> doInHibernate(Session session)
					{
				Criteria criteria = session.createCriteria(Mood.class).add(Restrictions.le("uptime", flushTime)).add(Restrictions.in("user", friendId)).addOrder(Order.desc("uptime"));
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
	
	
	
	
	
}
