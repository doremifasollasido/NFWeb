package com.nf.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nf.dao.AdminDao;
import com.nf.model.Admin;
import com.nf.model.User;
@Component("admindao")
public class AdminDaoImpl implements AdminDao {
	private HibernateTemplate hibernatetemplate;
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}
     @Resource
	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	public Admin adminvalidate(String username, String password)
	{
		List<Admin> list =(List<Admin>)hibernatetemplate.find("from Admin  a where a.username="+username+"and a.password="+password);
		if(null!=list&&list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}

	public List<User> getUsers()
	{
		List<User> list = (List<User>)hibernatetemplate.find("from User");
		if(null!=list&&list.size()>0)
		{
			System.out.println("dao");
		return list;
		}
		return null;
	}
	@Override
	public void userdelete(int id) throws Exception{
		try
		{
		User user =  hibernatetemplate.get(User.class,id);
		if(null!=user)
		{
		hibernatetemplate.delete(user);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
