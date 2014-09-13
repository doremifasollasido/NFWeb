package com.nf.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.UserDto;
import com.nf.model.User;
import com.nf.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("useraction")
@Scope("prototype")
public class RegisterAction extends ActionSupport implements ModelDriven,
		SessionAware
{
	/*
	 * 用户注册action
	 */
	private Map session;
	private UserDto userdto;
	private UserService userservice;

	public Map getSession()
	{
		return session;
	}

	public void setSession(Map session)
	{
		this.session = session;
	}

	public UserService getUserservice()
	{
		return userservice;
	}

	@Resource(name = "userservice")
	public void setUserservice(UserService userservice)
	{
		this.userservice = userservice;
	}

	public UserDto getUserdto()
	{
		return userdto;
	}

	@Resource(name = "userdto")
	public void setUserdto(UserDto userdto)
	{
		this.userdto = userdto;
	}

	@Override
	public String execute() throws Exception
	{
		System.out.println("action one ");
		User user = new User();
		user.setUsername(userdto.getUsername());
		user.setPassword(userdto.getPassword());
		user.setSno(userdto.getSno());
		user.setAlais(userdto.getAlais());
		user.setDept(userdto.getDept());
		user.setClassnumber(userdto.getClassnumber());
		user.setEmail(userdto.getEmail());
		user.setMajor(userdto.getMajor());
		user.setAddress(userdto.getAddress());
		System.out.println("action");

		String resultsting = userservice.exists(user);
		if (resultsting.length() > 0)
		{
			System.out.println("11111=" + resultsting);
			return INPUT;
		}
		userservice.save(user);
		return SUCCESS;
	}

	@Override
	public Object getModel()
	{
		// TODO Auto-generated method stub
		return userdto;
	}

}
