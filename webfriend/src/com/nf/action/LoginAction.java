package com.nf.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.UserDto;
import com.nf.model.User;
import com.nf.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("loginaction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven,
		SessionAware
{

	/*
	 * 用户登录action
	 */
	private Map session;

	public Map getSession()
	{
		return session;
	}

	public void setSession(Map session)
	{
		this.session = session;
	}

	private UserDto userdto;
	private UserService userservice;

	public UserDto getUserdto()
	{
		return userdto;
	}

	public void setUserdto(UserDto userdto)
	{
		this.userdto = userdto;
	}

	public UserService getUserservice()
	{
		return userservice;
	}

	public void setUserservice(UserService userservice)
	{
		this.userservice = userservice;
	}

	@Override
	public String execute() throws Exception
	{
		User user = userservice.login(userdto.getUsername(),
				userdto.getPassword());
		if (null != user)
		{
			session.put("user", user.getUsername());
			return SUCCESS;
		}
		return INPUT;
	}

	@Override
	public Object getModel()
	{
		// TODO Auto-generated method stub
		return userdto;
	}

}
