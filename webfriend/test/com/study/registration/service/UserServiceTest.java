package com.study.registration.service;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.study.registration.model.User;
import com.study.registration.service.UserService;
import com.study.registration.service.impl.UserServiceImpl;

public class UserServiceTest
{
	

	@Test
	public void testExists()
	{
		UserService userService = new UserServiceImpl();
		User u = new User();
		
		u.setUsername("zhangsan123a1");
		
		boolean bl = userService.exists(u);
		Assert.assertEquals(false, bl);
		
	}

	@Test
	public void testAdd()
	{
		UserService us = new UserServiceImpl();
		User u = new User();
		
		u.setUsername("cc");
		u.setPassword("123");
		if(!us.exists(u)){
			us.add(u);
			Assert.assertEquals(true,us.exists(u));
		}
		else{
			fail("add error!!");
		}
		
		
		
	}

}
