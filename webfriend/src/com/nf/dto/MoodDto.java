package com.nf.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.nf.model.User;
@Component("mooddto")
public class MoodDto {

	private int id;
	private User user;
	private String content;
	private Date uptime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
}
