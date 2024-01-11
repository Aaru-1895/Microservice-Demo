package com.microsub.model;

import java.util.List;

import com.microsub.entity.SubjectEntity;

public class ResponseData {
	
	
	private SubjectEntity subjectEntity;
	private List<UserEntity> userList;
	public SubjectEntity getSubjectEntity() {
		return subjectEntity;
	}
	public void setSubjectEntity(SubjectEntity subjectEntity) {
		this.subjectEntity = subjectEntity;
	}
	public List<UserEntity> getUserList() {
		return userList;
	}
	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}
	
	
	

}
