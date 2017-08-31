package com.zhiyou.ssm.model;

import java.util.List;

public class Subject {
    private Integer id;

    private String subject_name;
    
    private List<Course> courselist;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	
	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subject_name=" + subject_name + ", courselist=" + courselist + "]";
	}

	

   
}