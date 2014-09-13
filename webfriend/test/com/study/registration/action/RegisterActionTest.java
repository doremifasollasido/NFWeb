package com.study.registration.action;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.study.registration.vo.UserRegisterInfo;

public class RegisterActionTest
{
	@Test
	public void testExecute() throws Exception
	{
		RegisterAction userAction = new RegisterAction();
		UserRegisterInfo userRegisterInfo = new UserRegisterInfo();
		userRegisterInfo.setUsername("zhsangsan");
		userRegisterInfo.setPassword("123");		
		userAction.setUserRegisterInfo(userRegisterInfo);
		String str = userAction.execute();
		Assert.assertEquals("success", str);
	}
}
