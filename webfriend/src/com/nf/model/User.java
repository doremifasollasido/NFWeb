package com.nf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User
{
	private int id;
	private String username;
	private String password;
	private String sno;
	private String alais;
	private String email;
	private String major;
	private String dept;
	private int classnumber;
	private String address;
	private String image;
	private int info_state;
	private int at_state;

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

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSno()
	{
		return sno;
	}

	public void setSno(String sno)
	{
		this.sno = sno;
	}

	public String getAlais()
	{
		return alais;
	}

	public void setAlais(String alais)
	{
		this.alais = alais;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMajor()
	{
		return major;
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public String getDept()
	{
		return dept;
	}

	public void setDept(String dept)
	{
		this.dept = dept;
	}

	public int getClassnumber()
	{
		return classnumber;
	}

	public void setClassnumber(int classnumber)
	{
		this.classnumber = classnumber;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public int getInfo_state()
	{
		return info_state;
	}

	public void setInfo_state(int info_state)
	{
		this.info_state = info_state;
	}

	public int getAt_state()
	{
		return at_state;
	}

	public void setAt_state(int at_state)
	{
		this.at_state = at_state;
	}

}
