package com.nf.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.AdminDto;
import com.nf.model.Admin;
import com.nf.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("adminloginaction")
@Scope("prototype")
public class AdminLoginAction extends ActionSupport implements ModelDriven,SessionAware{
	private AdminDto admindto;
	private AdminService adminservice;
	private Map session;
	private Admin admin;
	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}
	public AdminDto getAdmindto() {
		return admindto;
	}
	@Resource
	public void setAdmindto(AdminDto admindto) {
		this.admindto = admindto;
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
		if((admindto.getUsername().length()<4||admindto.getUsername().length()>10)	||(admindto.getPassword().length()<4||admindto.getPassword().length()>10))
		{
			return INPUT;
		}
		Admin admin=adminservice.login(admindto.getUsername(), admindto.getPassword());
				if(null!=admin)
				{
			       session.put("admin", admin);
			      return SUCCESS;
				}
		
		return INPUT;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return admindto;
	}


}
