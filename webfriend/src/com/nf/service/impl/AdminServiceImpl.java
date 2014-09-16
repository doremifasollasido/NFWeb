package com.nf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nf.dao.AdminDao;
import com.nf.model.Admin;
import com.nf.model.User;
import com.nf.service.AdminService;
@Component("adminservice")
public class AdminServiceImpl implements AdminService {
private AdminDao admindao;

	public AdminDao getAdmindao() {
	return admindao;
}
@Resource
public void setAdmindao(AdminDao admindao) {
	this.admindao = admindao;
}

	@Override
	public Admin login(String username, String password) {
		
		return admindao.adminvalidate(username, password);
	}

	public List<User> showUsers()
	{
		System.out.println("service");
		return admindao.getUsers();
	}
	@Override
	public void userdelete(int id) {
		admindao.userdelete(id);
		
	}
}
