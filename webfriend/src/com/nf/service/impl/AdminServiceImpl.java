package com.nf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nf.dao.AdminDao;
import com.nf.dao.CommentDao;
import com.nf.dao.MoodDao;
import com.nf.model.Admin;
import com.nf.model.Comment;
import com.nf.model.Mood;
import com.nf.model.User;
import com.nf.service.AdminService;
@Component("adminservice")
public class AdminServiceImpl implements AdminService {
private AdminDao admindao;
private MoodDao moodDao;
private CommentDao commentdao;




	public CommentDao getCommentdao() {
	return commentdao;
	}
	@Resource
	public void setCommentdao(CommentDao commentdao) {
		this.commentdao = commentdao;
	}
	public MoodDao getMoodDao() {
	return moodDao;
	}
	@Resource
	public void setMoodDao(MoodDao moodDao) {
		this.moodDao = moodDao;
	}
	public AdminDao getAdmindao() {
	return admindao;
	}
	@Resource
	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}

	@Override
	public Admin login(String username, String password) {
		
		return admindao.adminvalidate(username, password);
	}
    @Override
	public List<User> showUsers()
	{
		return admindao.getUsers();
	}
	@Override
	public void userdelete(int id) throws Exception {
		admindao.userdelete(id);
		
	}
	
	@Override
	public List<Mood> getMoods() {
		// TODO Auto-generated method stub
		return moodDao.queryMood();
	}
	@Override
	public boolean deleteMood(Mood mood)
	{
		System.out.println("deletemood");
		return moodDao.deleteMood(mood);
	}
	public List<Comment> getComments(Comment comment)
	{
		System.out.println("getcomment");
		return commentdao.getcomments(comment);
	}
	public boolean deleteComment(Comment comment)
	{
		return commentdao.deleteComment(comment);
	}
}
