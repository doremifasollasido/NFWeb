package com.nf.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.UserDto;
import com.nf.model.User;
import com.nf.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
@Component("userdisplayaction")
@Scope("prototype")
public class UserDisplayAction extends ActionSupport {
	private AdminService adminservice;
	private List<User> list;
	private UserDto userdto;
	
	public UserDto getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public AdminService getAdminservice() {
		return adminservice;
	}
    @Resource
	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}

	@Override
	public String execute() throws Exception {
//		System.out.println("action");
		this.list =this.adminservice.showUsers();

		return SUCCESS;
	}

}
