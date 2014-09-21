package com.nf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nf.dao.UserDao;
import com.nf.model.User;
@Component("userdao")
public class UserDaoImpl implements UserDao {
    private HibernateTemplate hibernatetemplate;
    public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}
	@Resource
	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}
	@Override
	public void save(User user) throws Exception {
     
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
	public User UserInformation(String username) {
		
		List<User > list=(List<User >) hibernatetemplate.find( "from User u where u.username="+username);
		if(null!=list && list.size()>0)
		{
			
			return list.get(0);
		}
		return null;
		
	}
	public List<User> findUser(String alais)
	{
		System.out.println("dao invoke");
		List<User> list =(List<User>)hibernatetemplate.find("from User u where u.alais like '%"+alais+"%'");
		if(null!=list&&list.size()>0)
		{
			System.out.println("dao1 invoke");
			return list;
		}
		return null;
		
	}
//	public List<User> findMyFriend(User user)
//	{
//		List<User> list= (List<User>)hibernatetemplate.find("from User");
//		if(null!=list&&list.size()>0)
//		{
//			return list;
//		}
//		return null;
//	}
	

}

