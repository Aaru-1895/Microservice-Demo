package com.microuser.MicrroserviceUser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	
	@Column
	private String username;
	
	@Column
	private Integer subjectId;
	
	
	UserEntity(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public UserEntity(int id, String username, int subjectId) {
		super();
		this.id = id;
		this.username = username;
		this.subjectId = subjectId;
	}

	
	
	
}
