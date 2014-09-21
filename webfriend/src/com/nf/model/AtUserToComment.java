package com.nf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_atuser_comment")
public class AtUserToComment
{
	private int id;
	private User user;
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
	@JoinColumn(name="user_id")
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
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
