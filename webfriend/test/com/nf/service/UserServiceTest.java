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
	private  UserService userservice;
	@Before
	public  void setUpBeforeClass(){
		System.out.println("加载配置文件……");
		ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"src/beans.xml"});
		System.out.println("加载配置文件成功");
		userservice = (UserService) context.getBean("userservice");
	}
	@Test
	public void testExists()
	{
		
	}

	@Test
	public void testAddUser() throws Exception
	{
		User user = new User();
		for(int i=0 ;i<10;i++)
		{
		user.setAlais("煞笔啊啊"+i);
		user.setAt_state(i);
		user.setClassnumber(i+2);
		user.setAddress("广州"+i);
		user.setId(10+i);
		user.setPassword("123456"+i);
		user.setUsername("毒逍遥"+i);
		user.setDept("123456"+i);
		user.setMajor("计算机"+i);
		user.setInfo_state(i);
		user.setSno("123456+i");
		user.setEmail(i+"123456@qq.com");
		user.setImage("111"+i);
		ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"src/beans.xml"});
		UserService userservice= (UserService)context.getBean("userservice");
		userservice.save(user);
		}
	}


}
