package com.nf.dao.impl;

import java.util.ArrayList;
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

import com.nf.dao.FriendDao;
import com.nf.model.Friend;
import com.nf.model.User;

/**
 * 编写者：ZHJ
 * 功能：好友数据持久化实现类
 * 编写时间：2014-9-16
 */
@Component("friendDaoImpl")
public class FriendDaoImpl implements FriendDao
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nf.dao.impl.FriendDao#addFriend(com.nf.model.Friend)
	 */
	@Override
	public boolean addFriend(Friend friend)
	{
		boolean bl = false;
		try
		{
			hibernateTemplate.save(friend);
			bl = true;
		} catch (DataAccessException dex)
		{
			dex.printStackTrace();
			bl = false;
		}

		return bl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nf.dao.impl.FriendDao#deleteFriend(com.nf.model.Friend)
	 */
	@Override
	public boolean deleteFriend(Friend friend)
	{
		boolean bl = false;
		try
		{
			if (friend.getId() > 0)
			{
				// 根据表的主键来删除
				hibernateTemplate.delete(friend);
			} else
			{
				// 根据userId和FriendId来删除
				String hql = "delete from Friend f where f.friend_id='"
						+ friend.getFriend_id() + "' and f.user.id='"
						+ friend.getUser().getId() + "'";
				hibernateTemplate.bulkUpdate(hql);
			}
			bl = true;
		} catch (DataAccessException dex)
		{
			dex.printStackTrace();
			bl = false;
		}
		return bl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nf.dao.impl.FriendDao#loadFriendById(int)
	 */
	@Override
	public Friend loadFriendById(int frienId)
	{
		return hibernateTemplate.load(Friend.class, frienId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nf.dao.impl.FriendDao#loadFriendIdAarryByUser(com.nf.model.User,
	 * int, int)
	 */
	
	@Override
	public Object[] loadFriendIdAarryByUser(final User user)
	{
		Object[] resultArray = null;
		List<Friend> list = new ArrayList<Friend>();
		try
		{
			list = hibernateTemplate.execute(new HibernateCallback<List<Friend>>()
			{
				@SuppressWarnings("unchecked")
				public List<Friend> doInHibernate(Session session)
				{
					Criteria criteria = session.createCriteria(Friend.class)
							.add(Restrictions.eq("user.id", user.getId()));
					
					criteria.setMaxResults(500);//最大好友数500
					return (List<Friend>)criteria.list();
				}
			});
		} catch (HibernateException ex)
		{
			resultArray = null;
			ex.printStackTrace();
		}
		resultArray = new Object[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			User u = new User();
			u.setId(list.get(i).getFriend_id());
			resultArray[i] = u;
			System.out.println("friend" + i + "=" + list.get(i).getFriend_id());
		}

		return resultArray;
	}
	
	public List<User> loadFriendByUser(final User user,final int fromIndex,final int toIndex) 
	{
		
		List<Friend> list = new ArrayList<Friend>();
		List<User> resultList = new ArrayList<User>();
		//进行好友id查询
		try
		{
			list = hibernateTemplate.execute(new HibernateCallback<List<Friend>>()
			{
				@SuppressWarnings("unchecked")
				public List<Friend> doInHibernate(Session session)
				{
					Criteria criteria = session.createCriteria(Friend.class)
							.add(Restrictions.eq("user.id", user.getId())).addOrder(Order.desc("id"));
					criteria.setFirstResult(fromIndex);
					criteria.setMaxResults(toIndex);
					return (List<Friend>)criteria.list();
				}
			});
		} catch (HibernateException ex)
		{
			ex.printStackTrace();
		}
		//循环将friend_id装到user对象中，生成下一步查询所需的obj数组
		if(list.size()>0){//如果好友数不为0
			final Object[] resultArray = new Object[list.size()];
			for (int i = 0; i < list.size(); i++)
			{
				//User u = new User();
				//u.setId(list.get(i).getFriend_id());
				resultArray[i] = list.get(i).getFriend_id();
				System.out.println("friend" + i + "=" + list.get(i).getFriend_id());
			}
			//进行User查询
			try
			{
				resultList = hibernateTemplate.execute(new HibernateCallback<List<User>>()
				{
					@SuppressWarnings("unchecked")
					public List<User> doInHibernate(Session session)
					{
						Criteria criteria = session.createCriteria(User.class)
								.add(Restrictions.in("id", resultArray));
						return (List<User>)criteria.list();
					}
				});
			} catch (HibernateException ex)
			{
				ex.printStackTrace();
			}
		}
		return resultList;
	}

}
