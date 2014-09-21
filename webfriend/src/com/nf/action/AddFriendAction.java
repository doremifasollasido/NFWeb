package com.nf.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.UserDto;
import com.nf.model.Friend;
import com.nf.model.User;
import com.nf.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("addfriendaction")
@Scope("prototype")
public class AddFriendAction extends ActionSupport implements ModelDriven ,SessionAware{
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

	@Override
	public String execute() throws Exception {
		Friend friend =  new Friend();
//		User user = new User();
		User user=(User)session.get("user");
		System.out.println();
//    	user.setId(user1.getId());
//		System.out.println(user1.getId());
	
    	
		friend.setFriend_id(userdto.getId());
		System.out.println(userdto.getId());
		friend.setUser(user);
	
		userservice.addfriend(friend);
		return SUCCESS;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userdto;
	}

}
