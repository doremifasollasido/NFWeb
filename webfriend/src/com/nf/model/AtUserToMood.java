package com.nf.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_atuser_mood")
public class AtUserToMood
{
	private int id;
	private User user;
	private Mood mood;
	private Date uptime;
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
	public Date getUptime()
	{
		return uptime;
	}
	public void setUptime(Date uptime)
	{
		this.uptime = uptime;
	}
	

}
