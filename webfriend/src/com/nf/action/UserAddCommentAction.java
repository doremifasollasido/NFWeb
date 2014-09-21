package com.nf.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.model.Comment;
import com.nf.model.Mood;
import com.nf.model.User;
import com.nf.service.CommentService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 编写者：ZHJ
 * 功能：心情数据持久化抽象类
 * 修改时间：2014-9-21
 */
@Component("userAddCommentAction")
@Scope("prototype")
public class UserAddCommentAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommentService commentService;
	private String content;
	private int moodId;
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
		mood.setId(moodId);
		Comment comment = new Comment();
		comment.setContent(content);//图片，@ 未进行处理
		int resultInt = commentService.addcommentReturnId(comment, u, mood);//u只有id值也能成功
		System.out.println("action resultStr"+resultInt);
		return "success";
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
	
	public int getMoodId()
	{
		return moodId;
	}

	public void setMoodId(int moodId)
	{
		this.moodId = moodId;
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
