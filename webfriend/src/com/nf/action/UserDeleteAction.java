package com.nf.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.UserDto;
import com.nf.model.User;
import com.nf.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("userdeleteaction")
@Scope("prototype")
public class UserDeleteAction extends ActionSupport implements ModelDriven {
	private AdminService adminservice;
	private UserDto userdto;
	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public UserDto getUserdto() {
		return userdto;
	}
    @Resource
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
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
		
		System.out.println(userdto.getId());
	 adminservice.userdelete(userdto.getId());
	 this.list =this.adminservice.showUsers();
	 
		return SUCCESS;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userdto;
	}
	

}
