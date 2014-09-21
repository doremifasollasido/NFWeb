package com.nf.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.UserDto;
import com.nf.model.User;
import com.nf.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("userinfromationaction")
@Scope("prototype")
public class UserInformationAction extends ActionSupport implements ModelDriven {
    private UserService userservice;
    private UserDto userdto;
    private List list;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
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
		
		
//		this.list.add(userservice.CheckUserInformation(userdto.getUsername()));
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userdto;
	}

}
