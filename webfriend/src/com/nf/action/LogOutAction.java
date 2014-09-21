package com.nf.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Component("logoutaction")
public class LogOutAction extends ActionSupport implements SessionAware {
	/*
	 登录注销action
	 * 
	 */
	private Map session;
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("clear");
		session.clear();
		return SUCCESS;
	}

}
