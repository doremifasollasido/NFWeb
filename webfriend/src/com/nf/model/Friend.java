package com.nf.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_friend")
public class Friend
{
	private int id;
	private User user;
	private int friend_id;
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
	@ManyToOne(fetch=FetchType.LAZY)
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public int getFriend_id()
	{
		return friend_id;
	}
	public void setFriend_id(int friend_id)
	{
		this.friend_id = friend_id;
	}
}
