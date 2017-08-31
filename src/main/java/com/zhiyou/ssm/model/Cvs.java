package com.zhiyou.ssm.model;

import java.util.List;

public class Cvs {

	private List<Course> courselist;
	
	private Subject subject;

	 private List<Video> videolist;

	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public List<Course> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
	public List<Video> getVideolist() {
		return videolist;
	}
	public void setVideolist(List<Video> videolist) {
		this.videolist = videolist;
	}
	@Override
	public String toString() {
		return "Cvs [courselist=" + courselist + ", subject=" + subject + ", videolist=" + videolist + "]";
	}
	
	
}
