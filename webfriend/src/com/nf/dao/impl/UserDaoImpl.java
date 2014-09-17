package com.nf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nf.dao.UserDao;
import com.nf.model.User;

@Component("userdao")
public class UserDaoImpl implements UserDao
{
	private HibernateTemplate hibernatetemplate;

	public HibernateTemplate getHibernatetemplate()
	{
		return hibernatetemplate;
	}

	@Resource
	public void setHibernatetemplate(HibernateTemplate hibernatetemplate)
	{
		this.hibernatetemplate = hibernatetemplate;
	}

	@Override
	public void save(User user) throws Exception
	{

		hibernatetemplate.save(user);

	}

	@Override
	public User loginvalidate(String username, String password)
	{
		List list = new ArrayList();
		list = (List) hibernatetemplate.find("from User u where u.username='"
				+ username + "' and u.password='" + password+"'");
		if (null != list && list.size() > 0)
		{
			User u = (User) list.get(0);
			System.out.println("list is true!!");
			if (u.getId() > 0)
			{
				System.out.println("*****" + u.getId());
				return u;
			}
		}
		return null;
	}

	@Override
	public boolean checkByPropertyExists(String name, String value)
	{
		List list = hibernatetemplate.find("from User u where u." + name + "='"
				+ value+"'");

		if (null != list && list.size() > 0)
		{

			return true;
		}

		return false;
	}

	@Override
	public User load(int userId)
	{
		User u = null;
		try
		{
			u= hibernatetemplate.load(User.class, userId);
		} catch (Exception e)
		{
			u=null;
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return u;
	}

}
