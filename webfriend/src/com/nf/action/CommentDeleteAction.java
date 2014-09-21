package com.nf.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nf.dto.CommentDto;
import com.nf.model.Comment;
import com.nf.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("commentdeleteaction")
@Scope("prototype")
public class CommentDeleteAction extends ActionSupport implements ModelDriven{
private AdminService adminservice;
private CommentDto commentdto;
private List list;

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
	System.out.println(commentdto.getId());
	Comment comment = new Comment();
	comment.setId(commentdto.getId());
	adminservice.deleteComment(comment);
	this.list=adminservice.getComments(comment);
		
		return SUCCESS;
	}
@Override
public Object getModel() {
	// TODO Auto-generated method stub
	return commentdto;
}

}
