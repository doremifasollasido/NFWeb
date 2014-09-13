package com.nf.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogOutAction extends ActionSupport implements SessionAware
{
	/*
	 * 登录注销action
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

	@Override
	public String execute() throws Exception
	{

		session.clear();
		return SUCCESS;
	}

}
