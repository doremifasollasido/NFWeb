package com.nf.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private Set<Picture> pictures;
	private Set<AtUserToMood> atUserToMoods;
	private Set<Comment> comments;

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

	@OneToMany(mappedBy="mood")
	public Set<Picture> getPictures()
	{
		return pictures;
	}

	public void setPictures(Set<Picture> pictures)
	{
		this.pictures = pictures;
	}

	@OneToMany(mappedBy="mood")
	public Set<AtUserToMood> getAtUserToMoods()
	{
		return atUserToMoods;
	}

	public void setAtUserToMoods(Set<AtUserToMood> atUserToMoods)
	{
		this.atUserToMoods = atUserToMoods;
	}

	@OneToMany(mappedBy="mood")
	public Set<Comment> getComments()
	{
		return comments;
	}

	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}
	

}
