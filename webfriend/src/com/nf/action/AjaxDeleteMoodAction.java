package com.nf.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.dom4j.io.OutputFormat;
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
@Component("ajaxDeleteMoodAction")
@Scope("prototype")
public class AjaxDeleteMoodAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MoodService moodService;
	private String content;
	@SuppressWarnings("rawtypes")
	private Map session;
	private int moodid;
	
	
	public int getMoodid()
	{
		return moodid;
	}


	public void setMoodid(int moodid)
	{
		this.moodid = moodid;
	}


	@Override
	public String execute() throws Exception
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		User u = (User)session.get("user");
		if(null == u){
			//进行登录
			return "login";
		}
		System.out.println("id==="+moodid);
		Mood mood = new Mood();
		mood.setId(moodid);
		String resultStr = moodService.deleteOneMoodById(moodid);//u只有id值也能成功
		
		if(resultStr.length()==0){
			
		}
		
		
		JSONObject json = new JSONObject();
		
		resp.setContentType("application/json; charset=utf-8");
		resp.setHeader("pragma", "no-cacher");
		resp.setHeader("cacher-control", "no-cacher");
		
		PrintWriter out = resp.getWriter();
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		out.print(json);
		out.flush();
		return null;
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
