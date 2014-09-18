package com.nf.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nf.dao.CommentDao;
import com.nf.model.Comment;
import com.nf.model.Mood;
import com.nf.model.User;
import com.nf.service.CommentService;

/**
 * 编写者：ZHJ
 * 功能：评论处理服务实现层
 * 编写时间：2014-9-18
 */
@Component("commentServiceImpl")
public class CommentServiceImpl implements CommentService
{	
	
	private CommentDao commentDao;
	
	
	/* (non-Javadoc)
	 * @see com.nf.service.impl.CommentService#addComment(com.nf.model.Comment, com.nf.model.User, com.nf.model.Mood)
	 */
	@Override
	public String addComment(Comment comment,User user,Mood mood){
		String resultStr = "";
		comment.setUser(user);
		comment.setMood(mood);
		comment.setUptime(new Date());//作为发表心情的时间
		if(!commentDao.addcomment(comment)){
			resultStr="add fail";
		}
		return resultStr;
	}
	
	/* (non-Javadoc)
	 * @see com.nf.service.impl.CommentService#addcommentReturnId(com.nf.model.Comment, com.nf.model.User, com.nf.model.Mood)
	 */
	@Override
	public int addcommentReturnId(Comment comment,User user,Mood mood){
		int result = 0;
		comment.setUser(user);
		comment.setMood(mood);
		comment.setUptime(new Date());//作为发表心情的时间
		result = commentDao.addCommentReturnId(comment);
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.nf.service.impl.CommentService#deleteOneMoodById(int)
	 */
	@Override
	public String deleteOneMoodById(int moodId){
		String resultStr = "";
		
		return resultStr;
	}

	public CommentDao getCommentDao()
	{
		return commentDao;
	}
	@Resource(name="comentDaoImpl")
	public void setCommentDao(CommentDao commentDao)
	{
		this.commentDao = commentDao;
	}
	
	
	
	
	
	
}
