package com.nf.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nf.dao.CommentDao;
import com.nf.model.Comment;
import com.nf.model.Mood;

/**
 * 编写者：ZHJ 功能：评论处理服务实现层 编写时间：2014-9-18
 */
@Component("commentDaoImpl")
public class CommentDaoImpl implements CommentDao
{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean addcomment(Comment comment)
	{
		boolean bl = false;
		try
		{
			hibernateTemplate.save(comment);
			bl = true;
		} catch (DataAccessException dex)
		{
			dex.printStackTrace();
			bl = false;
		}

		return bl;
	}

	@Override
	public Integer addCommentReturnId(Comment comment)
	{
		Integer a = 0;
		try
		{
			a = (Integer) hibernateTemplate.save(comment);

		} catch (DataAccessException dex)
		{
			dex.printStackTrace();
			a = 0;
		}

		return a;
	}

	@Override
	public Comment loadCommentById(int commentId) throws DataAccessException
	{
		return hibernateTemplate.load(Comment.class, commentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> loadCommentByMood(Mood mood)
			throws DataAccessException
	{
		return (List<Comment>) hibernateTemplate.find("Comment", mood.getId());

	}

	@Override
	public boolean deleteComment(Comment comment)
	{
		boolean bl = false;
		try
		{
			hibernateTemplate.delete(comment);
			bl = true;
		} catch (DataAccessException dex)
		{
			dex.printStackTrace();
			bl = false;
		}
		return bl;
	}

	@Override
	public List<Comment> getcomments(Comment comment)
	{
		@SuppressWarnings("unchecked")
		List<Comment> list = (List<Comment>) hibernateTemplate
				.find("from Comment");
		if (null != list && list.size() > 0)
		{
			return list;
		}
		return null;
	}

}
