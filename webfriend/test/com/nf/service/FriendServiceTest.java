package com.nf.service;

import junit.framework.Assert;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nf.model.Friend;
import com.nf.model.User;

public class FriendServiceTest
{
	private  FriendService friendService;
	@Before
	public  void setUpBeforeClass(){
		System.out.println("加载配置文件……");
		ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"src/beans.xml"});
		System.out.println("加载配置文件成功");
		friendService = (FriendService) context.getBean("friendServiceImpl");
	}
	@Test
	public void addFriendTest(){
		User user = new User();
		user.setId(4);
		for(int i=0;i<2;i++){
			String str = friendService.addFriend(user, 3);
			Assert.assertEquals("", str);
		}
		
	}
	@Test
	public void deleteFriendTest(){
		User user = new User();
		user.setId(2);
		Friend friend = new Friend();
		friend.setUser(user);
		friend.setFriend_id(4);
		//friend.setId(3);
		friendService.deleteOneFriendById(friend);
	}
	@Test
	public void getFriendByUserTest(){
		
	}
	@Test
	public void getFriendIdArrayByUserTest(){
		User user = new User();
		user.setId(4);
		int[] resultArray = friendService.getFriendIdArrayByUser(user,3,2);
		for(int i = 0;i<resultArray.length;i++){
			System.out.println(resultArray[i]+",");
		}
		
	}

}
