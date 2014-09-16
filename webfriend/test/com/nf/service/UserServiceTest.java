package com.nf.service;

import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nf.service.UserService;
import com.nf.service.impl.UserServiceImpl;
import com.nf.model.AtUserToComment;
import com.nf.model.AtUserToMood;
import com.nf.model.Friend;
import com.nf.model.User;

public class UserServiceTest
{
	private  UserService userService;
	@Before
	public  void setUpBeforeClass(){
		System.out.println("加载配置文件……");
		ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"src/beans.xml"});
		System.out.println("加载配置文件成功");
		userService = (UserService) context.getBean("userService");
	}
	@Test
	public void testExists()
	{
		
	}

	@Test
	public void testAdd()
	{
		
	}


}
