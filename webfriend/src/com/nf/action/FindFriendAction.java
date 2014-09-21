package com.nf.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.nf.dto.UserDto;
import com.nf.model.User;
import com.nf.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("findfriendaction")
public class FindFriendAction extends ActionSupport implements ModelDriven,SessionAware{
	private List<User> list;
	private UserDto userdto;
	private UserService userservice;
	private Map session;
	
	

	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public UserService getUserservice() {
		return userservice;
	}
	@Resource
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	public UserDto getUserdto() {
		return userdto;
	}
	@Resource
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	

	@Override
	public String execute() throws Exception {
		session.remove("list1");
		System.out.println(session.get("list1"));
		User user = new User();
		System.out.println(userdto.getAlais());
		if(null!=userdto.getAlais())
		{
		user.setAlais(userdto.getAlais());
		this.list=userservice.findUser(userdto.getAlais());
		session.put("list1", list);
		return SUCCESS;
		}
		return INPUT;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userdto;
	}
}
