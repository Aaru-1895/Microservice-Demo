package com.microsub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubjectEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column
	private String subjectName;
	
	
	@Column
	private String subjectAuthor;
	
	SubjectEntity(){
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectAuthor() {
		return subjectAuthor;
	}

	public void setSubjectAuthor(String subjectAuthor) {
		this.subjectAuthor = subjectAuthor;
	}

	public SubjectEntity(int id, String subjectName, String subjectAuthor) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.subjectAuthor = subjectAuthor;
	}
	
	
	
	

}
