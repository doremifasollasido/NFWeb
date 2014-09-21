package com.nf.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nf.dto.CommentDto;
import com.nf.model.Comment;
import com.nf.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("commentdisplayaction")
public class CommentDisplayAction extends ActionSupport implements ModelDriven{
	private AdminService adminservice;
	private List list;
	private CommentDto commentdto;
	

	public CommentDto getCommentdto() {
		return commentdto;
	}
    @Resource
	public void setCommentdto(CommentDto commentdto) {
		this.commentdto = commentdto;
	}

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
    	 Comment comment = new Comment();
    	 comment.setId(commentdto.getId());
    	 this.list=adminservice.getComments(comment);
    	
    	return SUCCESS;
    }

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return commentdto;
	}

}
