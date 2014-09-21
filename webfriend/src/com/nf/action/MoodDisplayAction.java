package com.nf.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
@Component("mooddisplayaction")
@Scope("prototype")
public class MoodDisplayAction extends ActionSupport {

	private AdminService adminservice;
	private List list;

	public List getList() {
		return list;
	}

	public void setList(List list) {
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
		
		this.list=adminservice.getMoods();
		return SUCCESS;
	}
}
