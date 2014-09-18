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
 * 编写者：ZHJ
 * 功能：评论处理服务实现层
 * 编写时间：2014-9-18
 */
@Component("comentDaoImpl")
public class CommentDaoImpl implements CommentDao
{
	private HibernateTemplate hibernateTemplate;
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.CommentDao#addcomment(com.nf.model.Comment)
	 */
	@Override
	public boolean addcomment(Comment comment){
		boolean bl =false;
		try{
			hibernateTemplate.save(comment);
			bl =true;
		}catch(DataAccessException dex){
			dex.printStackTrace();
			bl = false;
		}
		
		return bl;
	}
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.CommentDao#addCommentReturnId(com.nf.model.Comment)
	 */
	@Override
	public Integer addCommentReturnId(Comment comment){
		Integer a=0;
		try{
			a =(Integer) hibernateTemplate.save(comment);
			
		}catch(DataAccessException dex){
			dex.printStackTrace();
			a=0;
		}
		
		return a;
	}
	
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.CommentDao#loadCommentById(int)
	 */
	@Override
	public Comment loadCommentById(int commentId) throws DataAccessException{
		return hibernateTemplate.load(Comment.class, commentId);
	}
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.CommentDao#loadCommentByMood(com.nf.model.Mood)
	 */
	@Override
	public List<Comment> loadCommentByMood(Mood mood) throws DataAccessException{
//		hibernateTemplate.findByExample("mood", mood);
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.CommentDao#deleteComment(com.nf.model.Comment)
	 */
	@Override
	public boolean deleteComment(Comment comment){
		boolean bl =false;
		try{
			hibernateTemplate.delete(comment);
			bl =true;
		}catch(DataAccessException dex){
			dex.printStackTrace();
			bl = false;
		}
		return bl;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.CommentDao#getHibernateTemplate()
	 */
	@Override
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}
	/* (non-Javadoc)
	 * @see com.nf.dao.impl.CommentDao#setHibernateTemplate(org.springframework.orm.hibernate4.HibernateTemplate)
	 */
	@Override
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
}
