package com.nf.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.model.Mood;
import com.nf.model.User;
import com.nf.service.MoodService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 编写者：ZHJ
 * 功能：心情数据持久化抽象类
 * 修改时间：2014-9-21
 */
@Component("userAddMoodAction")
@Scope("prototype")
public class UserAddMoodAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MoodService moodService;
	private String content;
	@SuppressWarnings("rawtypes")
	private Map session;
	
	
	
	@Override
	public String execute() throws Exception
	{
		User u = (User)session.get("user");
		if(null ==u){
			return "login";
		}
		Mood mood = new Mood();
		mood.setContent(content);
		String resultStr = moodService.addmood(mood, u);//u只有id值也能成功
		System.out.println("action resultStr"+resultStr);
		return "success";
	}


	public MoodService getMoodService()
	{
		return moodService;
	}

	@Resource(name="moodServiceImpl")
	public void setMoodService(MoodService moodService)
	{
		this.moodService = moodService;
	}


	public String getContent()
	{
		return content;
	}


	public void setContent(String content)
	{
		this.content = content;
	}


	@SuppressWarnings("rawtypes")
	public Map getSession()
	{
		return session;
	}


	@SuppressWarnings("rawtypes")
	public void setSession(Map session)
	{
		this.session = session;
	}

	

}
