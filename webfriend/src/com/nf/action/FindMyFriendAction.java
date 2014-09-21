package com.nf.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.UserDto;
import com.nf.model.User;
import com.nf.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("findmyfriendaction")
@Scope("prototype")
public class FindMyFriendAction extends ActionSupport  implements ModelDriven,SessionAware{
	private UserService userservice;
	private List list;
	private UserDto userdto;
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

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	@Override
	public String execute() throws Exception {
		User user = (User)session.get("user");
		if(null!=user)
		{
		this.list= userservice.loadFriendByUser(user, 0, 50);
		session.put("list", list);
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
