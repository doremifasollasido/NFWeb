package com.nf.service;

import java.util.List;

import com.nf.model.Admin;
import com.nf.model.Comment;
import com.nf.model.Mood;
import com.nf.model.User;

public interface AdminService {
	public Admin login(String username,String password);
	public List<User> showUsers();
	public void userdelete(int id) throws Exception;
	public List<Mood> getMoods();
	public boolean deleteMood(Mood mood);
	public List<Comment> getComments(Comment comment);
	public boolean deleteComment(Comment comment);
	
	
	
 
}
