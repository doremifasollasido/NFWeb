package com.nf.model;

import java.util.HashSet;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_Comment")
public class Comment
{
	private int id;
	private User user;//评论者
	private Comment fatherComment;
	private Set<Comment> children = new HashSet<Comment>();
	private String content;
	private Date uptime;
	private Set<AtUserToComment> atUserToComments = new HashSet<AtUserToComment>();
	private Mood mood;
	
	@ManyToOne
	public Mood getMood()
	{
		return mood;
	}

	public void setMood(Mood mood)
	{
		this.mood = mood;
	}

	@Id
	@GeneratedValue
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser()
	{
		return user;
	}

	
	public void setUser(User user)
	{
		this.user = user;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="father_id")
	public Comment getFatherComment()
	{
		return fatherComment;
	}

	public void setFatherComment(Comment fatherComment)
	{
		this.fatherComment = fatherComment;
	}
	public String getContent()
	{
		return content;
	}

	@OneToMany(mappedBy="fatherComment",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	
	public Set<Comment> getChildren()
	{
		return children;
	}

	public void setChildren(Set<Comment> children)
	{
		this.children = children;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getUptime()
	{
		return uptime;
	}

	public void setUptime(Date uptime)
	{
		this.uptime = uptime;
	}
	//评论可以看到@,但@不能看到评论
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	@JoinColumn(name="comment_id")
	public Set<AtUserToComment> getAtUserToComments()
	{
		return atUserToComments;
	}

	public void setAtUserToComments(Set<AtUserToComment> atUserToComments)
	{
		this.atUserToComments = atUserToComments;
	}

	
	
	

}
