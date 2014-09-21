package com.nf.action;

import java.util.List;
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
@Component("frienddeleteaction")
@Scope("prototype")
public class FriendDeleteAction extends ActionSupport  implements ModelDriven,SessionAware{
	private UserService userservice;
	private UserDto userdto;
	private Map session;
	private List list;
	

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public UserDto getUserdto() {
		return userdto;
	}
	@Resource
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
	public UserService getUserservice() {
		return userservice;
	}
    @Resource
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

    
    @Override
    public String execute() throws Exception {
    	Friend friend = new Friend();
//    	User user = new User();
    	User user=(User)session.get("user");
    	System.out.println(user.getId());
//    	user.setId(user.getId());
//    	user.setId(1);
    	friend.setUser(user);
    	friend.setFriend_id(userdto.getId());
    	userservice.deleteFriend(friend);
    	
    	return SUCCESS;
    }
    
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userdto;
	}
	
	
	

}
