package com.nf.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.MoodDto;
import com.nf.model.Mood;
import com.nf.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("mooddeleteaction")
@Scope("prototype")
public class MoodDeleteAction extends ActionSupport implements ModelDriven {
	private  AdminService adminservice;
	private MoodDto mooddto;
	private List list;

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public MoodDto getMooddto() {
		return mooddto;
	}
	@Resource
	public void setMooddto(MoodDto mooddto) {
		this.mooddto = mooddto;
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
    	Mood mood=new Mood();
    	System.out.println(mooddto.getId());
    	mood.setId(mooddto.getId());
    	adminservice.deleteMood(mood);
   	    this.list =this.adminservice.getMoods();
    
    	return SUCCESS;
    }
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return mooddto;
	}
}
