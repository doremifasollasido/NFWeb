package com.nf.model;

import java.sql.Date;
import java.util.HashSet;
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
	private User user;
	private Mood mood;
	private Comment fatherComment;
	private Set<Comment> children = new HashSet<Comment>();
	private String content;
	private Date uptime;
	private Set<AtUserToComment> atUserToComments;

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
	public User getUser()
	{
		return user;
	}

	
	public void setUser(User user)
	{
		this.user = user;
	}

	@ManyToOne
	public Mood getMood()
	{
		return mood;
	}

	public void setMood(Mood mood)
	{
		this.mood = mood;
	}

	@ManyToOne
	@JoinColumn(name="father_id")
	public Comment getFatherComment()
	{
		return fatherComment;
	}

	public void setFatherComment(Comment fatherComment)
	{
		this.fatherComment = fatherComment;
	}

	@OneToMany(mappedBy="fatherComment",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Comment> getChildren()
	{
		return children;
	}

	public void setChildren(Set<Comment> children)
	{
		this.children = children;
	}

	public String getContent()
	{
		return content;
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

	@OneToMany(mappedBy="comment")
	public Set<AtUserToComment> getAtUserToComments()
	{
		return atUserToComments;
	}

	public void setAtUserToComments(Set<AtUserToComment> atUserToComments)
	{
		this.atUserToComments = atUserToComments;
	}
	

}
