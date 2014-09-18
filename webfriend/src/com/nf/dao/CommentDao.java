package com.nf.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.nf.model.Comment;
import com.nf.model.Mood;

/**
 * 编写者：ZHJ
 * 功能：评论数据持久化抽象类
 * 编写时间：2014-9-18
 */
public interface CommentDao
{

	public abstract boolean addcomment(Comment comment);

	public abstract Integer addCommentReturnId(Comment comment);

	public abstract Comment loadCommentById(int commentId)
			throws DataAccessException;

	/**
	 * 
	 * @param mood moodId不为空
	 * @return 查找到的评论
	 * @throws DataAccessException
	 */
	public abstract List<Comment> loadCommentByMood(Mood mood)
			throws DataAccessException;

	public abstract boolean deleteComment(Comment comment);

	public abstract HibernateTemplate getHibernateTemplate();

	@Resource
	public abstract void setHibernateTemplate(
			HibernateTemplate hibernateTemplate);

}