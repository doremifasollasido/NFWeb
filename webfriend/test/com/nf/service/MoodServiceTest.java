package com.nf.service;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;


import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.nf.model.Mood;
import com.nf.model.User;

public class MoodServiceTest
{
	private  MoodService moodService;
	@Before
	public  void setUpBeforeClass(){
		System.out.println("加载配置文件……");
		ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"src/beans.xml"});
		System.out.println("加载配置文件成功");
		moodService = (MoodService) context.getBean("moodServiceImpl");
	}
	@Test
	public void addMoodTest(){
		
		User user = new User();
		user.setId(2);
		Mood mood = new Mood();
		mood.setContent("hello world!");
		String str = moodService.addmood(mood,user);
		Assert.assertEquals("", str);
	}
	
	@Test
	public void deleteMoodTest(){
		String str = moodService.deleteOneMoodById(1);
		Assert.assertEquals("", str);
	}
	@Test
	public void getSchoolMoodTest(){
		List<Mood> list = moodService.getSchoolMood(new Date(), 2, 1);
		JSONObject json = new JSONObject();
		json.put("list",list);
		System.out.println(json.toString());
		Assert.assertNotNull(list);
		
	}
	@Test
	public void getMoodByUserIdTest(){
		List<Mood> list = moodService.getMoodByUserId(new Date(), 2, 1, 2);
		JSONObject json = new JSONObject();
		json.put("list",list);
		System.out.println(json.toString());
		Assert.assertNotNull(list);
	}
	@Test
	public void getFriendIdArray(){
		User user = new User();
		user.setId(2);
	}
	

}
