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
@Table(name="t_Mood")
public class Mood
{
	private int id;
	private User user;
	private String content;
	private Date uptime;
	private Set<Picture> pictures = new HashSet<Picture>();
	private Set<AtUserToMood> atUserToMoods = new HashSet<AtUserToMood>();
	private Set<Comment> comments = new HashSet<Comment>();

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
	//心情能看到图片，但图片不能看到心情
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="mood_id")
	public Set<Picture> getPictures()
	{
		return pictures;
	}

	public void setPictures(Set<Picture> pictures)
	{
		this.pictures = pictures;
	}
	//心情能看到@，但@不能看到心情
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	@JoinColumn(name="mood_id")
	public Set<AtUserToMood> getAtUserToMoods()
	{
		return atUserToMoods;
	}

	public void setAtUserToMoods(Set<AtUserToMood> atUserToMoods)
	{
		this.atUserToMoods = atUserToMoods;
	}
	//心情能看到评论，但评论不能看到心情
	@OneToMany(mappedBy="mood",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	//@JoinColumn(name="mood_id")
	public Set<Comment> getComments()
	{
		return comments;
	}

	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}

	
	

}
