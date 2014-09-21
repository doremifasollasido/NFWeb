package com.nf.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.dom4j.io.OutputFormat;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.model.Mood;
import com.nf.service.CommentService;
import com.nf.service.MoodService;
import com.nf.util.JsonFilter;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 编写者：ZHJ
 * 功能：心情数据持久化抽象类
 * 修改时间：2014-9-17
 */
@Component("ajaxQuerySchoolMoodAction")
@Scope("prototype")
public class AjaxQuerySchoolMoodAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private MoodService moodService;
	private CommentService commentService;
	@SuppressWarnings("rawtypes")
	private Map session;
	private int page;
	
	
	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
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
	
	public CommentService getCommentService()
	{
		return commentService;
	}
	@Resource(name="commentServiceImpl")
	public void setCommentService(CommentService commentService)
	{
		this.commentService = commentService;
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

	@Override
	public String execute() throws Exception
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		//是否登录校验
//		User u = (User)session.get("user");
		
		List<Mood> list = new ArrayList<Mood>();
		System.out.println("page="+page);
		//返回一堆没有comment内容的mood
		list = moodService.getSchoolMood(new Date(), 5, page);
		//num用于判断是否最后一页
		int num = list.size();
		if(num<5){
			page=-1;
		}
		System.out.println("list.size="+num);
		
		
		JsonFilter myJsonFilter = new JsonFilter();
		final String[] jsonKeys = {"fatherComment","password","mood"};
		JSONArray commentList=myJsonFilter.PropertyFilter(list, jsonKeys);
		
		JSONObject json = new JSONObject();
		json.put("list",commentList);
		System.out.println(json.toString());
		json.put("page", page);
		
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

}
