package com.nf.service;

import com.nf.model.Comment;
import com.nf.model.Mood;
import com.nf.model.User;

/**
 * 编写者：ZHJ
 * 功能：评论处理服务抽象层
 * 编写时间：2014-9-18
 */
public interface CommentService
{

	public abstract String addComment(Comment comment, User user, Mood mood);

	public abstract int addcommentReturnId(Comment comment, User user, Mood mood);

	public abstract String deleteOneMoodById(int moodId);

}